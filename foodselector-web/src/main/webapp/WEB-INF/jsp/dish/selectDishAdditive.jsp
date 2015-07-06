<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ include file="../taglib_includes.jsp"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<div class="right_body">

	<h2>
		<spring:message code="dish_add_title" />
	</h2>	
	
	<div class="clr"></div>	
	
	
	<form:form id="dishForm"  modelAttribute="dish" cssClass="form-horizontal" action="${flowExecutionUrl}" >
	<fieldset class="scheduler-border">
	<legend class="scheduler-border"><spring:message code="dish_add_subtitle_additive" /></legend>	
		<div class="form-horizontal" role="form">			
			<div class="form-group">
	    	 	<form:label path="name" cssClass="control-label col-md-3"><spring:message code="dish_add_name"/></form:label>
	    	 	<div class="col-md-7">
	    	 		<form:input path="name" cssClass="form-control" cssErrorClass="errorFormInput"/>&nbsp;<form:errors path="name" cssClass="error" />
	    	 	</div>	    	 	
	    	 </div>	    	
	    	<div class="form-group">
	    			<form:label path="name" cssClass="control-label col-md-3"><spring:message code="dish_additive"/></form:label>
	    			<c:set var="additiveSize" value="${fn:length(dishAdditives)}" />  			
	    			<div class="col-md-4">
	    				<form:select path="additiveToChoose" multiple="false" id="all_dishAdditives_list"  size="${additiveSize}px" style="width: 250px">	    	 				
	    				<c:forEach items="${dishAdditives}" var="option" >	    					
	    					<form:option  value="${option.descriptionCode}"><spring:message code="${option.descriptionCode}" /></form:option>
	    				</c:forEach>	    	 					    	 					    	 				
	    	 			</form:select> 
	    	 		</div>
	    	 		<div class="col-md-2">
	    	 			<div align="right" >
	    	 				<button class="btn" type="submit" name="_eventId_selectAdditiveType" style="margin-top:${fn:length(dishAdditives)}"><spring:message code="button_add" /></button>	 
	    	 			</div>
	    			</div> 
	     	</div>
	     	  	

		</div>		
		</fieldset>
				
		<div class="buttons">
			<button class="btn btn-primary bold pull-right RbtnMargin" id="next-button" type="submit" name="_eventId_save"  ><spring:message code="button.next" /></button>
			<button class="btn btn-primary bold" id="cancel-button" type="submit" name="_eventId_cancel"><spring:message code="button.cancel" /></button>
		</div>
		
			
							 
			
	</form:form>
	
	
</div>


