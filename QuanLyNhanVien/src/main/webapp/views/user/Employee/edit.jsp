<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="../../../common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Nhân Viên</title>
</head>
<body>
	<div class="form-container">
                <form action="admin-Employee" method="post" class= "form" id = "form-editEm">
                    <h2>${model.idnv==null?"Thêm Nhân Viên":"Thay Đổi Thông Tin Nhân Viên"}</h2>
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
					    <select name="idpb" id="idpb" class="form-control">
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
                    <span id="invalidMessage" class=" required form-message" ></span>
                    <hr/>
                    <br/>
                    <input type ="submit" class="form-submit btn btn--normal" value ='Submit'>
                	<input type="hidden" value="${model.idnv}" id="idnvhidden"/>
                </form>
            </div>
            <script>
			    const EmployeeURL = "admin-Employee";
			    const APIurl = "api-admin-employee";
			
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
			                    await addEmployee(data);  // Nếu không, thêm mới
			                }
			            } catch (error) {
			                console.error(error);
			            }
			        }
			    });
			
			    async function addEmployee(data) {
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
			                window.location.href = `${EmployeeURL}?type=list&maxPageItem=10&page=1`;
			            } else {
			                document.querySelector("#invalidMessage").innerText = "Thêm nhân viên thất bại!";
			            }
			        } catch (error) {
			            console.error(error);
			            document.querySelector("#invalidMessage").innerText = "Thêm nhân viên thất bại!";
			        }
			    }
			
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
			                alert("Thay đổi thông tin thành công!");
			                window.location.href = `${EmployeeURL}?type=list&maxPageItem=10&page=1`;
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