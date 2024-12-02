<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="../common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Login"/></title>
	<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet"><link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value ='/template/web/assets/css/normalize_css.css'/>">
    <link rel="stylesheet" href="<c:url value= '/template/web/assets/css/base.css'/>">
    <link rel="stylesheet" href="<c:url value= '/template/web/assets/css/main.css'/>">
    <link rel="stylesheet" href="<c:url value= '/template/web/assets/css/form1.css' />">
		<script src ="<c:url value= '/template/js/validator.js' />"> </script>
</head>
<body>
	    <!--container-->
	    <div class="grid">
		     <dec:body/>	 
	    </div>    
	    <!--./end container-->
</body>
</html>