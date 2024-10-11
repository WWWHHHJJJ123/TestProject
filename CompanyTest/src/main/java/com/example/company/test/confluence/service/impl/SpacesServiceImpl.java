package com.example.company.test.confluence.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONWriter;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.company.test.confluence.common.enums.SpacePemissionOperEnum;
import com.example.company.test.confluence.dao.ContentDao;
import com.example.company.test.confluence.dao.ContentPermDao;
import com.example.company.test.confluence.dao.ContentPermSetDao;
import com.example.company.test.confluence.dao.SpacesDao;
import com.example.company.test.confluence.dao.UserMappingDao;
import com.example.company.test.confluence.domain.ao.SpacePermissionAO;
import com.example.company.test.confluence.domain.dto.ItemDTO;
import com.example.company.test.confluence.domain.dto.UserDTO;
import com.example.company.test.confluence.domain.entity.AoC77861AuditEntityEntity;
import com.example.company.test.confluence.domain.entity.ContentEntity;
import com.example.company.test.confluence.domain.entity.ContentPermEntity;
import com.example.company.test.confluence.domain.entity.ContentPermSetEntity;
import com.example.company.test.confluence.domain.entity.SpacepermissionsEntity;
import com.example.company.test.confluence.domain.entity.SpacesEntity;
import com.example.company.test.confluence.domain.entity.UserMappingEntity;
import com.example.company.test.confluence.service.IAoC77861AuditEntityService;
import com.example.company.test.confluence.service.IContentPermService;
import com.example.company.test.confluence.service.IContentPermSetService;
import com.example.company.test.confluence.service.ISpacepermissionsService;
import com.example.company.test.confluence.service.ISpacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author whj
 * @since 2024-08-29 19:07:01
 */
@Service
public class SpacesServiceImpl extends ServiceImpl<SpacesDao, SpacesEntity> implements ISpacesService {


    @Autowired
    private ISpacepermissionsService iSpacepermissionsService;

    @Autowired
    private IAoC77861AuditEntityService iAoC77861AuditEntityService;

    @Autowired
    private SpacesDao spacesDao;

    @Autowired
    private UserMappingDao userMappingDao;

    @Autowired
    private ContentDao contentDao;

    @Autowired
    private IContentPermSetService contentPermSetService;

    @Autowired
    private IContentPermService contentPermService;

