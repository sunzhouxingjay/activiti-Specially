package org.activiti.engine.impl.db.redis;

import java.net.ConnectException;
import java.time.Duration;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.RedisSocketConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

public class redisUtil {
    @SuppressWarnings("rawtypes")
    public StringRedisTemplate getstringRedisTemplate() {
        RedisStandaloneConfiguration redisConfiguration=new RedisStandaloneConfiguration("localhost", 6379);
        redisConfiguration.setDatabase(0);
        
        LettuceConnectionFactory connectionFactory=new LettuceConnectionFactory(new RedisSocketConfiguration("/home/sunweekstar/redis/redis.sock"));
        //LettuceConnectionFactory connectionFactory=new LettuceConnectionFactory(redisConfiguration);
        connectionFactory.afterPropertiesSet();
        StringRedisTemplate stringRedisTemplate=new StringRedisTemplate(connectionFactory);
        return stringRedisTemplate;
    } 
}
