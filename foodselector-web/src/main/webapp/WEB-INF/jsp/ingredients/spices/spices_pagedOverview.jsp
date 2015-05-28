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
	
	<c:if test="${not empty spicesListPerPage}">		
		<c:url var="firstUrl" value="/spicesPageOverview/1" />
		<c:url var="lastUrl" value="/spicesPageOverview/${spicesListPerPage.totalPages}" />
		<c:url var="prevUrl" value="/spicesPageOverview/${currentIndex - 1}" />
		<c:url var="nextUrl" value="/spicesPageOverview/${currentIndex + 1}" />
	
		<div class="pagination">
						
			<c:choose>
            	<c:when test="${currentIndex == 1}">
               		<li class="disabled"><a href="#">&lt;&lt;</a></li>
               		<li class="disabled"><a href="#">&lt;</a></li>
            	</c:when>
            	<c:otherwise>
                	<li><a href="${firstUrl}">&lt;&lt;</a></li>
                	<li><a href="${prevUrl}">&lt;</a></li>
            	</c:otherwise>
            </c:choose>
            
            <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
            		<c:url var="pageUrl" value="/spicesPageOverview/${i}" />
            		<c:choose>
                		<c:when test="${i == currentIndex}">
                    		<li class="active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>                    		
                		</c:when>
                		<c:otherwise>
	                    	<li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
	                	</c:otherwise>	                	
    	        	</c:choose>
        	</c:forEach>
        	<c:choose>
            <c:when test="${currentIndex == spicesListPerPage.totalPages}">
                <li class="disabled"><a href="#">&gt;</a></li>
                <li class="disabled"><a href="#">&gt;&gt;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${nextUrl}">&gt;</a></li>
                <li><a href="${lastUrl}">&gt;&gt;</a></li>
            </c:otherwise>
        	</c:choose>
		</div>
		
		<c:forEach items="${spicesListPerPage.content}" var="spices" >
			<div class="row">
				<div class="col-sm-8" style="background-color:#b0c4de; ">
					<strong style="margin-right: 50px"><c:out value="${spices.name}"  /></strong>
					<a href="<c:url value='/spicesUpdate/${spices.id}' />"><span class="glyphicon glyphicon-edit" style="color: #5f5f5f;"></span></a>					
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
				<div class="col-sm-5">
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