<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/common/taglib.jsp" %>
  <!--Header-->
    <header class = "header ">
        <!--Top Header-->
        <div class="top-header--form3-header">
            <div class="grid top-header">
                <div class="top-header-Left">
                    <ul class="top-header__list">
                        <li class="top-header__item top-header__item--left min-font-size">Tin tức & Sự kiện</li>
                        <li class="top-header__item top-header__item--left min-font-size">Thông báo</li>
                        <li class="top-header__item top-header__item--left min-font-size">Văn bản</li>
                        <li class="top-header__item top-header__item--left min-font-size">Lịch tuần</li>
                        <li class="top-header__item top-header__item--left min-font-size">Danh bạ</li>
                        <li class="top-header__item top-header__item--last-left min-font-size">Liên hệ</li>
                    </ul>
                </div>
                <div class="top-header-right">
                    <ul class="top-header__list top-header--right">
                        <li class="top-header__item top-header__item--right" id="btn-khoa-pagehome"> 
                            <a href="#" class="btn--primary btn--size-S min-font-size">Khoa</a>
                            <!--drop down khoa-->
                            <div class="list-contaner" id ="dropDown-list-khoa-pagehome">
                                <ul class="list-option">
                                    <li class="list-option__item">
                                        <a href="#" class="link-item link--Pagehome">Công nghệ thông tin</a>
                                    </li>
                                    <li class="list-option__item">
                                </ul>
                            </div>
                             <!--./ End drop down khoa-->
                        </li>
                        <li class="top-header__item top-header__item--right" id = "btn-phong-pagehome">
                            <a href="#" class=" btn--primary btn--size-S min-font-size">Phòng</a>
                            <!--drop down phong-->
                            <div class="list-contaner" id ="dropDown-list-phong-pagehome">
                                <ul class="list-option">
                                    <li class="list-option__item">
                                        <a href="#" class="link-item link--Pagehome">Công tác sinh viên</a>
                                    </li>
                                    <li class="list-option__item">
                                </ul>
                            </div>
                            <!--./end drop down phong-->
                        </li>
                        <li class="top-header__item top-header__item--language">
                            <div class="header-item__flag"> <img src="<c:url value= '/template/web/assets/images/form3-HomePage/top-header-flag-vienam.png" alt="vienam flag" class="flag-vienammsese'/>"> </div>
                            <div class="header-item__label">Vietnamese</div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!--/. End Top Header-->

        <!--Body Header-->
        <div class="body-header grid">
            <div class="body-header--left">
                <img src="<c:url value= '/template/web/assets/images/form3-HomePage/logo-k_cntt.png" alt="Khoa CNTT" class="body-header__logoBrand' />">
            </div>
            <div class="body-header--right">
                <div class="body-header--right">
                <div class="body-header__search-container">
                    <c:if test="${not empty USERMODEL}">
                    	<a class="btn">Xin Chào, ${USERMODEL.role.name}</a>
                    <a href="thoat?action=logout" class=" btn min-font-size btn--header">Đăng Xuất</a>
                    </c:if>
    				<c:if test="${empty USERMODEL }">
    					<a class="btn">Khách Vãng Lai</a>
	    				<a href="dang-nhap?action=login" class=" btn min-font-size btn--header">Đăng Nhập</a>
    				</c:if>
                </div>
            </div>
            </div>
        </div>
        <c:if test="${empty USERMODEL }">
        	 <!--./ End Body Header-->
	        <div class="bottom-header grid">
	            <ul class="bottom-header__menubar">
	                <li class="menubar__item"id="menubar-gioithieu">
	                    <a href="#" class="item__option">Giới Thiệu</a>
	                    <div class="dropdown-container " id ="dropdown-container--form3">
	                        <ul class="dropdown-list">
	                            <li class="dropdown-list__option"> <a href="news?type=tamnhinvasumang" class="link-item link-item--menubar-form3">Tầm nhìn và Sứ mạng</a></li>
	                        </ul>
	                    </div>
	                </li>
	                <li class="menubar__item" id="menubar--daotao">
	                    <a href="#" class="item__option">Đào Tạo</a>
	                    <div class="dropdown-container " id ="dropdown-container-menubar-daotao">
	                        <ul class="dropdown-list">
	                            <li class="dropdown-list__option"> <a href="news?type=mohinhdaotao"  class="link-item link-item--menubar-form3">Mô hình đào tạo</a></li>
	                        </ul>
	                    </div>
	                </li>
	                <li class="menubar__item" id ="menubar-nghiencuu">
	                    <a href="#" class="item__option">Nghiêng Cứu Khoa Học</a>
	                    <div class="dropdown-container " id ="dropdown-container-menubar-nghiencuu">
	                        <ul class="dropdown-list">
	                            <li class="dropdown-list__option"> <a href="news?type=cachuongnghiencuu" class="link-item link-item--menubar-form3">Các hướng nghiên cứu</a></li>
	                        </ul>
	                    </div>
	                </li>
	                <li class="menubar__item" id="menubar-hoptac">
	                    <a href="#" class="item__option">Hợp Tác</a>
	                    <div class="dropdown-container " id ="dropdown-container-menubar-hoptac">
	                        <ul class="dropdown-list">
	                            <li class="dropdown-list__option"> <a href="news?type=hoptacnhatruong" class="link-item link-item--menubar-form3">Hợp tác nhà trường</a></li>
	                        </ul>
	                    </div>
	                </li>
	                <li class="menubar__item" id = "menubar-cuusinhvien">
	                    <a href="#" class="item__option">Cựu Sinh Viên</a>
	                    <div class="dropdown-container " id ="dropdown-container-menubar-cuusinhvien">
	                        <ul class="dropdown-list">
	                            <li class="dropdown-list__option"> <a href="news?type=cuusinhviendaihoc"  class="link-item link-item--menubar-form3">Danh sách cựu sinh viên đại học</a></li>
	                        </ul>
	                    </div>
	                </li>
	
	            </ul>
	            <div class="direction-bar"><a href="#" class="link-direction">Trang chủ / Khoa Công Nghệ Thông Tin</a></div>
	        </div>
        </c:if>
    </header>
    <!--./End Header-->
