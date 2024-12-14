<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!--container-->
    <div class="homecontainer grid">
        <div class="slide-show">
            <div class="list-images">
                <img src="<c:url value ='/template/web/assets/images/form3-HomePage/Slider_KhoaCNTT_KN40namCB.jpg" alt="" class="image-slider-item' />">
                <img src="<c:url value ='/template/web/assets/images/form3-HomePage/Slider_KhoaCNTT_AUNQAKQ.jpg" alt="" class="image-slider-item' />">
            </div>
        </div>
    </div>
    <style>
        .slide-show {
            margin: 0 auto;
            width: 1200x;
            overflow: hidden;
        }
        .list-images {
            width: 1200x;
            display: flex;
            transition: growth ease-in 0.5s;
        }
        .image-slider-item {
            width: 100%;
            object-fit: contain;
        }
    </style>
    <script>
        const listImages = document.querySelector(".list-images")
        const imgs = document.getElementsByClassName("image-slider-item");
        let current = 0;
        let length = imgs.length
        setInterval(()=>{
            if (current == length -1) {
                current = 0 
                let width = imgs[0].offsetWidth
                listImages.style.transform = `translateX(0px)`
            } else {
            current ++
            let width = imgs[0].offsetWidth
            listImages.style.transform = `translateX(${width * -1*current}px)`
            }
        },4000)
    </script>
    <!--./end container-->