<%@include file="header2.jsp"%>

<h2>Welcome to the Supermarket Database</h2>

<br />
<br />


	Authorization
	</h2>

	<div class="container-fluid" id="loginCont">

		<form action="login" method="POST" role="form">

			<c:if test="${param.error != null}">
				<div class="alert alert-danger">
					<p>Invalid username and/or password.</p>
				</div>
			</c:if>
			<c:if test="${param.logout != null}">
				<div class="alert alert-success">
					<p>You have been logged out successfully.</p>
				</div>
			</c:if>

			<div class="form-group">
				<label for="login">Login</label> <input type="text"
					class="form-control" id="login" name="login" required />
			</div>
			<div class="form-group">
				<label for="pwd">Password</label> <input type="password"
					class="form-control" id="pwd" name="password" required />
			</div>
			<button type="submit" class="btn btn-default" id="submitButton">Submit</button>
		</form>

	</div>



	<%@include file="footer.jsp"%>