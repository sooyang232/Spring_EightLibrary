package com.qna.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qna.dao.QnaDAO;
import com.qna.domain.QnaCommand;

@Controller
public class DeleteController {

	//Logger객체->제대로 입력했는지 체크해서 그 결과를 콘솔에 출력시켜주는 객체
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private QnaDAO qnaDAO;
	
	// 1.글삭제폼으로 이동(Get방식)=>데이터를 보여주는 목적X ,단순히 이동
	@RequestMapping(value = "/qna/delete.do", method = RequestMethod.GET)
	public String form() { // 메서드명은 임의로 작성(글쓰기)
		return "qnaDelete";
	}
	
	// 2.에러메세지 출력->다시 초기화 ->암호를 다시 입력받을 데이터 준비
	@ModelAttribute("command")
	public QnaCommand forBacking() {
		System.out.println("다시 암호를 재입력하기위해서 초기화함!");
		return new QnaCommand();
	}
	
	// 3.입력해서 유효성검사->에러발생
	// BindingResult=>유효성검사 때문에 필요=>에러정보객체를 저장할 목적
	@RequestMapping(value = "/qna/delete.do", method = RequestMethod.POST)
	public String submit(@ModelAttribute("command") QnaCommand command, BindingResult result) {
		if (log.isDebugEnabled()) {
			log.debug("QnaCommand=>" + command);// 입력받은 값을 출력
			// 로그객체명.debug(출력대상자)
		}
		// 에러정보가 들어있다면
		if (result.hasErrors()) {
			return form(); // "boardDelete"->boardDelete.jsp로 이동->다시 삭제
		}
		// DB상의 데이터를 삭제
		qnaDAO.delete(command.getNum());

		return "redirect:/qna/list.do";
	}
}
