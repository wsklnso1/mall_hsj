package com.hsj.mall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UmsAdminController {
	@RequestMapping("/test")
	public String test() {
		return "hello world";
		
	}
}
