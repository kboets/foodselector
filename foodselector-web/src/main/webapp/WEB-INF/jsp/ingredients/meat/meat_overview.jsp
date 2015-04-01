<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ include file="../../taglib_includes.jsp"%>

<div class="right_body">
	<h2>
		<spring:message code="meat_overview_title" />
	</h2>	
	
	<div class="clr"></div>	
		
	<div class="content">
		<c:if test="${not empty success}">
       		<div class="alert alert-success">
	    		<i class="icon-ok-sign icon-green"></i> <span> <spring:message code="label.success.${success}"/></span>
	    	 </div>
       	</c:if>
       		
		<fieldset class="fsStyle">
		<legend class="content large"><spring:message code="meat_overview" /></legend>
		
		<c:if test="${not empty meatOverview}">		
		<table class="content large">			
			
			<c:forEach items="${meatOverview}" var="meatOrigin">
				<tr>
					<td><c:out value="${meatOrigin.name}" /></td>
					<td>&nbsp;</td>					
				</tr>				
				<c:forEach items="${meatOrigin.meatSet}" var="meat" >
				<tr>
					<td>&nbsp;</td>
					<td><c:choose>
							<c:when test="${not empty meatOrigin.meatSet}">
								<a href="<c:url value='/meatUpdate/${meat.id}' />"><c:out value="${meat.name}" /></a>
							</c:when>
							<c:otherwise>
								<spring:message code="no_result" />
							</c:otherwise>
						</c:choose>						
					</td>
				</tr>	
				</c:forEach>
			</c:forEach>
		</table>
		</c:if>
		</fieldset>		
	</div>
		
	<div class="buttons">
			<button class="btn bold" id="meat_add"><spring:message code="button_add" /></button>
	</div>
</div>

<script>
$("#meat_add").click(function(){
	window.location="/foodselector/meatAdd";
});

</script>
