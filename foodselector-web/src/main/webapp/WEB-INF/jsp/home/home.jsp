<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div class="right_body">
	<h2>
		<spring:message code="welcome_home" /><br /> <span> March 16, 2010 | Posted by Owner
			| Filed under templates, internet</span>
	</h2>
	
	<!-- <img src="<c:url value='/resources/images/img_1.jpg'/>" alt="" width="585" height="156" /> -->
	<div class="clr"></div>
	
			
	<div class="content">	
		This is a free CSS website template by HotWebsiteTemplates.net. This
		work is distributed under the <a href="http://creativecommons.org/licenses/by/3.0/">Creative
			Commons Attribution 3.0 License</a>, which means that you are free to use
		it for any personal or commercial purpose provided you credit me in
		the form of a link back to HotWebsiteTemplates.net.
	</div>
	<p>
		<a href="#">Read more | Comments (5)</a><br />
	</p>
	<h2>
		Aliquam Risus Justo<br /> <span>March 16, 2010 | Posted by
			Owner | Filed under templates, internet</span>
	</h2>	
	<img src="images/img_2.jpg" alt="" width="585" height="156" />
	
	<div class="clr"></div>	
	
	<p>
		<a href="#">Lorem ipsum dolor sit amet, consectetur adipiscing
			elit.</a> Sed euismod aliquet nunc vel porta. Morbi non mi id diam mattis
		consequat. Mauris pharetra fermentum tortor quis sagittis. Fusce
		rutrum ipsum lectus, vel congue velit. Nulla ultrices pretium congue.
		Mauris metus nibh, pulvinar vel vehicula eu, pharetra id ante. Vivamus
		tincidunt semper sapien ut fermentum. Nullam facilisis, nulla eu
		suscipit vulputate, libero nisl pellentesque tellus, ac scelerisque
		metus mauris ut quam. Nulla facilisi. Quisque rhoncus dolor et dolor
		lobortis accumsan. Pellentesque habitant morbi tristique senectus et
		netus et malesuada fames ac turpis egestas. Suspendisse at nulla ante,
		at hendrerit mi. Aenean in ipsum massa. Pellentesque semper elit quis
		mauris ultricies ultrices. Sed sit amet felis tellus. Suspendisse
		potenti.
	</p>
	<p>
		<a href="#">Read more | Comments (5)</a>
	</p>
</div>
<script>
$(document).ready(function(){
	console.log( "ready!" );
});


var bar = $( "#myProgressbar" ).progressbarFS({
	htmlId:'myProgressbar'	
}); 

//var bar = $( "#myProgressbar" ).progressbarFS();
//bar.progressbarFS( "option", "htmlId", "myProgressbar");
bar.progressbarFS( "option", "value", 10);

 
var bar2 = $( "#myProgressbar2" ).progressbarFS({
	htmlId:'myProgressbar2'
});
//bar2.progressbarFS( "option", "htmlId", "myProgressbar2");
bar2.progressbarFS( "option", "value", 80);







</script>