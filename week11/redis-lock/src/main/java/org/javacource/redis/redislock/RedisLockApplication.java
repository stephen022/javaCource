package org.javacource.redis.redislock;

import org.javacource.redis.redislock.lock.RedisLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 *
 */
@SpringBootApplication
public class RedisLockApplication {

    private static JedisPool jedisPool = new JedisPool();

    private final static String LOCK = "redis_lock";

    private final static String AMOUNT = "redis_amount";

    private final static int EXPIRE = 3;


    public static void lockTest() {
        System.out.println("lock test:: start sleep 10");

        if (!RedisLock.getInstance().lock(LOCK, EXPIRE)) {
            System.out.println("获取锁失败");
            return;
        }

        try {
            Thread.sleep(10000);
            try(Jedis jedis = jedisPool.getResource()) {
                int amount = Integer.parseInt(jedis.get(AMOUNT));
                amount -= 1;
                jedis.set(AMOUNT,Integer.toString(amount));
                System.out.printf("库存减一 amount: %d\n", amount);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        RedisLock.getInstance().release(LOCK);
        System.out.println("lock test:: end");
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(RedisLockApplication.class, args);

        try(Jedis jedis = jedisPool.getResource()) {
            jedis.set(AMOUNT,"10");
        }

        Thread thread1 = new Thread(RedisLockApplication::lockTest);
        Thread thread2 = new Thread(RedisLockApplication::lockTest);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        Thread thread3 = new Thread(RedisLockApplication::lockTest);
        thread3.start();
        thread3.join();
    }

}
