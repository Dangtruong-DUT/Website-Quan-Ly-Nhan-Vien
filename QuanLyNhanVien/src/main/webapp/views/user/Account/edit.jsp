<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="../../../common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>edit account</title>
</head>
<body>
	<div class="grid">
            <div class="form-container">
                <form action="#" class= "form" id = "formAccount">
                    <h2>Thay Đổi Thông Tin Tài Khoản</h2>
                    <p class="desc">chỉnh sửa thông tin tài khoản để bảo mật hơn! </p>

                    <div class="spacer"></div>

                    <div class="form-group">
                        <lable class="form-lable" for ='UserName'>UserName<span class="required">*</span></lable>
                        <input type="text" name ='userName' id="username" placeholder="VD: user" class ='form-control' value="${model.userName}" ${model.userName!=null?"readonly":"" }>
                        <span class="form-message"></span>
                    </div>

                    <div class="form-group">
                        <lable class="form-lable" for ='password'>Mật khẩu<span class="required">*</span></lable>
                        <input type="password"id= 'password' name = 'passWord' placeholder="Nhập mật khẩu" class ='form-control'  value="${model.passWord}">
                        <span class="form-message" ></span>
                    </div>

                    <div class="form-group">
                        <lable class="form-lable">Nhập lại mật khẩu<span class="required">*</span></lable>
                        <input type="password"  id="verifypassword" placeholder="Nhập lại mật khẩu" class ='form-control' value="${model.passWord}">
                        <span class="form-message"></span>
                    </div>
                    <div class="form-group">
                        <lable class="form-lable" for ='idNv'>IDNV<span class="required">*</span></lable>
                        <input type="text" name ='idNV' id="idnv" placeholder="VD: user" class ='form-control' value="${model.idNV}" ${model.idNV!=null?"readonly":"" }>
                        <span class="form-message"></span>
                    </div> 
                    <input type="hidden" value="${model.role}" name="role"/>
                    <span id="invalidMessage" class=" required form-message" ></span>
                    <input type ="submit" class="form-submit btn btn--normal" value ='Submit'>
					<input type="hidden" value="${model.userName}" id="userNamehidden"/>

                </form>
            </div>
            
        </div>
        <script>
	        const URL = "user-account";
	    	const APIurl = "api-user-account";
	        Validator ({
	            form: '#formAccount',
	            formGroupSelector: '.form-group',
	            errorSelector: '.form-message',
	            rules: [
	                Validator.isRequired('#username'),
	                Validator.isRequired('#idnv'),
	                Validator.isRequired('#password'),
	                Validator.minLegth('#password', 6),
	                Validator.isRequired('#verifypassword'),
	                Validator.isConfirmed('#verifypassword', function () {
	                    return document.querySelector('#formAccount #password').value;
	                }, 'Mật khẩu không trùng khớp'),
	            ],
	            onSubmit: async function (data) {
	            	 const idnv = document.querySelector("#userNamehidden");
			            try {
			                if (idnv.value) {
			                    await updateAccount(data);  // Nếu có idnv, cập nhật
			                } else {
			                	alert("Có lỗi trong quá trình thực hiện!")
			                }
			            } catch (error) {
			                console.error(error);
			            }
	            }
	        })
	        
			    async function updateAccount(data) {
			        try {
			            const response = await fetch(APIurl, {
			                method: 'PUT',
			                headers: {
			                    'Content-Type': 'application/json'
			                },
			                body: JSON.stringify(data)
			            });
			
			            if (response.ok) {
			                const result = await  response.json(); 
			                if (result) {
			                	 alert("Thay đổi thông tin thành công!");
			                } else {
			                	 document.querySelector("#invalidMessage").innerText = "Cập nhật  thất bại!";
			                }
			               
			            } else {
			                document.querySelector("#invalidMessage").innerText = "Cập nhật  thất bại!";
			            }
			        } catch (error) {
			            console.error(error);
			            document.querySelector("#invalidMessage").innerText = "Cập nhật  thất bại!";
			        }
			    }
	    </script>
</body>
</html>