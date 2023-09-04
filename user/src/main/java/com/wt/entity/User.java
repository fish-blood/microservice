package com.wt.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

/**
 * (user)实体类
 *
 * @author wt
 * @since 2023-09-02 15:25:28
 * @description 由 Mybatisplus Code Generator 创建
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("user")
public class User extends Model<User> implements Serializable, UserDetails {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
	private Integer id;
    /**
     * name
     */
    private String username;

    /**
     * name
     */
    private String password;
    /**
     * 帐户是否过期(1 未过期，0已过期)
     */

    private boolean isAccountNonExpired = true;
    /**
     * 帐户是否被锁定(1 未过期，0已过期)
     */

    private boolean isAccountNonLocked = true;
    /**
     * 密码是否过期(1 未过期，0已过期)
     */

    private boolean isCredentialsNonExpired = true;
    /**
     * 帐户是否可用(1 可用，0 删除用户)
     */

    private boolean isEnabled = true;

    @TableField(exist = false)
    Collection<? extends GrantedAuthority> authorities;
    @TableField(exist = false)
    Collection<Permission> permissionList;
}