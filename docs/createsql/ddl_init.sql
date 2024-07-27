CREATE TABLE users (
                       user_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '用户ID',
                       username VARCHAR(255) NOT NULL UNIQUE COMMENT '用户名',
                       password VARCHAR(255) NOT NULL COMMENT '密码',
                       email VARCHAR(255) COMMENT '电子邮箱',
                       created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
                       updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期'
) COMMENT='用户信息表';

CREATE TABLE products (
                          product_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '商品ID',
                          name VARCHAR(255) NOT NULL COMMENT '商品名称',
                          description TEXT COMMENT '商品描述',
                          price DECIMAL(10, 2) NOT NULL COMMENT '商品价格',
                          stock INT NOT NULL COMMENT '库存数量',
                          created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
                          updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期'
) COMMENT='商品表';

CREATE TABLE orders (
                        order_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '订单ID',
                        user_id INT NOT NULL COMMENT '用户ID',
                        total_price DECIMAL(10, 2) NOT NULL COMMENT '订单总价',
                        status ENUM('pending', 'completed', 'canceled') DEFAULT 'pending' COMMENT '订单状态',
                        created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建日期',
                        updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '订单更新日期',
                        FOREIGN KEY (user_id) REFERENCES users(user_id)
) COMMENT='订单表';
CREATE TABLE seckill_products (
                                  seckill_product_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '秒杀商品ID',
                                  product_id INT NOT NULL COMMENT '商品ID',
                                  seckill_price DECIMAL(10, 2) NOT NULL COMMENT '秒杀价格',
                                  start_time DATETIME NOT NULL COMMENT '秒杀开始时间',
                                  end_time DATETIME NOT NULL COMMENT '秒杀结束时间',
                                  stock INT NOT NULL COMMENT '秒杀库存数量',
                                  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
                                  updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
                                  FOREIGN KEY (product_id) REFERENCES products(product_id)
) COMMENT='秒杀商品表';
CREATE TABLE seckill_orders (
                                seckill_order_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '秒杀订单ID',
                                user_id INT NOT NULL COMMENT '用户ID',
                                seckill_product_id INT NOT NULL COMMENT '秒杀商品ID',
                                order_id INT NOT NULL COMMENT '订单ID',
                                status ENUM('pending', 'completed', 'canceled') DEFAULT 'pending' COMMENT '秒杀订单状态',
                                created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '秒杀订单创建日期',
                                updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '秒杀订单更新日期',
                                FOREIGN KEY (user_id) REFERENCES users(user_id),
                                FOREIGN KEY (seckill_product_id) REFERENCES seckill_products(seckill_product_id),
                                FOREIGN KEY (order_id) REFERENCES orders(order_id)
) COMMENT='秒杀订单表';

