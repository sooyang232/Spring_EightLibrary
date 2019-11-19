package com.qna.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.qna.domain.QnaCommand;

public class QnaDaoImpl extends SqlSessionDaoSupport implements QnaDAO {

	//�۸�Ϻ���
	public List<QnaCommand> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<QnaCommand> list=getSqlSession().selectList("selectList",map);
		System.out.println("list()ȣ���!");
		return list;
	}
	//�ѷ��ڵ��
	public int getRowCount(Map<String, Object> map) {
		System.out.println("getRowCount()ȣ���!");
		return getSqlSession().selectOne("selectCount",map);
	}
	//�ִ�۹�ȣ
	public int getNewSeq() {
		// Object->Integer->int(�ڵ����� ������ �ȴ�.�ڽ�,��ڽ�)
		int newseq = (Integer) getSqlSession().selectOne("getNewSeq");
		System.out.println("getNewSeq()�� newseq=>" + newseq);
		return newseq;
	}
	//�۾���
	public void insert(QnaCommand qna) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertQna",qna);
	}
	//��ȸ������
	public void updateHit(Integer seq) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateHit",seq);
	}
	//���ڵ����
	public QnaCommand selectQna(Integer seq) {
		// TODO Auto-generated method stub
		return (QnaCommand)getSqlSession().selectOne("selectQna",seq); 
	} 
	//�ۼ����ϱ� 
	public void update(QnaCommand qna) { 
		// TODO Auto-generated method stub
		getSqlSession().update("updateQna",qna); 
	}
	  
	//�ۻ����ϱ� 
	public void delete(Integer seq) { 
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteQna",seq); 
	}
	 
	 
}
