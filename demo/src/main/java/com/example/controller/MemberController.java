package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.MemberDAO;
import com.example.vo.MemberVO;

@Controller
@RequestMapping(value = "/member")
@ComponentScan({"com.example.controller","com.example.dao"})
public class MemberController {
	
	@Autowired
	private MemberDAO mDAO = null;
	
	//단축키 ctrl + shift + ? : 주석문
	//단축키 ctrl + shift + f : 자동 정렬
	
	@RequestMapping(value = "/memberlist")
	public String memberList(Model model) {
		
		List<MemberVO> list = mDAO.selectMemberList();
//		for (MemberVO tmp:list) {
//			System.out.println(tmp.getUserid());
//		}
		
		model.addAttribute("list", list);
		return "memberlist";
	}

	@RequestMapping(value = "/login",  method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginpost(@ModelAttribute MemberVO obj, HttpSession httpSession) {
		
		MemberVO obj1 = mDAO.selectMemberLogin(obj);
		
		if (obj1 != null) {
			httpSession.setAttribute("SESSION_ID", obj1.getUserid());
			return "redirect:/";
		}
		return "redirect:/member/login";
	
	}
	
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "join";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinpost(@ModelAttribute MemberVO obj) {
		System.out.println(obj.toString());
		
		int ret = mDAO.insertMember(obj);
		
		if(ret > 0 ) {
			return "redirect:/";
		}
	
		return "redirect:/member/login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:/";
	}
	

}
