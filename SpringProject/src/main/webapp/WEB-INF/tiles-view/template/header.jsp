<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="userID" value="${sessionScope.idKey}" />
<%
	String contextPath = request.getContextPath();
%>
<a class="skip-link" href="#content">Skip to content</a>
<div id="header">
	<div class="top-area">
		<div class="inner-max">
			<h1 class="top-logo">
				<a href="index.jsp">
					<span class="site-logo">Eight Library
						<img src="/webapp/img/site-logo.png">
					</span>
				</a>
			</h1>
			<div class="top-gnb">
			<c:if test="${!empty userID}">
				<b><c:out value="${userID}" /></b>님 환영합니다.
				<ul class="gnb-list">
					<li class="logout"><a href="logout.do">로그아웃</a></li>
				</ul>
			</c:if>
			<c:if test="${empty userID}">
				<ul class="gnb-list">
					<li class="login"><a href="login.do">로그인</a></li>
					<li><a href="join1.do">회원가입</a></li>
				</ul>
			</c:if>
			</div>
			<button type="button" class="btn-all-menu" id="show-menu">
				<span class="line">
					<span></span>
					<span></span>
					<span></span>
				</span>
			</button>
		</div>
	</div>
	<div class="nav-area">
		<div class="inner-max">
			<div id="main-nav">
				<h2 class="hide">주메뉴</h2>
				<ul class="main-nav-list">
					<li>
						<a href="search.do">자료검색</a>
						<ul class="sub-menu">
							<li><a href="search.do">통합검색</a></li>
                               <li><a href="newbook.do">신착도서</a></li>
						</ul>
					</li>
					<li>
						<a href="reserveroom.do?userID=${userID}">열람실예약</a>
						<ul class="sub-menu">
							<li><a href="reserveroom.do?userID=${userID}">예약신청</a></li>
							<li><a href="reserveroomstatus.do?userID=${userID}">예약확인/취소</a></li>
						</ul>
					</li>
					<li>
						<a href="notice.do">커뮤니티</a>
						<ul class="sub-menu">
							<li><a href="notice.do">공지&새소식</a></li>
							<li><a href="faq.do">자주하는 질문(FAQ)</a></li>
							<li><a href="<%=contextPath%>/qna/list.do">질문 및 답변(Q&A)</a></li>
							<li><a href="board.do">자유게시판</a></li>
							<li><a href="award.html">다독상현황</a></li>
						</ul>
					</li>
                       <li>
                           <a href="contFacility.jsp">도서관소개</a>
                           <ul class="sub-menu">
                               <li><a href="contFacility.jsp">시설현황</a></li>
                               <li><a href="contData.jsp">자료현황</a></li>
                               <li><a href="contInfomation.jsp">이용안내</a></li>
                               <li><a href="contDirections.jsp">찾아오시는길</a></li>
                           </ul>
                       </li>
					<li>
						<c:if test="${empty userID}">
							<a onclick="alert('로그인 후 이용가능합니다.')" href="login.do">마이페이지</a>
							<ul class="sub-menu">
							<li><a onclick="alert('로그인 후 이용가능합니다.')" href="login.do">회원정보</a></li>								
							<li><a onclick="alert('로그인 후 이용가능합니다.')" href="login.do">대출/예약/이력</a></li>
							<li><a onclick="alert('로그인 후 이용가능합니다.')" href="login.do">관심도서</a></li>
							<li><a onclick="alert('로그인 후 이용가능합니다.')" href="login.do">나의 게시글</a></li>							
						</ul>
						</c:if>
						
						<c:if test="${!empty userID}">
							<a href="usermodify.do?userID=${userID}">마이페이지</a>
						<ul class="sub-menu">
							<li>
								<a href="usermodify.do?userID=${userID}">회원정보</a>
								<ul>
									<li><a href="usermodify.html">회원정보수정</a></li>
									<li><a href="passwordchange.html">비밀번호변경</a></li>
									<li><a href="withdraw.html">회원탈퇴</a></li>
									<li><a href="contPrivacy.html">개인정보처리방침</a></li>
									<li><a href="contEmail.html">이메일무단수집거부</a></li>
								</ul>
							</li>								
							<li>
								<a href="revlist.do?userID=${userID }">대출/예약/이력</a>
								<ul>
									<li><a href="mypage1.html">대출현황</a></li>
									<li><a href="revlist.do?userID=${userID }">예약현황</a></li>
									<li><a href="mypage3.html">대출이력</a></li>
								</ul>
							</li>
							<li><a href="basketlist.do?userID=${userID}">관심도서</a></li>
							<li>
								<a href="myboard1.do?userID=${userID }">나의 게시글</a>
								<ul>
									<li><a href="myboard1.do?userID=${userID }">질문 및 답변(Q&A)</a></li>
									<li><a href="myboard2.do?userID=${userID }">자유게시판</a></li>
								</ul>
							</li>							
						</ul>
						</c:if>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>