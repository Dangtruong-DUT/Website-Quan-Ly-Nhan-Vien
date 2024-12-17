<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!--Tin Tưc-->
    <div class="container-material container-material--border">
        <div class="material__title text-color--primary container-material--inforE">${model.title}</div>
        <div class="material__body">
            <div class="media__date">
                <div class="media__date-icon">
                    <i class="fa-solid fa-calendar-days"></i>
                </div>
                <div class="media__date-value">
                    ${model.createdDate}
                </div>
            </div>
            <div class="material__section">
                <div class="section__body">
                    <p class="section__content">
                        ${model.shortDescription}
                    </p>
                    <div class="section__img">
                        <img src="data:image/jpeg;base64,${model.thumbnailBase64}" width ="80%" alt="img">
                    </div>
                </div>
                </div>
                <div class="section__body">
                 	<p class="section__content">
						${model.content}
					</p>
                </div>
            </div>
        </div>
    </div>