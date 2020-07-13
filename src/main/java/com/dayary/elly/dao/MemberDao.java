package com.dayary.elly.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dayary.elly.domain.Member;

@Mapper
public interface MemberDao {

	int signUp(Member member);

	Member getHashedPassword(Member member);
}
