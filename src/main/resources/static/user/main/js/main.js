window.onload = function() {

    /* 이미지에 마우스오버를 하면 프로젝트 간략 소개 나타내기 */
    // const projectImage = document.querySelector(".project-image")
    // const displayBox = document.querySelector(".display-box")

    // projectImage.addEventListener('mouseenter', () => displayBox.style.transition = "block");
    // displayBox.addEventListener('mouseout', () => displayBox.style.display = "none");


    /* 하트를 클릭할 시 이미지 변경 */
    const likeFull = document.querySelector(".like-full")
    const likeEmpty = document.querySelector(".like-empty")

    likeEmpty.addEventListener('click', changeToFull)
    likeFull.addEventListener('click', changeToEmpty)

    function changeToFull() {
        likeEmpty.style.display = "none";
        likeFull.style.display = "block";
    }

    function changeToEmpty() {
        likeEmpty.style.display = "block";
        likeFull.style.display = "none";
    }
}