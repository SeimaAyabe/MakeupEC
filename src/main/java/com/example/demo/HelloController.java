package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		// 入力フォームで取り扱うオブジェクトを設定
		mav.setViewName("index");
		mav.addObject("msg","お名前を書いて送信してください");
		// 表示するHTMLを指定
		return mav;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView send(@RequestParam("text1")String str, ModelAndView mav) {
		// 入力フォームで取り扱うオブジェクトを設定
		mav.setViewName("index");
		mav.addObject("msg","こんにちは、" + str + "さん！");
		mav.addObject("value",str);
		// 表示するHTMLを指定
		return mav;
	}
}