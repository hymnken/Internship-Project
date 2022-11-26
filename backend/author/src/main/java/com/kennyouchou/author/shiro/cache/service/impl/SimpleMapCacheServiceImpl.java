package com.kennyouchou.author.shiro.cache.service.impl;

import com.kennyouchou.author.shiro.cache.service.SimpleMapCacheService;
import com.kennyouchou.commons.enums.ShiroCacheEnum;
import com.kennyouchou.commons.utils.LSerializeUtils;
import com.kennyouchou.commons.utils.ShiroUtils;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 自定义简单缓存管理接口实现类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-31 09:48:44
 */
@Slf4j
@Component
public class SimpleMapCacheServiceImpl implements SimpleMapCacheService {

    /**
     * 使用shiro专用的reids客户端
     * @since 2022/10/31 9:53
     **/
    @Resource(name = "redissonClientForShiro")
    private RedissonClient redissonClient;

    /**
     * <b>功能说明：</b>：新增缓存堆到管理器<br>
     *
     * @param cacheName 缓存名称
     * @param cache     缓存对象
     * @throws CacheException 缓存异常
     * @author kennyouchou
     * @since 2022/10/31 9:40
     **/
    @Override
    public void createCache(String cacheName, Cache<Object, Object> cache) throws CacheException {
        // 根据键得到缓存对象，如果没有则会创建
        RBucket<Object> bucket = redissonClient.getBucket(ShiroCacheEnum.GROUP_CAS.getValue() + cacheName);
        // 参数：缓存对象，过期时间，时间单位
        bucket.trySet(LSerializeUtils.serialize(cache),
                ShiroUtils.getSession().getTimeout()/1000,
                TimeUnit.SECONDS);
    }

    /**
     * <b>方法名：</b>：getCache<br>
     * <b>功能说明：</b>：获取缓存堆<br>
     *
     * @param cacheName 缓存名称
     * @return org.apache.shiro.cache.Cache<java.lang.Object, java.lang.Object>
     * @throws CacheException 缓存异常
     * @author kennyouchou
     * @since 2022/10/31 9:44
     **/
    @Override
    public Cache<Object, Object> getCache(String cacheName) throws CacheException {
        RBucket<String> bucket = redissonClient.getBucket(ShiroCacheEnum.GROUP_CAS.getValue() + cacheName);
        return (Cache<Object, Object>) LSerializeUtils.deserialize(bucket.get());
    }

    /**
     * <b>方法名：</b>：removeCache<br>
     * <b>功能说明：</b>：移除缓存堆<br>
     *
     * @param cacheName 缓存名称
     * @throws CacheException 缓存异常
     * @author kennyouchou
     * @since 2022/10/31 9:46
     **/
    @Override
    public void removeCache(String cacheName) throws CacheException {
        RBucket<Object> bucket = redissonClient.getBucket(ShiroCacheEnum.GROUP_CAS.getValue() + cacheName);
        bucket.delete();
    }

    /**
     * <b>方法名：</b>：updateCahce<br>
     * <b>功能说明：</b>：更新缓存堆<br>
     *
     * @param cacheName 缓存名称
     * @param cache     缓存对象
     * @throws CacheException 缓存异常
     * @author kennyouchou
     * @since 2022/10/31 9:47
     **/
    @Override
    public void updateCahce(String cacheName, Cache<Object, Object> cache) throws CacheException {
        RBucket<Object> bucket = redissonClient.getBucket(ShiroCacheEnum.GROUP_CAS.getValue() + cacheName);
        // 参数：缓存对象，过期时间，时间单位
        bucket.set(LSerializeUtils.serialize(cache),
                ShiroUtils.getSession().getTimeout()/1000,
                TimeUnit.SECONDS);
    }
}
