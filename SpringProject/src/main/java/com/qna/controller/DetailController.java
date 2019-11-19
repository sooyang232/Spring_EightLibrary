package com.qna.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.qna.dao.QnaDAO;
import com.qna.domain.QnaCommand;

import freemarker.template.utility.StringUtil;

@Controller
public class DetailController {

	private Logger log=Logger.getLogger(this.getClass());
	
	private QnaDAO qnaDAO;
	
	@Autowired
	public void setQnaDAO(QnaDAO qnaDAO) {
		this.qnaDAO = qnaDAO;
		System.out.println("setQnaDAO ȣ���!");
	}
	
	@RequestMapping("/qna/detail.do")
	public ModelAndView process(@RequestParam("num") int num) {
		if(log.isDebugEnabled()) {
			log.debug("num=>"+num);
		}
		//1.��ȸ�� ����
		qnaDAO.updateHit(num);//int->Integer(�ڵ� �ڽ�,��ڽ�)
		//2.�󼼺��⿡ �ش�Ǵ� ���ڵ� ã�ƿ���
		QnaCommand qna=qnaDAO.selectQna(num);
		//�۳���->\r\n �� ������ <br>�� �����϶� (������)=>(����) <pre><%=content%></pre>
		//qna.setContent(StringUtil.parseBr(qna.getContent()));
		
		//1.�̵�����������2.������Ű��3.�����Ұ�
		return new ModelAndView("qnaView","qna",qna);
	}
	
	
}
