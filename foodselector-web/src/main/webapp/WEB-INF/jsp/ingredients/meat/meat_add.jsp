<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ include file="../../taglib_includes.jsp"%>

<div class="right_body">
	<h2>
		<spring:message code="meat_add_title" />
	</h2>	
	
	<div class="clr"></div>	
	
	<form:form id="addMeat_form" method="POST" modelAttribute="meat">
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
	    	<div class="row">
	    		<form:label path="name" cssClass="control-label col-md-2"><spring:message code="meat_add_name"/></form:label>
	    		<div class="col-md-3">
	    	 		<form:input path="name" cssClass="form-control" cssErrorClass="errorFormInput"/>&nbsp;<form:errors path="name" cssClass="error" />
	    	 	</div>
	    	 	<form:label path="name" cssClass="control-label col-md-2"><spring:message code="meat_meatOrigin"/></form:label>
	    	 	<div class="col-md-5">
	    	 		<form:select path="meatOrigins" multiple="true" size="${fn:length(meatOverview)}px"  cssErrorClass="errorFormInput">							
						<form:options items="${meatOverview}" itemLabel="name" itemValue="name"  />					
					</form:select>
					<form:errors path="meatOrigins" cssClass="error"/>
				</div>
	    	</div>    	
	    </div>	    
		
		<div class="form-group">
			<div class="row">
			 	<form:label path="info" cssClass="control-label col-md-2"><spring:message code="meat_add_info"/></form:label>
				<div class="col-md-5">
					<form:textarea path="info" cssClass="form-control" />
				</div>
			</div>    	 		
	  	 </div>
	  	 <div class="buttons">				
				<button class="btn bold" id="meat_save"><spring:message code="button_save" /></button> 
				<button class="btn bold" id="meat_back"><spring:message code="button_back" /></button>
			</div>
	</div>	
	</form:form>
</div>
<script>
$('#meat_back').click(function(){	
	$('#action').val('back');
	window.location.href='/meatOverview'	
});

$('#meat_save').click(function(){
	$('#addMeat_form').submit();
});  
	
</script>