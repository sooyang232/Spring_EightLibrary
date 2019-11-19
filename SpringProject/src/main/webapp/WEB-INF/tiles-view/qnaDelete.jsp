<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="content" class="site-content">
	<div class="inner-max">
		<div class="content-area">
			<form:form commandName="command">
				<br>
				선택된 게시글을 삭제하시겠습니까?
				<div class="btn-area tar">
	                       	<input type="submit" value="확인" class="btn deep-blue">
	                       	<a href="list.do" role="button" class="btn blue-gray">취소</a>
	            </div>
	         </form:form>
		</div>
	</div>
</div>