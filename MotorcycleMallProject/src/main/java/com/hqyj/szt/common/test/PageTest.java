package com.hqyj.szt.common.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 此类为测试页面的类@Controller
 * 并没有调用方法，使用
 * @author ZengShiqi
 *
 */
@Controller
@RequestMapping("/common")
public class PageTest {

	/**
	 * 127.0.0.1:8080/common/indexTest
	 * @return
	 */
	@RequestMapping("/indexTest")
	public String FirstPageTest() {
		return "index";
	}
}
