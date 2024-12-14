<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tìm Kiếm Nhân Viên</title>
</head>
<body>
	<form action="admin-user" method="post">
		<div class="search__container">
	        <div class="search__title">Tìm Kiếm Nhân Viên</div>
	        <div class="search__group-item">
	            <div class="search__selectBox-item">
	                <input id="idnv" type="radio" value="idnv" name="key" checked>
	                <label for="idnv" class="search__item-label">IDNV</label>
	            </div>
	            <div class="search__selectBox-item">
	                <input id="hoten" type="radio" value="tenNV" name="key">
	                <label for="hoten" class="search__item-label">HoTen</label>
	            </div>
	            <div class="search__selectBox-item">
	                <input id="diachi" type="radio" value="diachi" name="key">
	                <label for="diachi" class="search__item-label">DiaChi</label>
	            </div>
	            <div class="search__selectBox-item">
	                <input id="IDPB" type="radio" value="idpb" name="key">
	                <label for="IDPB" class="search__item-label">IDPB</label>
	            </div>
	        </div>
	        <div class="search__group-item">
	            <label for="inputField" class="search__item-label">Nhập vào Thông Tin</label>
	            <input id="inputField" class="search__input-field" placeholder="nhap thong tin nhan vien" type="text" name="value" value="">
	        </div>
	        <input type="hidden" name="action" value="search">
	        <div class="search__buttons">
	            <button type="submit" id="btnok" class="search__btn-ok">OK</button>
	            <button type="reset" id="btnreset" class="search__btn-reset">Reset</button>
	        </div>
	    </div>
	</form>	
</body>
</html>