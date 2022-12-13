package com.lyl.controller;

import com.lyl.pojo.News;
import com.lyl.service.NewsQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("queryNews")
	public List<News> queryNews() {
		return newsQueryService.queryNews();
	}
}