    @Override
    public void toTarget(SpacePermissionAO ao) {
        String valueSpaceKey = "~" + ao.getValueLdap();
        String targetSpaceKey = "~" + ao.getTargetLdap();

        //先获取到value空间id
        SpacesEntity valueSpace = this.getOne(Wrappers.<SpacesEntity>lambdaQuery()
                .eq(SpacesEntity::getSpaceKey, valueSpaceKey));

        //再获取到target空间id
        SpacesEntity targetSpace = this.getOne(Wrappers.<SpacesEntity>lambdaQuery()
                .eq(SpacesEntity::getSpaceKey, targetSpaceKey));


        Long valueSpaceId = valueSpace.getSpaceId();
        String targetCreator = targetSpace.getCreator();

        //公用用的对象，
        ItemDTO operaItem = new ItemDTO();
        operaItem.setI18nKey("键入");
        operaItem.setKey("键入");
        operaItem.setFrom(null);


        ItemDTO spaceItem = new ItemDTO();
        spaceItem.setI18nKey("空间");
        spaceItem.setKey("空间");
        spaceItem.setFrom(null);
        spaceItem.setTo(valueSpaceKey);

        ItemDTO userItem = new ItemDTO();
        userItem.setI18nKey("用户");
        userItem.setKey("用户");
        userItem.setFrom(null);
        userItem.setTo(ao.getTargetLdap());


        List<ItemDTO> itemList = Arrays.asList(operaItem, spaceItem, userItem);

        //user对象
        UserDTO testDTO = new UserDTO();
        testDTO.setId(targetSpace.getCreator());
        testDTO.setUri(null);
        testDTO.setType("User");
        testDTO.setName(targetSpace.getSpaceName());

        UserDTO adminDTO = new UserDTO();
        adminDTO.setId(valueSpace.getSpaceId().toString());
        adminDTO.setUri(null);
        adminDTO.setType("Space");
        adminDTO.setName(valueSpace.getSpaceName());
        List<UserDTO> userList = Arrays.asList(testDTO, adminDTO);


        //再根据空间id去在空间权限里面去操作
        SpacePemissionOperEnum[] values = SpacePemissionOperEnum.values();
        List<SpacepermissionsEntity> permissions = new ArrayList<>();
        List<AoC77861AuditEntityEntity> auditEntityEntities = new ArrayList<>();


//        //获取到ao_c77861_audit_entity字段的ENTITY_TIMESTAMP当前最大值
        AoC77861AuditEntityEntity maxValue =
                iAoC77861AuditEntityService.getOne(Wrappers.<AoC77861AuditEntityEntity>lambdaQuery()
                .orderByDesc(AoC77861AuditEntityEntity::getEntityTimestamp)
                .last("limit 1"));

        for (int i = 0; i < values.length; i++) {
            //权限表操作
            SpacepermissionsEntity spacepermissionsEntity = new SpacepermissionsEntity();
            spacepermissionsEntity.setSpaceid(valueSpaceId);
            spacepermissionsEntity.setCreator(targetCreator);
            spacepermissionsEntity.setPermusername(targetCreator);
            spacepermissionsEntity.setPermtype(values[i].value);
            spacepermissionsEntity.setCreationdate(LocalDateTime.now());
            spacepermissionsEntity.setLastmoddate(LocalDateTime.now());
            spacepermissionsEntity.setLastmodifier(valueSpace.getCreator());
            permissions.add(spacepermissionsEntity);

            //编辑表操作
            AoC77861AuditEntityEntity auditEntity = new AoC77861AuditEntityEntity();
            auditEntity.setAction("空间权限已添加");
            auditEntity.setActionTKey("audit.logging.summary.space.permission.added");
            auditEntity.setArea("PERMISSIONS");
            auditEntity.setAttributes(Collections.emptyList().toString());
            auditEntity.setCategory("权限");
            auditEntity.setCategoryTKey("audit.logging.category.permissions");

            ItemDTO itemDTO = itemList.get(0);
            itemDTO.setTo(values[i].value);
            String itemJsonString = JSON.toJSONString(itemList, JSONWriter.Feature.WriteMapNullValue);
//            auditEntity.setChangeValues(JSONArray.toJSONString(itemList));
            auditEntity.setChangeValues(itemJsonString);

            auditEntity.setEntityTimestamp(maxValue.getEntityTimestamp() + i + 1);
            auditEntity.setLevel("BASE");
            auditEntity.setMethod("Browser");
            auditEntity.setPrimaryResourceId(targetSpace.getCreator());
            auditEntity.setPrimaryResourceType("User");

            String jsonString = JSON.toJSONString(userList, JSONWriter.Feature.WriteMapNullValue);
//            auditEntity.setResources(JSONArray.toJSONString(userList));
            auditEntity.setResources(jsonString);

            auditEntity.setSearchString("test admin audit.logging.summary.space.permission.added audit.logging" +
                    ".category.permissions 空间权限已添加 权限 10.10.51.234");
            auditEntity.setSecondaryResourceId(valueSpace.getSpaceId().toString());
            auditEntity.setSecondaryResourceType("Space");
            auditEntity.setSource("10.10.51.234");
            auditEntity.setSystemInfo("http://10.10.52.125:8090");
            auditEntity.setUserId(valueSpace.getCreator());
            auditEntity.setUserName(valueSpace.getSpaceName());
            auditEntity.setUserType("user");
            auditEntityEntities.add(auditEntity);
        }

        iSpacepermissionsService.saveBatch(permissions);
        iAoC77861AuditEntityService.saveBatch(auditEntityEntities);
    }

