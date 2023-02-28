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
    <script type="text/javascript">
    	function fileUpload() {
    		console.log(uploadForm.file.value);
			if (!uploadForm.file.value) {
				alert("등록된 파일이 없습니다.");
				return;
			}
			uploadForm.submit();
		}
    </script>
</head>
<body>
    <div class="d-flex" id="wrapper">
        <!-- Sidebar-->
        <div class="border-end bg-white" id="sidebar-wrapper">
            <div class="sidebar-heading border-bottom bg-light"><spring:message code="mainTitle" /></div>
            <div class="list-group list-group-flush">
                <a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath}/">
                	<spring:message code="sideBarTitle1" />
                </a>
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
                                    <a class="dropdown-item" href="${pageContext.request.contextPath}/changeLanguage?language=ko_kr&redirectUri=redirect:/fileView">한국어</a>
                                    <a class="dropdown-item" href="${pageContext.request.contextPath}/changeLanguage?language=en&redirectUri=redirect:/fileView">English</a>
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

				<!-- Button trigger modal -->
				<h5 class="down"><spring:message code="uploadNotice" /> &nbsp;</h5>
				<img src="${pageContext.request.contextPath}/resources/upload.png" data-bs-toggle="modal" data-bs-target="#exampleModal" style="cursor: pointer;">

				<!-- Modal -->
				<div class="modal fade" id="exampleModal" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<!-- 업로드 토글 타이틀 -->
								<h5 class="modal-title" id="exampleModalLabel"><spring:message code="togle.title" /></h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
							</div>
							<form name="uploadForm" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
								<div class="modal-body">
									<div class="mb-3">
										<input class="form-control" type="file" name="file" id="txtfile">
									</div>
								</div>
								<div class="modal-footer">
									<!-- 제출 버튼 -->
									<button type="button" class="btn btn-primary" onclick="fileUpload()"><spring:message code="togle.button1" /></button>
									<!-- 취소 버튼 -->
									<button type="button" class="btn btn-secondary" data-bs-dismiss="modal"><spring:message code="togle.button2" /></button>
								</div>
							</form>
						</div>
					</div>
				</div>
            	<div id="result">
					<table class="table">
						<thead>
							<tr>
								<!-- 파일 번호 -->
								<th scope="col"><spring:message code="file.no" /></th>
								<!-- 파일 이름 -->
								<th scope="col"><spring:message code="file.name" /></th>
								<!-- 파일 유형 -->
								<th scope="col"><spring:message code="file.type" /></th>
								<!-- 파일 크기 -->
								<th scope="col"><spring:message code="file.size" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${fileInfoList}" var="fileInfo">
								<tr>
									<td>${fileInfo.no}</td>
									<td><a href="${pageContext.request.contextPath}/file?name=${fileInfo.name}">${fileInfo.name}</a></td>
									<td>${fileInfo.type}</td>
									<td>${fileInfo.size}</td>
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