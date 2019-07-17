package com.wxss.mongodblearn;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.wxss.mongodblearn.dao.GoodsRepo;
import com.wxss.mongodblearn.entity.Goods;
import com.wxss.mongodblearn.entity.QGoods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:Created by wx on 2019/7/16
 * Desc:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsTest {
    @Autowired
    private GoodsRepo goodsRepo;

    @Test
    public void testQuery() {

        QGoods qGoods = new QGoods("aaa");
        Predicate predicate = qGoods.goodsName.eq("aaa");
        List<Goods> goods = (List<Goods>) goodsRepo.findAll(predicate);
        System.out.println("测试 eq 查询...");
        for (Goods good : goods) {
            System.out.println(good);
        }

        QGoods qGoods1 = new QGoods("goods");
        BooleanExpression gt = qGoods1.count.gt(100L);
//        BooleanExpression between = qGoods1.price.between(new BigDecimal(100),new BigDecimal(200));
        goods = (List<Goods>) goodsRepo.findAll(gt);
        System.out.println("测试 between 查询...");
        for (Goods goods1 : goods) {
            System.out.println(goods1);
        }

    }

    @Test
    public void testQuery2() {
        QGoods goods = QGoods.goods;
        BooleanExpression expression = goods.goodsName.eq("aaa");
        Iterable<Goods> iterable = goodsRepo.findAll(expression);
        for (Goods value : iterable) {
            System.out.println(value);
        }
    }

}