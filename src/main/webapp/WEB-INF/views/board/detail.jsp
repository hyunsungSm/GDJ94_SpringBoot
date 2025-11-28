<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
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
                        <h1 class="h3 mb-0 text-gray-800">${category} 상세정보</h1>
                        <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                    </div>
                    
                    <!-- Content Row -->
					<div class="row" style="width:100%; display:flex; justify-content:center;">
					  <div style="width:100%; max-width:900px;">
					
					    <!-- 제목 / 메타 정보 -->
					    <div style="border-bottom:1px solid #ddd; padding-bottom:12px; margin-bottom:20px;">
					      <h3 style="margin:0;">${n.boardTitle}</h3>
					      <div style="color:#888; font-size:14px;">
					        작성자 : ${n.boardWriter} |
					        등록일 : ${n.boardDate} |
					        조회수 : ${n.boardHit}
					      </div>
					    </div>
					
					    <!-- 본문 -->
					    <div style="min-height:200px; padding:10px; font-size:15px;">
					      ${n.boardContents}
					    </div>
					
						<div class="card-footer">
							<c:if test="${category ne 'Notice'}"></c:if>
							<a href="/reply?"></a>
						</div>
						
					    <!-- 버튼 -->
					    <div style="display:flex; justify-content:right; gap:10px; margin-top:20px;">
					      <button class="btn btn-secondary"
					              onclick="location.href='/qna/list'">
					          목록
					      </button>
					      <button class="btn btn-primary"
						        onclick="location.href='${pageContext.request.contextPath}/qna/update?boardNum=${n.boardNum}'">
						    수정
						</button>

					    </div>
					
					  </div>
					</div>
                    
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
</body>
</html>