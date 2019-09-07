
$(document).ready(function () {

    //로그인
    $("#loginBtn").click(function() {
        loginUser();
    });

    //회원 가입
    $("#joinBtn").click(function () {
        joinUser();
    });

    //유저 회원가입
    function joinUser() {
        $.ajax({
            url: "/api/user/join",
            type: "post",
            data: JSON.stringify({
                userId: $("#inputId").val(),
                password: $("#inputPassword").val(),
                confirmPassword: $("#inputConfirmPassword").val()
            }),
            contentType: "application/json",
        }).done(function (data) {
            alert("정상적으로 회원 가입 되셨습니다.");
            //로그인 창으로 이동
            window.location.href = "/user/login"
        }).fail(function (xhr, status, errorThrown) {
            alert("관리자에게 문의하세요.")
        });
    }

    //유저 로그인
    function loginUser() {

        $.ajax({
            url: "/api/user/login",
            type: "post",
            data: JSON.stringify({
                username: $("#inputId").val(),
                password: $("#inputPassword").val()
            }),
            contentType: "application/json",
        }).done(function (data) {
            if (data == true) {
                alert("정상적으로 접속하셨습니다.");

                window.location.href = "/book/search"
            } else {
                alert("패스워드, 비밀번호 다시 한번 확인하세요.")
            }
        }).fail(function (xhr, status, errorThrown) {
            alert("관리자에게 문의하세요.")
        });
    }
});