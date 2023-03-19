function onlyNumber(obj) {
    //숫자 아닌 표현식 찾기
    const regexp = /\D/g;
    //숫자 아니면 공백
    event.target.value = event.target.value.replace(regexp, "");
    /* , 추가 */
    obj.value = comma(uncomma(obj.value));
    function comma(str) {
        str = String(str);
        return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
    }

    function uncomma(str) {
        str = String(str);
        return str.replace(/[^\d]+/g, '');
    }
}

window.onload = function () {
    const $rewradAddress = document.getElementById("rewradAddress");
    const $outer = document.getElementById("addre");
    const $new = document.createElement("p");
    $rewradAddress.onclick = function () {
        new daum.Postcode({
            oncomplete: function (data) {
                
                
                $rewradAddress.innerHTML = "[" + data.zonecode + "]" + data.address + "<input type='button' value='X' onclick='remove1()'>";
                $new.innerHTML = "<input type='text' class='detailed-address' placeholder='상세주소 입력' style='text-align: center;'>";
                $outer.appendChild($new);
                
            }
        }).open({
            // popupKey: 'popup1'
            
        });
        return remove1();
        function remove1() {
        
            $rewradAddress.innerHTML = "주소를 검색하시려면 이곳을 클릭하세요.";
            $new.remove();
        }
    };
    

    const $btn = document.querySelectorAll('.btn');
    const $img = document.querySelectorAll('.img');
    const $off = document.querySelectorAll('.off');
    const $text1 = document.getElementsByClassName('text1');
    console.log($text1);
    var state = "off";
    var state1 = "off";
    var state2 = "off";

    const $pay1 = document.getElementById('pay1');
    console.log($pay1);
$btn[0].addEventListener('click', function(){    
    if(state == "off"){
    $img[0].style.display = 'none';
    $off[0].style.display = 'block';
    $btn[0].style.border = " 3px solid green";
    $text1[0].style.color = 'green';
    $off[1].style.display = 'none';
    $img[1].style.display = 'block';
    $text1[1].style.color = 'black';
    $off[2].style.display = 'none';
    $img[2].style.display = 'block';
    $text1[2].style.color = 'black';
    $pay1.style.display = 'none';
    $btn[1].style.border = " 3px solid black"
    $btn[2].style.border = " 3px solid black"
    state="on";
    state1 = "off";
    state2 = "off";
    } else {
    $off[0].style.display = 'none';
    $img[0].style.display = 'block';
    $text1[0].style.color = 'black';
    $off[1].style.display = 'none';
    $img[1].style.display = 'block';
    $text1[1].style.color = 'black';
    $btn[0].style.border = " 3px solid black"
    state = "off";
    }
});
$btn[1].addEventListener('click', function(){    
    if(state1 == "off"){
    $pay1.style.display = 'block';
    $img[1].style.display = 'none';
    $off[1].style.display = 'block';
    $text1[1].style.color = 'green';
    $off[0].style.display = 'none';
    $img[0].style.display = 'block';
    $text1[0].style.color = 'black';
    $off[2].style.display = 'none';
    $img[2].style.display = 'block';
    $text1[2].style.color = 'black';
    $btn[1].style.border = " 3px solid green";
    $btn[0].style.border = " 3px solid black"
    $btn[2].style.border = " 3px solid black"
    state = "off";
    state1="on";
    state2 = "off";
    } else {
    $off[1].style.display = 'none';
    $img[1].style.display = 'block';
    $text1[1].style.color = 'black';
    $off[2].style.display = 'none';
    $img[2].style.display = 'block';
    $text1[2].style.color = 'black';
    $pay1.style.display = 'none';
    $btn[1].style.border = " 3px solid black"
    state1 = "off";
    
    }
});
$btn[2].addEventListener('click', function(){    
    if(state2 == "off"){
    $img[2].style.display = 'none';
    $off[2].style.display = 'block';
    $text1[2].style.color = 'green';
    $off[1].style.display = 'none';
    $img[1].style.display = 'block';
    $text1[1].style.color = 'black';
    $off[0].style.display = 'none';
    $img[0].style.display = 'block';
    $text1[0].style.color = 'black';
    $pay1.style.display = 'none';
    $btn[2].style.border = " 3px solid green";
    $btn[0].style.border = " 3px solid black"
    $btn[1].style.border = " 3px solid black"
    state = "off";
    state1="off";
    state2 = "on";
    } else {
    $off[2].style.display = 'none';
    $img[2].style.display = 'block';
    $text1[2].style.color = 'black';
    $btn[2].style.border = " 3px solid black"
    state2 = "off";
    }
});

const $selectCoupon = document.getElementById('selectcoupon');

const $cutext = document.getElementsByClassName('cutext')[0];

const $cuprice = document.getElementsByClassName('cuprice')[0];




$(document).ready(function() {
    $("#selectcoupon").on('click', function() {
        if ( $(this).prop('checked') ) {
     
        $cutext.innerHTML = "회원가입 축하 쿠폰";
        $cuprice.innerHTML = "10,000원";
                
} else {
    $cutext.innerHTML =  "";
    $cuprice.innerHTML = "";
}
});
});

}

/* 직접 입력*/

$(function () {
    //직접입력 인풋박스 기존에는 숨어있다
    $("#selboxmemo").hide();
    $("#rewardOrderFormMemo").change(function () {
        //직접입력을 누를 때 나타남
        if ($("#rewardOrderFormMemo").val() == "직접 입력") {
            $("#selboxMemo").show();
        } else {
            $("#selboxMemo").hide();
        }
    })
});

$(function () {
    //직접입력 인풋박스 기존에는 숨어있다가
    $("#selboxAddressName").hide();
    $("#rewardOrderFormAddressName").change(function () {
        //직접입력을 누를 때 나타남
        if ($("#rewardOrderFormAddressName").val() == "직접 입력") {
            $("#selboxAddressName").show();
        } else {
            $("#selboxAddressName").hide();
        }
    })
});
