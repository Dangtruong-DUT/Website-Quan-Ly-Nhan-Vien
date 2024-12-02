<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<%
	String ivalidMessage = request.getAttribute("ivalidMessage") != null 
    ? (String) request.getAttribute("ivalidMessage") 
    : "";
	%>
	<div class="form-container">
                <form action="dang-nhap" method="post" class= "form" id = "form-1">
                    <h2>Login</h3>
                    <p class="desc">Chao mung ban quay tro lai! </p>

                    <div class="spacer"></div>

                    <div class="form-group">
                        <lable class="form-lable" for ='username'>username<span class="required">*</span></lable>
                        <input type="text" name ='userName' id="username" placeholder="VD: user01" class ='form-control'>
                        <span class="form-message"></span>
                    </div>
                    <div class="form-group">
                        <lable class="form-lable" for ='password'>Mật khẩu<span class="required">*</span></lable>
                        <input type="password"id= 'password' name = 'passWord' placeholder="Nhập mật khẩu" class ='form-control'>
                        <span class="form-message" ></span>
                    </div>
                    <span class=" required form-message" ><%=ivalidMessage %></span>
                    <hr>
                    <br/>
                    <input type ="hidden" value="login" name="action">
                    <input type ="submit" class="form-submit btn btn--normal" value ='Dang Nhap'>
                </form>
            </div>
            <script>
	            Validator ({
	                form: '#form-1',
	                formGroupSelector: '.form-group',
	                errorSelector: '.form-message',
	                rules: [
	                    Validator.isRequired('#username'),
	                    Validator.isRequired('#password'),
	                    Validator.minLegth('#password',6),
	                ],
	            })
        </script>
</body>
</html>