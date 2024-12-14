<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<div class="table-container">
            <h1 class="table-container__title">Danh Sách Account</h1>
            <form action="admin-account" id="formListAccount" method="get">
				<table class="table">
	                <thead class="table__head">
	                    <tr >
	                    	<th><input type="checkbox" id="checkAll"></th>
	                        <th class="table__cell table__cell--header">#idNV</th>
	                        <th class="table__cell table__cell--header">UserName</th>
	                        <th class="table__cell table__cell--header">PassWord</th>
	                        <th class="table__cell table__cell--header">Role</th>
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
						                <td><input type="checkbox" id="checkbox_${item.userName}" value="${item.userName}"></td>
						                <td class="table__cell">${item.idNV}</td>
						                <td class="table__cell">${item.userName}</td>
						                <td class="table__cell">${item.passWord}</td>
						                <td class="table__cell">${item.role}</td>
						                <td class="table__cell">
						                	<c:url var="editURL" value="admin-account">
						                		<c:param name="type" value="edit"/>
						                		<c:param name="idNV" value="${item.idNV}"/>
						                	</c:url>
						                    <a href="${editURL}" class="actions__link actions__link--edit">Edit</a>
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
	       	<ul class="pagination" id="pagination"></ul>
            </form>
        </div>
        <!-- /.main-content -->
		<script>
		   const APIurl = "api-admin-account";
		   const URL = "admin-account";
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
		                   $('#formListAccount').submit();
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
		           await deleteAccount(data);
		       } catch (err) {
		           console.log(err);
		       }
		   });
		
		   // Sự kiện Xóa từng mục
		   document.querySelectorAll(".btnDelete").forEach(button => {
		       button.addEventListener("click", async function () {
		           try {
		               await deleteAccount({ "ids": [this.value] });
		           } catch (err) {
		               console.log(err);
		           }
		       });
		   });
		
		   // Hàm xóa dữ liệu sử dụng fetch
		   function deleteAccount(data) {
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
		               window.location.href = `${URL}?type=list&maxPageItem=10&page=1`;
		           } else {
		        	   alert("Xóa thất bại")
		           }
		       })
		       .catch(error => {
		           alert("Xóa thất bại")
		       });
		   }
		</script>
