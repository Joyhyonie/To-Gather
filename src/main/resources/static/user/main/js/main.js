window.onload = function() {

	/* 좋아요 버튼 */
		const likeBtns = document.querySelectorAll('.like-btn'); /* querySelectorAll을 통해 모든 class=like-btn 가져옴 */
	
	    likeBtns.forEach((likeBtn) => { /* 가져온 요소들의 집합을 반복문을 통해 하나씩 접근 */
	        
	        let isLiked = false;
	
	        likeBtn.addEventListener('click', like)
	    
	        function like() {
	            if(isLiked) {
	                likeBtn.src = "/user/main/images/like-empty.png";
	                isLiked = false;
	            } else {
	                likeBtn.src = "/user/main/images/like-full.png"
	                isLiked = true;
	            }
	        }
	    });
	    
	    
	    /* 메인 배너 슬라이드 */
	    const slides = document.querySelectorAll('.slide');
	    const slider = document.querySelector('.slider');
	    const prevBtn = document.querySelector('.prev');
	    const nextBtn = document.querySelector('.next');
	      
	    let currentSlide = 0;
	    let slideInterval;
	      
	    function showSlide(n) {
	        if (n < 0) {
	            currentSlide = slides.length - 1;
	        } else if (n >= slides.length) {
	            currentSlide = 0;
	        }
	        for (let i = 0; i < slides.length; i++) {
	            if (i < currentSlide) {
	                slides[i].classList.add('slide-left');
	                slides[i].classList.remove('slide-right', 'current-slide');
	            } else if (i === currentSlide) {
	                slides[i].classList.add('current-slide');
	                slides[i].classList.remove('slide-right', 'slide-left');
	            } else {
	                slides[i].classList.add('slide-right');
	                slides[i].classList.remove('slide-left', 'current-slide');
	            }
	        }
	    }
	      
	    function prevSlide() {
	        currentSlide--;
	        showSlide(currentSlide);
	    }
	      
	    function nextSlide() {
	        currentSlide++;
	        showSlide(currentSlide);
	    }
	
	    prevBtn.addEventListener('click', () => {
	        clearInterval(slideInterval);
	        prevSlide();
	    });
	      
	    nextBtn.addEventListener('click', () => {
	        clearInterval(slideInterval);
	        nextSlide();
	    });
	      
	    slider.addEventListener('mouseover', () => {
	        clearInterval(slideInterval);
	    });
	      
	    slider.addEventListener('mouseout', () => {
	        slideInterval = setInterval(() => {
	          nextSlide();
	        }, 2500);
	    });
	      
	    slideInterval = setInterval(() => {
	        nextSlide();
	    }, 2500);
}