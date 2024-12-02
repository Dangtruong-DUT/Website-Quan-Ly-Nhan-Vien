<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="../../../common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản Lý Phòng Ban</title>
</head>
<body>
	<div class="form-container">
                <form action="admin-department" method="post" class= "form" id = "form-editDe">
                    <h2>${model.idpb==null?"Thêm Phòng Ban":"Thay Đổi Thông Tin Phòng Ban"}</h2>
                    <p class="desc">Quản lý thông tin Phòng Ban! </p>

                    <div class="spacer"></div>

                    <div class="form-group">
                        <lable class="form-lable" for='"idpb"'>IDPB<span class="required">*</span></lable>
                        <input type="text" name ='idpb' id="idpb" placeholder="nhap idpb" class ='form-control' value="${model.idpb}" ${model.idpb!=null?"readonly":"" }>
                        <span class="form-message"></span>
                    </div>
                    <div class="form-group">
                        <lable class="form-lable" for ='tenpb'>Tên Phòng Ban<span class="required">*</span></lable>
                        <input type="text"id= 'tenpb' name = 'tenpb' placeholder="nhap ten phong ban" class ='form-control' value="${model.tenpb}">
                        <span class="form-message" ></span>
                    </div>
                    <div class="form-group">
                        <lable class="form-lable" for ='mota'>Mô tả<span class="required">*</span></lable>
                        <input type="text" id= 'mota' name = 'mota' placeholder="mo tả phòng ban" class ='form-control' value="${model.mota}">
                        <span class="form-message" ></span>
                    </div>
                    <span id="invalidMessage" class=" required form-message" ></span>
                    <hr/>
                    <br/>
                    <input type ="submit" class="form-submit btn btn--normal" value ='Sunmit'>
                	<input type="hidden" value="${model.idpb}" id="idpbhidden"/>
                </form>
            </div>
            <script>
			    const DepartmentURL = "admin-department";
			    const APIurl = "api-admin-department";
			
			    Validator({
			        form: '#form-editDe',
			        formGroupSelector: '.form-group',
			        errorSelector: '.form-message',
			        rules: [
			            Validator.isRequired('#idpb'),
			            Validator.isRequired('#tenpb'),
			            Validator.isRequired('#mota'),
			        ],
			        onSubmit: async (data) => {
			            const idpb = document.querySelector("#idpbhidden");
			            try {
			                if (idpb.value) {
			                    await updateDepartment(data);  // Nếu có idnv, cập nhật
			                } else {
			                    await addDepartment(data);  // Nếu không, thêm mới
			                }
			            } catch (error) {
			                console.error(error);
			            }
			        }
			    });
			
			    async function addDepartment(data) {
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
			                window.location.href = `${DepartmentURL}?type=list&maxPageItem=10&page=1`;
			            } else {
			                document.querySelector("#invalidMessage").innerText = "Thêm phòng ban thất bại!";
			            }
			        } catch (error) {
			            console.error(error);
			            document.querySelector("#invalidMessage").innerText = "Thêm phòng ban thất bại!";
			        }
			    }
			
			    async function updateDepartment(data) {
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
			                window.location.href = `${DepartmentURL}?type=list&maxPageItem=10&page=1`;
			            } else {

			                document.querySelector("#invalidMessage").innerText = "Cập nhật phòng ban thất bại!";
			            }
			        } catch (error) {
			            console.error(error);
			            document.querySelector("#invalidMessage").innerText = "Cập nhật phòng ban thất bại!";
			        }
			    }
			</script>

</body>
</html>