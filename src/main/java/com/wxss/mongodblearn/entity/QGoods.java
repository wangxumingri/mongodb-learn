package com.wxss.mongodblearn.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGoods is a Querydsl query type for Goods
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGoods extends EntityPathBase<Goods> {

    private static final long serialVersionUID = 754083879L;

    public static final QGoods goods = new QGoods("goods");

    public final NumberPath<Long> count = createNumber("count", Long.class);

    public final StringPath goodsName = createString("goodsName");

    public final StringPath oid = createString("oid");

    public final NumberPath<java.math.BigDecimal> price = createNumber("price", java.math.BigDecimal.class);

    public final BooleanPath status = createBoolean("status");

    public QGoods(String variable) {
        super(Goods.class, forVariable(variable));
    }

    public QGoods(Path<? extends Goods> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGoods(PathMetadata metadata) {
        super(Goods.class, metadata);
    }

}

