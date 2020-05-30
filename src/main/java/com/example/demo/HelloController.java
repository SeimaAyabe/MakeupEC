package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.repositories.UsersRepository;

@Controller
public class HelloController {

	@Autowired
    private UsersRepository usersRepository;

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

	@RequestMapping(value = "/test1", method = RequestMethod.GET)
    public ModelAndView indextwo(ModelAndView mav) {
		mav.setViewName("index");
		System.out.println(usersRepository.findAll());
        Iterable<Users> list = usersRepository.findAll();
        mav.addObject("data", list);
        return mav;
    }
}