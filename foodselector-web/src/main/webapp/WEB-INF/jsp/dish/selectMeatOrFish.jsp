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
									+<c:forEach items="${dish.vegetables}" var="vegetable" varStatus="loop"> 
										<c:out value="${vegetable.name}" />
										<c:if test="${loop.index != (fn:length(dish.vegetables)-1)}">+</c:if>
									</c:forEach>
								</c:when>
							</c:choose>							
						</form:label>
					</div>										
				</div>						
		</fieldset>	
		<fieldset class="scheduler-border">
			<legend class="scheduler-border"><spring:message code="dish_specify_meatOrFish" /></legend>
			<div class="form-group">
				<form:label path="meatDish" cssClass="control-label col-md-3" >Maak uw keuze :</form:label>
				<div class="col-md-2">
					<form:label path="name" cssClass="control-label label-nobold">					
						<form:radiobutton id="isMeat" path="meatDish" value="true" />&nbsp;<spring:message code="dish_meat"/>
					</form:label>										
				</div>
				<div class="col-md-2">
					<form:radiobutton id="isFish" path="meatDish" value="false" />&nbsp;<spring:message code="dish_fish"/>
				</div>
			</div>
			<div id="isMeatOverview" class="form-group" >
				<form:label path="meats" cssClass="control-label col-md-3" >blba</form:label>			
			</div>			
						
		</fieldset>
	</form:form>
</div>
<script type="text/javascript">
$(document).ready(function(){	
	$('#isMeatOverview').hide();
	
});

$('#isMeat').click(function(){
	
}	
</script>
}