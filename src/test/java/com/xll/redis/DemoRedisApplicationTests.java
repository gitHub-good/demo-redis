package com.xll.redis;

import com.xll.redis.entity.UserEntity;
import com.xll.redis.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
@Slf4j
@SpringBootTest
class DemoRedisApplicationTests {

    // redis中存储的过期时间60s
    private static int ExpireTime = 60;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void redisSet(){
        UserEntity userEntity =new UserEntity(Long.valueOf(1), String.valueOf(1), "小小高", String.valueOf(25), new Date());
        redisUtil.set("userEntity", userEntity);
    }

    @Test
    public void redisListSet(){
        List<UserEntity> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new UserEntity(Long.valueOf(i), String.valueOf(i), "小小高"+i, String.valueOf(25+i), new Date()));
        }
        redisUtil.lSet("userEntityList", list);
    }

    @Test
    public void redisGet(){
        String key = "userEntity";
        Object value = redisUtil.get(key);
        log.info("value:[{}]", value);
        Assert.notNull(value, "值不为NUll");
    }

    @Test
    public void redisDel(){
        String key = "userEntityList";
        redisUtil.del(key);
    }

    @Test
    public void expire(){
        String key = "userEntity";
        redisUtil.expire(key, ExpireTime);
    }

}
