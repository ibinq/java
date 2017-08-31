package com.ibinq.databse.redis;




import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/8/18.
 */
public class RedisDemo1 {
    Jedis jedis = new Jedis("127.0.0.1");
    /**
     * String 实例
     */
    @Test
    public void testRedisString(){

        //存储数据
       jedis.set("name","zhangsan1");
        //获取数据
        System.out.println(jedis.get("name"));

        jedis.append("name", " is my lover"); //拼接
        System.out.println(jedis.get("name"));

        jedis.del("name");  //删除某个键
        System.out.println(jedis.get("name"));
        //设置多个键值对
        jedis.mset("name","bhz","age","27","qq","174754613");
        jedis.incr("age"); //进行加1操作
        System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));

    }

    @Test
    public void testRedisHash(){
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("zhou","bing");
        map.put("wang","qing");
        String aa = jedis.hmset("name1",map);
        List<String> name = jedis.hmget("name1","zhou","wang");
        for (String a:name ) {
            System.out.println(a);
        }
    }

    @Test
    public void testRedisList(){
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

    @Test
    public  void testSet(){
        //添加
        jedis.sadd("user1","liuling");
        jedis.sadd("user1","xinxin");
        jedis.sadd("user1","ling");
        jedis.sadd("user1","zhangxinxin");
        jedis.sadd("user1","who");
        //移除noname
        jedis.srem("user1","who");
        System.out.println(jedis.smembers("user1"));//获取所有加入的value
        System.out.println(jedis.sismember("user1", "who"));//判断 who 是否是user集合的元素
        System.out.println(jedis.srandmember("user1"));
        System.out.println(jedis.scard("user1"));//返回集合的元素个数
    }
}

