<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ include file="../../taglib_includes.jsp"%>

<div class="right_body">
	
	<h2>
		<spring:message code="vegetablesOrigin_overview_title" />
	</h2>	
			
	<div class="clr"></div>
	
	<div class="content">
		<c:if test="${not empty success}">
       		<div class="alert alert-success">
	    		<i class="icon-ok-sign icon-green"></i> <span> <spring:message code="label.success.${success}"/></span>
	    	 </div>
       	</c:if>
       	<c:if test="${not empty exception}">
       		<div class="alert alert-danger">
	    		<span><spring:message code="exception.wrong.input"/></span>
	    	</div>
	   </c:if>
	</div>	
	<c:if test="${not empty vegetablesFamilyOverview}">
		<c:forEach items="${vegetablesFamilyOverview}" var="vegetablesFamily" >
			<div class="row">
				<div class="col-sm-2">
					<strong><a href="<c:url value='/vegetablesFamilyUpdate/${vegetablesFamily.id}' />"><c:out value="${vegetablesFamily.name}"  /></a></strong>					
				</div>
			</div>
			<div class="row">	
				<div class="col-sm-1"></div>
				<div class="col-sm-4">
					<c:forEach items="${vegetablesFamily.vegetables}" var="vegetables">
						<c:choose>		
							<c:when test="${not empty vegetables}">
								<c:out value="${vegetables.name}"/><br/>
							</c:when>
						</c:choose>
					</c:forEach>	
				</div>
			</div>		
		</c:forEach>
	</c:if>
	<div class="buttons">
		<button class="btn bold" id="vegetablesFamily_add"><spring:message code="button_add" /></button>
	</div>		
</div>

<script>
$("#vegetablesFamily_add").click(function() {
	window.location="/foodselector/vegetablesFamilyAdd";
});
</script>