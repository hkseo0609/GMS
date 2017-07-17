package com.hanbit.gms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.gms.constants.DB;
import com.hanbit.gms.domain.MemberBean;

public class MemberDAOImpl implements MemberDAO{
	public MemberDAOImpl(){
		try {
			Class.forName(DB.DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("drive load fail...");
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberBean> selectAll() {
		List<MemberBean> list = new ArrayList<>();
		
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(String.format("SELECT * FROM MEMBER"));
			MemberBean member = null;
			while(rs.next()){
				member = new MemberBean();
				member.setId(rs.getString(DB.MEM_ID));
				member.setName(rs.getString(DB.MEM_NAME));
				member.setPwd(rs.getString(DB.MEM_PWD));
				member.setSsn(rs.getString(DB.MEM_SSN));
				member.setRegdate(rs.getString(DB.MEM_REGDATE));
				list.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int count() {
		int count=0;
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(String.format("SELECT COUNT(*)AS count FROM MEMBER"));
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
	public int insert(MemberBean member) {
		int rs=0;
		try {
			Connection conn = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD);
			Statement stmt = conn.createStatement();
			rs = stmt.executeUpdate(String.format("insert into %s values('%s', '%s', '%s', '%s', SYSDATE)",DB.TABLE_MEMBER,member.getId(),member.getPwd(),member.getName(),member.getSsn()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
		
		
	}

	@Override
	public MemberBean selectByid(String id) {
		MemberBean member = new MemberBean();
		try {
			Connection conn = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM MEMBER WHERE id='%s'",id));
			
			if(rs.next()){
				member.setId(rs.getString(DB.MEM_ID));
				member.setName(rs.getString(DB.MEM_NAME));
				member.setPwd(rs.getString(DB.MEM_PWD));
				member.setRegdate(rs.getString(DB.MEM_REGDATE));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
         return member;
	}

	@Override
	public List<MemberBean> selectByName(String name) {
		List<MemberBean> list = new ArrayList<>();
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(String.format("SELECT * FROM MEMBER WHERE name='%s'",name));
			MemberBean member = null;
			while(rs.next()){
				member = new MemberBean();
				member.setId(rs.getString(DB.MEM_ID));
				member.setName(rs.getString(DB.MEM_NAME));
				member.setPwd(rs.getString(DB.MEM_PWD));
				member.setRegdate(rs.getString(DB.MEM_REGDATE));
				list.add(member);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int update(MemberBean bean) {
		int rs=0;
		try {
			rs = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeUpdate(
					String.format("insert into %s values('%s', '%s', '%s', '%s', SYSDATE)",DB.TABLE_MEMBER,bean.getId(),bean.getPwd(),bean.getName(),bean.getSsn()));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}

	@Override
	public int delete(String id) {
		int rs=0;
		try {
			Connection conn = DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD);
			Statement stmt = conn.createStatement();
			rs = stmt.executeUpdate(String.format("%s",""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}

}
