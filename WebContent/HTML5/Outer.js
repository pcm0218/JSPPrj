function btnOpenDocClick()
{
	window.frames[0].location.href = "http://www.daum.net";
}

function init()
{
	var btnOpenDoc = document.getElementById("btn-open-doc");
	btnOpenDoc.onclick = btnOpenDocClick;
}

window.onload = init;