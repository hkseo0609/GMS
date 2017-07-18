package com.hanbit.gms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.gms.constants.DB;
import com.hanbit.gms.constants.SQL;
import com.hanbit.gms.constants.Vendor;
import com.hanbit.gms.domain.MemberBean;
import com.hanbit.gms.factory.DatabaseFactory;

public class MemberDAOImpl implements MemberDAO{
	/*싱글턴 패턴 static으로 dao 미리 생성
	public static MemberDAOImpl instance = new MemberDAOImpl();*/
	public static MemberDAOImpl getInstance() {
		return new MemberDAOImpl();
	}

	private MemberDAOImpl(){
	}

	@Override
	public List<MemberBean> selectAll() {
		List<MemberBean> list = new ArrayList<>();
		try {
			ResultSet rs = DatabaseFactory.createDatabse(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_LIST).executeQuery();
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
	public String count() {
		int count=0;
		try {
			ResultSet rs=DatabaseFactory.createDatabse(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_COUNT).executeQuery();

			if(rs.next()){
				count = Integer.valueOf(rs.getString("count"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.valueOf(count);
	}

	@Override
	public String insert(MemberBean member) {
		int rs=0;
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabse(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_INSERT);
			pstmt.setString(1,member.getId());
			pstmt.setString(2,member.getPwd());
			pstmt.setString(3,member.getName());
			pstmt.setString(4,member.getSsn());
			rs = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return String.valueOf(rs);
		
		
	}

	@Override
	public MemberBean selectByid(String id) {
		MemberBean member = new MemberBean();
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabse(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_FINDBYID);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
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
			PreparedStatement pstmt = DatabaseFactory.createDatabse(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_FINDBYNAME);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
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
	public String update(MemberBean bean) {
		String rs="";
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabse(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_UPDATE);
			pstmt.setString(1, bean.getPwd());
			pstmt.setString(2, bean.getId());
			rs=String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}

	@Override
	public String delete(String id) {
		String rs="";
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabse(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_DELETE);
			pstmt.setString(1, id);
			rs = String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}

}
