<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header2.jsp"%>

<div class="container-fluid">
	<div class="row-fluid">

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
								href="adminDeleteUser?id_empl=${user.userId}">Delete</a></td>
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