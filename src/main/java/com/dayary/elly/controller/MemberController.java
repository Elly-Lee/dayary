package com.dayary.elly.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dayary.elly.domain.Member;
import com.dayary.elly.service.MemberSevice;

@Controller
@RequestMapping("/member")
public class MemberController {

	private final MemberSevice memberService;

	public MemberController(MemberSevice memberService) {
		this.memberService = memberService;
	}

	/**
	 * 회원가입
	 * 
	 * @param member
	 * @return
	 */
	@PostMapping("/signUp")
	@ResponseBody
	public Map<String, Object> signUp(Member member) {
		return memberService.signUp(member);
	}

	/**
	 * 로그인
	 * 
	 * @param member
	 * @param session
	 * @return
	 */
	@PostMapping("/login")
	@ResponseBody
	public Map<String, Object> doLogin(Member member, HttpSession session) {
		return memberService.login(member, session);
	}

}
