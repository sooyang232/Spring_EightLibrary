<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                   <p class="sub-title">질문 및 답변(Q&A)은 로그인해야만 작성할 수 있으며, 비밀글 사용이 가능합니다.
                   <br>질문 및 답변(Q&A) 이외에 FAQ, 전화 및 이메일 문의, 주제담당사서 문의를 통해 궁금증을 해결할 수 있습니다.</p>
               </div>
               <div class="board-search-box tar">
                   <form method="post" action="list.do" id="searchForm">
                       <div class="input-box">
  
                           <select name="keyField" id="keyField" title="검색 선택" class="select">
							<option value="all" selected>전체</option>
							<option value="title">제목</option>
							<option value="userID">이름</option>
							<option value="content">내용</option>
							
						</select> 
						<input type="text" name="keyWord" title="검색어 입력" id="keyWord" class="form">
                           <input type="submit" value="검색" title="검색" class="btn primary md">
                       </div>
                   </form>
               </div>
               <div class="board-area">
                   <table class="table tac">
                       <thead>
                           <tr>
                               <th class="board-list-uid">번호</th>
                               <th class="board-list-title">제목</th>
                               <th class="board-list-user">작성자</th>
                               <th class="board-list-date">작성일</th>
                               <th class="board-list-view">조회</th>
                           </tr>
                       </thead>
                       <tbody>
                           <c:set var="number" value="${pgList.number}" />
                           <c:forEach var="article" items="${list}">
							<tr>
								<td class="board-list-uid">
									${article.num }
								</td>
								<td class="board-list-title">
									<a href="detail.do?num=${article.num}">
										<div class="board-default-cut-strings">
											<c:if test="${article.step==1}">
											<img src="img/sub/icon-reply.png" alt="">
                                           	Re:${article.title}
											</c:if>
											<c:if test="${article.step==0 }">							
          										${article.title}
												</c:if>
											<!-- <img src="img/sub/icon-lock.png" alt="비밀글"> -->
											<jsp:useBean id="now" class="java.util.Date"/>
											<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="today" />
											<fmt:formatDate value="${article.date}" pattern="yyyy-MM-dd" var="date" />
											<c:if test="${date==today}">
												<span class="board-default-new-notify">New</span>
											</c:if>
										</div>
										<div class="board-mobile-contents">
											<span class="contents-item">${article.userID}</span> 
											<span class="contents-item">${date}</span> 
											<span class="contents-item">${article.view}</span>
										</div>
								</a></td>
								<td class="board-list-user">${article.userID}</td>
								<td class="board-list-date">${date}</td>
								<td class="board-list-view">${article.view}</td>
							</tr>
						</c:forEach>
                           
                       </tbody>
                   </table>
                   <div class="pagination tac">
                   		${pagingHtml }
                   </div>
       			<div class="btn-area tar mt0">
       				<%-- <c:if test="${!empty userID}"> --%>
                   	<a href="write.do" role="button" class="btn deep-blue">글쓰기</a>
                   	<%-- </c:if> --%>
               	</div>
               </div>
		</div>
	</div>
</div>