window.onload = function() {


    if(document.getElementById("login")) {
        const $login = document.getElementById("login");
        $login.onclick = function() {
            location.href = "/user/login";
        }
    }

    if(document.getElementById("logout")) {
        const $logout = document.getElementById("logout");
        $logout.onclick = function() {
            location.href = "/user/logout";
        }
    }
    
    if(document.getElementById("signup")) {
        const $regist = document.getElementById("signup");
        $regist.onclick = function() {
            location.href = "/user/signup";
        }
    }

    if(document.getElementById("duplicationCheck")) {

        const $duplication = document.getElementById("duplicationCheck");

        $duplication.onclick = function() {
            let email = document.getElementById("email").value.trim();

            fetch("/user/idDupCheck", {
                method: "POST",
                headers: {
                    'Content-Type': 'application/json;charset=UTF-8'
                },
                body: JSON.stringify({email: email})
            })
                .then(result => result.text())
                .then(result => alert(result))
                .catch((error) => error.text().then((res) => alert(res)));

        }
    }

    if(document.getElementById("updateUser")) {
        const $update = document.getElementById("updateUser");
        $update.onclick = function() {
            location.href = "/user/myInfo";
        }
    }
    
     if(document.getElementById("updatePwd")) {
        const $updatePwd = document.getElementById("updatePwd");
        $updatePwd.onclick = function() {
            location.href = "/user/myInfo.pwd";
        }
    }
    
    
    if(document.getElementById("deleteUser")) {
        const $update = document.getElementById("deleteUser");
        $update.onclick = function() {
            location.href = "/user/delete";
        }
    }
}