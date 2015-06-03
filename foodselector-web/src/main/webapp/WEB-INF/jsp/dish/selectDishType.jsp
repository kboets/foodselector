<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ include file="../taglib_includes.jsp"%>


<div class="right_body">

	<h2>
		<spring:message code="dish_add_title" />
	</h2>	
	
	<div class="clr"></div>	
	
	<form:form id="dishForm"  modelAttribute="dish" cssClass="form-horizontal" action="${flowExecutionUrl}" >
		<div class="form-horizontal" role="form">
			<div class="form-group">
	    	 	<form:label path="name" cssClass="control-label col-sm-3"><spring:message code="vegetables_add_name"/></form:label>
	    	 	<div class="col-sm-7">
	    	 		<form:input path="name" cssClass="form-control" cssErrorClass="errorFormInput"/>&nbsp;<form:errors path="name" cssClass="error" />
	    	 	</div>	    	 	
	    	 </div>
		</div>	
	</form:form>

</div>
