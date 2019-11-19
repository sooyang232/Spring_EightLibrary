<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
    
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
               
               <div class="board view-area">
                   <div class="view-head">
                       <h2 class="article-title">
                          ${qna.title }<!-- <span class="item-icon new">새 글</span> -->
                       </h2>
                       <div class="article-meta">
                           <dl class="list colon inline">
                               <dt class="author">작성자</dt>
                               <dd class="author r-sep">${qna.userID }</dd>
                               <dt class="date">작성일</dt>
                               <dd class="date r-sep">
                               	<fmt:formatDate value="${qna.date}" pattern="yyyy-MM-dd" />
                               </dd>
                               <dt class="view">조회</dt>
                               <dd class="view">${qna.view }</dd>
                               <%-- <dd class="view r-sep">${article.b2_view }</dd> --%>
                              <!--  <dt class="comment">댓글</dt>
                               <dd class="comment">0</dd> -->
                           </dl>
                       </div>
                   </div>
                   <div class="view-body">
                       ${qna.content }
                   </div>
               </div>
               <div class="btn-area tar">
                   <a href="update.do?num=${qna.num}" role="button" class="btn blue-gray">글 수정</a>
                   <a href="delete.do?num=${qna.num}" role="button" class="btn blue-gray">글 삭제</a>
                   <a href="list.do" role="button" class="btn blue-gray">목록보기</a>
               </div>
		</div>
	</div>
</div>