    @Override
    public Boolean deleteLimit(String ldap) {
        UserMappingEntity ldapEntity = userMappingDao.selectOne(Wrappers.<UserMappingEntity>lambdaQuery()
                .eq(UserMappingEntity::getUsername, ldap));
        SpacesEntity ldapSpace = spacesDao.selectOne(Wrappers.<SpacesEntity>lambdaQuery()
                .eq(SpacesEntity::getCreator, ldapEntity.getUserKey())
                .eq(SpacesEntity::getSpaceKey,"~"+ldap));
        List<ContentEntity> ldapContent = contentDao.selectList(Wrappers.<ContentEntity>lambdaQuery()
                .eq(ContentEntity::getSpaceid, ldapSpace.getSpaceId()));
        List<Long> contentIds = ldapContent.stream().map(ContentEntity::getContentid).collect(Collectors.toList());
        List<ContentPermSetEntity> ldapContentPerSet = contentPermSetService.list(Wrappers.<ContentPermSetEntity>lambdaQuery()
                .in(ContentPermSetEntity::getContentId, contentIds));
        List<Long> contentPerSetIds = ldapContentPerSet.stream().map(ContentPermSetEntity::getId).collect(Collectors.toList());
        contentPermService.remove(Wrappers.<ContentPermEntity>lambdaQuery()
                .in(ContentPermEntity::getCpsId,contentPerSetIds));
        List<ContentPermEntity> collect = ldapContentPerSet.stream().map(perSet -> {
            ContentPermEntity entity = new ContentPermEntity();
            entity.setCpType(perSet.getContPermType());
            entity.setUsername(ldapEntity.getUserKey());
            entity.setCpsId(perSet.getId());
            entity.setCreator(ldapEntity.getUserKey());
            entity.setCreationdate(LocalDateTime.now());
            entity.setLastmodifier(ldapEntity.getUserKey());
            entity.setLastmoddate(LocalDateTime.now());
            return entity;
        }).collect(Collectors.toList());
        //新增
        boolean b = contentPermService.saveBatch(collect);
        return b;
    }

//    @Override
//    public Boolean deleteLimit(String ldap) {
//
//
//        //先找key
//        UserMappingEntity leaveUser = userMappingDao.selectOne(Wrappers.<UserMappingEntity>lambdaQuery()
//                .eq(UserMappingEntity::getUsername, ldap));
//        //首先先通过离职人员的ldap去查找他的空间id
//        SpacesEntity leaveSpace = spacesDao.selectOne(Wrappers.<SpacesEntity>lambdaQuery()
//                .eq(SpacesEntity::getCreator, leaveUser.getUserKey())
//                .eq(SpacesEntity::getSpaceKey,"~"+ldap));
//        //在通过spaceId去content表找到所有关于这个空间的页面
//        List<ContentEntity> contents = contentDao.selectList(Wrappers.<ContentEntity>lambdaQuery()
//                .eq(ContentEntity::getSpaceid, leaveSpace.getSpaceId()));
//        //抽离出来contentId集合
//        List<Long> contentIds = contents.stream().map(ContentEntity::getContentid).collect(Collectors.toList());
//        //再去content_perm_set表中查找id
//        List<ContentPermSetEntity> permSetList = contentPermSetService.list(Wrappers.<ContentPermSetEntity>lambdaQuery()
//                .in(ContentPermSetEntity::getContentId, contentIds));
//
//        //删除content_perm_set表中数据
//        List<Long> perSetIds = permSetList.stream().map(ContentPermSetEntity::getId).collect(Collectors.toList());
//        contentPermSetService.removeByIds(perSetIds);
//        //最后再去content_perm表中的CPS_ID根据content_perm_set表的id去做删除操作
//
//        boolean remove = contentPermService.remove(Wrappers.<ContentPermEntity>lambdaQuery()
//                .in(ContentPermEntity::getCpsId, perSetIds));
//        System.out.println(remove);
//        return remove;
//    }


}
