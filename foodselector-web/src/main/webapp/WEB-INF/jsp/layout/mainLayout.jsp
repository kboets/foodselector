<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- foodselector css -->
<link rel="stylesheet" type="text/css"	href="<c:url value='/resources/css/style.css'/>" />
<link rel="stylesheet" type="text/css"	href="<c:url value='/resources/css/foodselector.css'/>" />
<!-- jquery css -->
<link rel="stylesheet" type="text/css"	href="<c:url value='/resources/css/jquery-ui.css'/>" />
<!-- bootstrap css--> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<script type="text/javascript"	src="<c:url value='/resources/js/jquery.js'/>"></script>
<script type="text/javascript"	src="<c:url value='/resources/js/jquery-ui.js'/>"></script>
<script type="text/javascript"  src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script> 
<script type="text/javascript"	src="<c:url value='/resources/js/cufon-yui.js'/>"></script>
<script type="text/javascript"	src="<c:url value='/resources/js/arial.js' />"></script>
<script type="text/javascript"	src="<c:url value='/resources/js/cuf_run.js'/>"></script>
<script type="text/javascript"	src="<c:url value='/resources/js/foodselector.js'/>"></script>
<!-- <script type="text/javascript"	src="<c:url value='/resources/js/progressbar.js'/>"></script> -->

<!-- USE WEBJARS 
<spring:url value="/webjars/jquery/2.0.3/jquery.js" var="jQuery"/>
<script src="${jQuery}"></script>
<spring:url value="/webjars/jquery-ui/1.10.3/ui/jquery.ui.core.js" var="jQueryUiCore"/>
<script src="${jQueryUiCore}"></script>
<spring:url value="/webjars/jquery-ui/1.10.3/ui/jquery.ui.progressbar.js" var="jQueryUiProgressBar"/>
<script src="${jQueryUiProgressBar}"></script>
<spring:url value="/webjars/jquery-ui/1.10.3/themes/base/jquery-ui.css" var="jQueryUiCss"/>
    <link href="${jQueryUiCss}" rel="stylesheet"></link>-->

<title>Foodselector</title>
</head>

<body>

	<div class="main">

		<tiles:insertAttribute name="header" />
		<div id="container">
			<div class="body">
				<div>
					<tiles:insertAttribute name="body" />
					<tiles:insertAttribute name="leftmenu" />					
				</div>
			</div>
		</div>
		<tiles:insertAttribute name="footer" />

	</div>

</body>