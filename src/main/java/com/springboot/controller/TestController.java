package com.springboot.controller;


import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.service.TestService;

@Controller
public class TestController {
 
	@Autowired
	TestService testservice;
	
	
	@GetMapping("/test")
	public String test() {
			System.out.println("nihao---"+testservice.getClass().getName());
			//获得虚拟机年轻代和老年代的垃圾回收器
			List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
			for (GarbageCollectorMXBean garbageCollectorMXBean : garbageCollectorMXBeans) {
				System.out.println(garbageCollectorMXBean.getName());
			}
			return "test";
		}
}
