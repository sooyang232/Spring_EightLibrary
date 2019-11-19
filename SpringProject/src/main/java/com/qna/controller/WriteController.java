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
import com.qna.validator.QnaValidator;

@Controller
public class WriteController {

	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private QnaDAO qnaDAO;
	
	// 1.글쓰기 폼으로 이동(Get방식) 및 에러메세지를 출력하기위해서 다시 페이지 이동목적
	@RequestMapping(value = "/qna/write.do", method = RequestMethod.GET)
	public String form() { // 메서드명은 임의로 작성
		System.out.println("다시 처음부터 값을 입력을 받기위해서 form()호출됨!");
		return "qnaWrite";
	}

	// 2.에러메세지 출력->다시 처음부터 값을 입력을 받을 수 있도록 처리
	@ModelAttribute("command")
	public QnaCommand forBacking() { // 형식) 반환형 (DTO형) 임의의 메서드명()
		System.out.println("forBacking()호출됨");
		return new QnaCommand();
	}
	//3.입력해서 유효성검사->에러발생
		//BindingResult=>유효성검사 때문에 필요=>에러정보객체를 저장할 목적
		@RequestMapping(value="/qna/write.do",method=RequestMethod.POST)
		public String submit(@ModelAttribute("command") QnaCommand command,
				                          BindingResult result) {
			if(log.isDebugEnabled()) {
				log.debug("QnaCommand=>"+command);//입력받은 값을 출력
				//로그객체명.debug(출력대상자)
			}
			//유효성검사
			new QnaValidator().validate(command,result);//Errors errors
			//에러정보가 들어있다면
			if(result.hasErrors()) {
				return form();  //다시 입력하라
			}
			//정상적인 입력(글쓰기 및 업로드=>입출력=>예외처리)
			try {
				
				//최대값+1
				int newSeq=qnaDAO.getNewSeq()+1;
				command.setNum(newSeq);//1->2
				//글쓰기 메서드
				qnaDAO.insert(command);//DB상에 저장
				//실제로 upload폴더로 업로드한 파일을 전송(복사)
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return "redirect:/qna/list.do";
		}
}
