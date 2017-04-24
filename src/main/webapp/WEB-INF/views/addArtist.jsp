<%@include file="header2.jsp"%>

<div align="center">
	</br>
	<h3>Add or Edit Artist</h3>
	</br>

	<div class="container-fluid" id="loginCont">
		<form:form action="adminSaveArtist" method="post" modelAttribute="artist">

			<form:hidden path="artistId" />

			<spring:bind path="lastName">
				<div class="form-group ">
					<label for="lastName" class="control-label">Last name</label>

					<form:input path="lastName" type="text" class="form-control"
						id="lastName" name="lastName" placeholder="Last name"
						data-error="Wrong input!" required="true" />
					<form:errors path="lastName" class="control-label" />

				</div>
			</spring:bind>

			<spring:bind path="firstName">
				<div class="form-group ">
					<label for="firstName" class="control-label">First name</label>

					<form:input path="firstName" type="text" class="form-control" id="firstName"
						name="firstName" placeholder="First name" data-error="Wrong input!"
						required="true" />
					<form:errors path="firstName" class="control-label" />

				</div>
			</spring:bind>

			<spring:bind path="birthCountry">
				<div class="form-group ">
					<label for="birthCountry" class="control-label">Birth Country</label>

					<form:input path="birthCountry" type="text" class="form-control" id="birthCountry"
						name="birthCountry" placeholder="Birth Country" data-error="Wrong input!"
						required="true" />
					<form:errors path="birthCountry" class="control-label" />

				</div>
			</spring:bind>

			<spring:bind path="birthday">
				<div class="form-group">
					<label for="birthday" class="control-label">Birthday</label>
					<form:input path="birthday" type="date" class="form-control"
						id="birthday" name="birthday"
						placeholder="year-month-date" data-error="Wrong input!"
						required="true" />
					<form:errors path="birthday" class="control-label" />
				</div>
			</spring:bind>

			<spring:bind path="dateOfDeath">
				<div class="form-group">
					<label for="dateOfDeath" class="control-label">Date of
						death</label>
					<form:input path="dateOfDeath" type="date" class="form-control"
						id="dateOfDeath" name="dateOfDeath"
						placeholder="year-month-date" data-error="Wrong input!"
						required="true" />
					<form:errors path="dateOfDeath" class="control-label" />
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
