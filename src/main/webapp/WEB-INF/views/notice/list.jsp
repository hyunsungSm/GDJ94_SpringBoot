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
                        <h1 class="h3 mb-0 text-gray-800">공지사항</h1>
                        <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                    </div>
                    
					<form action="${pageContext.request.contextPath}/notice/list" method="get"
					      class="row mb-3" style="display:flex; align-items:center;">
					    
					    <div style="margin-right:10px;">
					        <select name="kind" class="form-control">
					            <option value="k1">제목</option>
					            <option value="k2">내용</option>
					            <option value="k3">번호</option>
					        </select>
					    </div>
					
					    <div style="margin-right:10px; width:200px;">
					        <input type="text" name="search" class="form-control"
					               placeholder="검색어를 입력하세요" value="${pager.search}">
					    </div>
					
					    <div>
					        <button type="submit" class="btn btn-primary">검색</button>
					    </div>
					</form>
                    
                    <!-- Content Row -->
                    <div class="row">
                        <!-- 공지사항 목록 카드 -->
				            <div class="card-body">
				                <table class="table">
				                    <thead class="thead-dark">
				                        <tr>
				                            <th>번호</th>
				                            <th>제목</th>
				                            <th>작성자</th>
				                            <th>작성일</th>
				                            <th>조회수</th>
				                        </tr>
				                    </thead>
				                    <tbody>
				                        <c:forEach items="${list}" var="n">
				                            <tr onclick="location.href='detail?board_num=${n.boardNum}'" style="cursor:pointer;">
				                                <td>${n.boardNum}</td>
				                                <td>${n.boardTitle}</td>
				                                <td>${n.boardWriter}</td>
				                                <td>${n.boardDate}</td>
				                                <td>${n.boardHit}</td>
				                            </tr>
				                        </c:forEach>
				                    </tbody>
				                </table>
				                <div class="row justify-content-between">
				                	<nav aria-label="Page navigation example">
									  <ul class="pagination">
									    <li class="page-item">
									      <a class="page-link" href="./list?page=${pager.begin-1}" aria-label="Previous">
									        <span aria-hidden="true">&laquo;</span>
									      </a>
									    </li>
									    <c:forEach begin="${pager.begin}" end="${pager.end}" var="i">
										    <li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${param.kind}&${param.search}">${i}</a></li>									    	
									    </c:forEach>
									    <li class="page-item">
									      <a class="page-link" href="./list?page=${pager.end+1}&kind=${param.kind}&${param.search}" aria-label="Next">
									        <span aria-hidden="true">&raquo;</span>
									      </a>
									    </li>
									  </ul>
									</nav>
									
									<div>
										<a href="./add" class="btn btn-primary">글쓰기</a>
									</div>
				                </div>
				            </div>
				        </div>
				    </div>
                    <!-- 생성한 contents 작성 -->
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