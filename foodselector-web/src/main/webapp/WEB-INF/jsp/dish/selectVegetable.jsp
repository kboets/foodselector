<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ include file="../taglib_includes.jsp"%>


<div class="right_body">
	<h2>
		<spring:message code="dish_specify_vegetable" />
	</h2>
	<div class="clr"></div>
	<form:form id="dishForm"  modelAttribute="dish" cssClass="form-horizontal" action="${flowExecutionUrl}" >
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
						</form:label>
					</div>										
				</div>						
		</fieldset>
		<fieldset class="scheduler-border">
			<legend class="scheduler-border"><spring:message code="dish_select_vegetables" /></legend>
			<div class="form-group">
	    		<form:label path="vegetables" cssClass="control-label col-md-3" ><spring:message code="dish_vegetables"/></form:label>
	    			<c:set var="vegetablesSize" value="${fn:length(allVegetables)}" />  			
	    			<div class="col-md-4">
	    				<form:select path="vegetables" multiple="true" size="${vegetablesSize}px"  cssErrorClass="errorFormInput">							
							<form:options items="${allVegetables}" itemLabel="name" itemValue="id"  />					
						</form:select>
						<form:errors path="vegetables" cssClass="error"/>
	    	 		</div>	    	 		 
	     	</div>
		</fieldset>
		<div class="buttons">
			<button class="btn btn-primary bold pull-right RbtnMargin" id="next-button" type="submit" name="_eventId_selectMeatOrFish"  ><spring:message code="button.next" /></button>
			<button class="btn btn-primary bold" id="back-button" type="submit" name="_eventId_back"><spring:message code="button.back" /></button>
			<button class="btn btn-primary bold" id="cancel-button" type="submit" name="_eventId_cancel"><spring:message code="button.cancel" /></button>
		</div>
	</form:form>	
</div>