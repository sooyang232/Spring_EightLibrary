package com.qna.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.qna.domain.QnaCommand;

public class QnaDaoImpl extends SqlSessionDaoSupport implements QnaDAO {

	//글목록보기
	public List<QnaCommand> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<QnaCommand> list=getSqlSession().selectList("selectList",map);
		System.out.println("list()호출됨!");
		return list;
	}
	//총레코드수
	public int getRowCount(Map<String, Object> map) {
		System.out.println("getRowCount()호출됨!");
		return getSqlSession().selectOne("selectCount",map);
	}
	//최대글번호
	public int getNewSeq() {
		// Object->Integer->int(자동으로 변경이 된다.박싱,언박싱)
		int newseq = (Integer) getSqlSession().selectOne("getNewSeq");
		System.out.println("getNewSeq()의 newseq=>" + newseq);
		return newseq;
	}
	//글쓰기
	public void insert(QnaCommand qna) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertQna",qna);
	}
	//조회수증가
	public void updateHit(Integer seq) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateHit",seq);
	}
	//레코드출력
	public QnaCommand selectQna(Integer seq) {
		// TODO Auto-generated method stub
		return (QnaCommand)getSqlSession().selectOne("selectQna",seq); 
	} 
	//글수정하기 
	public void update(QnaCommand qna) { 
		// TODO Auto-generated method stub
		getSqlSession().update("updateQna",qna); 
	}
	  
	//글삭제하기 
	public void delete(Integer seq) { 
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteQna",seq); 
	}
	 
	 
}
