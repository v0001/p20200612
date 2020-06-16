package com.example.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.vo.MemberVO;

@Service
@Transactional
public class MemberDAO {
	
	@Autowired
	private SqlSessionFactory sqlFactory = null;

	public int insertMember(MemberVO obj){
		return sqlFactory.openSession().insert("Member.join", obj);
		
	}
	
	public List<MemberVO> selectMemberList(){
		return sqlFactory.openSession().selectList("Member.memberList");
	}

	public MemberVO selectMemberLogin(MemberVO obj) {
		return sqlFactory.openSession().selectOne("Member.login",obj);
	}
	
	public int deleteMemberBatch(String[] userid) {
		return sqlFactory.openSession().delete("Member.deleteMemberBatch",userid);
		
	}
	
}
