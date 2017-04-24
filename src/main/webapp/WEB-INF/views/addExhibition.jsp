<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header2.jsp"%>

<div align="center">
	</br>
	<h3>Add or Edit Exhibition</h3>
	</br>

	<div class="container-fluid" id="loginCont">
		<form:form action="adminSaveExhb" method="post" modelAttribute="exhb">

			<form:hidden path="exhibitionId" />	

			<spring:bind path="exhibitionName">
				<div class="form-group ">
					<label for="exhibitionName" class="control-label">Name of Exhibition</label>

					<form:input path="exhibitionName" type="text" class="form-control" id="exhibitionName"
						name="exhibitionName" placeholder="Name" data-error="Wrong input!"
						required="true" />
					<form:errors path="exhibitionName" class="control-label" />

				</div>
			</spring:bind>
			
			<spring:bind path="dateOpened">
				<div class="form-group">
					<label for="dateOpened" class="control-label">Date of Opening</label>
					<form:input path="dateOpened" type="date" class="form-control"
						id="dateOpened" name="dateOpened"
						placeholder="year-month-date" data-error="Wrong input!"
						required="true" />
					<form:errors path="dateOpened" class="control-label" />
				</div>
			</spring:bind>
			
			<spring:bind path="dateClosed">
				<div class="form-group">
					<label for="dateOpened" class="control-label">Date of Closing</label>
					<form:input path="dateOpened" type="date" class="form-control"
						id="dateOpened" name="dateOpened"
						placeholder="year-month-date" data-error="Wrong input!"
						required="true" />
					<form:errors path="dateOpened" class="control-label" />
				</div>
			</spring:bind>
			
			<spring:bind path="priceOfVisiting">
				<div class="form-group">
					<label for="priceOfVisiting" class="control-label">Price of visiting</label>
					<form:input path="priceOfVisiting" type="number" class="form-control"
						id="priceOfVisiting" name="priceOfVisiting" placeholder="Salary"
						data-error="Wrong input!" min="1" step="any" required="true" />
					<form:errors path="priceOfVisiting" class="control-label" />
				</div>
			</spring:bind>
			
			<spring:bind path="otherDetails">
				<div class="form-group ">
					<label for="otherDetails" class="control-label">Description</label>

					<form:input path="otherDetails" type="text" class="form-control" id="otherDetails"
						name="otherDetails" placeholder="Description" data-error="Wrong input!"
						required="true" />
					<form:errors path="otherDetails" class="control-label" />

				</div>
			</spring:bind>

			<div class="form-group">
				<button type="submit" class="btn btn-default">Submit</button>
			</div>
		</form:form>
	</div>
</div>


<%@include file="footer.jsp"%>>