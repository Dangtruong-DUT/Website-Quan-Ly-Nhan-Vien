<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--Sibar-->
    <div class="sibar-container">
        <div class="sibar__label">K. Công Nghệ Thông Tin</div>
        <ul class="sibar-list">
        	<li class="sibar__option"><a href="user-trang-chu" class="link-item link-item--sibar">Trang chủ</a></li>
        	<li class="sibar__option"><a href="user-account?type=edit" class="link-item link-item--sibar">Quản lý tài Khoản</a></li>
        	<li class="sibar__option"><a href="user-account?type=edit" class="link-item link-item--sibar">Quản lý Thông Tin Cá Nhân</a></li>
            <li class="sibar__option"><a href="user?type=list&page=1&maxPageItem=10" class="link-item link-item--sibar">Danh Sách Nhân Viên</a></li>
            <li class="sibar__option"><a href="user-department?type=list&page=1&maxPageItem=10" class="link-item link-item--sibar item--choice">Danh Sách Phòng Ban</a></li>
            <li class="sibar__option"><a href="user?type=search" class="link-item link-item--sibar">Tìm Kiếm Nhân Viên</a></li>
        </ul>
    </div>
    <!--./ end Sibar-->
</body>
</html>