package com.qna.dao;

import java.util.*;

import com.qna.domain.QnaCommand;

public interface QnaDAO {

	//1.�۸�Ϻ���
	public List<QnaCommand> list(Map<String,Object>map);
	
	//2.�ѷ��ڵ��(�˻�� �´� ���ڵ������ ����)
		public int getRowCount(Map<String,Object> map);

	// 3.�ִ�۹�ȣ ���ϱ�
	public int getNewSeq();
}

