package com.lyl.service.impl;

import com.lyl.mapper.CategoryMapper;
import com.lyl.mapper.NewsMapper;
import com.lyl.pojo.Category;
import com.lyl.pojo.News;
import com.lyl.pojo.NewsExample;
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

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<News> queryNews() {
		return newsMapper.selectByExample(null);
	}

	@Override
	public List<News> queryNewsByCondition(News news) {
		NewsExample newsExample = new NewsExample();
		NewsExample.Criteria criteria = newsExample.createCriteria();

		if (news != null && news.getCategoryid() != 0) {
			System.out.println(111);
			criteria.andCategoryidEqualTo(news.getCategoryid());
		}
		if (news != null && !"".equals(news.getTitle())) {
			System.out.println(222);
			criteria.andTitleLike("%" + news.getTitle() + "%");
		}

		return newsMapper.selectByExample(newsExample);
	}

	@Override
	public List<Category> findAllCategory() {
		return categoryMapper.selectByExample(null);
	}

	@Override
	public News findNewsById(Integer id) {
		return newsMapper.selectByPrimaryKey(id);
	}
}
