
function create()
{
	if(window.XMLHttpRequest){
		xmlHttp=new XMLHttpRequest();
	}
	else if(window.ActiveXObject){
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP")
	}
}


function callback()
{
	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
            var xmlDoc=xmlHttp.responseText;
        	var data=JSON.parse(xmlDoc);
			var text = "<table><tr><td>出版社：</td><td>"+data.publisher+"</td></tr><tr><td>销量：</td><td>"+data.sales_volume+
				"</td></tr><tr><td>库存：</td><td>"+data.quantity+"</td></tr></table>";
			var div = "mydiv"+data.bookID;
		    document.getElementById(div).innerHTML=text;
		}
		else{
			alert("AJAX服务器返回错误！");
		}    
	}
}


function run(url)
{
	create();
	xmlHttp.open("POST",url,true);
	xmlHttp.onreadystatechange=callback;
	xmlHttp.send();
}

function ajaxJson(bookID)
{
	run("/bookstore_It3/customer/showBookDetail?bookID="+bookID);
}

function hideAjaxJson(bookID)
{
	var div = "mydiv"+bookID;
    document.getElementById(div).innerHTML="";
}