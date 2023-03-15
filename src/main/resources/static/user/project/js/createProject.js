window.onload = function() {

    /* Maker 프로필 프리뷰 */
    (function(){
        const previewArea = document.querySelector("#preview-area");
        const fileElements = document.querySelector("#attach-profile");

        fileElements.addEventListener('change', preview);

        function preview() {
            console.log(this);
            if(this.files && this.files[0]) {
                const reader = new FileReader();
                reader.readAsDataURL(this.files[0]);
                reader.onload = function() {
                    previewArea.innerHTML = `<img src='${reader.result}' id="preview-image">`;
                }
            }
        }
    })();


    /* 주소 검색 */
    const SearchAddress = document.getElementById("address1");
		
	SearchAddress.onclick = function() {
			
		/* 다음 우편번호 검색 창을 오픈하면서 동작할 콜백 메소드를 포함한 객체를 인자로 전달 */
		new daum.Postcode({
		    oncomplete: function(data) {
		        /* 팝업에서 검색결과 항목을 클릭 했을 시 실행 할 코드를 작성하는 부분 */
		        document.getElementById("zip-code").value = data.zonecode; /* 넘어온 우편번호를 value로 저장 */
		        document.getElementById("address1").value = data.address; /* 넘어온 주소를 value로 저장 */
		        document.getElementById("address2").focus(); /* 상세주소를 입력하라는 의미로 포커스 */
		    }
		}).open();
	};

    /* 프로젝트 이미지들의 크기를 제한하는 alert */
    const mainImage = document.querySelector("#main-image")
    const uploadName = document.querySelector(".upload-name") /* 20MB보다 큰 이미지는 파일명 변경되지 않도록 하기 위해 추가 */

    mainImage.addEventListener('change', checkSize);

    function checkSize() {
        if(mainImage.files && mainImage.files[0].size > (0.01 * 1024 * 1024)) { /* 추후 (20 * 1024 * 1024) 으로 변경 */
            alert("이미지는 20MB 이하의 크기를 가지고 있어야 합니다 😰")
            mainImage.value = null;
            uploadName.value = "파일을 업로드 해주세요 :)";
        }
    };
    
    /* 프로젝트 메인 사진 프리뷰 */
    (function(){
        const previewArea = document.querySelector("#main-preview-area");

        mainImage.addEventListener('change', preview);

        function preview() {
            console.log(this);
            if(this.files && this.files[0]) {
                const reader = new FileReader();
                reader.readAsDataURL(this.files[0]);
                reader.onload = function() {
                    previewArea.innerHTML = `<img src='${reader.result}' id="main-preview-image">`;
                }
            }
        }
    })();


    /* 프로젝트 메인 사진 첨부 시, 프리뷰 생성 */
    const mainPreviewArea = document.querySelector("#main-preview-area");
    const uploadMainImage = document.querySelector("#upload-main-image");

    uploadMainImage.addEventListener('click', ()=> mainPreviewArea.style.display = "block"); /* display:none을 block으로 변경 */


    /* 프로젝트 메인 사진의 비율이 다를 경우, alert로 알림 */
    // const mainPreviewImage = document.querySelector("#main-preview-image");

    // uploadMainImage.addEventListener('click', alertSize);

    // function alertSize() {
    //     console.log("메롱")
    //     console.log(mainPreviewImage.width)
    //     console.log(mainPreviewImage.height)
    //     if(mainPreviewImage.width != (600) && mainPreviewImage.height != (450)) {
    //         alert("권장 크기와의 차이로 실제 이미지와 다르게 보일 수 있습니다 😓");
    //         return;
    //     }
    // }


}