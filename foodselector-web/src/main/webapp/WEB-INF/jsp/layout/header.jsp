<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="header">
    <div >
      <div class="logo">
        <h1><a href="index.html"><span>FOOD</span>SELECTOR<br />
          <small>Selecteer uw menu</small></a></h1>
      </div>
      <div class="clr"></div>
      <div class="menu">
        <ul>
          <li><a href="<c:url value='/' />"><span>Home</span></a></li>
          <li><a href="<c:url value='/dishflow' />"><span><spring:message code="header_link_dish" /></span></a></li>
          <li><a href="<c:url value='/ingredients' />"><span><spring:message code="header_link_ingredients" /></span></a></li>          
          <li><a href="contact.html"><span>Contact Us</span></a></li>
        </ul>
      </div>
      <div class="search">
        <form id="form1" name="form1" method="post" action="#">
          <label><span>
            <input name="q" type="text" class="keywords" id="textfield" maxlength="50" value="Search..." />
            </span>
            <input name="b" type="image" src="images/search.gif" class="button" />
          </label>
        </form>
      </div>
      <div class="clr"></div>
    </div>
    <div class="headert_text_resize"></div>
    <!--<div class="clr"></div>-->
 </div>