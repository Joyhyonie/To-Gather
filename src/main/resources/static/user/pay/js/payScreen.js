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
                $new.innerHTML = "<input type='text' id='detailed-address' placeholder='상세주소 입력' style='text-align: center;'>";
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

// $(function(){
//     $('#submitPay').click(function(){
//         if(state == "on"){
//            $.ajax({
// 			   url:'/pay/kakaopay',
// 			   dataType: 'json',
// 			   success:function(data){
// 				   /*alert(data, tid);*/
// 					var box = data.next_redirect_pc_url;
// 					window.open(box);
				
// 			   },
// 			   error:function(error){
// 				   alert(error, "아");
// 			   }
			   
// 		   });
//         }
//     });
// });
/* 결제자 번호 */
// const $supporterPhoneNumber = document.getElementById('supporterPhoneNumber').value;
/* 주소 + 상세주소*/ 
// const $countbox = + document.getElementById('countbox').value;

$(function(){
    $('#submitPay').click(function(){
        if(state == "on"){
            const $finalPrice = document.getElementById('finalPrice').innerText;
            const $kakao = document.querySelectorAll('.text1')[0].innerText;
            const $title = document.getElementById('pjTitle').innerText;
            const $Date = new Date();
            const onError = xhr => console.log(xhr);
            const onSuccess = data => console.log(data);
            console.log($Date);

            console.log($kakao);
            console.log("하");
            console.log($finalPrice);
            const json = { $title, $kakao, $finalPrice, $Date};
            console.log(json);
            IMP.init('imp63382662');
            IMP.request_pay({
                pg : "kakaopay", 
                pay_method : 'card',
                merchant_uid : 'ka' + new Date().getTime(),
                name : '결제',
                amount : $finalPrice,
                buyer_email : '구매자 이메일',
                buyer_name : '구매자 이름',
                buyer_tel : '구매자 번호',
                buyer_addr : '구매자 주소',
                buyer_postcode : '구매자 주소',
                // m_redirect_url : 'redirect url'
            }, function(rsp) {
                if ( rsp.success ) {
                    console.log(rsp);
                    //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
                    $.ajax({
                        url: "/pay/order", //cross-domain error가 발생하지 않도록 주의해주세요
                        type: 'POST',
                        data: { json,
                        contentType : 'text',
                        error : onError,
                        success : onSuccess
                            //기타 필요한 데이터가 있으면 추가 전달
                        }
                    })
                    // .done(function(data) {
                    //     //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
                    //     if ( everythings_fine ) {
                    //         msg = '결제가 완료되었습니다.';
                    //         msg += '\n고유ID : ' + rsp.imp_uid;
                    //         msg += '\n상점 거래ID : ' + rsp.merchant_uid;
                    //         msg += '\결제 금액 : ' + rsp.paid_amount;
                    //         msg += '카드 승인번호 : ' + rsp.apply_num;
                    //         console.log("하");
                    //         alert(msg);
                    //     } else {
                    //         //[3] 아직 제대로 결제가 되지 않았습니다.
                    //         //[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
                    //     }
                    // });
                    //성공시 이동할 페이지
                    // location.href="http://localhost:8001/pay/payComplete";
                } else {
                    msg = '결제에 실패하였습니다.';
                    msg += '에러내용 : ' + rsp.error_msg;
                    //실패시 이동할 페이지
                    location.href="http://localhost:8001/pay/payScreen";
                    alert(error);
                }
            });
        }
    })
    
    
});

const $rewradAddress1 = document.getElementById('detailed-address').value;
const $address = $rewradAddress + $rewradAddress1;
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function(e, xhr, options) { xhr.setRequestHeader(header, token); });

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
