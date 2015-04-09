<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ include file="../../taglib_includes.jsp"%>

<div class="right_body">
	<h2>
		<spring:message code="fish_add_title" />
	</h2>	

	<div class="clr"></div>	

	<form:form id="addFish_form" method="POST" modelAttribute="fish" cssClass="form-horizontal">
		<input name="action" id="action" type="hidden" />		
		<input name="_method" type="hidden" value="PUT" />
		<div class="form-horizontal" role="form">
			<c:if test="${not empty exception}">
       			<div class="alert alert-danger">
	    			<span><spring:message code="exception.wrong.input"/></span>
	    	 	</div>
	    	 </c:if>
	    	 <div class="form-group">
	    	 	<form:label path="name" cssClass="control-label col-sm-3"><spring:message code="fish_add_name"/></form:label>
	    	 	<div class="col-sm-7">
	    	 		<form:input path="name" cssClass="form-control" cssErrorClass="errorFormInput"/>&nbsp;<form:errors path="name" cssClass="error" />
	    	 	</div>
	    	 </div>		
	    	 <div class="form-group">
	    	 	<form:label path="fishOrigin" cssClass="control-label col-sm-3"><spring:message code="fishOrigin_title"/></form:label>
	    	 	<div class="col-sm-7">
	    	 		<form:select path="fishOrigin">
	    	 			<form:options items="${fishOrigins}" itemLabel="name"  itemValue="name"/>
	    	 		</form:select>
	    	 	</div>
	    	 </div>
	    	  <div class="form-group">
	    	 	<form:label path="info" cssClass="control-label col-sm-3"><spring:message code="fishOrigin_add_info"/></form:label>
	    	 		<div class="col-sm-7">
	    	 			<form:textarea path="info" cssClass="form-control" />
	    	 		</div>
	    	 </div>
	    	 <div class="buttons">
	    	 	<button class="btn bold" id="fish_save"><spring:message code="button_save" /></button> 
				<button class="btn bold" id="fish_back"><spring:message code="button_back" /></button>
	    	 </div>
		</div>
	</form:form>	
		

</div>
<script type="text/javascript">
$('#fish_back').click(function(){	
	$('#action').val('back');
	window.location.href='/fishOriginOverview'	
});

$('#fish_save').click(function(){
	$('#addFish_form').submit();
});  
</script>