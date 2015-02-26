//ajax代码

var  http_request = false; 
function createHttpRequest(){
	if (window.XMLHttpRequest) {    	             // 非IE浏览器
	        http_request = new XMLHttpRequest();   //创建XMLHttpRequest对象
	} else if (window.ActiveXObject) {     	             // IE浏览器
	   try {
	          http_request = new ActiveXObject("Msxml2.XMLHTTP"); //创建XMLHttpRequest对象
	    } catch (e) {
	       try {
	          http_request = new ActiveXObject("Microsoft.XMLHTTP");
		  } catch (e) {
		    alert("不能创建XMLHttpRequest对象实例！");
		 }
	    }
	}
}


//加载用户信息
function loadUser(){
	
	var id = window.opener.document.getElementById("user_id").value;
	var name = window.opener.document.getElementById("user_name").value;
	var sex = window.opener.document.getElementById("user_sex").value;
	var age = window.opener.document.getElementById("user_age").value;
	var addDate = window.opener.document.getElementById("user_addDate").value;
	var phone = window.opener.document.getElementById("user_phone").value;
	var success = window.opener.document.getElementById("user_success").value;
	
	
	document.getElementById("user_id").innerText  = id;
	document.getElementById("user_name").innerText  = name;
	document.getElementById("user_age").innerText  = age;
	if(sex == 'm'){
	document.getElementById("user_sex").innerText  = '男';
	}else{
		document.getElementById("user_sex").innerText  = '女';
	}
	document.getElementById("user_addDate").innerText  = addDate;
	document.getElementById("user_phone").innerText  = phone;
	document.getElementById("user_success").innerText  = success;
	
}

