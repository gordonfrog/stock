package com.lanl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lanl.model.Member;
import com.lanl.repository.MemberRepository;

@Controller
@RequestMapping("/admin/memberenquiry")
public class MemberEnquiryController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@RequestMapping
	public String showMemberEnquiryPage(Model model) {
		List<Member> members = (List<Member>) memberRepository.findAll();
		
		model.addAttribute("members", members);
		
		return "memberenquiry";
	}

}
