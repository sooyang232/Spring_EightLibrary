package com.qna.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.qna.domain.QnaCommand;

public class QnaValidator implements Validator {
	//1.유효성 검사를 할 클래스를 지정해주는 메서드
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return QnaCommand.class.isAssignableFrom(clazz);
	}
	//2.유효성검사를 해주는 메서드구현(1.검사대상자객체  2.에러발생->어디에 저장할것인지를 지정
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		//입력하지 않았거나 공백을 체크해주는 메서드->에러정보를 저장(에러객체)
		//1.에러객체(정보저장) 2.적용시킬 필드명 3.적용시킬 에러코드명(화면에 출력할 키명)
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userID", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"title", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"content", "required");
	}

}
