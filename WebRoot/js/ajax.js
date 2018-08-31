var httpRequest=null;
function createXHR(){		
	if(window.XMLHttpRequest){ //Mozilla,Safari,Opera,IE7��
		httpRequest = new XMLHttpRequest();
	}else if(window.ActiveXObject){
		try{
			httpRequest = new ActiveXObject("Msxml2.XMLHTTP"); //IE���°汾
		}catch(e){
			try {
				httpRequest = new ActiveXObject("Microsoft.XMLHTTP");//IE���ϰ汾
			}catch(e){
				httpRequest = null;
			}
		}		
	}	
	if(!httpRequest){ 
		alert("fail to create httpRequest");		
	}
}

function sendRequest(url,params,method,handler){
	
	createXHR();	//�ȴ���һ��XMLHttpRequest�Ķ���
	if(!httpRequest) return false;	//����ʧ�ܷ���false
	httpRequest.onreadystatechange = handler;
	
	if(method == "GET"){	
	    httpRequest.open(method,url+ '?' + params,true);	
		httpRequest.send(null);
	}
	if(method == "POST"){
	    httpRequest.open(method,url,true);
		httpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		httpRequest.send(params); 
	}	
}