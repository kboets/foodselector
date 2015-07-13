<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ include file="../taglib_includes.jsp"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<div class="right_body">
	<h2>
		<spring:message code="dish_specify_meatOrFish" />
	</h2>
	<div class="clr"></div>
	<form:form id="fishMeatForm"  modelAttribute="dish" cssClass="form-horizontal" action="${flowExecutionUrl}" >
		<fieldset class="scheduler-border">
			<legend class="scheduler-border"><spring:message code="dish_already_created" /></legend>
				<div class="form-horizontal" role="form">
					<form:label path="name" cssClass="control-label col-md-3" cssErrorClass="errorFormInput"><spring:message code="dish_add_name"/></form:label>&nbsp;<form:errors path="name" cssClass="error" />
					<div class="col-md-7">
						<form:label path="name" cssClass="control-label col-md-7" ><c:out value="${dish.name}"></c:out></form:label>
					</div>					
				</div>									
				<div class="form-horizontal" role="form">
					<form:label path="name" cssClass="control-label col-md-3"><spring:message code="dish_temp_overview"/></form:label>
					<div class="col-md-7">
						<form:label path="name" cssClass="control-label col-md-7">
							<c:choose>
								<c:when test="${fn:length(pickedAdditives) gt 1}">
									<c:out value="${dish.pickedAdditive.name}" />									
								</c:when>
								<c:otherwise>
									<spring:message code="${dish.pickedAdditive.descriptionCode}" />
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${fn:length(dish.vegetables) gt 0}">
									+ &nbsp; <c:forEach items="${dish.vegetables}" var="vegetable">
										<c:out value="${vegetable}" />
									</c:forEach>
								</c:when>
							</c:choose>
							
						</form:label>
					</div>										
				</div>						
		</fieldset>	
	</form:form>
</div>