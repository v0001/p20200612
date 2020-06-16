package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.vo.ItemVO;

@Service
@Transactional
public class ItemDAO {
	
	@Autowired
	private SqlSessionFactory sqlFactory = null;

	public int countItem(){
		return sqlFactory.openSession().update("Item.count");
	}

	public List<ItemVO> selectItem(HashMap<String,Object> map){
		return sqlFactory.openSession().selectList("Item.selectList", map);
	}
	
	
	public List<ItemVO> selectItemSearch(String txt){
		return sqlFactory.openSession().selectList("Item.searchItem", txt);
	}
	
	public int insertItemBatch(List<ItemVO> list) {
		return sqlFactory.openSession().insert("Item.insertItemBatch",list);
		
	}

	public List<ItemVO> selectItemList() {
		return sqlFactory.openSession().selectList("Item.selectList");
	}
	
	public int deleteItemBatch(int[] no) {
		return sqlFactory.openSession().delete("Item.deleteItemBatch",no);
		
	}
	public List<ItemVO> selectItemWhere(int[] itemno) {
		return sqlFactory.openSession().selectList("Item.selectItemWhere",itemno);
		
	}
	public int updateItemBatch(int[] itemno) {		
		return sqlFactory.openSession().update("Item.updateItemBatch",itemno);
	
	}
	public int deleteItemOne(int no) {
		return sqlFactory.openSession().delete("Item.deleteItemOne",no);
	}
	


}
