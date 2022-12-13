package com.lyl.service.impl;

import com.lyl.mapper.NewsMapper;
import com.lyl.pojo.News;
import com.lyl.service.NewsQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/12/13
 */

@Service
public class NewsQueryServiceImpl implements NewsQueryService {

	@Autowired
	private NewsMapper newsMapper;

	@Override
	public List<News> queryNews() {
		return newsMapper.selectByExample(null);
	}
}
