<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ include file="../taglib_includes.jsp"%>

<div class="right_body">
	<h2>
		<spring:message code="dish_specify_additive" />
	</h2>	
	<div class="clr"></div>
	<form:form id="dishForm"  modelAttribute="dish" cssClass="form-horizontal" action="${flowExecutionUrl}" >
		<fieldset class="scheduler-border">
			<legend class="scheduler-border"><spring:message code="dish_already_created" /></legend>
				<div class="form-horizontal" role="form">
					<form:label path="name" cssClass="control-label col-md-3"><spring:message code="dish_add_name"/></form:label>
					<div class="col-md-7">
						
					</div>
				</div>							
		</fieldset>	
		
	</form:form>
</div>