package com.hanbit.gms.domain;

import java.io.Serializable;

public class ArticleBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int articleSeq, hitcount;
	private String id, title, content, regdate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getArticleSeq() {
		return articleSeq;
	}
	public void setArticleSeq(int articleSeq) {
		this.articleSeq = articleSeq;
	}
	
	public int getHitcount() {
		return hitcount;
	}
	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String toString(){
		return "id: "+id+"\n"+
				"글번호: "+articleSeq+"\n"+
				"조회수: "+hitcount+"\n"+
				"글제목: "+title+"\n"+
				"글내용: "+content+"\n"+
				regdate+"\n"+
				"--------------------------\n";
	}
	

}
