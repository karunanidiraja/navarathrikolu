<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%-- Show usage; Used in Header --%>
<tiles:importAttribute name="title" scope="request" />
<html>
<head>
	<title><tiles:getAsString name="appName" /> - <tiles:getAsString name="title" /></title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link href="${pageContext.request.contextPath}/css/materialIcons.css" rel="stylesheet">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/materialize-1.0.0-rc.2/css/materialize.css" media="screen,projection" />
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/dataTables-1.10.18/datatables.css" />
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/loader.css" />
	
	<s:head theme="simple" />
</head>
<body class="teal">
	<s:include value="/WEB-INF/jsp/common/loader.jsp" />
	<div>
		<tiles:insertAttribute name="header" />
	</div>
	<div>
		<div class="section no-pad-bot">
			<div class="row">
				<div class="col s12">
					<tiles:insertAttribute name="body" />
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/materialize-1.0.0-rc.2/js/materialize.js"></script>

	<script src="${pageContext.request.contextPath}/dataTables-1.10.18/datatables.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
	
	<script type="text/javascript">
	$(document).ready(function() {
		$('.sidenav').sidenav();
	});
	function fnsubmit(formId, action) {
		var form = document.getElementById(formId);
		form.action = "${pageContext.request.contextPath}" + action;
		form.submit();
	}
	function fnlink(action) {
		onLoader();
		window.location = "${pageContext.request.contextPath}" + action;
	}
	</script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/loader.js"></script>
</body>
</html>