<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>NavarathriKolu.com - Login</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="${pageContext.request.contextPath}/css/materialIcons.css" rel="stylesheet">
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/materialize-1.0.0-rc.2/css/materialize.css" media="screen,projection" />
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/loader.css" />
		<s:head theme="simple" />
	</head>
	<body class="blue">
		<s:include value="/WEB-INF/jsp/common/loader.jsp" />
		<nav class="pink z-depth-3">
			<div class="nav-wrapper nav-wrapper container">
				<a href="#" class="brand-logo">NavarathriKolu.com</a>
			</div>
		</nav>
		<s:form id="form1" name="form1" theme="simple" validate="true">
			<div class="section no-pad-bot">
				<br /> <br />
				<div class="container">
					<div class="row">
						<div class="col s12 m9 l8 center">
							<div class="card">
								<div class="card-content">
									<div class="row center">
										<h4 class="materialize-red-text">Admin Login</h4>
									</div>
									<div class="row">
										<s:include value="/WEB-INF/jsp/common/errorMessage.jsp" />
									</div>
									<div class="row">
										<div class="input-field">
											<i class="material-icons prefix">account_circle</i> 
											<s:textfield type="text" id="username" name="username" placeholder="%{getText('login.userName.help')}" 
												cssClass="%{(fieldErrors.get('username')!=null)?'invalid':''}"/>
											<label id="usernameLabel" for="username"> <s:text name="login.userName" /> </label>
											<span class="helper-text" data-error='${fieldErrors.get("username")!=null? fieldErrors.get("username") :"Invalid"}'></span>
										</div>
									</div>
									<div class="row">
										<div class="input-field">
											<i class="material-icons prefix">lock</i> 
											<s:textfield type="password" id="userPwd" name="userPwd" placeholder="%{getText('login.password.help')}" 
												cssClass="%{(fieldErrors.get('userPwd')!=null)?'invalid':''}"/> 
											<label for="userPwd"> <s:text name="login.password" /> </label>
											<span class="helper-text" data-error='${fieldErrors.get("userPwd")!=null? fieldErrors.get("userPwd") :"Invalid"}'></span>
										</div>
									</div>
									<div class="row center">
										<button class="btn waves-effect waves-light hoverable" type="button" onclick="loginAttempt()">Login<i class="material-icons right">vpn_key</i></button>
										<button class="btn red waves-effect waves-light hoverable" type="button" onclick="resetForm()">Reset<i class="material-icons right">backspace</i></button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</s:form>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/materialize-1.0.0-rc.2/js/materialize.js"></script>
		
		<script type="text/javascript">
		function loginAttempt() {
			submitForm(document.getElementById("form1"), "${pageContext.request.contextPath}/loginAttempt");
		}
		function resetForm() {
			$("#username").val("");
			$("#userPwd").val("");
		}
		</script>
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/loader.js"></script>
	</body>
</html>
