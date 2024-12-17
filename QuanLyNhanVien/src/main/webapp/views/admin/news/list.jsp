<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<div class="table-container">
    <div class="group-btn">
    	<a href="admin-news?type=edit" class="btn--primary btn min-font-size">Thêm</a>
        <button id="btnDeleteALL" type="button" class="btn--primary btn min-font-size">Xóa Tất Cả</button>
    </div>
    <h1 class="table-container__title">Danh Sách ${model.id == "tintuc" ? "Tin Tức " : "Thông báo"}</h1>
    <form action="admin-news" id="formListNews" method="get">
        <table class="table">
            <thead class="table__head">
                <tr>
                    <th><input type="checkbox" id="checkAll"></th>
                    <th class="table__cell table__cell--header">#ID</th>
                    <th class="table__cell table__cell--header">Tiêu Đề</th>
                    <th class="table__cell table__cell--header">Mô Tả Ngắn</th>
                    <th class="table__cell table__cell--header">Ngày Tạo</th>
                    <th class="table__cell table__cell--header">Ngày Sửa</th>
                    <th class="table__cell table__cell--header">Người Tạo</th>
                    <th class="table__cell table__cell--header">Người Sửa</th>
                    <th class="table__cell table__cell--header">Ảnh Đại Diện</th>
                    <th class="table__cell table__cell--header">Actions</th>
                </tr>
            </thead>
            <tbody class="table__body">
                <c:choose>
                    <c:when test="${empty model.listResult}">
                        <tr>
                            <td colspan="10" class="table__row--empty">Danh sách trống</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="newsItem" items="${model.listResult}">
                            <tr class="table__row">
                                <td><input type="checkbox" id="checkbox_${newsItem.id}" value="${newsItem.id}"></td>
                                <td class="table__cell">${newsItem.id}</td>
                                <td class="table__cell">${newsItem.title}</td>
                                <td class="table__cell">${newsItem.shortDescription}</td>
                                <td class="table__cell">${newsItem.createdDate}</td>
                                <td class="table__cell">${newsItem.modifiedDate}</td>
                                <td class="table__cell">${newsItem.createdBy}</td>
                                <td class="table__cell">${newsItem.modifiedBy}</td>
                                <td class="table__cell">
                                    <img src="data:image/jpeg;base64,${newsItem.thumbnailBase64}" alt="Thumbnail" style="width: 50px; height: 50px;">
                                </td>
                                <td class="table__cell">
                                    <c:url var="editURL" value="admin-news">
                                        <c:param name="type" value="edit"/>
                                        <c:param name="id" value="${newsItem.id}"/>
                                    </c:url>
                                    <c:url var="deleteURL" value="admin-news">
                                        <c:param name="type" value="delete"/>
                                        <c:param name="id" value="${newsItem.id}"/>
                                    </c:url>
                                    <a href="${editURL}" class="actions__link actions__link--edit">Edit</a>
                                    <button value="${newsItem.id}" class="btnDelete actions__link actions__link--delete">Delete</button>
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
        <input type="hidden" value="${model.categoryId}" id="categoryId" name="categoryId"/>
        <ul class="pagination" id="pagination"></ul>
    </form>
</div>

<script>
    const APIurl = "api-admin-news";
    const NewsURL = "admin-news";
    const categoryId = document.querySelector("#categoryId").value;
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
                    $('#sortName').val('title');
                    $('#sortBy').val('desc');
                    $('#type').val('list');
                    $('#formListNews').submit();
                }
            }
        });
    });

    $("#btnDeleteALL").click(async function () {
        var data = {};
        var ids = $('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        data['ids'] = ids;
        try {
            await deleteNews(data);
        } catch (err) {
            console.log(err);
        }
    });

    document.querySelectorAll(".btnDelete").forEach(button => {
        button.addEventListener("click", async function () {
            try {
                await deleteNews({ "ids": [this.value] });
            } catch (err) {
                console.log(err);
            }
        });
    });

    function deleteNews(data) {
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
                window.location.href = `${NewsURL}?type=list&categoryId=${categoryId}&maxPageItem=10&page=1`;
            } else {
                alert("Xóa thất bại")
            }
        })
        .catch(error => {
            alert("Xóa thất bại")
        });
    }
</script>
