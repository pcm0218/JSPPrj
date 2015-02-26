/*var noticeDao = {}; //new Object();
noticeDato.getNotices = function(page){
	
}*/

/*function f1(){
	alert(this);
}

//f1();		//java에서의 static과 같은 형태 --> window를 불러옴
new f1();	//new를 통해서하면 새로운 객체가 만들어져 전달됨 --> Object를 불러옴 (객체를 초기화하기 위해 사용함)*/


//아래 javascript 에서 함수명은 소문자로 시작하지만,
//대문자로 시작한 것으로 보아 자바의 의미(그냥 객체가 아니라 클래스를 초기화해주는 것으로 유추해볼 수 있음
/*function NoticeDao(){
	this.getNotices = function(page){
		var oReq = new XMLHttpRequest();
	   	if (oReq) {
	   		oReq.onreadystatechange = function(){
	   			if(oReq.readyState == 4)			
   				{
		   			var data = eval(oReq.responseText);		      
			      	alert(data[0].title);
   				}
	   		}
	      	oReq.open("GET", "data.jsp?p=" + page, true);
	      	oReq.send();
	      	var data = eval(oReq.responseText);		      
	   	}
	}
}
*/


function Exam(){
	this.kor = 0;
	this.eng = 0;
	this.math = 0;
	
	this.total = function(){
		return this.kor + this.eng + this.math;
	}
	
	this.avg = function(){
		return this.total / 3;
	}
}