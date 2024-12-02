<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<div class="table-container">
			<div class="group-btn">
				<a href="admin-department?type=edit" class="btn--primary btn min-font-size">Thêm</a>
			</div>
            <h1 class="table-container__title">Danh Sách Phòng Ban</h1>
            <form action="admin-department" id="formListDepartment" method="get">
				<table class="table">
	                <thead class="table__head">
	                    <tr >
	                    	<th><input type="checkbox" id="checkAll"></th>
	                        <th class="table__cell table__cell--header">#id</th>
	                        <th class="table__cell table__cell--header">Name</th>
	                        <th class="table__cell table__cell--header">Description</th>
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
						                <td><input type="checkbox" id="checkbox_${item.idpb}" value="${item.idpb}"></td>
						                <td class="table__cell">${item.idpb}</td>
						                <td class="table__cell">${item.tenpb}</td>
						                <td class="table__cell">${item.mota}</td>
						                <td class="table__cell">
						                	<c:url var="editURL" value="admin-department">
						                		<c:param name="type" value="edit"/>
						                		<c:param name="idpb" value="${item.idpb}"/>
						                	</c:url>
						                	<c:url var="listEmployeeURL" value="admin-department">
						                		<c:param name="type" value="listEmployee"/>
						                		<c:param name="idpb" value="${item.idpb}"/>
						                	</c:url>
						                
						                    <a href="${editURL}" class="actions__link actions__link--edit">Edit</a>
						                    <a href="${listEmployeeURL}" class="actions__link actions__link--delete">Nhân Viên</a>
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
			var totalPages = ${model.totalPage};
			var currentPage = ${model.page};
			var limit = 6;
			$(function () {
				window.pagObj = $('#pagination').twbsPagination({
					totalPages: totalPages,
					visiblePages: 10,
					startPage: currentPage,
					onPageClick: function (event, page) {
						if (currentPage != page) {
							$('#maxPageItem').val(limit);
							$('#page').val(page);
							$('#sortName').val('tenpb');
							$('#sortBy').val('desc');
							$('#type').val('list');
							$('#formListDepartment').submit();
						}
					}
				});
			});
			
			
		</script>