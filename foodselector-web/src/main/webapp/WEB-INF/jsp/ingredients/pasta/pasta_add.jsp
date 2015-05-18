<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ include file="../../taglib_includes.jsp"%>

<div class="right_body">
	<h2>
		<spring:message code="pasta_add_title" />
	</h2>	

	<div class="clr"></div>	
	
	<form:form id="addPasta_form" method="POST" modelAttribute="pasta" cssClass="form-horizontal">
		<input name="action" id="action" type="hidden" />		
		<input name="_method" type="hidden" value="PUT" />
		<form:hidden path="id"/>  
		
		<div class="form-horizontal" role="form">
			<c:if test="${not empty exception}">
       			<div class="alert alert-danger">
	    			<span><spring:message code="exception.wrong.input"/></span>
	    	 	</div>
	    	 </c:if>	    	 
	    	 <div class="form-group">
	    	 	<form:label path="name" cssClass="control-label col-sm-3"><spring:message code="pasta_name"/></form:label>
	    	 		<div class="col-sm-7">
	    	 			<form:input path="name" cssClass="form-control" cssErrorClass="errorFormInput"/>&nbsp;<form:errors path="name" cssClass="error" />
	    	 	</div>
	    	 </div>	    	 	    	 
	    	 <div class="form-group">
	    	 	<form:label path="info" cssClass="control-label col-sm-3"><spring:message code="fishOrigin_add_info"/></form:label>
	    	 		<div class="col-sm-7">
	    	 			<form:textarea path="info" cssClass="form-control" />
	    	 		</div>
	    	 </div>	 
	    	  
	    	 <div class="buttons">
	    	 	<button class="btn bold" id="pasta_save"><spring:message code="button_save" /></button> 
				<button class="btn bold" id="pasta_back"><spring:message code="button_back" /></button>
	    	 </div>	    	
		</div>
		
	</form:form>

</div>

<script type="text/javascript">
$('#pasta_back').click(function(){	
	$('#action').val('back');	
});

$('#pasta_save').click(function(){
	$('#addPasta_form').submit();
});  
</script>