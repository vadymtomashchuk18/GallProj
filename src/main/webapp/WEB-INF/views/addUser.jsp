<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header2.jsp"%>

<div align="center">
	</br>
	<h3>Add or Edit User</h3>
	</br>

	<div class="container-fluid" id="loginCont">
		<form:form action="adminSaveUser" method="post" modelAttribute="user">

			<form:hidden path="userId" />

			<spring:bind path="lastName">
				<div class="form-group ">
					<label for="lastName" class="control-label">Surname</label>

					<form:input path="lastName" type="text" class="form-control"
						id="lastName" name="lastName" placeholder="Surname"
						data-error="Wrong input!" required="true" />
					<form:errors path="lastName" class="control-label" />

				</div>
			</spring:bind>

			<spring:bind path="firstName">
				<div class="form-group ">
					<label for="firstName" class="control-label">Name</label>

					<form:input path="firstName" type="text" class="form-control" id="firstName"
						name="firstName" placeholder="Name" data-error="Wrong input!"
						required="true" />
					<form:errors path="firstName" class="control-label" />

				</div>
			</spring:bind>

			<spring:bind path="role">
				<div class="form-group ">
					<label for="role">Role</label>

					<form:select path="role" class="form-control">
						
						<form:option value="ADMIN" label="ADMIN" />
						<form:option value="SMPLUSER" label="SMPLUSER" />
					</form:select>
					<form:errors path="role" class="control-label" />

					<div class="col-sm-5"></div>
				</div>
			</spring:bind>

			<spring:bind path="login">
				<div class="login">
					<label for="login" class="control-label">Login</label>
					<form:input path="login" type="text" class="form-control"
						id="login" name="login" placeholder="login"
						data-error="Wrong input!" required="true" />
					<form:errors path="login" class="control-label" />
				</div>
			</spring:bind>


			<spring:bind path="password">
				<div class="form-group ">
					<label for="password" class="control-label">Password</label>

					<form:password path="password" class="form-control" id="password"
						placeholder="Password" required="true" />
					<form:errors path="password" class="control-label" />

				</div>
			</spring:bind>

			<div class="form-group">
				<button type="submit" class="btn btn-default">Submit</button>
			</div>
		</form:form>
	</div>
</div>
<%@include file="footer.jsp"%>>