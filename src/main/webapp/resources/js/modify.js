const URLSearch = new URLSearchParams(location.search);
const username = URLSearch.get("username"); 
 
	
// 비밀번호 변경시 비밀번호입력 상태 확인
const isSubmit = (function() {
	let submit = false;
	
	const getSubmit =function() {
		return submit;
	}
	
	const setSubmit = function(set){
		submit = set;
		return submit;
	}
	return {getSubmit : getSubmit, setSubmit : setSubmit};
})();	
	
 
	
	
 
 
 
function pwdCheck() {
	const password1 = $(".password1").val().replaceAll(" ", "");
	const password2 = $(".password2").val().replaceAll(" ", "");
 
	const msgBox = $(".password_check_msg");
	
	if (!password1 || !password2) {
		msgBox.text("비밀번호를 입력해주세요");
		return false;
	} else {
		msgBox.text("");
	}
	
	if(password1 != password2) {
		msgBox.text("비밀번호를 확인해 주세요");
		return false;
	} else {
		msgBox.text("");
	}
	
	return true;
}
 
 
// 패스워드 변경
$(".modify_btn").click(function(){
    console.log(username)
	if(!pwdCheck()) {
		return;
	}
	
	const data = {
		password: $(".password1").val(),
		valueType : "password", 
		username : username
	}
	
	$.ajax({
		url: "/member/modify/password",
		type: "POST",
		data: data
	})
	.done(function(result){
        if(result == 1){

            swal({
                text : "비밀번호를 변경했습니다.",
                closeOnClickOutside : false
            })
            .then(function(){
                location.href = "/member/login";
            })
        } else {
            swal("변경에러","","error")
        }
	})
	.fail(function(){
		alert("에러");
	})
})