<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ include file="../../taglib_includes.jsp"%>


<div class="right_body">
	
	<h2>
		<spring:message code="spices_overview_title" />
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
	<c:if test="${not empty spicesList}">
		<c:forEach items="${spicesList}" var="spices" >
			<div class="row">
				<div class="col-sm-8" style="background-color:#b0c4de; ">
					<strong><c:out value="${spices.name}"  /></strong>					
				</div>
			</div>			
			<div class="row" style="margin-top: 10px">	
				<div class="col-sm-2"><spring:message code="spices_preferred_vegetables" /></div>
				<div class="col-sm-4">
					<c:choose>
					<c:when test="${not empty spices.favoriteVegetables}">
						<c:forEach items="${spices.favoriteVegetables}" var="vegetables">
							<c:choose>		
								<c:when test="${not empty vegetables}">
									<a href="<c:url value='/vegetablesUpdate/${vegetables.id}' />"><c:out value="${vegetables.name}"/></a><br/>
								</c:when>
							</c:choose>
					</c:forEach>
					</c:when>
					<c:otherwise>
						<spring:message code="spices_no_preferred_vegetables" />
					</c:otherwise>
					</c:choose>						
				</div>				
			</div>		
			<div class="row" style="margin-top: 10px">
				<div class="col-sm-2"><spring:message code="spices_extra_info" /></div>
				<div class="col-sm-4">
					<c:out value="${spices.info}" />
				</div>
			</div>			
			
		</c:forEach>
	</c:if>
	
	<div class="buttons" style="margin-top: 10px">
		<button class="btn bold" id="spices_add"><spring:message code="spices_add_button" /></button>		
	</div>

</div>

<script>
$("#spices_add").click(function() {
	window.location="/foodselector/spicesAdd";
});

</script>