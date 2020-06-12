package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.vo.BoardVO;

@Service
@Transactional
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSessionFactory sqlFactory = null;

	@Override
	public int insertBoard(BoardVO obj) {
		// TODO Auto-generated method stub
		return sqlFactory.openSession().insert("Board.insertBoard", obj);
	}

	@Override
	public int updateHit(int no){
		// TODO Auto-generated method stub
		return sqlFactory.openSession().update("Board.updateHit", no);
	}

	@Override
	public List<BoardVO> selectBoard(HashMap<String,Object> map) {
		// TODO Auto-generated method stub
		return sqlFactory.openSession().selectList("Board.selectList", map);
	}

	@Override
	public BoardVO selectBoardOne(int no) {
		// TODO Auto-generated method stub
		return sqlFactory.openSession().selectOne("Board.selectBoardOne", no);
	}

	@Override
	public int updateBoard(BoardVO obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(BoardVO obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countBoard() {
		// TODO Auto-generated method stub
		return sqlFactory.openSession().selectOne("Board.count");
	}
	
	@Override
	public int insertBoardBatch(List<BoardVO> list) {
		return sqlFactory.openSession().insert("Board.insertBoardBatch",list);
	}
	@Override
	public BoardVO selectBoardImg(int no) {
		return sqlFactory.openSession().selectOne("Board.selectBoardImg", no);
	}
	
	
	
}
