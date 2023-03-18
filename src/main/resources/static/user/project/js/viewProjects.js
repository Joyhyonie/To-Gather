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
    });

    /* ----------------------------------------------------------------------------------------- */
    
    /* 더보기 페이징 기능 */
    load('#more-projects', '8'); /* 기본 첫 화면에서 노출 될 프로젝트의 갯수 지정 */

    document.querySelector('.more-button').addEventListener('click', function() {
        load('#more-projects', '8', '#more-button');
    });

    /* more 버튼을 클릭할 때 마다 실행 될 함수 */
    function load(id, cnt, btn) {
        let viewProject = document.querySelectorAll(id + ' .loading:not(.active)'); /* loading 중 active가 아닌 것 */
        let viewLength = viewProject.length; /* 화면에 노출되지 않은 프로젝트들의 개수 */
        let viewTotalCount;
        
        if (cnt < viewLength) {
            viewTotalCount = cnt;
        } else {
            viewTotalCount = viewLength;
            document.querySelector('.more-button').style.display = 'none'; /* 더이상 로드될 프로젝트가 없는 경우 more 버튼 display:none */
        }

        for (let i = 0; i < viewTotalCount; i++) {
            viewProject[i].classList.add('active'); 
        }
    }

}