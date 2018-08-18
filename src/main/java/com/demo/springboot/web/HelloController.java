package com.demo.springboot.web;


import java.text.DateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 2.接着创建控制器类HelloController， 这个类就是Spring MVC里的一个普通的控制器。
 * @author lenovo
 *
 */
@Controller
//@RestController 是spring4里的新注解，是@ResponseBody和@Controller的缩写。
//@RestController
public class HelloController {
	
//	@RequestMapping("/hello")
//	public String hello() {
//		return "Hello Spring Boot!";
//	}
	
	@RequestMapping("/hello")
	public String hell0(Model m) throws Exception {
		m.addAttribute("now", DateFormat.getDateInstance().format(new Date()));
//		if (true) {
//			throw new Exception("some exception");
//		}
		return "hello";
	}

}
