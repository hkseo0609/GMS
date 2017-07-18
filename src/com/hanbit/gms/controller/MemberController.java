package com.hanbit.gms.controller;

import javax.swing.JOptionPane;

import com.hanbit.gms.constants.Butt;
import com.hanbit.gms.dao.MemberDAOImpl;
import com.hanbit.gms.domain.MemberBean;
import com.hanbit.gms.service.MemberService;
import com.hanbit.gms.service.MemberServiceImpl;

public class MemberController {
	public static void main(String[] args){
		
		MemberBean member = null;
		Butt[] buttons = {Butt.EXIT,Butt.ADD,Butt.LIST,Butt.FIND_NAME,Butt.FIND_ID,Butt.COUNT,Butt.UPDATE,Butt.DEL};
		
		do{
			flag:
			switch((Butt)JOptionPane.showInputDialog(
					null,//frame
					"member admin", //frame title
					"select menu", //order
					JOptionPane.QUESTION_MESSAGE, //type
					null, //icon
					buttons, //array of choices
					buttons[1] //default
							)){
			case EXIT:
				JOptionPane.showMessageDialog(null, "종료합니다.");
			return;
			case ADD:
				member = new MemberBean();
				String[] arr = (JOptionPane.showInputDialog("NAME/ID/PASSWORD/SSN")).split("/");
				member.setName(arr[0]);
				member.setId(arr[1]);
				member.setPwd(arr[2]);
				member.setSsn(arr[3]);
				JOptionPane.showMessageDialog(null, MemberServiceImpl.getInstance().addMember(member));
			break flag;
			case COUNT:
				JOptionPane.showMessageDialog(null, MemberServiceImpl.getInstance().countMembers());
				
			break flag;
			case LIST:
				JOptionPane.showMessageDialog(null, MemberServiceImpl.getInstance().getMembers());
			break flag;
			case FIND_ID:
				JOptionPane.showMessageDialog(null, MemberServiceImpl.getInstance().findByid(JOptionPane.showInputDialog("검색할 아이디를 입력하세요")));
			break flag;
			case FIND_NAME:
				JOptionPane.showMessageDialog(null, MemberServiceImpl.getInstance().findName(JOptionPane.showInputDialog("검색할 이름을 입력하세요")));
			break flag;
			case UPDATE: 
				MemberBean bean = new MemberBean();
				String[] arr2 = JOptionPane.showInputDialog("ID와 변경할 비밀번호 입력").split("/");
				bean.setId(arr2[0]);
				bean.setPwd(arr2[1]);
				JOptionPane.showMessageDialog(null, MemberServiceImpl.getInstance().modfiy(bean));
			break flag;
			case DEL: 
				JOptionPane.showMessageDialog(null, MemberServiceImpl.getInstance().remove(JOptionPane.showInputDialog("삭제하려는 아이디를 입력하세요")));
			break flag;
			
			}
		}while(true);
	}

}
