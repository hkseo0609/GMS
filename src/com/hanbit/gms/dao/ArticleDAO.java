package com.hanbit.gms.dao;

import java.util.List;

import com.hanbit.gms.domain.ArticleBean;

public interface ArticleDAO {
	public int insert(ArticleBean bean);
	public List<ArticleBean> selectAll();
	public List<ArticleBean> selectByid(String id);
	public ArticleBean selectBySeq(String seq);
	public int count();
	public String update(ArticleBean bean);
	public int delete(String seq);

}
