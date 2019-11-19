package com.qna.dao;

import java.util.List;
import java.util.Map;

import com.qna.domain.QnaCommand;

public interface QnaDAO {

	//1.�۸�Ϻ���
	public List<QnaCommand> list(Map<String,Object>map);
	
	//2.�ѷ��ڵ��(�˻�� �´� ���ڵ������ ����)
	public int getRowCount(Map<String,Object> map);

	// 3.�ִ�۹�ȣ ���ϱ�
	public int getNewSeq();
	
	//4.�Խ����� �۾���
	public void insert(QnaCommand qna);
		
	//5.�Խù���ȣ�� �ش��ϴ� ��ȸ�� ���� 
	public void updateHit(Integer seq);//~(int seq)=>(Integer seq)
	  
	//6.�Խù��� ���� ���ڵ� �Ѱ� ã�Ƽ� ��� 
	public QnaCommand selectQna(Integer seq);
	  
	  //7.�� �����ϱ� public void update(BoardCommand board);
	  
	  //8.�� �����ϱ� public void delete(Integer seq);//~(int seq)=>Integer
	 
	
}

