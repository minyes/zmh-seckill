CREATE TABLE users
(
    id           INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
    user_id      INT COMMENT '用户ID',
    username     VARCHAR(255) NOT NULL UNIQUE COMMENT '用户名',
    password     VARCHAR(255) NOT NULL COMMENT '密码',
    email        VARCHAR(255) COMMENT '电子邮箱',
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期'
) COMMENT ='用户信息表';
CREATE UNIQUE INDEX un_index_user_id ON users (user_id);


CREATE TABLE goods
(
    id           INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
    goods_id     INT COMMENT '商品ID',
    goods_name         VARCHAR(255)   NOT NULL COMMENT '商品名称',
    description  TEXT COMMENT '商品描述',
    price        DECIMAL(10, 2) NOT NULL COMMENT '商品价格',
    stock        INT            NOT NULL COMMENT '库存数量',
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期'
) COMMENT ='商品表';

CREATE UNIQUE INDEX un_index_goods_id ON goods (goods_id);


CREATE TABLE orders
(
    id           INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
    order_id     INT COMMENT '订单ID',
    user_id      INT            NOT NULL COMMENT '用户ID',
    total_amount DECIMAL(10, 2) NOT NULL COMMENT '订单金额',
    order_status ENUM ('pending', 'completed', 'canceled') DEFAULT 'pending' COMMENT '订单状态',
    created_date TIMESTAMP                                 DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建日期',
    updated_date TIMESTAMP                                 DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '订单更新日期',
    FOREIGN KEY (user_id) REFERENCES users (user_id)
) COMMENT ='订单表';
CREATE UNIQUE INDEX un_index_order_id ON orders (order_id);


CREATE TABLE seckill_goods
(
    id               INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
    seckill_goods_id INT COMMENT '秒杀商品ID',
    goods_id         INT            NOT NULL COMMENT '商品ID',
    seckill_price    DECIMAL(10, 2) NOT NULL COMMENT '秒杀价格',
    start_time       DATETIME       NOT NULL COMMENT '秒杀开始时间',
    end_time         DATETIME       NOT NULL COMMENT '秒杀结束时间',
    stock            INT            NOT NULL COMMENT '秒杀库存数量',
    created_date     TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    updated_date     TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
    FOREIGN KEY (goods_id) REFERENCES goods (goods_id)
) COMMENT ='秒杀商品表';
CREATE UNIQUE INDEX un_index_seckill_goods_id ON seckill_goods (seckill_goods_id);


CREATE TABLE seckill_orders
(
    id                 INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
    seckill_order_id   INT COMMENT '秒杀订单ID',
    user_id            INT NOT NULL COMMENT '用户ID',
    seckill_goods_id INT NOT NULL COMMENT '秒杀商品ID',
    order_id           INT NOT NULL COMMENT '订单ID',
    created_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '秒杀订单创建日期',
    updated_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '秒杀订单更新日期',
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (seckill_goods_id) REFERENCES seckill_goods (seckill_goods_id),
    FOREIGN KEY (order_id) REFERENCES orders (order_id)
) COMMENT ='秒杀订单表';
CREATE UNIQUE INDEX un_index_seckill_order_id ON seckill_orders (seckill_order_id);


CREATE TABLE idempotency_keys
(
    id               INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
    idempotency_key  VARCHAR(255) NOT NULL COMMENT '幂等性键，唯一标识每个请求',
    request_payload  TEXT         NOT NULL COMMENT '请求的负载数据，用于记录请求的具体内容',
    response_payload TEXT COMMENT '响应的负载数据，用于记录响应的具体内容',
    created_date       DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '请求的创建时间',
    updated_date       DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录的最近更新时间'
) COMMENT '幂等性表';
CREATE UNIQUE INDEX un_index_idempotency_key ON idempotency_keys (idempotency_key);


