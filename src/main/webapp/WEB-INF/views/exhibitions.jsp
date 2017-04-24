<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header2.jsp"%>


<div class="container-fluid">

	<div class="row-fluid">
		<h4 style="position: absolute; left: 45%;">All exhibitions</h4>
		</br> </br>

		<div class="span1">

			<div class="btn-group" role="group" aria-label="buttons">
				<button type="button" class="btn btn-default"
					onclick="location.href='adminAddExhb';">Add</button>

				<button type="button" class="btn btn-default" data-toggle="modal"
					data-target="#searchExhb">Search by exhibition name</button>

 <!-- 					
				<button type="button" class="btn btn-default" data-toggle="modal"
					data-target="#searchCat">Search by category name</button>	

  -->
				<button type="button" class="btn btn-default " onclick="location.href='printExhbs';">Report</button>
			</div>
		</div>

		<!-- modal -->

		<div class="modal fade" id="searchExhb" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Search exhibition by
							name</h4>
					</div>
					<div class="modal-body">


						<form action="searchExhbName" method="POST" role="form">

							<div class="form-group">
								<label for="name">Exhibition name</label> <input type="text"
									class="form-control" id="name" name="name" required />
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
		
		<!-- modal -->
<!-- 
		<div class="modal fade" id="searchCat" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Search exhibition by
							category name</h4>
					</div>
					<div class="modal-body">


						<form action="searchExhbCatName" method="POST" role="form">

							<div class="form-group">
								<label for="name">Exhb Category name</label> <input type="text"
									class="form-control" id="name" name="name" required />
							</div>

							<div class="modal-footer">
								<button type="submit" class="btn btn-default" id="submitButton">Submit</button>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
 -->
		<!-- modal -->
		

		<c:if test="${msg != null}">
			</br>
			<div class="well well-sm">
				<p>${msg}</p>
			</div>
		</c:if>
		
		<div class="span11">
			<table class="table table-bordered table-hover" id="exhbsTable">
				<thead>
					<tr>
						<th>Exhibition id</th>
						<th class="col-md-1">No</th>
						<th class="col-md-2">Exhibition name</th>
						<th class="col-md-2">Date opened</th>
						<th class="col-md-2">Date closed</th>
						<th class="col-md-2">Price of visiting</th>
						<th class="col-md-2">Description</th>
						<th class="col-md-1">Action</th>

					</tr>
				</thead>

				<tbody>
					<c:forEach items="${exhibitions}" var="exhibition" varStatus="status">
						<tr>
							<td>${exhibition.exhibitionId}</td>
							<td>${status.index + 1}</td>
							<td>${exhibition.exhibitionName}</td>
							<td>${exhibition.dateOpened}</td>
							<td>${exhibition.dateClosed}</td>
							<td>${exhibition.priceOfVisiting}</td>
							<td>${exhibition.otherDetails}</td>

							<td><a href="managerEditProd?id_product=${product.id_product}">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="managerDeleteProd?id_product=${product.id_product}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>




		</div>
	</div>

</div>

<script>
	$(document).ready(function() {
		var booksTable = $('#exhbsTable').DataTable({
			columns : [ {
				data : 'exhibitionId'
			}, {
				data : 'status'
			}, {
				data : 'exhibitionName'
			}, {
				data : 'dateOpened'
			}, {
				data : 'dateClosed'
			}, {
				data : 'priceOfVisiting'
			}, {
				data : 'otherDetails'
			}, {
				data : 'action'
			} ],
			columnDefs : [ {
				targets : 0,
				visible : false
			} ],
			rowId : 'exhibitionId',
			order : [ [ 1, 'asc' ] ],
			lengthChange : false
		});
	});
</script>
<%@include file="footer.jsp"%>