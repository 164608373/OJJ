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


//根据id解锁用户
function openLock(id){ 
	createHttpRequest();	
	
	var url = 'tbUser_openLock.action?id='+id;
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



//添加用户
function addUser(){
	//点击添加按钮弹出添加用户信息页面
	window.open("addUser.jsp", "newwindow","height=250,width=400,top=200,left=400,toolbar=yes,menubar=no,scrollbars=no,resizable=no,location=no,status=no");
}


//删除用户

function deleteUser(){
	//根据用户id删除用户
	//check()判断是否有选择用户  true为是
	if(check() == true){
		//执行删除用户
		
		createHttpRequest();	
		var id = document.getElementById("user_id").value;
		var url = 'tbUserDetail_deleteUser.action?user_id='+id;
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
}

//修改用户

function updateUser(){
	
	//check()判断是否有选择用户  true为是
	if(check() == true){	
	//点击修改按钮根据获取用户信息，然后再页面显示进行修改
	window.open("updateUser.jsp", "newwindow","height=250,width=400,top=200,left=400,toolbar=yes,menubar=no,scrollbars=no,resizable=no,location=no,status=no");
	}
}
//改变用户的id值
function changeId(id,name,age,sex,addDate,phone,success){
	document.getElementById("user_id").value=id;
	document.getElementById("user_name").value=name;
	document.getElementById("user_age").value=age;
	document.getElementById("user_sex").value=sex;
	document.getElementById("user_addDate").value=addDate;
	document.getElementById("user_phone").value=phone;
	document.getElementById("user_success").value=successs;
}

//检查是否有选择用户
function check(){
	//获取单选框对象集合
	var idRadio = document.getElementsByName("id");
	//标志是否已经选择单选框 true为已选 false为未选
	var isSelect = false;
	for(var i = 0; i < idRadio.length; i++){
		if(true == idRadio[i].checked){
		//如果有一个单选按钮已选则为已选择
			isSelect = true;
		}
	}
	
	if(false == isSelect){	
		alert("请选上要操作用户编号的单选框");
		return false;
	}
	return true;
}

//打印用户信息
function printUser(){
	if(check() == true){	
		//点击修改按钮根据获取用户信息，然后再页面显示进行修改
		window.open("printUser.jsp", "newwindow","height=350,width=400,top=200,left=400,toolbar=yes,menubar=no,scrollbars=no,resizable=no,location=no,status=no");
		}
}

