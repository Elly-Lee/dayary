package com.dayary.elly.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Diary {
	private int id; 
	private String regDate;
	private String memberId;
	private String fileName;
	private String fileExtension;
	private String body;
}