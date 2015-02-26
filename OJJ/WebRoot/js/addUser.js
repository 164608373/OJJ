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

//增加用户
function addUser(){ 
	createHttpRequest();	
	var username =  document.getElementById("username").value;
	var sex =  document.getElementById("sex").value;
	var phone =  document.getElementById("phone").value;
	var addDate =  document.getElementById("addDate").value;
	var age =  document.getElementById("age").value;
	
	if(!username){
		alert("请输入用户名");
		reset();
		return;
	}
	
	
	var url = 'tbUserDetail_addUserDetail.action?userName='+username+"&sex="+sex
		+"&phone="+phone+"&addDate="+addDate+"&age="+age;
	http_request.open("post", url, true); 
	http_request.onreadystatechange=function() { 
		if(http_request.readyState==4){   
			alert(http_request.responseText);
			window.close();
			window.opener.location.href = "tbUserDetail_queryAll.action";
         }   
	} 
	http_request.send(); 
}

//清空信息
function reset(){
	 document.getElementById("addUserForm").reset();
	
	
}


