package com.hsj.mall.service;

import org.springframework.stereotype.Component;

@Component
public class ServiceTestRemoteHystrix implements ServiceTestRemote {

	@Override
	public String test() {
		return "熔断";
	}

}
