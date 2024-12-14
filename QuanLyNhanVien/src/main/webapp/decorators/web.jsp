<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="../common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Trang Chủ"/></title>
    <link rel="stylesheet" href="<c:url value ='/template/web/assets/css/normalize_css.css'/>">
    <link rel="stylesheet" href="<c:url value= '/template/web/assets/css/base.css'/>">
    <link rel="stylesheet" href="<c:url value= '/template/web/assets/css/main.css'/>">
    <link rel="stylesheet" href="<c:url value= '/template/web/assets/css/form1.css' />">
    <link rel="stylesheet" href="<c:url value= '/template/web/assets/css/table1.css' />">

</head>
<body>
		<!-- header -->
	    <%@ include file="../common/header.jsp" %>
	    <!-- header -->
	    <div class="grid">
	        <div class="container-informationPage">
	            <div class="grid__row">
	                <div class="grid__column-3">
	    				<%@ include file="../common/web/sidebar.jsp" %>
	                </div>
	                <div style="flex:1" class="grid_column-9">
	                	<div class="container-material">
		                    <dec:body/>	 
	                	</div>
	                </div>
	            </div>
	        </div>
	    </div>    
	
		<!-- footer -->
		<%@ include file="../common/footer.jsp" %>
		<!-- footer -->
</body>
</html>