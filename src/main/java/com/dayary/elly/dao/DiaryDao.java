package com.dayary.elly.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dayary.elly.domain.Diary;

@Mapper
public interface DiaryDao {

	List<Diary> getDiarys();

	Diary getDiary(@Param("id") int id);
	

}
