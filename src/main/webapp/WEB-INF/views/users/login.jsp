<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <c:import url="/WEB-INF/views/template/head.jsp"></c:import>
</head>
<body id="page-top">
<div id="wrapper">

    <!-- Sidebar -->
    <c:import url="/WEB-INF/views/template/sidebar.jsp"></c:import>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <c:import url="/WEB-INF/views/template/topbar.jsp"></c:import>

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">로그인</h1>
                </div>

                <!-- Content Row -->
                <div class="row justify-content-center mt-5">
                    <div class="col-lg-6 mt-5">
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">로그인</h6>
                            </div>
                            <div class="card-body">
                                <form action="/users/login" method="post">
                                    <div class="form-group">
                                        <label for="username">아이디</label>
                                        <input type="text" class="form-control" name="username" id="username" required>
                                    </div>

                                    <div class="form-group">
                                        <label for="password">비밀번호</label>
                                        <input type="password" class="form-control" name="password" id="password" required>
                                    </div>

                                    <div class="form-group d-flex justify-content-end gap-2 mt-4">
									    <button type="submit" class="btn btn-primary" style="margin-right:8px;">로그인</button>
									    <a href="/users/register" class="btn btn-secondary">
									        회원가입
									    </a>
									</div>

                                    <c:if test="${not empty error}">
                                        <div class="alert alert-danger mt-3" role="alert">
                                            ${error}
                                        </div>
                                    </c:if>
                                </form>
                            </div>
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

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<c:import url="/WEB-INF/views/template/foot.jsp"></c:import>
</body>
</html>
