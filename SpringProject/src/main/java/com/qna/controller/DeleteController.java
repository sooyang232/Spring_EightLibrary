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

	//Logger��ü->����� �Է��ߴ��� üũ�ؼ� �� ����� �ֿܼ� ��½����ִ� ��ü
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private QnaDAO qnaDAO;
	
	// 1.�ۻ��������� �̵�(Get���)=>�����͸� �����ִ� ����X ,�ܼ��� �̵�
	@RequestMapping(value = "/qna/delete.do", method = RequestMethod.GET)
	public String form() { // �޼������ ���Ƿ� �ۼ�(�۾���)
		return "qnaDelete";
	}
	
	// 2.�����޼��� ���->�ٽ� �ʱ�ȭ ->��ȣ�� �ٽ� �Է¹��� ������ �غ�
	@ModelAttribute("command")
	public QnaCommand forBacking() {
		System.out.println("�ٽ� ��ȣ�� ���Է��ϱ����ؼ� �ʱ�ȭ��!");
		return new QnaCommand();
	}
	
	// 3.�Է��ؼ� ��ȿ���˻�->�����߻�
	// BindingResult=>��ȿ���˻� ������ �ʿ�=>����������ü�� ������ ����
	@RequestMapping(value = "/qna/delete.do", method = RequestMethod.POST)
	public String submit(@ModelAttribute("command") QnaCommand command, BindingResult result) {
		if (log.isDebugEnabled()) {
			log.debug("QnaCommand=>" + command);// �Է¹��� ���� ���
			// �αװ�ü��.debug(��´����)
		}
		// ���������� ����ִٸ�
		if (result.hasErrors()) {
			return form(); // "boardDelete"->boardDelete.jsp�� �̵�->�ٽ� ����
		}
		// DB���� �����͸� ����
		qnaDAO.delete(command.getNum());

		return "redirect:/qna/list.do";
	}
}
