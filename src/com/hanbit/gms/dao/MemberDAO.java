package com.hanbit.gms.dao;

import java.util.List;

import com.hanbit.gms.domain.MemberBean;

public interface MemberDAO {
	public List<MemberBean> selectAll();
	public String count();
	public String insert(MemberBean member);
	public MemberBean selectByid(String id);
	public List<MemberBean> selectByName(String name);
	public String update(MemberBean bean);
	public String delete(String id);

}
