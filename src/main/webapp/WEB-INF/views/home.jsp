<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <!-- 페이지 타이틀 -->
    <title><spring:message code="pageTitle" /></title>
    <!-- Favicon-->
    <!-- <link rel="icon" type="image/x-icon" href="assets/favicon.ico" /> -->
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="${pageContext.request.contextPath}/resources/styles.css" rel="stylesheet" />
    <style type="text/css">
    	.down {
    		float: left;
    	}
    	.fileImg {
    		margin-top: -4px;
    	}
    </style>
</head>
<body>
    <div class="d-flex" id="wrapper">
        <!-- Sidebar-->
        <div class="border-end bg-white" id="sidebar-wrapper">
            <div class="sidebar-heading border-bottom bg-light"><spring:message code="mainTitle" /></div>
            <div class="list-group list-group-flush">
            	<!-- EMP Table -->
                <a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath}/">
                	<spring:message code="sideBarTitle1" />
                </a>
                <!-- File 업&다운로드 -->
                <a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath}/fileView">
                	<spring:message code="sideBarTitle2" />
                </a>
            </div>
        </div>
        <!-- Page content wrapper-->
        <div id="page-content-wrapper">
            <!-- Top navigation-->
            <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                <div class="container-fluid">
                    <button class="btn btn-primary" id="sidebarToggle"><spring:message code="togle.button.title" /></button>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation"><span
                            class="navbar-toggler-icon"></span></button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ms-auto mt-2 mt-lg-0">
                            <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/"><spring:message code="home" /></a></li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button"
                                    data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><spring:message code="language.title" /></a>
                                <div class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="${pageContext.request.contextPath}/changeLanguage?language=ko_kr">한국어</a>
                                    <a class="dropdown-item" href="${pageContext.request.contextPath}/changeLanguage?language=en">English</a>
<!--                                     <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="#!">Something else here</a> -->
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <!-- Page content-->
            <div style="width: 90%; margin: 10px auto;">
            	<h5 class="down"><spring:message code="downloadNotice" /> &nbsp;</h5>
            	<a class="down fileImg" href="${pageContext.request.contextPath}/excel/emp">
	            	<img alt="" src="${pageContext.request.contextPath}/resources/xls.png">
	            </a>
            	<a class="down fileImg" href="${pageContext.request.contextPath}/pdf/emp" target="_blank">
	            	<img alt="" src="${pageContext.request.contextPath}/resources/pdf.png">
	            </a>
            	<div id="result">
					<table class="table">
						<thead>
							<tr>
								<!-- 사번 -->
								<th scope="col"><spring:message code="emp.no" /></th>
								<!-- 이름 -->
								<th scope="col"><spring:message code="emp.name" /></th>
								<!-- 직종 -->
								<th scope="col"><spring:message code="emp.job" /></th>
								<!-- 상사 -->
								<th scope="col"><spring:message code="emp.mgr" /></th>
								<!-- 입사일 -->
								<th scope="col"><spring:message code="emp.hiredate" /></th>
								<!-- 연봉 -->
								<th scope="col"><spring:message code="emp.sal" /></th>
								<!-- 커미션 -->
								<th scope="col"><spring:message code="emp.comm" /></th>
								<!-- 부서 -->
								<th scope="col"><spring:message code="emp.dept" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${empList}" var="emp">
								<tr>
									<td>${emp.empno}</td>
									<td>${emp.ename}</td>
									<td>${emp.job}</td>
									<td>${emp.mgr}</td>
									<td>${emp.hiredate}</td>
									<td>${emp.sal}</td>
									<td>${emp.comm}</td>
									<td>${emp.dept}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
            </div>
        </div>
    </div>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="${pageContext.request.contextPath}/resources/scripts.js"></script>
</body>
</html>