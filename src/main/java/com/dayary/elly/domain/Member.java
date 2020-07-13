package com.dayary.elly.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Member {
	private int id; 
	private String regDate;
	private String loginId;
	private String password;
	private String nickName;
}