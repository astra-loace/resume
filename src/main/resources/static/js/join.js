/**
 * 회원가입 시 필요한 검증 작업 
 */
let idCheck = false;
let pwdCheck = false;   // 비번이랑 비번확인에 입력된 값 모두 일치해야지~

$(function() {
    $('#idCheck').on('click', confirmId);
    $('#userPwd').on('focus', function() { // focus 되면 pwCheck쪽에 있는 값 지워줘!
        $('#pwCheck').val('');
    })

    $('#submitBtn').on('click', join);
});

// 2) 회원가입을 위한 나머지 검증작업
function join() {
    //idCheck를 안 했다고? 가입은 어림도 없다고 전해라~
    if (idCheck != true) {
        alert("아이디 중복확인을 먼저 해주세요.")
        return false;
    }

    // 비밀번호는 3~8자리로 해야 해요
    let userPwd = $('#userPwd').val();
    if (userPwd.trim().length < 3 || userPwd.trim().length > 8) {
        alert("비밀번호는 3~8글자 사이로 입력해주세요.")
        pwdCheck = false;
        return false; // submit에 보내는 거라서
    }

    // 비밀번호 확인이랑도 같아야지요
    let pwCheck = $('#pwCheck').val();
    if (userPwd.trim() != pwCheck.trim()) {
        alert("동일한 비밀번호를 입력해주세요.")
        pwdCheck = false;
        return false; // submit에 보내는 거라서
    }
    // 이름은 입력했나요?
    let userNm = $('#userNm').val();
    if (userNm.trim().length < 1) {
        alert("이름을 입력해주세요.")
        
        return false; // submit에 보내는 거라서
    }

    return true;

}

// 1) 아이디 검증하기
function confirmId() {
    let userId = $('#userId').val();

    // 아이디는 3~8자리로 입력해야 해요
    if(userId.trim().length < 3 || userId.trim().length > 8) {
        $('#confirmId').css('color', 'red')
        $('#confirmId').html("아이디는 3~8글자 사이로 입력해주세요.")
        return false;
    }
    
    // 아이디는 중복되나요?
    $.ajax ({
        url: "/user/idCheck",
        method: "POST",
        data: {"userId" : userId},
        success : function(resp) {
            if(resp) {
                $('#confirmId').css('color', 'blue');
                $('#confirmId').html("사용할 수 있는 아이디입니다.")
                idCheck = true;
            } else {
                $('#confirmId').css('color', 'red');
                $('#confirmId').html("사용할 수 없는 아이디입니다.")
                idCheck = false;
            }
        }
    });
}