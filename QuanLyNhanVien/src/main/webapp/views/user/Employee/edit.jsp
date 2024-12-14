<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="../../../common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>edit</title>
</head>
<body>
	<div class="form-container">
                <form action="admin-Employee" method="post" class= "form" id = "form-editEm">
                    <h2>Thay Đổi Thông Tin Nhân Viên"</h2>
                    <p class="desc">Quản lý thông tin nhân viên! </p>

                    <div class="spacer"></div>

                    <div class="form-group">
                        <label class="form-lable" for='idnv'>IDNV<span class="required">*</span></label>
                        <input type="text" name ='idnv' id="idnv" placeholder="nhap idnv" class ='form-control' value="${model.idnv}" ${model.idnv!=null?"readonly":"" }>
                        <span class="form-message"></span>
                    </div>
                    
                    
                    <div class="form-group">
                        <label class="form-lable" for ='hoten'>Họ và tên<span class="required">*</span></label>
                        <input type="text"id= 'hoten' name = 'hoten' placeholder="ho va ten nhan vien" class ='form-control' value="${model.hoten}">
                        <span class="form-message" ></span>
                    </div>
                    <div class="form-group">
					    <label class="form-lable">Phòng Ban<span class="required">*</span></label>
					    <select  id="idpb" class="form-control" disabled>
					        <option value="">---Chọn Phòng Ban---</option>
					        <c:forEach var="item" items="${departments}">
					            <option value="${item.idpb}" <c:if test="${item.idpb == model.idpb}">selected</c:if>>
					                ${item.tenpb}
					            </option>
					        </c:forEach>
					    </select>
					    <span class="form-message"></span>
					</div>
                    <div class="form-group">
                        <label class="form-lable" for ='diachi'>Địa chỉ<span class="required">*</span></label>
                        <input type="text"id= 'diachi' name = 'diachi' placeholder="nhap dia chi nhan vien" class ='form-control' value="${model.diachi}">
                        <span class="form-message" ></span>
                    </div>
                    <div class="form-group">
                        <label class="form-lable" for='sdt'>Số điện thoại<span class="required">*</span></label>
                        <input type="text" name ='soDienThoai' id="std" placeholder="VD: 0375656647" class ='form-control' value="${model.soDienThoai}">
                        <span class="form-message"></span>
                    </div>
                    <div class="form-group">
                        <label class="form-lable" for='ngaysinh'>Ngày sinh<span class="required">*</span></label>
                        <input type="date" name ='ngaySinh' id="ngaysinh" class ='form-control' value="${model.ngaySinh}" >
                        <span class="form-message"></span>
                    </div>
                    <span id="invalidMessage" class=" required form-message" ></span>
                    <hr/>
                    <br/>
                    <input type ="submit" class="form-submit btn btn--normal" value ='Submit'>
                	<input type="hidden" value="${model.idnv}" id="idnvhidden"/>
                	<input type="hidden" value="${model.idpb}" name="idpb" id="idnvhidden"/>
                </form>
            </div>
            <script>
			    const EmployeeURL = "user";
			    const APIurl = "api-employee-user";
			    const APIaddAccountURL = "admin-account"
			
			    Validator({
			        form: '#form-editEm',
			        formGroupSelector: '.form-group',
			        errorSelector: '.form-message',
			        rules: [
			            Validator.isRequired('#idnv'),
			            Validator.isRequired('#hoten'),
			            Validator.isRequired('#idpb'),
			            Validator.isRequired('#diachi'),
			        ],
			        onSubmit: async (data) => {
			            const idnv = document.querySelector("#idnvhidden");
			            try {
			                if (idnv.value) {
			                    await updateEmployee(data);  // Nếu có idnv, cập nhật
			                } else {
			                    alert("Co loi trong qua trinh thực hiện!")
			                }
			            } catch (error) {
			                console.error(error);
			            }
			        }
			    });
			
			    async function updateEmployee(data) {
			        try {
			            const response = await fetch(APIurl, {
			                method: 'PUT',
			                headers: {
			                    'Content-Type': 'application/json'
			                },
			                body: JSON.stringify(data)
			            });
			
			            if (response.ok) {
			            	const result = await response.json(); 
			                if (result) {
				                alert("Thay đổi thông tin thành công!");
			                } else {
			                	 document.querySelector("#invalidMessage").innerText = "Cập nhật nhân viên thất bại!";
				            }
			            } else {
			                document.querySelector("#invalidMessage").innerText = "Cập nhật nhân viên thất bại!";
			            }
			        } catch (error) {
			            console.error(error);
			            document.querySelector("#invalidMessage").innerText = "Cập nhật nhân viên thất bại!";
			        }
			    }
			</script>

</body>
</html>