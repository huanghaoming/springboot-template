package com.zhenmei.wsc.rbac.mybatis.custom.entity;

import lombok.Data;

import java.util.List;

@Data
public class PermissionEntity {
    /**
     * url
     */
    private String permissionUrl;

    private String permissionName;

    /**
     * 角色名称
     */
    private List<String> roleNames;
}