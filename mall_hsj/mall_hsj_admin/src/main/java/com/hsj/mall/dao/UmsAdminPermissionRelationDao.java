package com.hsj.mall.dao;

import org.apache.ibatis.annotations.Param;
import org.mall_hsj_mbg.model.UmsAdminPermissionRelation;

import java.util.List;

/**
 * 用户权限自定义Dao
 * Created by macro on 2018/10/8.
 */
public interface UmsAdminPermissionRelationDao {
    int insertList(@Param("list") List<UmsAdminPermissionRelation> list);
}
