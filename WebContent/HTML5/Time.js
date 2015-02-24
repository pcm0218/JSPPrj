var count = 60;
var timer = null;

function countDown()
{
	var lblCount = document.getElementById("lbl-count");
	lblCount.innerText = --count;			// value 처럼 사용
		
	if(count > 0)
		setTimeout(countDown, 1000);
	else if(count == 0)
		alert("시간초과");
}

function init()
{
	var btnCountDown = document.getElementById("btn-countdown");
	btnCountDown.onclick = btnCountDownClick;
}

function btnCountDownClick()
{
	if(timer == null)
		timer = setTimeout(countDown, 1000);		// 1000 ms 딜레이
}

window.onload = init;