package com.qna.dao;

import java.util.List;
import java.util.Map;

import com.qna.domain.QnaCommand;

public interface QnaDAO {

	//1.글목록보기
	public List<QnaCommand> list(Map<String,Object>map);
	
	//2.총레코드수(검색어에 맞는 레코드수까지 포함)
	public int getRowCount(Map<String,Object> map);

	// 3.최대글번호 구하기
	public int getNewSeq();
	
	//4.게시판의 글쓰기
	public void insert(QnaCommand qna);
		
	//5.게시물번호에 해당하는 조회수 증가 
	public void updateHit(Integer seq);//~(int seq)=>(Integer seq)
	  
	//6.게시물에 대한 레코드 한개 찾아서 출력 
	public QnaCommand selectQna(Integer seq);
	  
	  //7.글 수정하기 public void update(BoardCommand board);
	  
	  //8.글 삭제하기 public void delete(Integer seq);//~(int seq)=>Integer
	 
	
}

