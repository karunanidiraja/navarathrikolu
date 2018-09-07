<%@ taglib prefix="s" uri="/struts-tags"%>

<s:iterator var="menu" value="@com.nacreav.navarathrikolu.util.ConstantList@getMenus()">
	<s:set var="requestNamespace" value='#request["struts.actionMapping"].namespace' />
	<s:set var="requestNamespace" value='%{"/".equals(#requestNamespace)?"/":(#requestNamespace + "/")}'/>
	<s:set var="requestName" value='#request["struts.actionMapping"].name' />
	
	<s:set var="menuName" value="#menu[@com.nacreav.navarathrikolu.util.ConstantList$Keys@MENU_NAME]" />
	<s:set var="menuNamespace" value="#menu[@com.nacreav.navarathrikolu.util.ConstantList$Keys@MENU_NAMESPACE]" />
	<s:set var="menuAction" value="#menu[@com.nacreav.navarathrikolu.util.ConstantList$Keys@MENU_ACTION]" />
	
	<s:set var="menuUrl" value='%{#request["javax.servlet.include.context_path"] + #menuNamespace + #menuAction}' />
	
	<li class='${requestNamespace==menuNamespace && requestName==menuAction ?"active":""}'>
		<s:a href="#" onclick="loadLink('%{#menuUrl}')"><s:property value="#menuName"/></s:a>
	</li>
</s:iterator>