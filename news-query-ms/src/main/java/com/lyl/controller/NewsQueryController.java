package com.lyl.controller;

import com.lyl.pojo.Category;
import com.lyl.pojo.News;
import com.lyl.service.NewsQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/12/13
 */

@RestController
public class NewsQueryController {

	@Autowired
	private NewsQueryService newsQueryService;

	@GetMapping("/queryNews")
	public List<News> queryNews() {
		return newsQueryService.queryNews();
	}

	@GetMapping("/findAllCategory")
	public List<Category> findAllCategory() {
		return newsQueryService.findAllCategory();
	}

	@PostMapping("/queryNewsByCondition")
	public List<News> queryNewsByCondition(@RequestBody News news) {
		return newsQueryService.queryNewsByCondition(news);
	}

	@GetMapping("/findNewsById")
	public News findNewsById(Integer id) {
		return newsQueryService.findNewsById(id);
	}
}
