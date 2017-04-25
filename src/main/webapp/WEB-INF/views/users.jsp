<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header2.jsp"%>


<div class="container-fluid">

	<div class="row-fluid">
		<h4 style="position:absolute; left: 50%;">All users</h4>
		</br>

		<div class="span1">

			<div class="btn-group" role="group" aria-label="buttons">
				<button type="button" class="btn btn-default"
					onclick="location.href='adminAddUser';">Add</button>

				<button type="button" class="btn btn-default" data-toggle="modal"
					data-target="#search">Search by login</button>

<!-- 
				<button type="button" class="btn btn-default " onclick="location.href='adminPrintUser';">Report</button>
 -->
			</div>
		</div>

		<!-- modal -->

		<div class="modal fade" id="search" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Search user by login</h4>
					</div>
					<div class="modal-body">


						<form action="adminSearch" method="POST" role="form">

							<div class="form-group">
								<label for="login">Login</label> <input type="text"
									class="form-control" id="login" name="login" required />
							</div>

							<div class="modal-footer">
								<button type="submit" class="btn btn-default" id="submitButton">Submit</button>
							</div>
						</form>

					</div>



				</div>
			</div>
		</div>

		<!-- modal -->

		<c:if test="${msg != null}">
			</br>
			<div class="well well-sm">
				<p>${msg}</p>
			</div>
		</c:if>

		<div class="span11">
			<table class="table table-bordered table-hover" id="usrsTable">
				<thead>
					<tr>
						<th>userId</th>
						<th class="col-md-4">No</th>
						<th class="col-md-4">Surname</th>
						<th class="col-md-4">Name</th>
						<th class="col-md-4">Role</th>
						<th class="col-md-4">Login</th>
						<th class="col-md-4">Password</th>
						<th class="col-md-4">Action</th>

					</tr>
				</thead>

				<tbody>
					<c:forEach items="${usrs}" var="user" varStatus="status">
						<tr>
							<td>${user.userId}</td>
							<td>${status.index + 1}</td>
							<td>${user.lastName}</td>
							<td>${user.firstName}</td>
							<td>${user.role}</td>
							<td>${user.login}</td>
							<td>${user.password}</td>
							
							<td><a href="adminEditUser?userId=${user.userId}">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="adminDeleteUser?userId=${user.userId}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>




<script>
	$(document).ready(function() {
		var booksTable = $('#usrsTable').DataTable({
			columns : [ {
				data : 'userId'
			}, {
				data : 'status'
			}, {
				data : 'lastName'
			}, {
				data : 'firstName'
			}, {
				data : 'role'
			}, {
				data : 'login'
			}, {
				data : 'password'
			}, {
				data : 'action'
			} ],
			columnDefs : [ {
				targets : 0,
				visible : false
			} ],
			rowId : 'userId',
			order : [ [ 1, 'asc' ] ],
			lengthChange : false
		});
	});
</script>
<%@include file="footer.jsp"%>