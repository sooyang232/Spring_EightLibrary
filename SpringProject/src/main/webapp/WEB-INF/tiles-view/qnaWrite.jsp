<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:hasBindErrors name="command" />
<form:errors path="command" />

<div id="content" class="site-content">
	<div class="inner-max">
		<div class="content-area">
               <div class="page-header">
                   <div class="breadcrumbs">
                       <ul>
                           <li><a href="#">Home</a></li>
                           <li><a href="#">커뮤니티</a></li>
                           <li><a href="#">질문 및 답변(Q&A)</a></li>
                       </ul>
                   </div>
                   <h2 class="page-title">질문 및 답변(Q&A)</h2>
                   
               </div>
               
               <div class="board regist-area">
                   <form name="registForm" id="registForm" method="post"
                   			action="write.do" >
					
                       <table class="table th-bg">
                           <colgroup>
                               <col width="15%">
                               <col>
                           </colgroup>
                           <tbody>
                               <tr>
                                   <th scope="row"><label for="title">제목</label></th>
                                   <td><input type="text" class="form" name="title" id="title" value="${command.title}">
                                   <form:errors path="command.title"/>
                                   </td>
                               </tr>
                               <tr>
                                   <th scope="row"><label for="userID">작성자</label></th>
                                   <td>
                                   <%-- 	<c:out value="${userID }"/> --%>
                                   	<input type="text" class="form" name="userID" id="userID" value="${command.userID}">
                                   	<form:errors path="command.userID"/>
                                   </td>
                               </tr>
                               <tr>
                                   <th scope="row"><label for="content">내용</label></th>
                                   <td>
                                   		<textarea name="content" id="content" rows="15" class="form" title="상세 내용 입력" >
                                   		${command.content }
                                   		</textarea>
                                   		<form:errors path="command.content"/>
                                   </td>
                               </tr>
                           </tbody>
                       </table>
                       <!-- form 작성 내용 전달위해 form 태그 안에서 전송버튼 필요 -->
                       <div class="btn-area tar">
                       	<input type="submit" value="등록" class="btn deep-blue">
                       	<a href="list.do" role="button" class="btn blue-gray">취소</a>
                       </div>
                   </form>
               </div>
		</div>
	</div>
</div>