package com.example.rest_controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.BoardDAO;
import com.example.dao.ItemDAO;
import com.example.dao.OrderDAO;
import com.example.vo.BoardVO;
import com.example.vo.ItemVO;
import com.example.vo.OrderVO;

@CrossOrigin("*") // CORS 해제
@RestController
public class RestItemController {

	@Autowired
	private ItemDAO iDAO = null;

	@Autowired
	private OrderDAO oDAO = null;
	
	@Autowired
	private BoardDAO bDAO = null;
	
	@RequestMapping(value = "/rest/itemorder.json", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HashMap<String, Object> itemOrder(){
		List<OrderVO> list = oDAO.selectItemOrder();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ret", list);
		return map;
	}
	
//	@RequestMapping(value = "/rest/boardlist.json", method = { RequestMethod.GET,
//			RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody HashMap<String, Object> boardlist(@RequestParam(value = "page", defaultValue = "1", required = false)int page){
//		
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		map.put("start",(page-1)*10+1);
//		map.put("end", page*10);
//		
//		List<BoardVO> list = bDAO.selectBoard(map);
//		HashMap<String, Object> map1 = new HashMap<String, Object>();
//
//		map1.put("ret", list);
//		
//		//int cnt = bDAO.countBoard();
//		
//		//model.addAttribute("list",list);
//		//model.addAttribute("cnt",(cnt-1)/10 +1);
//		
//		return map1;
//	}
	
	// 127.0.0.1:8080/rest/itemsearch.json?txt=사과&key=abc
	@RequestMapping(value = "/rest/itemsearch.json", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HashMap<String, Object> itemSearch(@RequestParam("txt") String txt,
			@RequestParam("key") String key) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (key.equals("abc")) {
			List<ItemVO> list = iDAO.selectItemSearch(txt);
			map.put("ret", 1);
			map.put("data", list);
		} else {
			map.put("ret", 0);
			map.put("error", "유효하지 않는 키입니다.");
		}
		return map;
	}

	// 127.0.0.1:8080/rest/itemone.json?no=1&key=abc
//	@RequestMapping(value = "/rest/itemone.json", method = { RequestMethod.GET,
//			RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody HashMap<String, Object> itemOne(@RequestParam("no") int no, @RequestParam("key") String key) {
//
//		HashMap<String, Object> map = new HashMap<String, Object>();
//
//		if (key.equals("abc")) {
//			ItemVO obj = iDAO.selectItemOne(no);
//			map.put("ret", 1);
//			map.put("data", obj);
//		} else {
//			map.put("ret", 0);
//			map.put("error", "유효하지 않는 키입니다.");
//		}
//
//		return map;
//	}

}
