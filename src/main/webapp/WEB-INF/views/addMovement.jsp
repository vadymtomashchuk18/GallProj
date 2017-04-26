<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header2.jsp"%>

<div align="center">
	</br>
	<h3>Add or Edit Movement</h3>
	</br>

	<div class="container-fluid" id="loginCont">
		<form:form action="adminSaveMovement" method="post" modelAttribute="movement">

			<form:hidden path="movementCode" />

			<spring:bind path="nameOfMovement">
				<div class="form-group ">
					<label for="nameOfMovement" class="control-label">Name of direction</label>

					<form:input path="nameOfMovement" type="text" class="form-control" id="nameOfMovement"
						name="nameOfMovement" placeholder="Name of direction" data-error="Wrong input!"
						required="true" />
					<form:errors path="nameOfMovement" class="control-label" />

				</div>
			</spring:bind>
			
			<spring:bind path="description">
				<div class="form-group ">
					<label for="description" class="control-label">Description</label>

					<form:input path="description" type="text" class="form-control" id="description"
						name="description" placeholder="Description" data-error="Wrong input!"
						required="true" />
					<form:errors path="description" class="control-label" />

				</div>
			</spring:bind>

			<div class="form-group">
				<button type="submit" class="btn btn-default">Submit</button>
			</div>
		</form:form>
	</div>
</div>


<%@include file="footer.jsp"%>>
