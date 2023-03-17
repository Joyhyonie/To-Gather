window.onload = function() {

    /* 좋아요 버튼 */
    const likeBtns = document.querySelectorAll('.like-btn'); /* querySelectorAll을 통해 모든 class=like-btn 가져옴 */

    likeBtns.forEach((likeBtn) => { /* 가져온 요소들의 집합을 반복문을 통해 하나씩 접근 */
        
        let isLiked = false;

        likeBtn.addEventListener('click', like)
    
        function like() {
            if(isLiked) {
                likeBtn.src = "/src/main/resources/static/user/main/images/like-empty.png";
                isLiked = false;
            } else {
                likeBtn.src = "/src/main/resources/static/user/main/images/like-full.png"
                isLiked = true;
            }
        }
    })
}