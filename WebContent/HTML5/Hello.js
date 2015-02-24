	/* var x;
	alert(x==undefined) */

	/* var lottos = new Array();
	lottos[0] = 5;
	lottos[1] = 10;
	lottos[2] = 21; */

	/* var lottos = [5, [2, 3], "hello"];
	alert(typeof lottos[1, 1]);
	alert(lottos[2][0]); */

	/* alert(3.5 -"2"); */// 연산자에 따라 숫자와 문자 인식이 다름 >> 3.5 -"2" = 1.5 이다.
	/* alert(3.5 +"2"); */
	/* alert("32">"4"); */// false
	/* alert(32>"4"); */// true 위와 같이 애매한 비교, 연산들은 좋지 않음
	// 입/출력 플랫폼
	/* var x = 3;
	document.write(x); */

	//브라우저의 윈도우 객체 (window object)
	//window
	//window.location
	//window.history (Go, Back)	
	//window.document 가장 중요
	/* var x, y;;
	x = prompt("x 값을 입력하세요.", 0);
	y = prompt("y 값을 입력하세요.", 0);
	x = parseInt(x);
	y = parseInt(y);
	alert(x + y); */// alert, prompt 는 스크립트가 아니라 브라우저가 제공하는 기능(함수)
	/* alert(x - y); */

	// parseInt("abc"); // Returns NaN. > Not a Number
	// parseInt("12abc"); // Returns 12.
	/* var ar = ["철수", "영희", "맹구", "동천"]; */// list 형태: [] / map 형태: {} --> map은 key 안에 key 값이 있음
	// 아래에 kor 안에 30 이라는 값이 있음
	/* for(var i=0; i<4; i++)
		alert(ar[i]); */

	/* for(i in ar)
		alert(ar[i]); */

	/* var record = {kor:30, eng:40, math:50}
	
	/* for(var k in record)
		alert(record[k]); */

	/* function add(a, b)
	{
		return a + b;			
	} */

	/* var add = function(a, b)
	{
		return a + b;
	}
	
	alert(add(3, 4)); */

	/* function add(a, b) // a, b 는 별칭 일뿐
	{
		return arguments[0] + arguments[1] + arguments[2];
	}
	
	var sum = add(2, 3, "hello", 3, 4, 5, 6, 7, 87);
	
	alert(sum); */

	/*function printResult() {
		var btnPrint = document.getElementById("btn-print"); // html 식표기법은 (-) / 스크립트에서는 낙타표기법 : 표기법을 같게 해주기 위해 다큐먼트에 있는 객체 이용하여 표기법 변환해줌
		var x, y;
		x = prompt("x 값을 입력하세요", 0);
		y = prompt("y 값을 입력하세요", 0);
		x = parseInt(x);
		y = parseInt(y);
		btnPrint.value = x + y;
	}*/

	function init() // 함수 안에 있으면 함수 내에 있는 부분이 바로 실행되지 않아
	{
		var btnSum = document.getElementById("btn-sum");
		btnSum.onclick = btnSumClick;
	}
	
	function btnSumClick() 
	{
		/*var btnSum = document.getElementById("btn-sum");*/
		var txtX = document.getElementById("txt-x");
		var txtY = document.getElementById("txt-y");
		var x = parseInt(txtX.value);
		var y = parseInt(txtY.value);
		var txtSum = document.getElementById("txt-sum");
		
		txtSum.value = x + y;
	}

	/*function init() // 함수 안에 있으면 함수 내에 있는 부분이 바로 실행되지 않아
	{
		var btnPrint = document.getElementById("btn-print");
		btnPrint.onclick = printResult;
	}*/
	


	window.onload = init; // load 될 때 init 내부 함수를 실행함, init 함수가 없다면 우선순위에 의해 btnPrint 가 정의되지 않는 오류 발생