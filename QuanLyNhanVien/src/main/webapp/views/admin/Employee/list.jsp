<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<div class="table-container">
			<div class="group-btn">
				<a href="admin-Employee?type=edit" class="btn--primary btn min-font-size">Thêm</a>
				<button id="btnDeleteALL" type="button" class="btn--primary btn min-font-size">Xóa Tất cả</button>
			</div>
            <h1 class="table-container__title">Danh Sách Nhân Viên</h1>
            <form action="admin-Employee" id="formListEmployee" method="get">
				<table class="table">
	                <thead class="table__head">
	                    <tr >
	                    	<th><input type="checkbox" id="checkAll"></th>
	                        <th class="table__cell table__cell--header">#id</th>
	                        <th class="table__cell table__cell--header">Name</th>
	                        <th class="table__cell table__cell--header">IDPB</th>
	                        <th class="table__cell table__cell--header">Address</th>
	                        <th class="table__cell table__cell--header">Actions</th>
	                    </tr>
	                </thead>
	                <tbody class="table__body">
				    	<c:choose>
						    <c:when test="${empty model.listResult}">
						        <tr>
						            <td colspan="6" class="table__row--empty">Danh sách trống</td>
						        </tr>
						    </c:when>
						    <c:otherwise>
						        <c:forEach var="item" items="${model.listResult}">
						            <tr class="table__row">
						                <td><input type="checkbox" id="checkbox_${item.idnv}" value="${item.idnv}"></td>
						                <td class="table__cell">${item.idnv}</td>
						                <td class="table__cell">${item.hoten}</td>
						                <td class="table__cell">${item.idpb}</td>
						                <td class="table__cell">${item.diachi}</td>
						                <td class="table__cell">
						                	<c:url var="editURL" value="admin-Employee">
						                		<c:param name="type" value="edit"/>
						                		<c:param name="idnv" value="${item.idnv}"/>
						                	</c:url>
						                	<c:url var="deleteURL" value="admin-Employee">
						                		<c:param name="type" value="delete"/>
						                		<c:param name="idnv" value="${item.idnv}"/>
						                	</c:url>
						                
						                    <a href="${editURL}" class="actions__link actions__link--edit">Edit</a>
						                    <button value="${item.idnv}" class=" btnDelete actions__link actions__link--delete">Delete</button>
						                </td>
						            </tr>
						        </c:forEach>
						    </c:otherwise>
						</c:choose>
	                </tbody>
	            </table>
	        <input type="hidden" value="" id="page" name="page"/>
			<input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
			<input type="hidden" value="" id="sortName" name="sortName"/>
			<input type="hidden" value="" id="sortBy" name="sortBy"/>
			<input type="hidden" value="" id="type" name="type"/>
			<input type="hidden" value="${model.idpb}" id="type" name="idpb"/>
	       	<ul class="pagination" id="pagination"></ul>
            </form>
        </div>
        <!-- /.main-content -->
		<script>
		   const APIurl = "api-admin-employee";
		   const EmployeeURL = "admin-Employee";
		   let totalPages = ${model.totalPage};
		   let currentPage = ${model.page};
		   let limit = 10;
		
		   $(function () {
		       window.pagObj = $('#pagination').twbsPagination({
		           totalPages: totalPages,
		           visiblePages: 10,
		           startPage: currentPage,
		           onPageClick: function (event, page) {
		               if (currentPage != page) {
		                   $('#maxPageItem').val(limit);
		                   $('#page').val(page);
		                   $('#sortName').val('hoten');
		                   $('#sortBy').val('desc');
		                   $('#type').val('list');
		                   $('#formListEmployee').submit();
		               }
		           }
		       });
		   });
		
		   // Sự kiện Xóa tất cả
		   $("#btnDeleteALL").click(async function () {
		       var data = {};
		       var ids = $('tbody input[type=checkbox]:checked').map(function () {
		           return $(this).val();
		       }).get();
		       data['ids'] = ids;
		       try {
		           await deleteEmployee(data);
		       } catch (err) {
		           console.log(err);
		       }
		   });
		
		   // Sự kiện Xóa từng mục
		   document.querySelectorAll(".btnDelete").forEach(button => {
		       button.addEventListener("click", async function () {
		           try {
		               await deleteEmployee({ "ids": [this.value] });
		           } catch (err) {
		               console.log(err);
		           }
		       });
		   });
		
		   // Hàm xóa dữ liệu sử dụng fetch
		   function deleteEmployee(data) {
			   console.log(data)
		       fetch(APIurl, {
		           method: 'DELETE',
		           headers: {
		               'Content-Type': 'application/json'
		           },
		           body: JSON.stringify(data)
		       })
		       .then(response => {
		           if (response.ok) {
		        	   alert("Xóa Thành công");
		               window.location.href = `${EmployeeURL}?type=list&maxPageItem=10&page=1`;
		           } else {
		        	   alert("Xóa thất bại")
		           }
		       })
		       .catch(error => {
		           alert("Xóa thất bại")
		       });
		   }
		</script>
