<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/template/head.jsp"></c:import>
</head>
<body id="page-top">
	<div id="wrapper">
		<!-- sidebar -->
		<c:import url="/WEB-INF/views/template/sidebar.jsp"></c:import>
		<!-- content wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- main content -->
			<div id="content">
				<!-- topbar -->
				<c:import url="/WEB-INF/views/template/topbar.jsp"></c:import>
				
				<!-- Begin Page Content -->
				<div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Index</h1>
                        <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                    </div>
                    
                    <!-- Content Row -->
                    <div class="row">
                    
                    <spring:message code="hi"></spring:message>
                    <spring:message code="hello" text="키가없을때 기본메세지"></spring:message>
                    <sec:authorize access="isAuthenticated()">
				    <h1>Login 성공</h1>
				
				    <sec:authentication property="principal" var="user" />
				
				    <h1>${user.username}</h1>
				    <h1>${user.password}</h1>
				
				    <h3>${user.phone}</h3>
				
				    <spring:message code="message.welcome"
				                    arguments="${user.username}, ${user.birth}"
				                    argumentSeparator="," />
					</sec:authorize>

					<sec:authorize access="!isAuthenticated()">
						<h1>로그인 필요</h1>
						<a href="/oauth2/authorization/kakao">카카오 로그인</a>
                    	<li class="nav-item dropdown no-arrow mx-1">
		                    <a class="nav-link" href="/users/login" id="alertsDropdown" role="button"
		                        aria-haspopup="true" aria-expanded="false">
		                        <i class="fas fa-bell fa-fw"></i>
		                    </a>
	                    </li>
					</sec:authorize>                    
                    </div>
                    
                </div>
            <!-- /.container-fluid -->

        </div>
            <!-- End of Main Content -->
            
            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">022
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2021</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->
		</div>
	</div>
	
<c:import url="/WEB-INF/views/template/foot.jsp"></c:import>
<script src="/js/index/index.js"></script>
</body>
</html>