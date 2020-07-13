package com.dayary.elly.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Heart {
	private int id; 
	private String regDate;
	private String diaryId;
	private String memberId;
}