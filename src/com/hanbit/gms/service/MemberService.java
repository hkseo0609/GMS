package com.hanbit.gms.service;

import java.util.List;

import com.hanbit.gms.domain.MemberBean;

public interface MemberService {
	//목록을 보여주는 list / getter
	//public MemberBean[] getMembers();
	public List<MemberBean> getMembers();
	//회원수 구하는 것 / getter
	public String countMembers();
	//회원 가입(join)시키는 것 / setter
	public String addMember(MemberBean member);
	public MemberBean findByid(String id);
	public List<MemberBean> findName(String name);
	//비밀번호는 개인정보니까 노출이 되면 안되니 콩깍지에 넣어서 보내기
	public String modfiy(MemberBean bean);
	public String remove(String id);

}
