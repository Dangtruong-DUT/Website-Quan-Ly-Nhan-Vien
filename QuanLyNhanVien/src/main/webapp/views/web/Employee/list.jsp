<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<div class="table-container">
            <h1 class="table-container__title">Danh Sách Nhân Viên</h1>
            <form action="employee" id="formListEmployee" method="get">
				<table class="table">
	                <thead class="table__head">
	                    <tr >
	                        <th class="table__cell table__cell--header">#id</th>
	                        <th class="table__cell table__cell--header">Name</th>
	                        <th class="table__cell table__cell--header">IDPB</th>
	                        <th class="table__cell table__cell--header">Address</th>
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
						                <td class="table__cell">${item.idnv}</td>
						                <td class="table__cell">${item.hoten}</td>
						                <td class="table__cell">${item.idpb}</td>
						                <td class="table__cell">${item.diachi}</td>
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
		   const EmployeeURL = "employee";
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
		
		</script>
