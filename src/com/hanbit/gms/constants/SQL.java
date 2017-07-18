package com.hanbit.gms.constants;

public class SQL {
	public static final String MEMBER_INSERT=String.format("insert into %s values(?,?,?,?, SYSDATE)",DB.TABLE_MEMBER,DB.MEM_ID,DB.MEM_PWD,DB.MEM_NAME,DB.MEM_SSN);
	public static final String MEMBER_LIST="SELECT * FROM MEMBER";
	public static final String MEMBER_FINDBYNAME=String.format("SELECT * FROM MEMBER WHERE name=?",DB.MEM_NAME);
	public static final String MEMBER_FINDBYID=String.format("SELECT * FROM MEMBER WHERE id=?",DB.MEM_ID);
	public static final String MEMBER_COUNT="SELECT COUNT(*)AS count FROM MEMBER";
	public static final String MEMBER_UPDATE=String.format("UPDATE MEMBER SET %s=? WHERE %s=?",DB.MEM_PWD,DB.MEM_ID);
	public static final String MEMBER_DELETE=String.format("DELETE FROM MEMBER WHERE %s=?",DB.MEM_ID);

	public static final String BOARD_INSERT=String.format("insert into %s(%s,%s,%s,%s,%s,%s) values(article_seq.nextval,0,?,?,?,SYSDATE)",DB.TABLE_BOARD,DB.BOARD_SEQ,DB.BOARD_HIT,DB.BOARD_ID,DB.BOARD_TITLE,DB.BOARD_CONTENT,DB.BOARD_REGDATE);
	public static final String BOARD_LIST=String.format("SELECT * FROM %s",DB.TABLE_BOARD);
	public static final String BOARD_FINDBYSEQ=String.format("SELECT * FROM %s WHERE %s=?",DB.TABLE_BOARD, DB.BOARD_SEQ);
	public static final String BOARD_FINDBYID=String.format("SELECT * FROM %s WHERE %s=?",DB.TABLE_BOARD, DB.MEM_ID);
	public static final String BOARD_COUNT="SELECT COUNT(*)AS count FROM BOARD";
	public static final String BOARD_UPDATE=String.format("UPDATE %s SET %s=?, %s=? WHERE %s=?",DB.TABLE_BOARD,DB.BOARD_TITLE,DB.BOARD_CONTENT,DB.BOARD_SEQ);
	public static final String BOARD_DELETE=String.format("DELETE FROM %s WHERE %s=?",DB.TABLE_BOARD,DB.BOARD_SEQ);
}
