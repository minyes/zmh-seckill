package com.zmh.infrastructure.po;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description: UsersPO 用户信息表
 * @author: zhou ming hao
 * @date: 2024年07月27日 15:20
 */
@Data
public class UsersPO {

    /**
     * 用户did
     */
    private Long userId;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 创建时间
     */
    private LocalDateTime createdDate;

    /**
     * 更新时间
     */
    private LocalDateTime updatedDate;
}
