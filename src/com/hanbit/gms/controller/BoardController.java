package com.hanbit.gms.controller;

import javax.swing.JOptionPane;

import com.hanbit.gms.constants.Butt;
import com.hanbit.gms.domain.ArticleBean;
import com.hanbit.gms.service.ArticleServiceImpl;
public class BoardController {
	public static void main(String[] args) {
		ArticleBean bean = null;
		Butt[] buttons = {Butt.EXIT,Butt.WRITE,Butt.LIST,Butt.FIND_ID,Butt.FIND_SEQ,Butt.COUNT,Butt.UPDATE,Butt.DEL};
		do{
			flag:
			switch((Butt)JOptionPane.showInputDialog(
					null,
					"board",
					"board menu", 
					JOptionPane.QUESTION_MESSAGE,
					null, 
					buttons,
					buttons[1] 
							)){
			case EXIT:
				JOptionPane.showMessageDialog(null, "종료합니다.");
				return;
			case WRITE:
				bean = new ArticleBean();
				bean.setId(JOptionPane.showInputDialog("아이디를 입력하세요."));
				bean.setTitle(JOptionPane.showInputDialog("제목을 입력하세요."));
				bean.setContent(JOptionPane.showInputDialog("내용을 입력하세요."));
				ArticleServiceImpl.getInstance().write(bean);
				break flag;
			case LIST:
				JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().list());
				break flag;
			case FIND_ID:
				JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().findByid(JOptionPane.showInputDialog("검색할 아이디를 입력하세요.")));
				break flag;
			case FIND_SEQ:
				JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().findBySeq(JOptionPane.showInputDialog("검색할 글번호를 입력하세요.")));
				break flag;
			case COUNT:
				JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().count());
				break flag;
			case UPDATE:
				bean = new ArticleBean();
				bean.setArticleSeq(Integer.parseInt(JOptionPane.showInputDialog("수정할 글번호를 입력하세요.")));
				bean.setTitle(JOptionPane.showInputDialog("수정할 글제목을 입력하세요"));
				bean.setContent(JOptionPane.showInputDialog("수정할 글내용을 입력하세요"));
				JOptionPane.showMessageDialog(null,ArticleServiceImpl.getInstance().modfiy(bean));
				break flag;
				
			case DEL:
				JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().remove(JOptionPane.showInputDialog("삭제할 글번호를 입력하세요.")));
				break flag;
			}
		}while(true);
		
	}

}
