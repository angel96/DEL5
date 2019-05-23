<%--
 * header.jsp
 *
 * Copyright (C) 2019 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div>
	<a href="#"><img src="${banner}" alt="${systemName}" height="150"
		width="400" /></a>
</div>

<div>
	<ul id="jMenu">
		<!-- Admin -->
		<!-- Do not forget the "fNiv" class for the first level links !! -->
		<security:authorize access="hasRole('ADMIN')">
			<li><a class="fNiv"><spring:message
						code="master.page.administrator.listActor" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="actor/listSpammers.do"><spring:message
								code="master.page.administrator.listSpammers" /></a></li>
					<li><a href="actor/listBan.do"><spring:message
								code="master.page.administrator.listEnabled" /></a></li>
				</ul></li>
			<li><a class="fNiv"><spring:message
						code="master.page.administrator.category" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="category/administrator/list.do"><spring:message
								code="master.page.administrator.category.list" /></a></li>
					<li><a href="category/administrator/create.do"><spring:message
								code="master.page.administrator.category.create" /></a></li>
				</ul></li>
			<li><a class="fNiv"><spring:message
						code="master.page.administrator.custom" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="customisation/administrator/custom.do"><spring:message
								code="master.page.administrator.customAction" /></a></li>
				</ul></li>
			<li><a href="customisation/administrator/dashboard.do"><spring:message
						code="master.page.dashboard" /></a></li>
			<li><a href="actor/createAdmin.do"><spring:message
						code="master.page.actor.admin" /></a></li>
							
			<li><a href="actor/createAdmin.do"><spring:message
								code="master.page.actor.admin" /></a></li>		
										
		</security:authorize>
						
		
		
		<security:authorize access="hasRole('MEMBER')">
			<li><a class="fNiv"><spring:message
						code="master.page.comission" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="comission/member/list.do"><spring:message
								code="master.page.member.listComission" /></a></li>
					<li><a href="comission/member/create.do"><spring:message
								code="master.page.member.create" /></a></li>
				</ul></li>
		</security:authorize>
		
		<security:authorize access="hasRole('COLLABORATOR')">
			<li><a class="fNiv"><spring:message
						code="master.page.comission" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="comission/collaborator/list.do"><spring:message
								code="master.page.collaborator.listComission" /></a></li>
				</ul></li>
		</security:authorize>

		
		<security:authorize access="isAnonymous()">
		<li><a class="fNiv" href="security/login.do"><spring:message
						code="master.page.login" /></a></li>
		<li><a class="fNiv" href="about-us/terms.do"><spring:message
					code="master.page.terms" /></a></li>
				
		<li><a class="fNiv" href="event/listEvents.do"><spring:message
						code="master.page.listEvent" /></a>
					
		<li><a class="fNiv"><spring:message
						code="master.page.actor.register" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="actor/createMember.do"><spring:message
								code="master.page.actor.member" /> </a></li>
					<li><a href="actor/createCollaborator.do"><spring:message
								code="master.page.actor.collaborator" /></a></li>
					<li><a href="actor/createStudent.do"><spring:message
								code="master.page.actor.student" /></a></li>
					<li><a href="actor/createSponsor.do"><spring:message
								code="master.page.actor.sponsor" /></a></li>
				</ul></li>
		</security:authorize>
		<security:authorize access="isAuthenticated()">
			<li><a class="fNiv"> <spring:message
						code="master.page.profile" /> (<security:authentication
						property="principal.username" />)
			</a>
				<ul>
					<li class="arrow"></li>
					<li><a href="profile/list.do"><spring:message
								code="master.page.profile.list" /></a></li>
					<li><a href="actor/personal.do"><spring:message
								code="master.page.edit.data" /></a></li>

					<li><a href="box/list.do"><spring:message
								code="master.page.boxes" /></a></li>
					<li><a href="message/create.do"><spring:message
								code="master.page.message.create" /></a></li>
					<li><a href="j_spring_security_logout"><spring:message
								code="master.page.logout" /> </a></li>
				</ul></li>
		</security:authorize>
	</ul>
</div>

<div>
	<a href="?language=en">en</a> | <a href="?language=es">es</a>
</div>

