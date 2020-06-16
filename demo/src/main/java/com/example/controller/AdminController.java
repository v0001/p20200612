package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.example.dao.ItemDAO;
import com.example.dao.MemberDAO;
import com.example.vo.ItemVO;
import com.example.vo.MemberVO;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private ItemDAO iDAO = null;
	@Autowired
	private MemberDAO mDAO = null;
	
	@RequestMapping(value = "/home")
	public String home() {
		return "/admin/home";
	}
	
	@RequestMapping(value = "/iteminsert")
	public String iteminsert() {
		return "/admin/iteminsert";
	}
	
	@RequestMapping(value = "/iteminsert", method=RequestMethod.POST)
	public String iteminsertpost(
			@RequestParam("name[]") String[] name,
			@RequestParam("price[]") int[] price,
			@RequestParam("qty[]") int[] qty,
			@RequestParam("content[]") String[] content) {
		
		List<ItemVO> list = new ArrayList<ItemVO>();
		for(int i=0; i<name.length; i++) {
			ItemVO obj = new ItemVO();
			obj.setItemname(name[i]);
			obj.setItemprice(price[i]);
			obj.setItemqty(qty[i]);
			obj.setItemdes(content[i]);
			
			list.add(obj);
		}
		

		iDAO.insertItemBatch(list);
		
		return "redirect:/admin/home"; //<a href="/admin/home">자동화</a>
	}
	
	@RequestMapping(value="/item")
	public String itemlist(Model model) {
		List<ItemVO> list = iDAO.selectItemList();
		model.addAttribute("list", list);
		return "/admin/item";
	}
	
	@RequestMapping(value="/item", method = RequestMethod.POST)
	public String itembatch(@RequestParam("btn") String btn,
			RedirectAttributes redirectAttributes,
			@RequestParam(value = "chk[]", required = false) int[] itemno) {

		if(btn.equals("일괄삭제")) {
			iDAO.deleteItemBatch(itemno);
			
		}
		else if( btn.equals("일괄수정")) {
			redirectAttributes.addFlashAttribute("abc", itemno);
			System.out.println(itemno);
			System.out.println("Success");
			return "redirect:/admin/itemupdate";

			
		}		
		return "redirect:/admin/home";
	}
	
	@RequestMapping(value="/itemupdate")
	public String itemupdate(Model model, HttpServletRequest req) {
		
		Map<String, ?> map = RequestContextUtils.getInputFlashMap(req);

		if(map != null) {
			
			int[] tmp = (int[]) map.get("abc");
			
			for(int i=0;i<tmp.length;i++) {
				System.out.println(tmp[i]);
			}
			//DAO를 이용하여 물품번호에 해당하는 목록만 가져오기
			//JSP로 전달 후 화면 표시		
			//SELECT * FROM ITEM WHERE ITEMNO IN(1,2,3)
			
			List<ItemVO> list = iDAO.selectItemWhere(tmp);
			model.addAttribute("list",list);
			
			return "/admin/itemupdate";
		}
		else {
			return "redirect:/admin/item";
		}
	}
	
	@RequestMapping(value="/itemupdate", method = RequestMethod.POST)
	public String itemupdatepost(
			@RequestParam("no[]") int[] no,
			@RequestParam("name[]") String[] name,
			@RequestParam("price[]") int[] price,
			@RequestParam("qty[]") int[] qty,
			@RequestParam("des[]") String[] des) {
		
		List<ItemVO> list =  new ArrayList<ItemVO>();

		for(int i = 0; i <no.length ; i++) {
			ItemVO obj = new ItemVO();
			obj.setItemno(no[i]);
			obj.setItemname(name[i]);
			obj.setItemprice(price[i]);
			obj.setItemqty(qty[i]);
			obj.setItemdes(des[i]);
			list.add(obj);
		}
			return "redirect:/admin/item";
	}
	
	@RequestMapping(value="/memberlist")
	public String memberList(Model model) {
		
		List<MemberVO> list = mDAO.selectMemberList();		
		model.addAttribute("list", list);
		return "/admin/memberlist";
	}
	
	@RequestMapping(value="/memberlist", method = RequestMethod.POST)
	public String memberBatch(@RequestParam("btn") String btn,
			@RequestParam(value = "chk[]", required = false) String[] userid) {

		if(btn.equals("일괄삭제")) {
			mDAO.deleteMemberBatch(userid);
		}
		return "redirect:/admin/home";
	}
	
	@RequestMapping(value = "/itemdeleteone")
	public String itemdeleteone(
			@RequestParam(value="no", defaultValue = "0") int no) {
		
		iDAO.deleteItemOne(no);
		return "redirect:/admin/item";
	}
	
	@RequestMapping(value="/itemorder")
	public String itemorder() {

		return "/admin/itemorder";
		
	}
	
	
	
}

