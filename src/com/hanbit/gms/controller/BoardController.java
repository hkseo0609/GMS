package com.hanbit.gms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.hanbit.gms.constants.Butt;
import com.hanbit.gms.domain.ArticleBean;
import com.hanbit.gms.service.ArticleService;
import com.hanbit.gms.service.ArticleServiceImpl;
public class BoardController {
	public static void main(String[] args) {
		ArticleService service = new ArticleServiceImpl();
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
				service.write(bean);
				break;
			case LIST:
				JOptionPane.showMessageDialog(null, service.list());
				break;
			case FIND_ID:
				JOptionPane.showMessageDialog(null, service.findByid(JOptionPane.showInputDialog("검색할 아이디를 입력하세요.")));
				break;
			case FIND_SEQ:
				JOptionPane.showMessageDialog(null, service.findBySeq(JOptionPane.showInputDialog("검색할 글번호를 입력하세요.")));
				break;
			case COUNT:
				JOptionPane.showMessageDialog(null, service.count());
				break;
			case UPDATE:
				break;
			case DEL:
				JOptionPane.showMessageDialog(null, service.remove(JOptionPane.showInputDialog("삭제할 글번호를 입력하세요.")));
				break flag;
			}
		}while(true);
		
	}

}
