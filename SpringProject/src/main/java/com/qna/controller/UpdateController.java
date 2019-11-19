package com.qna.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.qna.dao.QnaDAO;
import com.qna.domain.QnaCommand;
import com.qna.validator.QnaValidator;

@Controller
public class UpdateController {
	//Logger객체
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private QnaDAO qnaDAO;
	
	// 글수정폼으로 이동(Get방식) 및 에러메세지를 출력하기위해서 다시 페이지 이동목적
	@RequestMapping(value = "/qna/update.do", method = RequestMethod.GET)
	public ModelAndView form(@RequestParam("num") int num) {
		System.out.println("다시 처음부터 값을 입력을 받기위해서 form()호출됨!");
		QnaCommand qnaCommand = qnaDAO.selectQna(num);
		// 1.이동할 페이지명(확장자생략) 2.모델(키명) 3.전달할값(모델값)
		return new ModelAndView("qnaModify", "command", qnaCommand);
	}

	// 입력해서 유효성검사->에러발생
	// BindingResult=>유효성검사 때문에 필요=>에러정보객체를 저장할 목적
	@RequestMapping(value = "/qna/update.do", method = RequestMethod.POST)
	public String submit(@ModelAttribute("command") QnaCommand command, BindingResult result) {
		if (log.isDebugEnabled()) {
			log.debug("QnaCommand=>" + command);// 입력받은 값을 출력
			// 로그객체명.debug(출력대상자)
		}
		// 유효성검사
		new QnaValidator().validate(command, result);// Errors errors
		// 에러정보가 들어있다면
		if (result.hasErrors()) {
			return "qnaModify"; // 다시 수정하라
		}
		// 글수정 메서드
		qnaDAO.update(command);// DB상에 저장

		return "redirect:/qna/list.do";
	}
}
