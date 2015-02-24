function ChangeImageClick()
{
	var img1 = document.getElementById("img1");
	var txt1 = document.getElementById("txt1");
	img1.src = txt1.value;
}

function ChangeBorderClick()
{
	var img1 = document.getElementById("img1");
	var txt2 = document.getElementById("txt2");
	img1.style.borderWidth = txt2.value;
}

function init()
{
	var ChangeImage = document.getElementById("change-image");
	var ChangeBorder = document.getElementById("change-border");
	ChangeImage.onclick = ChangeImageClick;
	ChangeBorder.onclick = ChangeBorderClick;
}

window.onload = init;