package com.ibinq.databse.redis;




import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by Administrator on 2017/8/18.
 */
public class RedisDemo1 {
    @Test
    public void testRedis(){
        Jedis jedis = new Jedis("localhost");

        //String 实例
        //存储数据
        jedis.set("name","zhangsan1");
        //获取数据
        System.out.print(jedis.get("name"));

        //List实例
        //存储数据
        jedis.lpush("set-list","11111");
        jedis.lpush("set-list","22222");
        jedis.lpush("set-list","33333");
        //获取数据并输出
        List<String> list = jedis.lrange("set-list",0,1);
        for (String s :list) {
            System.out.println(s);
        }

    }
}

