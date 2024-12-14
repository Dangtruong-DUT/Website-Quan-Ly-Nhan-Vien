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
        	<li class="sibar__option"><a href="user-trang-chu"  target="contrainer-frame" class="link-item link-item--sibar ">Home</a></li>
	        <li class="sibar__option"><a href="user-account?type=edit&idNV=${USERACCOUNT.idNV}"  target="contrainer-frame" class="link-item link-item--sibar ">Quản lý Tài Khoản Cá Nhân</a></li>
			<li class="sibar__option"><a href="user?type=edit&idnv=${USERMODEL.idnv }"  target="contrainer-frame" class="link-item link-item--sibar ">Quản lý Thông Tin Cá Nhân</a></li>
            <li class="sibar__option"><a href="user?type=list&page=1&maxPageItem=10"  target="contrainer-frame" class="link-item link-item--sibar ">Danh Sách Nhân Viên </a></li>
            <li class="sibar__option"><a href="user-department?type=list&page=1&maxPageItem=10" target="contrainer-frame" class="link-item link-item--sibar">Danh sách phòng ban</a></li>
            <li class="sibar__option"><a href="user?type=search " target="contrainer-frame" class="link-item link-item--sibar">Tìm Kiếm Nhân Viên</a></li>
        </ul>
    </div>
    <!--./ end Sibar-->
</body>
</html>