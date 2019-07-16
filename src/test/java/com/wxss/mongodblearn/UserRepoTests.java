package com.wxss.mongodblearn;

import com.wxss.mongodblearn.dao.MongoRepo;
import com.wxss.mongodblearn.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:Created by wx on 2019/7/15
 * Desc:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepoTests {
    @Autowired
    private MongoRepo mongoRepo;

    @Test
    public void testSave(){
        User user = new User();
        user.setName("测试5");
        user.setPassword("55555");
        User result = mongoRepo.save(user);

        System.out.println(result);
    }

    /**
     * 调用的是CrudRepository实现类
     * 参数是 Iterable接口
     */
    @Test
    public void testSaveMany(){
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setName("测试3");
        user.setPassword("3333");
        userList.add(user);
        user = new User();
        user.setName("测试4");
        user.setPassword("44444");
        userList.add(user);
        List<User> iterable = mongoRepo.saveAll(userList);

        System.out.println(iterable);
    }

    @Test
    public void testJsonQuery(){
        List<User> userList = mongoRepo.findList("uid save");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testJsonQuery1(){
        List<User> list = mongoRepo.findList(10, 30);
        for (User user : list) {
            System.out.println(user);
        }
    }
    @Test
    public void testPage(){
        Pageable pageable = PageRequest.of(0, 3);

        Page<User> all = mongoRepo.findAll(pageable);
        System.out.println(all.getTotalElements());
        System.out.println(all.getTotalPages());
        System.out.println(all.getContent());


    }

}
