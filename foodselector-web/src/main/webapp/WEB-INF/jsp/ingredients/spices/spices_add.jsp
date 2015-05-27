<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ include file="../../taglib_includes.jsp"%>




<div class="right_body">
	<h2>
		<spring:message code="spices_add_title" />
	</h2>	

	<div class="clr"></div>	
	
	<form:form id="addSpices_form" method="POST" modelAttribute="spices" cssClass="form-horizontal">
		<c:choose>
			<c:when test="${fn:length(vegetablesList) lt 15}">
				<c:set var="vegetableLength"  value="${fn:length(vegetablesList)}"/>
			</c:when>
			<c:otherwise>
				<c:set var="vegetableLength"  value="15"/>
			</c:otherwise>
		</c:choose>
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
	    	 	<form:label path="name" cssClass="control-label col-sm-4"><spring:message code="pasta_name"/></form:label>
	    	 		<div class="col-sm-7">
	    	 			<form:input path="name" cssClass="form-control" cssErrorClass="errorFormInput"/>&nbsp;<form:errors path="name" cssClass="error" />
	    	 	</div>
	    	 </div>	   
	    	 <div class="form-group">
	    	 	<form:label path="favoriteVegetables" cssClass="control-label col-sm-4"><spring:message code="spices_preferred_vegetables"/></form:label>
	    	 		<div class="col-sm-3">
	    	 			<spring:message code="spices_all_vegetables"/>
	    	 		</div>
	    	 		<div class="col-sm-3">
	    	 			<spring:message code="spices_existing_preferred_vegetables"/>
	    	 		</div>
	    	 </div>
	    	 	    	  	 
	    	 <div class="form-group">
	    	 	<form:label path="favoriteVegetables" cssClass="control-label col-sm-4" />	    	 		
	    	 		<div class="col-sm-3">							 			    	 		
	    	 			<select id="all_vegetables_list" multiple="multiple" size="${vegetableLength}px" style="width: 150px">
	    	 				<c:forEach items="${vegetablesList}" var="vegetables">
	    	 					<option value="${vegetables.id}"><c:out value="${vegetables.name}" /></option>
	    	 				</c:forEach>
	    	 			</select>	    	 		
	    	 		</div>	    	 		    	 		
	    	 		<div class="col-sm-1 pagination" align="center">	    	 			
	    	 				<li id="one_right"><a href="#">&gt;</a></li>	    	 					    	 				
	    	 				<li id="one_left"><a href="#" >&lt;</a></li>
	    	 				<li id="all_left"><a href="#" >&lt;&lt;</a></li>	    	 				    	 			
	    	 		</div>
	    	 		<div class="col-sm-3">							 			    	 		
	    	 			<form:select id="preferred_vegetables" path="favoriteVegetables" multiple="true" size="${vegetableLength}px" style="width: 150px">
	    	 				<form:options items="${spices.favoriteVegetables}" itemLabel="name" itemValue="id"></form:options>
	    	 			</form:select>	    	 		
	    	 		</div> 		
	    	 		
	    	 </div>	    	     	 	
	    	 
	    	     	 
	    	 <div class="form-group">
	    	 	<form:label path="info" cssClass="control-label col-sm-4"><spring:message code="fishOrigin_add_info"/></form:label>
	    	 		<div class="col-sm-8">
	    	 			<form:textarea path="info" cssClass="form-control"  rows="7" />
	    	 		</div>
	    	 </div>	 
	    	  
	    	 <div class="buttons">
	    	 	<button class="btn bold" id="spices_save"><spring:message code="button_save" /></button> 
				<button class="btn bold" id="spices_back"><spring:message code="button_back" /></button>
	    	 </div>	    	
		</div>
		
	</form:form>

</div>

<script type="text/javascript">
$('#spices_back').click(function(){	
	$('#action').val('back');	
});

$('#spices_save').click(function(){
	$('#addSpices_form').submit();
});  

$('#one_right').click(function(){
	$('#all_vegetables_list option:selected').clone().attr('id', 'name').appendTo('#preferred_vegetables');
	$('#preferred_vegetables option').prop('selected', true);
	return !$('#all_vegetables_list option:selected').remove();	  
});

$('#all_right').click(function(){	
	$('#all_vegetables_list option').clone().attr('id', 'name').appendTo('#preferred_vegetables');
	$('#preferred_vegetables option').prop('selected', true);
	return !$('#all_vegetables_list option').remove();  
});

$('#one_left').click(function(){	
	$('#preferred_vegetables option:selected').clone().prop('selected', false).attr('id', 'name').appendTo('#all_vegetables_list');	
	$('#preferred_vegetables option:selected').remove();
	$('#preferred_vegetables option').prop('selected', true);
});

$('#all_left').click(function(){	
	$('#preferred_vegetables option').clone().prop('selected', false).attr('id', 'name').appendTo('#all_vegetables_list');	
	return !$('#preferred_vegetables option').remove();  
});


</script>