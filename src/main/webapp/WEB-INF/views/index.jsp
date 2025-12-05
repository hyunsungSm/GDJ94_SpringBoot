<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
                    <!-- 생성한 contents 작성 -->
                    <c:if test="${not empty user}">
                    	<h1>Login 성공</h1>
                    <spring:message code="message.welcome" arguments="${user.username}, ${user.birth}" argumentSeparator=","></spring:message>                    
                    </c:if>
                    
                    <c:if test="${empty user}">
                    	<li class="nav-item dropdown no-arrow mx-1">
		                    <a class="nav-link" href="/users/login" id="alertsDropdown" role="button"
		                        aria-haspopup="true" aria-expanded="false">
		                        <i class="fas fa-bell fa-fw"></i>
		                    </a>
	                    </li>
                    </c:if>
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