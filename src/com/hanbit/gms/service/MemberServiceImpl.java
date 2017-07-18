package com.hanbit.gms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanbit.gms.dao.MemberDAO;
import com.hanbit.gms.dao.MemberDAOImpl;
import com.hanbit.gms.domain.MemberBean;

public class MemberServiceImpl implements MemberService {
	public static MemberServiceImpl instance = new MemberServiceImpl();
	
	public static MemberServiceImpl getInstance() {
		return instance;
	}
	private MemberServiceImpl() {
		
	}
	@Override
	public String addMember(MemberBean member) {
		String msg = "";
		String rs = MemberDAOImpl.getInstance().insert(member);
		msg = (Integer.parseInt(rs)==1)?msg="등록 성공":"등록 실패";
		return msg;
	}

	@Override
	public String countMembers() {
		return String.valueOf(MemberDAOImpl.getInstance().count());
	}
	
	@Override
	public List<MemberBean> getMembers() {
		
		return MemberDAOImpl.getInstance().selectAll();
	}
	
	@Override
	public MemberBean findByid(String id) {
	
		return MemberDAOImpl.getInstance().selectByid(id);
	}
	
	@Override
	public List<MemberBean> findName(String name) {
		return MemberDAOImpl.getInstance().selectByName(name);
	}
	
	@Override
	public String modfiy(MemberBean bean) {
		String msg = "";
		String rs = MemberDAOImpl.getInstance().update(bean);
		msg = (Integer.parseInt(rs)==1)?msg="수정 성공":"수정 실패";
		return msg;
			
	}	
	@Override
	public String remove(String deleteId) {
		String msg = "";
		String rs = MemberDAOImpl.getInstance().delete(deleteId);
		msg = (Integer.parseInt(rs)==1)?msg="삭제 성공":"삭제 실패";
		return msg;
	}


}
