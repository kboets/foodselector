<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ include file="../taglib_includes.jsp"%>


<div class="right_body">
	<h2>
		<spring:message code="dish_overview_title" />
	</h2>	
	
	<div class="clr"></div>

	
	<form:form id="dishOverviewForm"  modelAttribute="dish" cssClass="form-horizontal" action="${flowExecutionUrl}" >
	<fieldset class="scheduler-border">
	<legend class="scheduler-border"><spring:message code="dish_add_subtitle_overview" /></legend>
		<div class="form-horizontal" role="form">
			<div class="form-group">
	    	 	<form:label path="name" cssClass="control-label col-md-3"><spring:message code="dish_add_name"/></form:label>
	    	 	<div class="col-md-7">
	    	 		<form:input disabled="true" path="name" cssClass="form-control" />
	    	 	</div>	    	 	
	    	 </div>
		</div>
	</fieldset>
		<div class="buttons">
			<button class="btn btn-primary bold" id="next-button" type="submit" name="_eventId_toSelectDishAdditive"><spring:message code="button.back" /></button>	 
		</div>		
	</form:form>	
	
</div>