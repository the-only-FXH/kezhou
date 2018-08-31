(function(){
    var hintText={
		
        
        phone:{hint:"⚠️请输入11位电话号码",right:"√电话号码输入正确",wrong:"×电话号码输入有误，请重新输入"},
       
       quhuohao:{hint:"⚠️请输入正确的取货号",right:"√取货号格式正确",wrong:"×请输入符合格式的取货号"},
        requhuohao:{hint:"⚠️请输入正确的取货号",right:"√再次输入取货号正确",wrong:"×两次输入不一致或取货号格式不正确，请重新输入或取货号格式不正确"}
    
	};
	
	var regEvent=function(node, event, func)
	
	{
        if (node.addEventListener)
            node.addEventListener(event, func);
        else if (node.attachEvent)
            node.attachEvent("on" + event, func);
        else
            node["on" + event] = func;
    };
  
  
	function regValue(id,i)
	{
        var flag=false,
        input=document.getElementById(id),
        value=input.value;
        switch (id)
{
            
            
            case "quhuohao":
           
                flag=/^([a-zA-Z0-9-]){0,20}$/.test(value.replace(/[\u0391-\uFFE5]/g,"nn"));
                id="quhuohao";
                break;
            case "requhuohao":
                flag=document.getElementById("quhuohao").value==value && value !="" && value !=null && (/^\S{0,20}$/.test(value));
                break;
           
            case "phone":
           
                flag=/^[0-9]{11}$/.test(value);
                id="phone";
                break;
				
		
           
            default:
                break;
        }
        if(flag) 
		{
            index=0;
            input.className="right input";
            hint[i].className="hint hint_right";
            hint[i].innerHTML=hintText[id].right;
        }
		else
		{
            input.className="wrong input";
            hint[i].className="hint hint_wrong";
            hint[i].innerHTML=hintText[id].wrong;
            index=1;
        }
    };
    var inputs=document.getElementsByClassName("input"),
    id,
    hint=document.getElementsByClassName("hint"),
    index=0;
    for(var j=0;j<inputs.length;j++){
        (function(i){
            regEvent(inputs[i],"focus",function(){
                hint[i].style.visibility="visible";
                id=inputs[i].id;
            });
            regEvent(inputs[i],"blur",function(){
               regValue(id,i);
            });
        })(j)
    }
    
	regEvent(document.getElementById("submit"),"click",function(e){
		
		input1=document.getElementById("xm"), //得到id为kdlx的数据
        value1=input1.value;
		input2=document.getElementById("phone"), //得到id为kdlx的数据
        value2=input2.value;
		input3=document.getElementById("lou"), //得到id为kdlx的数据
        value3=input3.value;
		input4=document.getElementById("sushe"), //得到id为kdlx的数据
        value4=input4.value;
        if(index!==0||value1==""||value2==""||value3=="未选择"||value4==""){
            
            e.preventDefault();
            alert("注册栏四项均不能为空，请检查并重新输入！");
            return false;
        }  
    });  
   
})();