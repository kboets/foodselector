<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ include file="../taglib_includes.jsp"%>



<div id="selectedAdditives">
	
	<div class="form-group">
		<c:choose>
			<c:when test="${fn:length(selectedAdditives) > 1}">
				<div class="form-group">
				<c:set var="selectedAdditiveSize" value="${fn:length(selectedAdditives)}" />
					<form:label path="name" cssClass="control-label col-md-3"></form:label>
					<div class="col-md-4">
						<form:select path="selectedAdditives" multiple="false" id="selected_dishAdditives_list"  size="${selectedAdditiveSize}px" style="width: 250px" >	    	
							<form:option value="0">Kies een</form:option>
							<form:options itemLabel="name" />
						</form:select>	
					</div>				
				</div>	
			</c:when>
		</c:choose>			
	</div>
	
</div>

