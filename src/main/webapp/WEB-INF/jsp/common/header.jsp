<%@ taglib prefix="s" uri="/struts-tags"%>

<nav class="pink z-depth-3">
	<div class="nav-wrapper nav-wrapper">
		<div class="row">
			<div class="col s12">
				<a href="#" class="brand-logo">NavarathriKolu.com</a>
				<a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
				<ul class="right hide-on-med-and-down">
					<s:include value="/WEB-INF/jsp/common/menu.jsp"/>
				</ul>
				<%-- <ul class="right">
					<li class="${request['struts.actionMapping'].namespace=='/' && request['struts.actionMapping'].name=='dashboard'?'active':''}"><a href="#">Dashboard</a></li>
					<li><a href="#">Stocks</a></li>
					<li><a href="#">Reports</a></li>
				</ul> --%>
			</div>
		</div>
	</div>
</nav>

<ul class="sidenav" id="mobile-demo">
	<s:include value="/WEB-INF/jsp/common/menu.jsp" />
</ul>