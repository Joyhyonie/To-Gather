window.onload = function() {

    /* 메뉴 탭 클릭 시 스토리 or 소식&후기 화면 전환 */
    const menuList = document.querySelectorAll('.story-bar .menu li');
    const contents = document.querySelectorAll('.story-body .content');
    let activeCont = ''; // 현재 활성화된 컨텐츠 (기본으로 스토리 활성화)

    for(let i = 0; i < menuList.length; i++) {
        menuList[i].querySelector('.btn').addEventListener('click', function(e){
            e.preventDefault();
                    
             for(let j = 0; j < menuList.length; j++) {
                menuList[j].classList.remove('is_on'); /* 나머지 버튼 클래스 제거 */

                contents[j].style.display = 'none'; /* 나머지 컨텐츠 display:none 처리 */
            }

            /* 버튼 관련 이벤트 */
            this.parentNode.classList.add('is_on');

            /* 버튼 클릭 시 컨텐츠 전환 */
            activeCont = this.getAttribute('href');
            document.querySelector(activeCont).style.display = 'block';
        });
    }
}

