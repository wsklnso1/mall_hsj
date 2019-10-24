package com.hsj.mall.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.mall_hsj_mbg.model.UmsAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsj.mall.dto.UmsAdminParam;
import com.hsj.mall.service.UmsAdminService;
import com.macro.mall.common.api.CommonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/admin")
public class UmsAdminController {
	@Autowired
	private UmsAdminService umsAdminService;

	@Value("${jwt.tokenHead}")
	private String tokenHead;

	@RequestMapping(value= "/test", method = RequestMethod.GET)
	public String test() {
		return "hello world1";

	}

	@RequestMapping(value= "/login", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult login(@RequestBody UmsAdminParam umsAdminParam, BindingResult result) {
		String token = umsAdminService.login(umsAdminParam.getUsername(), umsAdminParam.getPassword());
		if (token == null) {
			return CommonResult.validateFailed("用户名或密码错误");
		}
		Map<String, String> tokenMap = new HashMap<>();
		tokenMap.put("token", token);
		tokenMap.put("tokenHead", tokenHead);
		return CommonResult.success(tokenMap);

	}
	
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<UmsAdmin> getItem(@PathVariable Long id) {
        UmsAdmin admin = umsAdminService.getItem(id);
        return CommonResult.success(admin);
    }
    
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAdminInfo(Principal principal) {
        String username = principal.getName();
        UmsAdmin umsAdmin = umsAdminService.getAdminByUsername(username);
        Map<String, Object> data = new HashMap<>();
        data.put("username", umsAdmin.getUsername());
        data.put("roles", new String[]{"TEST"});
        data.put("icon", umsAdmin.getIcon());
        return CommonResult.success(data);
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult logout() {
        return CommonResult.success(null);
    }
}
