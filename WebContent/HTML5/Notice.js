function btnResizeClick()
{
	/*opener.resizeTo(100, 100);*/		// 부모(opener)의 사이즈를 100,100 으로
	opener.resizeBy(100, 100);			// 부모(opener)의 사이즈를 +100,+100 늘려줌
}

function btnMoveClick()
{
	opener.moveTo(100, 100);
	opener.moveBy(100, 100);
}

function btnOpenerCloseClick()
{
	opener.close();
}

function init()
{
	var btnResize = document.getElementById("btn-resize");
	var btnMove = document.getElementById("btn-move");
	var btnOpenerClose = document.getElementById("btn-opener-close");
	
	btnResize.onclick = btnResizeClick;
	btnMove.onclick = btnMoveClick;
	btnOpenerClose.onclick = btnOpenerCloseClick;
}

window.onload = init;