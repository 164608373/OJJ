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
	document.getElementById("user_id").value = id;
	document.getElementById("username").value = name;
	document.getElementById("age").value = age;
	document.getElementById("sex").value = sex;
	document.getElementById("addDate").value = addDate;
	document.getElementById("phone").value = phone;
	document.getElementById("success").value = success;
}

//清空用户的值	
function reset(){
	document.getElementById("updateForm").reset();
}


//更新用户的值
function updateUser(){
	createHttpRequest();	
	var id = document.getElementById("user_id").value;
	var name= document.getElementById("username").value;
	var sex = document.getElementById("sex").value;
	var age = document.getElementById("age").value;
	var phone = document.getElementById("phone").value;
	var addDate = document.getElementById("addDate").value;
	var success = document.getElementById("success").value;
	var url = 'tbUserDetail_updateUser.action?user_id='+id+"&userName="+name+
	"&sex="+sex+"&age="+age+"&phone="+phone+"&addDate="+addDate+"&success="+success;
	http_request.open("post", url, true); 
	http_request.onreadystatechange=function() { 
		if(http_request.readyState==4){   
            if(http_request.status==200){   
            	alert(http_request.responseText);
            	window.location.replace("tbUserDetail_queryAll.action");
            }   
         }   
	} 
	http_request.send(); 
}

function test(){
	alert(test);
}
