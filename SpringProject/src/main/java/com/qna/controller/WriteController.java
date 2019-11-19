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
	
	// 1.�۾��� ������ �̵�(Get���) �� �����޼����� ����ϱ����ؼ� �ٽ� ������ �̵�����
	@RequestMapping(value = "/qna/write.do", method = RequestMethod.GET)
	public String form() { // �޼������ ���Ƿ� �ۼ�
		System.out.println("�ٽ� ó������ ���� �Է��� �ޱ����ؼ� form()ȣ���!");
		return "qnaWrite";
	}

	// 2.�����޼��� ���->�ٽ� ó������ ���� �Է��� ���� �� �ֵ��� ó��
	@ModelAttribute("command")
	public QnaCommand forBacking() { // ����) ��ȯ�� (DTO��) ������ �޼����()
		System.out.println("forBacking()ȣ���");
		return new QnaCommand();
	}
	//3.�Է��ؼ� ��ȿ���˻�->�����߻�
		//BindingResult=>��ȿ���˻� ������ �ʿ�=>����������ü�� ������ ����
		@RequestMapping(value="/qna/write.do",method=RequestMethod.POST)
		public String submit(@ModelAttribute("command") QnaCommand command,
				                          BindingResult result) {
			if(log.isDebugEnabled()) {
				log.debug("QnaCommand=>"+command);//�Է¹��� ���� ���
				//�αװ�ü��.debug(��´����)
			}
			//��ȿ���˻�
			new QnaValidator().validate(command,result);//Errors errors
			//���������� ����ִٸ�
			if(result.hasErrors()) {
				return form();  //�ٽ� �Է��϶�
			}
			//�������� �Է�(�۾��� �� ���ε�=>�����=>����ó��)
			try {
				
				//�ִ밪+1
				int newSeq=qnaDAO.getNewSeq()+1;
				command.setNum(newSeq);//1->2
				//�۾��� �޼���
				qnaDAO.insert(command);//DB�� ����
				//������ upload������ ���ε��� ������ ����(����)
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return "redirect:/qna/list.do";
		}
}
