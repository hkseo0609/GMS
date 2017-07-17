package com.hanbit.gms.service;

import java.util.List;

import com.hanbit.gms.dao.ArticleDAO;
import com.hanbit.gms.dao.ArticleDAOImpl;
import com.hanbit.gms.domain.ArticleBean;
public class ArticleServiceImpl implements ArticleService{

	@Override
	public String write(ArticleBean bean) {
		String msg = "";
		ArticleDAO dao = new ArticleDAOImpl();
		int result = dao.insert(bean);
		if(result==1){
			msg = "등록되었습니다.";
		}else{
			msg = "등록에 실패하였습니다.";
		}
		return msg;
	}

	@Override
	public List<ArticleBean> list() {
		return new ArticleDAOImpl().selectAll();
	}

	@Override
	public List<ArticleBean> findByid(String id) {
		return new ArticleDAOImpl().selectByid(id);
	}

	@Override
	public ArticleBean findBySeq(String seq) {
		return new ArticleDAOImpl().selectBySeq(seq);
	}

	@Override
	public int count() {
		return new ArticleDAOImpl().count();
	}

	@Override
	public String modfiy(ArticleBean bean) {
		return null;
	}

	@Override
	public String remove(String seq) {
		String msg = "";
		ArticleDAO dao = new ArticleDAOImpl();
		int result = dao.delete(seq);
		if(result==1){
			msg = "삭제되었습니다.";
		}else{
			msg = "삭제에 실패하였습니다.";
		}
		return msg;
	}

}
