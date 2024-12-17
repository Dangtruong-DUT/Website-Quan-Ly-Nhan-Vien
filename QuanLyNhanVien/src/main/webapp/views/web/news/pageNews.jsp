<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tin Tức</title>
</head>
<body>
    <div class="container-material">
        <div class="material__title">Khoa CNTT - Tin Tức</div>
        <form action="news" id="formListNews" method="get">
	        <ul class="material__list">
	            <c:choose>
	                <c:when test="${empty model.listResult}">
	                    <div class="material__news">Danh sách tin tức trống</div>
	                </c:when>
	                <c:otherwise>
	                    <c:forEach var="newsItem" items="${model.listResult}">
	                        <li class="material__news">
	                            <div class="news-container">
	                                <img src="data:image/jpeg;base64,${newsItem.thumbnailBase64}" alt="news" class="news__IMG-information">
	                                <div class="media">
	                                    <div class="media__title">
	                                        <a href="news?type=detail&id=${newsItem.id}"  class="link-item media__title">${newsItem.title}</a>
	                                    </div>
	                                    <div class="media__date">
	                                        <div class="media__date-icon">
	                                            <i class="fa-solid fa-calendar-days"></i>
	                                        </div>
	                                        <div class="media__date-value">
	                                            ${newsItem.createdDate}
	                                        </div>
	                                    </div>
	                                    <div class="media__description">
	                                        <p>${newsItem.shortDescription}</p>
	                                    </div>
	                                </div>
	                            </div>
	                        </li>
	                    </c:forEach>
	                </c:otherwise>
	            </c:choose>
	        </ul>
		    <input type="hidden" value="" id="page" name="page"/>
	        <input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
	        <input type="hidden" value="" id="sortName" name="sortName"/>
	        <input type="hidden" value="" id="sortBy" name="sortBy"/>
	        <input type="hidden" value="list" id="type" name="type"/>
        	<input type="hidden" value="${model.categoryId}" id="categoryId" name="categoryId"/>
         <ul class="pagination" id="pagination"></ul>
    	</form>
        <script type="text/javascript">
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
        </script>
    </div>
</body>
</html>
