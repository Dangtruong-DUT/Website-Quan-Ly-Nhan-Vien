<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="../../../common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="grid">
            <div class="form-container">
                <form action="#" class= "form" id = "formAccount">
                    <h2>Chỉnh Sửa Tài Khoản</h3>
                    <p class="desc">chỉnh sửa thông tin tài khoản để bảo mật hơn! </p>

                    <div class="spacer"></div>

                    <div class="form-group">
                        <lable class="form-lable" for ='UserName'>UserName<span class="required">*</span></lable>
                        <input type="text" name ='UserName' id="UserName" placeholder="VD: user" class ='form-control'>
                        <span class="form-message"></span>
                    </div>

                    <div class="form-group">
                        <lable class="form-lable" for ='password'>Mật khẩu<span class="required">*</span></lable>
                        <input type="password"id= 'password' name = 'password' placeholder="Nhập mật khẩu" class ='form-control'>
                        <span class="form-message" ></span>
                    </div>

                    <div class="form-group">
                        <lable class="form-lable">Nhập lại mật khẩu<span class="required">*</span></lable>
                        <input type="password" name="verifypassword" id="verifypassword" placeholder="Nhập lại mật khẩu" class ='form-control'>
                        <span class="form-message"></span>
                    </div>
                    <div class="form-group">
                        <lable class="form-lable" for ='idNv'>IDNV<span class="required">*</span></lable>
                        <input type="text" name ='idNv' id="idNv" placeholder="VD: user" class ='form-control'>
                        <span class="form-message"></span>
                    </div> <div class="form-group">
                        <lable class="form-lable" for ='code'>Role<span class="required">*</span></lable>
                        <input type="text" name ='code' id="code" placeholder="VD: user" class ='form-control'>
                        <span class="form-message"></span>
                    </div>
                    <input type ="submit" class="form-submit btn btn--normal" value ='Đăng Ký'>
					<input type="hidden" value="${model.idnv}" id="idnvhidden"/>

                </form>
            </div>
            
        </div>
        <script src ="/validator.js"> </script>
        <script>
        	const URL = "admin-account";
	    	const APIurl = "api-admin-account";
            Validator ({
                form: '#formAccount',
                formGroupSelector: '.form-group',
                errorSelector: '.form-message',
                rules: [
                    Validator.isRequired('#fullname'),
                    Validator.isRequired('#idNv'),
                    Validator.isRequired('#code'),
                    Validator.isRequired('#password'),
                    Validator.minLegth('#password',6),
                    Validator.isRequired('#verifypassword'),
                    Validator.isConfirmed('#verifypassword',function () {
                        return document.querySelector('#formAccount #password').value
                    },'Mật khẩu không trùng khớp'),
                ],
                onSubmit: function (data) {
                	 const idnv = document.querySelector("#idnvhidden");
			            try {
			                if (idnv.value) {
			                    await updateAccount(data);  // Nếu có idnv, cập nhật
			                } else {
			                    await addAccount(data);  // Nếu không, thêm mới
			                }
			            } catch (error) {
			                console.error(error);
			            }
                }
            })
            
             async function addAccount(data) {
			        try {
			            const response = await fetch(APIurl, {
			                method: 'POST',
			                headers: {
			                    'Content-Type': 'application/json'
			                },
			                body: JSON.stringify(data)
			            });
			
			            if (response.ok) {
			                alert("Thêm thành công!");
			                window.location.href = `${URL}?type=list&maxPageItem=10&page=1`;
			            } else {
			                document.querySelector("#invalidMessage").innerText = "Thêm thất bại!";
			            }
			        } catch (error) {
			            console.error(error);
			            document.querySelector("#invalidMessage").innerText = "Thêm  thất bại!";
			        }
			    }
			
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
			                alert("Thay đổi thông tin thành công!");
			                window.location.href = `${URL}?type=list&maxPageItem=10&page=1`;
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