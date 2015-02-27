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


//登陆方法
function login(){ 
	createHttpRequest();	
	var username =  document.getElementById("username").value;
	var password =  document.getElementById("password").value;
	
	var url = 'tbUser_login.action?&userName='+username+"&password="+password;
	http_request.open("post", url, true); 
	http_request.onreadystatechange=function() { 
		if(http_request.readyState==4){   
            if(http_request.status==200){ 
            	var rs = http_request.responseText;
            	if( rs == '0')
            		window.location.replace("tbUserDetail_queryAll.action");
            	else if( rs == '1')
            		alert("用户密码错误!");
            	else if( rs == '2')
            		alert("该用户已被锁定，请与管理员联系");
            	else if( rs == '3')
            		alert("用户不存在");
            	
            }   
         }   
	} 
	http_request.send(); 
}

