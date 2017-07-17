package com.hanbit.gms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanbit.gms.dao.MemberDAO;
import com.hanbit.gms.dao.MemberDAOImpl;
import com.hanbit.gms.domain.MemberBean;

public class MemberServiceImpl implements MemberService {
	Map<String,MemberBean> map;
	MemberBean member;
	
	public MemberServiceImpl() {
		map = new HashMap<>();
		member = new MemberBean();
	}
	@Override
	public String addMember(MemberBean member) {
		String msg = "";
		MemberDAO dao = new MemberDAOImpl();
		int rs = dao.insert(member);
		msg = (rs==1)?msg="등록 성공":"등록 실패";
		return msg;
	}

	@Override
	public int countMembers() {
		MemberDAO dao = new MemberDAOImpl();
		int rs = dao.count();
		return rs;
	}
	
	@Override
	public List<MemberBean> getMembers() {
		
		return new MemberDAOImpl().selectAll();
	}
	
	@Override
	public MemberBean findByid(String id) {
		MemberBean member = new MemberBean();
		MemberDAO dao = new MemberDAOImpl();
		member = dao.selectByid(id);
		return member;
	}
	
	@Override
	public List<MemberBean> findName(String name) {
		return new MemberDAOImpl().selectByName(name);
	}
	
	@Override
	public String modfiy(MemberBean bean) {
		String msg = "";
		return msg;
			
	}	
	@Override
	public String remove(String deleteId) {
		String msg = "";
		return msg;
	}


}
