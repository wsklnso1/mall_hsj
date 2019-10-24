package com.hsj.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsj.mall.service.ServiceTestRemote;

@RestController
public class ServiceTestController {
	
	@Autowired
	private ServiceTestRemote servicetest;
	
	@RequestMapping("/test")
	public String test() {
		return servicetest.test();	
	}
}
