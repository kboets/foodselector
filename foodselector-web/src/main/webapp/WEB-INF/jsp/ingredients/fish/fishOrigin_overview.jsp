<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ include file="../../taglib_includes.jsp"%>

<div class="right_body">
	<h2>
		<spring:message code="fishOrigin_overview_title" />
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
       	
       	<c:if test="${not empty fishOriginOverview}">
       	<div class="surrounded">
       		<div class="content large row" style="background-color:#b0c4de;">
       			<div class="col-sm-4"><strong><spring:message code="fishOrigin_title" /></strong></div>
       			<div class="col-sm-4"><strong><spring:message code="fish_title" /></strong></div>
       			<div class="col-sm-4"><strong><spring:message code="fish_type" /></strong></div>
       		</div> 
       		<c:forEach items="${fishOriginOverview}" var="fishOrigin" varStatus="loop">
       			<c:choose>
       				<c:when test="${loop.index % 2 == 0}">
       					<div class="content large row">
       						<div class="col-sm-4"><a href="<c:url value='/fishOriginUpdate/${fishOrigin.id}' />"><c:out value="${fishOrigin.name}" /></a></div>
       						<div class="col-sm-4">
       							<c:forEach items="${fishOrigin.fishs}" var="fish">					
									<c:choose>
										<c:when test="${not empty fish}">
											<c:out value="${fish.name}" /><br/>
										</c:when>
										<c:otherwise>&nbsp;</c:otherwise>
									</c:choose>					
								</c:forEach>
       						</div>
       						<div class="col-sm-4">
       							<c:if test="${fishOrigin.fishType eq 'OILY'}">
									<spring:message code="fish_type_fat" />
								</c:if> 
								<c:if test="${fishOrigin.fishType eq 'HALF_OILY'}">
									<spring:message code="fish_type_half" />
								</c:if>
								<c:if test="${fishOrigin.fishType eq 'WHITE'}">
									<spring:message code="fish_type_white" />
								</c:if>
								<c:if test="${fishOrigin.fishType eq 'SEAFOOD'}">
									<spring:message code="fish_type_seafood" />
								</c:if>
       						</div>
       					</div>       				
       				</c:when>
       				<c:otherwise>
       					<div class="content large row" style="background-color:lightgray;">
       						<div class="col-sm-4"><a href="<c:url value='/fishOriginUpdate/${fishOrigin.id}' />"><c:out value="${fishOrigin.name}" /></a></div>
       						<div class="col-sm-4"><c:forEach items="${fishOrigin.fishs}" var="fish">					
									<c:choose>
										<c:when test="${not empty fish}">
											<c:out value="${fish.name}" /><br/>
										</c:when>
										<c:otherwise>&nbsp;</c:otherwise>
									</c:choose>					
								</c:forEach>
							</div>
							<div class="col-sm-4">
       							<c:if test="${fishOrigin.fishType eq 'OILY'}">
									<spring:message code="fish_type_fat" />
								</c:if> 
								<c:if test="${fishOrigin.fishType eq 'HALF_OILY'}">
									<spring:message code="fish_type_half" />
								</c:if>
								<c:if test="${fishOrigin.fishType eq 'WHITE'}">
									<spring:message code="fish_type_white" />
								</c:if>
								<c:if test="${fishOrigin.fishType eq 'SEAFOOD'}">
									<spring:message code="fish_type_seafood" />
								</c:if>
       						</div>	
       					</div>
       				</c:otherwise>
       			</c:choose>       	       			
       		</c:forEach> 
       		</div>    	
       	</c:if>
       	<div class="buttons" style="margin-top: 10px">
       		<button id="vissoort" type="button" class="btn bold">vissoort toevoegen</button>
       		<button id="vis" type="button" class="btn bold">vis toevoegen</button>       		
       	</div>       	
	</div>

</div>

<script>
$("#vissoort").click(function() {
	window.location="/foodselector/fishOriginAdd";
});

$("#vis").click(function() {
	window.location="/foodselector/fishAdd";
});
</script>