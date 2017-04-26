<%@include file="header2.jsp"%>


<div class="container-fluid">

	<div class="row-fluid">
		<h4 style="position: absolute; left: 45%;">All movements</h4>
		</br> </br>

		<div class="span1">

			<div class="btn-group" role="group" aria-label="buttons">
				<button type="button" class="btn btn-default"
					onclick="location.href='adminAddMovement';">Add</button>

				<button type="button" class="btn btn-default" data-toggle="modal"
					data-target="#searchMovement">Search by movement name</button>
<!-- 					
					<button type="button" class="btn btn-default" data-toggle="modal"
					data-target="#searchCat">Search by category name</button>

				<button type="button" class="btn btn-default " onclick="location.href='managerPrintProd';">Report</button>
 -->			</div>
		</div>

		<!-- modal -->

		<div class="modal fade" id="searchMovement" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Search movement by
							name</h4>
					</div>
					<div class="modal-body">


						<form action="searchMovementName" method="POST" role="form">

							<div class="form-group">
								<label for="name">Movement name</label> <input type="text"
									class="form-control" id="nameOfMovement" name="nameOfMovement" required />
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
		<!-- modal -->
		

		<c:if test="${msg != null}">
			</br>
			<div class="well well-sm">
				<p>${msg}</p>
			</div>
		</c:if>
		
		<div class="span11">
			<table class="table table-bordered table-hover" id="movementsTable">
				<thead>
					<tr>
						<th>Product id</th>
						<th class="col-md-4">No</th>
						<th class="col-md-4">Movement name</th>
						<th class="col-md-4">Description</th>
						<th class="col-md-4">Action</th>

					</tr>
				</thead>

				<tbody>
					<c:forEach items="${movements}" var="movement" varStatus="status">
						<tr>
							<td>${movement.movementCode}</td>
							<td>${status.index + 1}</td>
							<td>${movement.nameOfMovement}</td>
							<td>${movement.description}</td>

							<td><a href="adminEditMovement?movementId=${movement.movementCode}">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="adminDeleteMovement?id_product=${movement.movementCode}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>




		</div>
	</div>

</div>

<script>
	$(document).ready(function() {
		var booksTable = $('#movementsTable').DataTable({
			columns : [ {
				data : 'movementCode'
			}, {
				data : 'status'
			}, {
				data : 'nameOfMovement'
			}, {
				data : 'description'
			}, {
				data : 'action'
			} ],
			columnDefs : [ {
				targets : 0,
				visible : false
			} ],
			rowId : 'movementCode',
			order : [ [ 1, 'asc' ] ],
			lengthChange : false
		});
	});
</script>
<%@include file="footer.jsp"%>