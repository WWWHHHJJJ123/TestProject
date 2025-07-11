package com.whj.redis.interfaceIdempotency.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * Redis 键操作服务
 *
 * @author CiZhong
 * @date 2025-05-20
 */
@Service
public class RedisKeyOperation {
    private static final Logger logger = LoggerFactory.getLogger(RedisKeyOperation.class);

    // 用于业务数据操作的RedisTemplate（JSON序列化）
    private final RedisTemplate<String, Serializable> jsonRedisTemplate;

    // 用于监听器操作的RedisTemplate（String序列化）
    private final RedisTemplate<String, String> stringRedisTemplate;

    @Autowired
    public RedisKeyOperation(
            @Qualifier("jacksonRedisTemplate") RedisTemplate<String, Serializable> jsonRedisTemplate,
            @Qualifier("stringRedisTemplate") RedisTemplate<String, String> stringRedisTemplate) {

        this.jsonRedisTemplate = jsonRedisTemplate;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     * 保存数据并设置过期时间
     *
     * @param key        键
     * @param value      值（JSON字符串）
     * @param expireTime 过期时间（分钟）
     */
    public void saveData(String key, String value, Long expireTime) {
        try {
            if (!StringUtils.hasText(key) || !StringUtils.hasText(value)) {
                logger.warn("保存数据失败: key或value为空");
                return;
            }

            // 主存储使用JSON序列化（带过期时间）
            jsonRedisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.MINUTES);

            // 备份存储使用String序列化（永不过期）
            String backupKey = "backup:" + key;
            stringRedisTemplate.opsForValue().set(backupKey, value);

            logger.debug("保存数据成功 - key: {}, expire: {}分钟", key, expireTime);
        } catch (Exception e) {
            logger.error("保存Redis数据失败 - key: {}", key, e);
            throw new RuntimeException("保存Redis数据失败", e);
        }
    }

    /**
     * 删除键及其备份
     *
     * @param key 要删除的键
     * @return 是否删除成功
     */
    public void deleteKey(String key) {
        jsonRedisTemplate.delete(key);
        stringRedisTemplate.delete("backup:" + key);
    }

    /**
     * 检查键是否存在
     *
     * @param key 要检查的键
     * @return 是否存在
     */
    public boolean isKeyExists(String key) {
        try {
            if (!StringUtils.hasText(key)) {
                return false;
            }
            return Boolean.TRUE.equals(jsonRedisTemplate.hasKey(key));
        } catch (Exception e) {
            logger.error("检查key存在失败: {}", key, e);
            return false;
        }
    }

    /**
     * 获取键对应的值
     *
     * @param key 键
     * @return 值（JSON字符串），不存在返回null
     */
    public String getValue(String key) {
        try {
            if (!StringUtils.hasText(key)) {
                return null;
            }

            // 从备份存储获取（使用String序列化）
            String backupKey = "backup:" + key;
            String value = stringRedisTemplate.opsForValue().get(backupKey);

            logger.debug("获取key {} 的值: {}", key, value != null ? "存在" : "null");
            return value;
        } catch (Exception e) {
            logger.error("获取Redis值失败 - key: {}", key, e);
            return null;
        }
    }

    /**
     * 清理备份数据
     *
     * @param key 原始键
     * @return 是否删除成功
     */
    public boolean cleanBackup(String key) {
        try {
            if (!StringUtils.hasText(key)) {
                return false;
            }

            stringRedisTemplate.delete("backup:" + key);
            logger.debug("清理备份 {} 结果: {}", key);
            return true;
        } catch (Exception e) {
            logger.error("清理备份数据失败 - key: {}", key, e);
            return false;
        }
    }

    /**
     * 获取键的剩余生存时间
     *
     * @param key      键
     * @param timeUnit 时间单位
     * @return 剩余时间，-2表示键不存在，-1表示无过期时间
     */
    public long getExpire(String key, TimeUnit timeUnit) {
        try {
            if (!StringUtils.hasText(key)) {
                return -2;
            }
            return jsonRedisTemplate.getExpire(key, timeUnit);
        } catch (Exception e) {
            logger.error("获取key过期时间失败: {}", key, e);
            return -2;
        }
    }

    /**
     * 设置键的过期时间
     *
     * @param key      键
     * @param timeout  时间值
     * @param timeUnit 时间单位
     * @return 是否设置成功
     */
    public boolean expire(String key, long timeout, TimeUnit timeUnit) {
        try {
            if (!StringUtils.hasText(key)) {
                return false;
            }
            return Boolean.TRUE.equals(jsonRedisTemplate.expire(key, timeout, timeUnit));
        } catch (Exception e) {
            logger.error("设置key过期时间失败: {}", key, e);
            return false;
        }
    }
}