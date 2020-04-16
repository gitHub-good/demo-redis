package com.xll.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 *
 * @Author：xuliangliang
 * @Description：测试实体类
 * @Date：12:58 下午 2020/4/16
 */
@Data
@AllArgsConstructor
public class UserEntity implements Serializable {
    private Long id;
    private String guid;
    private String name;
    private String age;
    private Date createTime;
}
