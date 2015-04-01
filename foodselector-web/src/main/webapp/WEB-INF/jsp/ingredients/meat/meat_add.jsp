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
	<div class="content">	
			 
			<c:if test="${not empty exception}">
       			<div class="alert alert-danger">
	    			<span><spring:message code="exception.wrong.input"/></span>
	    	 	</div>
	    	 </c:if>
	    	 
			<table class="content large input-table">
				<tr>
					<td><spring:message code="meat_add_name" /><c:out value="${meat.id}"/></td>
					<td><span style="margin-left: 10px"><form:input path="name" id="meat_name" cssErrorClass="errorFormInput" /><form:errors path="name" cssClass="error"/></span>
					</td>
					<td>&nbsp;</td>										
					<td><spring:message code="meat_meatOrigin" /><td>
					<td><span style="margin-left: 10px">
						<form:select path="meatOrigins"    multiple="true" size="${fn:length(meatOverview)}px"  cssErrorClass="errorFormInput">							
							<form:options items="${meatOverview}" itemLabel="name" itemValue="name"  />													
						</form:select>
						<form:errors path="meatOrigins" cssClass="error"/></span>
					</td>
					
				</tr>
				<tr>
					<td><spring:message code="meat_add_info" /></td>
					<td><span style="margin-left: 10px"><form:textarea path="info" id="meat_info"  cols="35" /></span></td>
				</tr>			
				<tr>
					<td>&nbsp;</td>
				</tr>	
			</table>
			
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