<%--
 * action-1.jsp
 *
 * Copyright (C) 2019 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action="${requestURI}" modelAttribute="comment" id="form">

	<form:hidden path="id"/>
	<form:hidden path="actor"/>
	<form:hidden path="proclaim"/>
	
	<spring:message code="comment.proclaim"></spring:message>
	<jstl:out value=" : ${comment.proclaim.title}"></jstl:out>

	<acme:textbox code="comment.description" path="description"/>
	
	<acme:textbox code="comment.attachments" path="attachments"/>
		
		<spring:message code="comment.author" />
		<jstl:out value=" : ${comment.actor.name}" />
	
		<acme:submit name="save" code="comment.save" />

</form:form>

<acme:cancel url="${requestCancel}" code="comment.cancel" />
