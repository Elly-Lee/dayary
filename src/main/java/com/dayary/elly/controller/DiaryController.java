package com.dayary.elly.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dayary.elly.domain.Diary;
import com.dayary.elly.domain.Member;
import com.dayary.elly.service.DiaryService;

@Controller
public class DiaryController {

	@Autowired
	private DiaryService diaryService;

	@RequestMapping("/diary/list")
	public String showList(Model model, Member member, HttpSession session) {
		List<Diary> diarys = diaryService.getDiarys();
		model.addAttribute("diarys", diarys);

		member = (Member) session.getAttribute("member");
		model.addAttribute("member", member);

		return "diary/list";
	}

	@RequestMapping("/diary/detail")
	public String showDetail(Model model, int id) {
		Diary diary = diaryService.getDiary(id);

		model.addAttribute("diary", diary);

		return "diary/detail";
	}
}
