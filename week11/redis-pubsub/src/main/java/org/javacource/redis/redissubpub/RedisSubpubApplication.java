package org.javacource.redis.redissubpub;

import org.javacource.redis.redissubpub.service.PublishOrder;
import org.javacource.redis.redissubpub.service.SubscribeOrder;
import redis.clients.jedis.JedisPool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 */
@SpringBootApplication
public class RedisSubpubApplication {


    public static void main(String[] args)  {
        SpringApplication.run(RedisSubpubApplication.class, args);

        JedisPool jedisPool = new JedisPool();
        String channelName = "ORDER";

        SubscribeOrder subscribeOrder = new SubscribeOrder(jedisPool, channelName);
        PublishOrder publishOrder = new PublishOrder(jedisPool, channelName);
    }

}
