package com.zhenmei.wsc.security.controller;

import com.zhenmei.wsc.form.BasePageForm;
import com.zhenmei.wsc.form.BatchDeleteForm;
import com.zhenmei.wsc.response.ResultBuilder;
import com.zhenmei.wsc.security.pojo.form.AdminUserSaveForm;
import com.zhenmei.wsc.security.service.AdminUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/security")
@CrossOrigin
public class AdminUserController {

    @Resource
    private AdminUserService adminUserService;

    @RequestMapping(value = "/admin/list", method = RequestMethod.GET)
    public Object list(@Valid BasePageForm form) {

        return ResultBuilder.success(adminUserService.list(form));
    }

    @RequestMapping(value = "/admin/save", method = RequestMethod.POST)
    public Object list(@RequestBody @Valid AdminUserSaveForm form) {
        adminUserService.saveAdminUser(form);

        return ResultBuilder.buildSuccess("添加用户成功");
    }


    @RequestMapping(value = "/admin/del", method = RequestMethod.POST)
    public Object deleteUser(@RequestBody @Valid BatchDeleteForm form) {
        adminUserService.deleteUser(form);
        return ResultBuilder.buildSuccess("删除用户成功");
    }

}