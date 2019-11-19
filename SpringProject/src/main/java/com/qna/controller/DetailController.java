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
		System.out.println("setQnaDAO 호출됨!");
	}
	
	@RequestMapping("/qna/detail.do")
	public ModelAndView process(@RequestParam("num") int num) {
		if(log.isDebugEnabled()) {
			log.debug("num=>"+num);
		}
		//1.조회수 증가
		qnaDAO.updateHit(num);//int->Integer(자동 박싱,언박싱)
		//2.상세보기에 해당되는 레코드 찾아오기
		QnaCommand qna=qnaDAO.selectQna(num);
		//글내용->\r\n 을 만나면 <br>로 저장하라 (구버전)=>(요즘) <pre><%=content%></pre>
		//qna.setContent(StringUtil.parseBr(qna.getContent()));
		
		//1.이동할페이지명2.전달할키명3.전달할값
		return new ModelAndView("qnaView","qna",qna);
	}
	
	
}
