package com.dayary.elly.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.dayary.elly.common.tool.BCRYPT;
import com.dayary.elly.dao.MemberDao;
import com.dayary.elly.domain.Member;
import com.dayary.elly.domain.Status;

@Service
public class MemberSevice {

	private final MemberDao memberDao;

	public MemberSevice(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public Map<String, Object> signUp(Member member) {
		Map<String, Object> data = new HashMap<>();

		String hashedPassword = BCRYPT.hashpw(member.getPassword());
		member.setPassword(hashedPassword);

		memberDao.signUp(member);

		return data;
	}

	public Map<String, Object> login(Member member, HttpSession session) {
		Map<String, Object> data = new HashMap<>();

		Member dbMember = memberDao.getHashedPassword(member);

		if (dbMember == null) {// 존재하지 않는 아이디
			data.put("status", Status.UNREGISTERED_LOGIN_ID);
		} else {// 존재하는 아이디
			if (BCRYPT.checkpw(member.getPassword(), dbMember.getPassword())) {// 비밀번호 일치(로그인성공)
				dbMember.setPassword(null);//비밀번호제거
				session.setAttribute("member", dbMember);//세션등록
				data.put("status", Status.GOOD);
			} else {// 비밀번호 불일치
				data.put("status", Status.PASSWORD_MISMATCH);
			}
		}

		return data;
	}

}
