
//登录的ajax
function login(name2,pwd){
	var data1={name:name2};
	$.ajax({
		type:"POST",
		url:"login2.do",
		dataType:'json',
		contentType:'application/json;charset=UTF-8',
		data:JSON.stringify(data1),
		success:function(result){
			
		}
	});
}




$(document).ready(function(){
	$("#login_button").click(function(){
		var name=$("#username").val();
		var pwd=$("#pwd").val();
		login(name,pwd);
	});
});