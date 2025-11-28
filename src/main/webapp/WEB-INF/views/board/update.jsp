<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/template/head.jsp"></c:import>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-bs4.min.css" rel="stylesheet">
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
                        <h1 class="h3 mb-0 text-gray-800">글 수정</h1>
                        <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                    </div>
                    
                    <!-- Content Row -->
                    <div class="row" style="display:flex; justify-content:center; width: 100%;">
                    <!-- 생성한 contents 작성 -->
                    	<form action="/notice/add" method="post" style="width: 100%">
						  <div class="form-group">
						    <label for="formGroupExampleInput">제목</label>
						    <input type="text" class="form-control" name="boardTitle">
						  </div>
						  <div class="form-group">
						    <label for="formGroupExampleInput2">작성자</label>
						    <input type="text" class="form-control" name="boardWriter">
						  </div>
						  <div class="mb-3">
						    <label for="validationTextarea">내용</label>
						    <textarea rows="17" class="form-control" name="boardContents"></textarea>
						  </div>
						  <div style="display:flex; justify-content:right;">
							  <button type="submit" class="btn btn-primary" style="margin-right:8px;">등록</button>
							  <button type="submit" class="btn btn-secondary">목록</button>						  
						  </div>
						</form>
                  	</div>
               	<!-- /.container-fluid -->

           	 </div>
             <!-- End of Main Content -->
            
            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2021</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->
		</div>
	</div>
	
<c:import url="/WEB-INF/views/template/foot.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-bs4.min.js"></script>
</body>
</html>