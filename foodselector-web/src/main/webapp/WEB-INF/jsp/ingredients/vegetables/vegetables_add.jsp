<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ include file="../../taglib_includes.jsp"%>

<div class="right_body">
	<h2>
		<spring:message code="vegetables_add_title" />
	</h2>	

	<div class="clr"></div>	
	
	<form:form id="addVegetables_form" method="POST" modelAttribute="vegetables" cssClass="form-horizontal">
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
	    	 	<form:label path="name" cssClass="control-label col-sm-3"><spring:message code="vegetables_add_name"/></form:label>
	    	 	<div class="col-sm-7">
	    	 		<form:input path="name" cssClass="form-control" cssErrorClass="errorFormInput"/>&nbsp;<form:errors path="name" cssClass="error" />
	    	 	</div>	    	 	
	    	 </div>	  
	    	 <div class="form-group">
	    	 	<form:label path="availability" cssClass="control-label col-sm-3"><spring:message code="vegetables_availability"/></form:label>
	    	 		<div class="col-sm-7">
	    	 		<form:select path="availability" >	    
	    	 			<c:forEach items="${availabilities}" var="option">
	    	 				<form:option value="${option}"><spring:message code="${option.code}"/></form:option>
	    	 			</c:forEach> 	    	 			
	    	 		</form:select>&nbsp;<form:errors path="availability" cssClass="error" />
	    	 	</div>
	    	 </div>
	    	 <div class="form-group">
	    	 	<form:label path="vegetablesFamily" cssClass="control-label col-sm-3"><spring:message code="vegetablesFamily"/><c:out value="${vegetablesFamily.id}" /></form:label>
	    	 		<div class="col-sm-7">
	    	 		<form:select path="vegetablesFamily" >	    
	    	 			  <c:if test="${not empty vegetables.vegetablesFamily.id}">
	    	 			  	<form:option  value="${vegetables.vegetablesFamily.id}" ><c:out value="${vegetables.vegetablesFamily.name}"/></form:option>
	    	 			  </c:if>	
	    	 			  <form:options items="${vegetablesFamilies}" itemValue="id" itemLabel="name"/> 	 				
	    	 		</form:select>&nbsp;<form:errors path="vegetablesFamily" cssClass="error" />
	    	 	</div>
	    	 </div>	    	 
	    	 <div class="form-group">
	    	 	<form:label path="info" cssClass="control-label col-sm-3"><spring:message code="fishOrigin_add_info"/></form:label>
	    	 		<div class="col-sm-7">
	    	 			<form:textarea path="info" cssClass="form-control" />
	    	 		</div>
	    	 </div> 	 
	    	  
	    	 <div class="buttons">
	    	 	<button class="btn bold" id="vegetables_save"><spring:message code="button.save" /></button> 
				<button class="btn bold" id="vegetables_back"><spring:message code="button.back" /></button>
	    	 </div>	    	
		</div>
		
	</form:form>

</div>

<script type="text/javascript">
$('#vegetables_back').click(function(){	
	$('#action').val('back');	
});

$('#vegetables_save').click(function(){
	$('#addVegetables_form').submit();
});  
</script>