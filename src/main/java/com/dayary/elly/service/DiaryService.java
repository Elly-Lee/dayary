package com.dayary.elly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayary.elly.dao.DiaryDao;
import com.dayary.elly.domain.Diary;

@Service
public class DiaryService {

	@Autowired
	private DiaryDao diaryDao;
	
	public List<Diary> getDiarys() {
		return diaryDao.getDiarys();
	}

	public Diary getDiary(int id) {
		return diaryDao.getDiary(id);
	}

	
}
