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

function NoticeDao(){
	
}

NoticeDao.prototype = {
		getNotices : function(page, callback){
			var oReq = new XMLHttpRequest();
		   	if (oReq) {
		   		oReq.onreadystatechange = function(){
		   			if(oReq.readyState == 4)			
	   				{
			   			var data = eval(oReq.responseText);
				      	callback(data);
	   				}
		   		}
		      	oReq.open("GET", "data.jsp?p=" + page, true);
		      	oReq.send();
		   	}
		}
};

var noticeDao = new NoticeDao();
noticeDao.getNotices(1, function(data){
	alert(data[0].title);
	alert(data[1].title);
});


/*function Exam(){
	this.kor = 0;
	this.eng = 0;
	this.math = 0;
}*/

/*Exam.prototype.total = function(){
	return this.kor + this.eng + this.math;
}

Exam.prototype.avg = function(){
	return this.total() / 3;
}
*/
// 위의 방법을 간단하게 아래와 같이 쓰도록 (중간에 , 빼먹지 말 것 !)

/*Exam.prototype = {
	cnt : 0,
		
	total : function(){
		this.cnt++;
		return this.kor + this.eng + this.math;
	},

	avg : function(){
		return this.total() / 3;
	}
}*/

// Array, Object, Function, .... --> 모두 Object를 물려받는 것들임

/*var ex1 = new Exam();		// static으로 선언하면 total 이라는 객체 하나를 같이 쓰는 것 
							// new로 만든 것은 total 이 여러개 만들어짐 (여기서 문제점 발생)
ex1.kor = 30;
ex1.eng = 40;
ex1.math = 50;
ex1.total();
alert(Exam.prototype);

var ex2 = new Exam();
ex2.kor = 10;
ex2.total();

var ex3 = new Exam();
ex3.kor = 10;
ex3.total();*/
