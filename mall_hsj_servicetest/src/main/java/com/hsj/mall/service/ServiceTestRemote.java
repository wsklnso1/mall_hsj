package com.hsj.mall.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name= "mall-hsj-admin",fallback=ServiceTestRemoteHystrix.class)
public interface ServiceTestRemote {
	@RequestMapping(value = "/test")
	public String test();

}
