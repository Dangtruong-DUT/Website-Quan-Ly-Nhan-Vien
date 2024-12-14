<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="../common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Trang Chủ"/></title>
	<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet"><link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value ='/template/web/assets/css/normalize_css.css'/>">
    <link rel="stylesheet" href="<c:url value= '/template/web/assets/css/base.css'/>">
    <link rel="stylesheet" href="<c:url value= '/template/web/assets/css/main.css'/>">
    <link rel="stylesheet" href="<c:url value= '/template/web/assets/css/form1.css' />">
    <link rel="stylesheet" href="<c:url value= '/template/web/assets/css/table1.css' />">
    
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
    <script src="<c:url value= '/template/js/jquery.twbsPagination.js" type="text/javascript' />"></script>
	<script src ="<c:url value= '/template/js/validator.js' />"> </script>

</head>
<body>
		<!-- header -->
	    <%@ include file="../common/header.jsp" %>
	    <!-- header -->
	    <div class="grid">
	        <div class="container-informationPage">
	            <div class="grid__row">
	                <div class="grid__column-3">
	    				<%@ include file="../common/user/sidebar.jsp" %>
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