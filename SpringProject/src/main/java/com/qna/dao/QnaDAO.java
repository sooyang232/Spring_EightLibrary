package com.qna.dao;

import java.util.*;

import com.qna.domain.QnaCommand;

public interface QnaDAO {

	//1.글목록보기
	public List<QnaCommand> list(Map<String,Object>map);
	
	//2.총레코드수(검색어에 맞는 레코드수까지 포함)
		public int getRowCount(Map<String,Object> map);

	// 3.최대글번호 구하기
	public int getNewSeq();
}

