<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ include file="../../taglib_includes.jsp"%>

<div class="right_body">
	
	<h2>
		<spring:message code="fishOrigin_add_title" />
	</h2>	

	<div class="clr"></div>	
	
	<form:form id="addFishOrigin_form" method="POST" modelAttribute="fishOrigin" cssClass="form-horizontal">		
		<input name="action" id="action" type="hidden" />		
		<input name="_method" type="hidden" value="PUT" />
		<div class="form-horizontal" role="form">
			
			<c:if test="${not empty exception}">
       			<div class="alert alert-danger">
	    			<span><spring:message code="exception.wrong.input"/></span>
	    	 	</div>
	    	 </c:if>
	    	 	    	 
	    	 <div class="form-group">
	    	 	<form:label path="name" cssClass="control-label col-sm-3"><spring:message code="fishOrigin_add_name"/></form:label>
	    	 	<div class="col-sm-7">
	    	 		<form:input path="name" cssClass="form-control" cssErrorClass="errorFormInput"/>&nbsp;<form:errors path="name" cssClass="error" />
	    	 	</div>
	    	 </div>
	    	 
	    	 <div class="form-group">
	    	 	<form:label path="name" cssClass="control-label col-sm-3"><spring:message code="fish_type"/></form:label>
	    	 	<div class="col-sm-7">
	    	 		<form:select path="fishType" >	    
	    	 			<c:forEach items="${fishTypes}" var="option">
	    	 				<form:option value="${option}"><spring:message code="${option.code}"/></form:option>
	    	 			</c:forEach> 	    	 			
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
	    	 	<button class="btn bold" id="fishOrigin_save"><spring:message code="button.save" /></button> 
				<button class="btn bold" id="fishOrigin_back"><spring:message code="button.back" /></button>
	    	 </div>
		</div>
	</form:form>
</div>
<script type="text/javascript">
$('#fishOrigin_back').click(function(){	
	$('#action').val('back');
	window.location.href='/fishOriginOverview'	
});

$('#fishOrigin_save').click(function(){
	$('#addFishOrigin_form').submit();
});  
</script>
