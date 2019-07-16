package com.wxss.mongodblearn.entity;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

/**
 * Author:Created by wx on 2019/7/16
 * Desc:
 */
@QueryEntity
@Document("goods")
@Data
public class Goods {
    @Id
    private String oid;
    @Field("name")
    private String goodsName;
    private BigDecimal price;
    private boolean status;
    private long count;

}
