<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${model.id == null ? "Thêm Tin Tức" : "Sửa Thông Tin Tin Tức"}</title>
</head>
<body>
    <div class="form-container">
        <form id="form-editNews" class="form">
            <h2>${model.id == null ? "Thêm " : "Sửa Thông Tin"} ${model.id == "tintuc" ? "Tin Tức " : "Thông báo"}</h2>
            <p class="desc">Quản lý thông tin tin tức!</p>

            <div class="spacer"></div>

            <div class="form-group">
                <label class="form-lable" for="id">ID<span class="required">*</span></label>
                <input type="text" name="id" id="id" placeholder="Nhập ID tin tức" class="form-control" value="${model.id}" ${model.id != null ? "readonly" : ""}>
                <span class="form-message"></span>
            </div>

            <div class="form-group">
                <label class="form-lable" for="title">Tiêu Đề<span class="required">*</span></label>
                <textarea type="text" id="title" name="title" placeholder="Tiêu đề tin tức" class="form-control" style="height: 113px;">${model.title}</textarea>
                <span class="form-message"></span>
            </div>

            <div class="form-group">
                <label class="form-lable" for="thumbnail">Ảnh Đại Diện</label>
                <input type="file" id="thumbnail" name="thumbnail" accept="image/*">
                <span class="form-message"></span>
                <div id="thumbnailPreviewContainer">
                    <img id="thumbnailPreview" src="data:image/jpeg;base64,${model.thumbnailBase64}" 
                         alt="Ảnh đại diện" style="max-width: 200px; margin-top: 10px; display: ${model.thumbnail != null ? 'block' : 'none'};">
                    <button type="button" id="removeThumbnailBtn" style="display: ${model.thumbnail != null ? 'block' : 'none'};">Xóa Ảnh</button>
                </div>
            </div>

            <div class="form-group">
                <label class="form-lable" for="shortDescription">Mô Tả Ngắn<span class="required">*</span></label>
                <textarea id="shortDescription" name="shortDescription" placeholder="Mô tả ngắn" class="form-control" style="height: 113px;">${model.shortDescription}</textarea>
                <span class="form-message"></span>
            </div>

            <div class="form-group">
                <label class="form-lable" for="content">Nội Dung<span class="required">*</span></label>
                <textarea id="content" name="content" placeholder="Nội dung tin tức" class="form-control" style="height: 113px;">${model.content}</textarea>
                <span class="form-message"></span>
            </div>

            <div class="form-group">
                <label class="form-lable" for="categoryId">Danh Mục<span class="required">*</span></label>
                <select id="categoryId" name="categoryId" class="form-control">
                    <option value="">---Chọn Danh Mục---</option>
                    <c:forEach var="item" items="${categories}">
                        <option value="${item.id}" <c:if test="${item.id == model.categoryId}">selected</c:if>>${item.name}</option>
                    </c:forEach>
                </select>
                <span class="form-message"></span>
            </div>

            <span id="invalidMessage" class="required form-message"></span>
            <hr/>
            <br/>
            <input type="submit" class="form-submit btn btn--normal" value="Submit">
            <input type="hidden" id="idhidden" value="${model.id}">
        </form>
    </div>

    <script>
    const APIurl = "api-admin-news";

    document.getElementById("thumbnail").addEventListener("change", function (event) {
        const file = event.target.files[0];
        const previewImg = document.getElementById("thumbnailPreview");
        const removeBtn = document.getElementById("removeThumbnailBtn");

        if (file) {
            const reader = new FileReader();
            reader.onload = () => {
                previewImg.src = reader.result;
                previewImg.style.display = "block";
                removeBtn.style.display = "block";
            };
            reader.readAsDataURL(file);
        }
    });

    document.getElementById("removeThumbnailBtn").addEventListener("click", function () {
        document.getElementById("thumbnail").value = "";
        document.getElementById("thumbnailPreview").src = "";
        document.getElementById("thumbnailPreview").style.display = "none";
        this.style.display = "none";
    });

    Validator({
        form: '#form-editNews',
        formGroupSelector: '.form-group',
        errorSelector: '.form-message',
        rules: [
            Validator.isRequired('#id'),
            Validator.isRequired('#title'),
            Validator.isRequired('#shortDescription'),
            Validator.isRequired('#content'),
            Validator.isRequired('#categoryId'),
        ],
        onSubmit: async (data) => {
            const fileInput = document.getElementById("thumbnail");
            const previewImg = document.getElementById("thumbnailPreview");

            // Nếu chọn ảnh mới, chuyển sang base64
            if (fileInput.files.length > 0) {
                data.thumbnail = await toBase64(fileInput.files[0]);
            } else if (previewImg.src) {
                // Giữ ảnh cũ nếu không chọn ảnh mới
                data.thumbnail = previewImg.src.split(',')[1];
            } else {
                data.thumbnail = null;
            }

            const id = document.querySelector("#idhidden");
            try {
                if (id.value) {
                    await updateNews(data);
                } else {
                    await addNews(data);
                }
            } catch (error) {
                console.error(error);
            }
        }
    });

    async function toBase64(file) {
        return new Promise((resolve, reject) => {
            const reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = () => resolve(reader.result.split(',')[1]);
            reader.onerror = error => reject(error);
        });
    }

    async function addNews(data) {
        try {
            const response = await fetch(APIurl, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(data)
            });
            if (response.ok) {
                alert("Thêm tin tức thành công!");
            	 window.location.href = "admin-news?type=list&categoryId="+
         		data.categoryId+"&page=1&maxPageItem=10"
            } else {
                document.querySelector("#invalidMessage").innerText = "Thêm tin tức thất bại!";
            }
        } catch (error) {
            console.error(error);
        }
    }

    async function updateNews(data) {
        try {
            const response = await fetch(APIurl, {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(data)
            });
            if (response.ok) {
                alert("Cập nhật tin tức thành công!");
                window.location.href = "admin-news?type=list&categoryId="+
                		data.categoryId+"&page=1&maxPageItem=10"
            } else {
                document.querySelector("#invalidMessage").innerText = "Cập nhật tin tức thất bại!";
            }
        } catch (error) {
            console.error(error);
        }
    }
    </script>
</body>
</html>

