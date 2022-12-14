package com.lyl.service;

import com.lyl.pojo.Category;
import com.lyl.pojo.News;

import java.util.List;

/**
 * 功能：
 *
 * @author 林亦亮
 * @version 1.0
 * @date 2022/12/13
 */

public interface NewsQueryService {

	List<News> queryNews();

	List<News> queryNewsByCondition(News news);

	List<Category> findAllCategory();

	News findNewsById(Integer id);
}
