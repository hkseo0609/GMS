package com.hanbit.gms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.gms.constants.DB;
import com.hanbit.gms.domain.ArticleBean;

public class ArticleDAOImpl implements ArticleDAO {
	public ArticleDAOImpl() {
		try {
			Class.forName(DB.DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int insert(ArticleBean bean) {
		int rs=0;
		try {
			Connection conn = DriverManager.getConnection(DB.URL, DB.USERID, DB.PASSWORD);
			Statement stmt = conn.createStatement();
			rs = stmt.executeUpdate(String.format("insert into board values(article_seq.nextval,0,'%s','%s','%s',sysdate)", bean.getId(), bean.getTitle(), bean.getContent()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	@Override
	public List<ArticleBean> selectAll() {
		List<ArticleBean> list = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM board"));
			ArticleBean bean = null; 
			while(rs.next()){
				bean = new ArticleBean();
				bean.setArticleSeq(rs.getInt("article_seq"));
				bean.setHitcount(rs.getInt("hitcount"));
				bean.setId(rs.getString("id"));
				bean.setTitle(rs.getString("title"));
				bean.setContent(rs.getString("content"));
				bean.setRegdate(rs.getString("regdate"));
				list.add(bean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<ArticleBean> selectByid(String id) {
		List<ArticleBean> list = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM board WHERE id='%s'", id));
			ArticleBean bean = null; 
			while(rs.next()){
				bean = new ArticleBean();
				bean.setArticleSeq(rs.getInt("article_seq"));
				bean.setHitcount(rs.getInt("hitcount"));
				bean.setId(rs.getString("id"));
				bean.setTitle(rs.getString("title"));
				bean.setContent(rs.getString("content"));
				bean.setRegdate(rs.getString("regdate"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArticleBean selectBySeq(String seq) {
		ArticleBean bean = new ArticleBean();
		
		try {
			Connection conn = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM board WHERE article_seq='%s'", seq));
			if(rs.next()){
				bean.setArticleSeq(rs.getInt("article_seq"));
				bean.setHitcount(rs.getInt("hitcount"));
				bean.setId(rs.getString("id"));
				bean.setTitle(rs.getString("title"));
				bean.setContent(rs.getString("content"));
				bean.setRegdate(rs.getString("regdate"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public int count() {
		int count = 0;
		try {
			Connection conn = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(String.format("SELECT COUNT(*)AS count FROM board"));
			if(rs.next()){
				count = Integer.valueOf(rs.getString("count"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public String update(ArticleBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(String seq) {
		int rs=0;
		try {
			Connection conn = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD);
			Statement stmt = conn.createStatement();
			rs = stmt.executeUpdate(String.format("delete * from board where article_seq='%s'",seq));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
