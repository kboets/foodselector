<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="right">
	<h2><spring:message code="leftMenu_ingredients" /></h2>
	<ul>
		<li><a href="<c:url value='/meatOverview' />"><spring:message code="leftMenu_ingredients_Meat" /></a></li>
		<li><a href="<c:url value='/fishOriginOverview' />"><spring:message code="leftMenu_ingredients_Fish" /></a></li>
		<li><a href="<c:url value='/vegetablesFamilyOverview' />"><spring:message code="leftMenu_ingredients_Vegetables" /></a></li>
		<li><a href="<c:url value='/pastaOverview' />"><spring:message code="leftMenu_ingredients_Pasta" /></a></li>	
		<li><a href="<c:url value='/spicesPageOverview/1' />"><spring:message code="leftMenu_ingredients_Spices" /></a></li>
	</ul>
	
</div>
<div class="clr"></div>