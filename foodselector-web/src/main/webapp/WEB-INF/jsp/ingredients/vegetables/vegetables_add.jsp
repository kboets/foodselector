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
	    	 	<form:label path="name" cssClass="control-label col-sm-3"><spring:message code="vegetables_availability"/></form:label>
	    	 		<div class="col-sm-7">
	    	 		<form:select path="availability" >	    
	    	 			<c:forEach items="${availabilities}" var="option">
	    	 				<form:option value="${option}"><spring:message code="${option.code}"/></form:option>
	    	 			</c:forEach> 	    	 			
	    	 		</form:select>
	    	 	</div>
	    	 </div>  	 
	    	 	    	
		</div>
		
	</form:form>

</div>