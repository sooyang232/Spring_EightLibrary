package com.qna.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.qna.domain.QnaCommand;

public class QnaDaoImpl extends SqlSessionDaoSupport implements QnaDAO {

	public List<QnaCommand> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<QnaCommand> list=getSqlSession().selectList("selectList",map);
		System.out.println("list()»£√‚µ !");
		return list;
	}
	
	public int getRowCount(Map<String, Object> map) {
		System.out.println("getRowCount()»£√‚µ !");
		return getSqlSession().selectOne("selectCount",map);
	}

	public int getNewSeq() {
		// Object->Integer->int(¿⁄µø¿∏∑Œ ∫Ø∞Ê¿Ã µ»¥Ÿ.π⁄ΩÃ,æπ⁄ΩÃ)
		int newseq = (Integer) getSqlSession().selectOne("getNewSeq");
		System.out.println("getNewSeq()¿« newseq=>" + newseq);
		return newseq;
	}
}
