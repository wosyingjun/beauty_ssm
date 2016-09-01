package com.yingjun.ssm.cache;

import com.yingjun.ssm.util.ProtoStuffSerializerUtil;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * redis缓存
 *
 * 采用Jedis Cluster
 *
 * @author yingjun
 *
 */
@Component
public class RedisClusterCache {
	
	
	public final static String CAHCENAME="cache";//缓存名
	public final static int CAHCETIME=60;//默认缓存时间

	//@Autowired
	private JedisCluster jedisCluster;


	public <T> void putCache(String key, T obj) {
		final byte[] bkey = key.getBytes();
		final byte[] bvalue = ProtoStuffSerializerUtil.serialize(obj);
		jedisCluster.set(bkey,bvalue);
	}

	public <T> void putCacheWithExpireTime(String key, T obj,  int expireTime) {
		final byte[] bkey = key.getBytes();
		final byte[] bvalue = ProtoStuffSerializerUtil.serialize(obj);
		jedisCluster.setex(bkey, expireTime, bvalue);
	}

	public <T> void putListCache(String key, List<T> objList) {
		final byte[] bkey = key.getBytes();
		final byte[] bvalue = ProtoStuffSerializerUtil.serializeList(objList);
		jedisCluster.set(bkey,bvalue);
	}

	public <T> void putListCacheWithExpireTime(String key, List<T> objList, int expireTime) {
		final byte[] bkey = key.getBytes();
		final byte[] bvalue = ProtoStuffSerializerUtil.serializeList(objList);
		jedisCluster.setex(bkey, expireTime, bvalue);
	}

	public <T> T getCache(final String key, Class<T> targetClass) {
		byte[] result =jedisCluster.get(key.getBytes());
		if (result == null) {
			return null;
		}
		return ProtoStuffSerializerUtil.deserialize(result, targetClass);
	}

	public <T> List<T> getListCache(String key, Class<T> targetClass) {
		byte[] result =jedisCluster.get(key.getBytes());
		if (result == null) {
			return null;
		}
		return ProtoStuffSerializerUtil.deserializeList(result, targetClass);
	}

	/**
	 * 精确删除key
	 * 
	 * @param key
	 */
	public void deleteCache(String key) {
		jedisCluster.del(key);
	}

	/**
	 * 模糊删除key
	 * 
	 * @param pattern
	 */
	public void deleteCacheWithPattern(String pattern) {
		Set<String> keys =this.keys(pattern);
		for(String key:keys){
			jedisCluster.del(key);
		}
	}

	/**
	 * 清空所有缓存
	 */
	public void clearCache() {
		deleteCacheWithPattern(RedisClusterCache.CAHCENAME+"|*");
	}

	/**
	 * 由于JedisCluster没有提供对keys命令的封装，只能自己实现
	 * @param pattern
	 * @return
     */
	public Set<String> keys(String pattern){
		Set<String> keys = new HashSet<>();
		Map<String, JedisPool> clusterNodes = jedisCluster.getClusterNodes();
		for(String k : clusterNodes.keySet()){
			JedisPool jp = clusterNodes.get(k);
			Jedis connection = jp.getResource();
			try {
				keys.addAll(connection.keys(pattern));
			} catch(Exception e){
				e.printStackTrace();
			} finally{
				//用完一定要close这个链接！！！
				connection.close();
			}
		}
		return keys;
	}
}
