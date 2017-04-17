<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>

<title>Supermarket</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!--  Bootstrap -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>




<!--  JQuery -->
<!--  
<script src="/resources/bootstrap/js/jquery-1.11.3.min.js"></script>
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>">
-->
<!--  Bootstrap
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
 -->


<!--  DataTables -->
<script
	src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.10/js/dataTables.bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.10/css/dataTables.bootstrap.min.css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/styles.css" />">
</head>

<body>
	<div class="wrapper">
		<div id="content">

			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
					<sec:authorize access="isAuthenticated()">
						<a class="navbar-brand"  href="<c:url value="/"/>">Main</a>
					</sec:authorize>
					</div>
					<ul class="nav navbar-nav">
					<sec:authorize access="isAuthenticated()">

						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#"> DATA <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<sec:authorize  access="hasAuthority('MANAGER')">
									<li><a href="managerEmpl">Employee</a></li>
								</sec:authorize>
								<sec:authorize access= "hasAuthority('MANAGER')">
									<li><a href="managerAllProducers">Producer</a></li>
								</sec:authorize>

								<li><a href="allCards">Customer Card</a></li>

								<sec:authorize access= "hasAuthority('MANAGER')">
									<li><a href="managerAllCats">Category</a></li>
								</sec:authorize>

								<li><a href="allProd">Product</a></li>

								<li><a href="strPr">Store product</a></li>

								<li><a href="allChecks">Check</a></li>

								<sec:authorize access= "hasAuthority('MANAGER')">
									<li><a href="managerAllCons">Consignment</a></li>
								</sec:authorize>

								<sec:authorize access= "hasAuthority('MANAGER')">
									<li><a href="managerAllContr">Return contract</a></li>
								</sec:authorize>
							</ul></li>
							</sec:authorize>


					</ul>
					<ul class="nav navbar-nav navbar-right">


						<sec:authorize access="isAuthenticated()">
							<li><p class="navbar-text">Logged in as
									<sec:authentication property="principal.surname" />
									<sec:authentication property="principal.name" />
									(<sec:authentication property="principal.job" />)</p></li>
							<li><a href="logout"><span
									class="glyphicon glyphicon-log-out"></span> Logout</a></li>
						</sec:authorize>

					</ul>
				</div>
			</nav>