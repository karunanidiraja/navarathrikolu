$(document).ready(function() {
	onLoaderComplete();
});

function submitForm(form, action) {
	onLoader();
	$("#form1").attr("action", action);
	form.submit();
}

function viewLoader(wrapperId, loaderId) {
	if(!$("#" + wrapperId).hasClass("loading")) {
		$("#" + wrapperId).addClass("loading");
	}
	if(!$("#" + loaderId).hasClass("loading")) {
		$("#" + loaderId).addClass("loading");
	}
}

function hideLoader(wrapperId, loaderId) {
	if($("#" + wrapperId).hasClass("loading")) {
		$("#" + wrapperId).removeClass("loading");
	}
	if($("#" + loaderId).hasClass("loading")) {
		$("#" + loaderId).removeClass("loading");
	}
}

function onLoader() {
	viewLoader('nested-loader-wrapper', 'nested-loader');
}

function onLoaderComplete() {
	hideLoader('nested-loader-wrapper', 'nested-loader');
}

function onModalLoader() {
	viewLoader('modal-nested-loader-wrapper', 'modal-nested-loader');
}

function onModalLoaderComplete() {
	hideLoader('modal-nested-loader-wrapper', 'modal-nested-loader');
}

function loadLink(path) {
	onLoader();
	window.location.href = path;
}

