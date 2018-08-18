package com.demo.springboot.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 3.新增加一个类GlobalExceptionHandler，用于捕捉Exception异常以及其子类。
 * @author lenovo
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("exception", e);
		mv.addObject("url", req.getRequestURI());
		mv.setViewName("errorPage");//发出异常的地址放进ModelAndView里，然后跳转到 errorPage.jsp
		return mv;
	}

}
