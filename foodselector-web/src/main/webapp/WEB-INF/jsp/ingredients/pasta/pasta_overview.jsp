<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ include file="../../taglib_includes.jsp"%>

<div class="right_body">
	
	<h2>
		<spring:message code="pasta_overview_title" />
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
	<c:if test="${not empty pastas}">
		<c:forEach items="${pastas}" var="pasta" >
			<div class="row">
				<div class="col-sm-2">
					<strong><a href="<c:url value='/pastaUpdate/${pasta.id}' />"><c:out value="${pasta.name}"  /></a></strong>					
				</div>
			</div>				
			<div class="row">
				<div class="col-sm-1"></div>
				<div class="col-sm-6">
					<c:out value="${pasta.info}" />
				</div>
			</div>				
		</c:forEach>
	</c:if>
	
	<div class="buttons" style="margin-top: 10px">
		<button class="btn bold" id="pasta_add"><spring:message code="pasta_add_button" /></button>		
	</div>		
</div>

<script>
$("#pasta_add").click(function() {
	window.location="/foodselector/pastaAdd";
});
</script>