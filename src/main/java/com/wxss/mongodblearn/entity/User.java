package com.wxss.mongodblearn.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Author:Created by wx on 2019/7/15
 * Desc:
 *      1.实体类有id属性，或者使用@Id声明一个属性为主键时，MongoDB默认将其映射为_id字段，如果该属性有值，就以其值为_id的值，否则自动生成ObjectId(...)为值
 *      2.实体类没有id属性，且没有显示声明哪个属性是主键时，MongoDB会增加一个_id字段，并设其值为ObjectId(...)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("user")
public class User {
    //
    //    private String id;
    @Id
    private String uid;
    private String name;
    private int age;
    private String password;
}
