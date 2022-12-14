package com.lyl.controller;

import com.lyl.pojo.NewsCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/12/14
 */

@Controller
public class NewsController {

	private static final String QUERY_NEWS = "http://localhost:8899/news-query/";

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/queryNews")
	public ModelAndView queryNews(@ModelAttribute("newsCondition") NewsCondition newsCondition) {
		ModelAndView mv = new ModelAndView();

		List newsList = restTemplate.getForObject(QUERY_NEWS + "queryNews", List.class);
		List categoryList = restTemplate.getForObject(QUERY_NEWS + "findAllCategory", List.class);

		mv.addObject("newsList", newsList);
		mv.addObject("categoryList", categoryList);
		mv.setViewName("index");

		return mv;
	}

	@PostMapping("/queryNewsByCondition")
	public ModelAndView queryNewsByCondition(@ModelAttribute("newsCondition") NewsCondition newsCondition) {
		ModelAndView mv = new ModelAndView();

		List newsList = restTemplate.postForObject(QUERY_NEWS + "queryNewsByCondition", newsCondition, List.class);
		List categoryList = restTemplate.getForObject(QUERY_NEWS + "findAllCategory", List.class);

		mv.addObject("newsList", newsList);
		mv.addObject("categoryList", categoryList);
		mv.setViewName("index");

		return mv;
	}

}
