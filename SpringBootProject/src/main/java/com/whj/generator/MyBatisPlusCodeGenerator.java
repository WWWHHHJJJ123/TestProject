package com.whj.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.util.Collections;

/**
 * @author ZSJ
 * @date 2023/3/18 10:41
 */
public class MyBatisPlusCodeGenerator {

    public static void main(String[] args) {
        //模块名
        String moduleName = "SpringBootProject";
        //作者名 *******************自己的名字**************************
        String author = "whj";
        //数据库连接配置
/*        String url = "jdbc:mysql://10.98.250.71:3306/eifini_escm_main?useUnicode=true&useSSL=false&characterEncoding=utf8";
        String username = "root";
        String password = "root";*/
        String url = "jdbc:mysql://127.0.0.1:3306/whj_database?useUnicode=true&useSSL=false&characterEncoding=utf8";
        String username = "root";
        String password = "whj123123";
/*        String url = "jdbc:mysql://172.16.1.152:3306/yfl_elink_admin?useUnicode=true&useSSL=false&characterEncoding=utf8";
        String username = "root";
        String password = "yl2022!";*/

        //生成实体表名配置
        // *********************修改表名***********************
        String[] tables = new String[]{
                "tree"
        };
        System.out.println("===================开始生成代码========================");
        run(moduleName, author, url, username, password, tables);
        System.out.println("===================代码生成完成========================");
    }

    public static void run(String moduleName, String author, String url, String username, String password, String... tables) {
        FastAutoGenerator.create(url, username, password)
                // 全局配置
                .globalConfig(builder -> {
                    builder
//                            .fileOverride()   //	开启覆盖之前生成的文件
                            .disableOpenDir()  // 禁止打开输出目录
                            .outputDir(System.getProperty("user.dir") + File.separator + moduleName + "\\src\\main\\java")   // 指定输出目录
                            .author(author)   // 作者名
                            // .enableKotlin()      //开启 kotlin 模式
                            .enableSwagger()     // 开启 swagger 模式
                            .dateType(DateType.TIME_PACK)   // 时间策略
                            .commentDate("yyyy-MM-dd HH:mm:ss");   // 注释日期
                })
                // 包配置
                .packageConfig(builder -> {
                    //************************修改代码父包名(最后一级)**************************
                    builder.parent("com.whj.common_structures")     // 父包名
                            .entity("domain.entity")                 // Entity 包名
                            .service("service")             //	Service 包名
                            .serviceImpl("service.impl")    // Service Impl 包名
                            .mapper("dao")               // Mapper 包名
                            .xml("mapper.xml")              //	Mapper XML 包名
                            .controller("controller")       // Controller 包名
                            .other("config")                // 自定义文件包名	输出自定义文件时所用到的包名
                            //****************************修改xml文件路径(最后一级)********************************
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, System.getProperty("user.dir") + File.separator + moduleName + "\\src\\main\\resources\\mapper"));// 指定xml位置
                })
                // 策略配置
                .strategyConfig(builder -> {
                    builder.addInclude(tables)
                            // .addTablePrefix("ums_")// 表名前缀，配置后生成的代码不会有此前缀
                            // entity策略配置
                            .entityBuilder()
                            .formatFileName("%sEntity")// 实体类名称后缀
                            .enableLombok()// 实体类使用lombok,需要自己引入依赖
                            .enableChainModel()// 开启链式调用模式
                            .enableTableFieldAnnotation()// 开启生成实体时生成字段注解@TableField
                            .naming(NamingStrategy.underline_to_camel)// 数据库表映射到实体的命名策略(默认下划线转驼峰命名)
                            .idType(IdType.ASSIGN_UUID)// 全局主键类型
                            //.logicDeleteColumnName("status")//逻辑删除字段，使用delete方法删除数据时会将status设置为1。调用update方法时并不会将该字段放入修改字段中，而是在条件字段中
                            // controller策略配置
                            .controllerBuilder()
                            .formatFileName("%sController")// 控制类名称后缀
                            .enableRestStyle()// 开启生成@RestController 控制器
                            // service策略配置
                            .serviceBuilder()
                            .formatServiceFileName("I%sService")// 服务层接口名后缀
                            .formatServiceImplFileName("%sServiceImpl")// 服务层实现类名后缀
                            // mapper策略配置
                            .mapperBuilder()
                            .enableMapperAnnotation()// 开启 @Mapper 注解
                            .superClass(BaseMapper.class)
                            .formatMapperFileName("%sDao")// 持久层接口名后缀
                            .formatXmlFileName("%sDao");// 持久层xml文件后缀
                })
                .execute();


    }
}
