package com.hsj.mall.service;

import org.springframework.stereotype.Service;


import java.util.List;

import org.mall_hsj_mbg.model.UmsAdmin;
import org.mall_hsj_mbg.model.UmsPermission;

public interface UmsAdminService {
	
	String login(String username,String password);
	/**
     * 根据用户id获取用户
     */
    UmsAdmin getItem(Long id);
    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUsername(String username);
    
    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
