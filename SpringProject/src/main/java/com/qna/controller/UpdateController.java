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
	//Logger��ü
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private QnaDAO qnaDAO;
	
	// �ۼ��������� �̵�(Get���) �� �����޼����� ����ϱ����ؼ� �ٽ� ������ �̵�����
	@RequestMapping(value = "/qna/update.do", method = RequestMethod.GET)
	public ModelAndView form(@RequestParam("num") int num) {
		System.out.println("�ٽ� ó������ ���� �Է��� �ޱ����ؼ� form()ȣ���!");
		QnaCommand qnaCommand = qnaDAO.selectQna(num);
		// 1.�̵��� ��������(Ȯ���ڻ���) 2.��(Ű��) 3.�����Ұ�(�𵨰�)
		return new ModelAndView("qnaModify", "command", qnaCommand);
	}

	// �Է��ؼ� ��ȿ���˻�->�����߻�
	// BindingResult=>��ȿ���˻� ������ �ʿ�=>����������ü�� ������ ����
	@RequestMapping(value = "/qna/update.do", method = RequestMethod.POST)
	public String submit(@ModelAttribute("command") QnaCommand command, BindingResult result) {
		if (log.isDebugEnabled()) {
			log.debug("QnaCommand=>" + command);// �Է¹��� ���� ���
			// �αװ�ü��.debug(��´����)
		}
		// ��ȿ���˻�
		new QnaValidator().validate(command, result);// Errors errors
		// ���������� ����ִٸ�
		if (result.hasErrors()) {
			return "qnaModify"; // �ٽ� �����϶�
		}
		// �ۼ��� �޼���
		qnaDAO.update(command);// DB�� ����

		return "redirect:/qna/list.do";
	}
}
