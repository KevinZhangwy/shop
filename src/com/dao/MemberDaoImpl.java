package com.dao;

import java.util.List;

import com.model.Member;
import com.tools.ChStr;
import com.tools.ConnDB;

public class MemberDaoImpl implements MemberDao {
private ConnDB conn=new ConnDB();
private ChStr chStr=new ChStr();
	@Override
	public int insert(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List select() {
		// TODO Auto-generated method stub
		return null;
	}

}
