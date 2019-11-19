package com.qna.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.qna.domain.QnaCommand;

public class QnaValidator implements Validator {
	//1.��ȿ�� �˻縦 �� Ŭ������ �������ִ� �޼���
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return QnaCommand.class.isAssignableFrom(clazz);
	}
	//2.��ȿ���˻縦 ���ִ� �޼��屸��(1.�˻����ڰ�ü  2.�����߻�->��� �����Ұ������� ����
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		//�Է����� �ʾҰų� ������ üũ���ִ� �޼���->���������� ����(������ü)
		//1.������ü(��������) 2.�����ų �ʵ�� 3.�����ų �����ڵ��(ȭ�鿡 ����� Ű��)
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userID", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"title", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"content", "required");
	}

}
