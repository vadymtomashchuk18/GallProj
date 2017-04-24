<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header2.jsp"%>


<div class="container-fluid">

	<div class="row-fluid">
		<h4 style="position: absolute; left: 45%;">All paintings</h4>
		</br> </br>

		<div class="span1">

			<div class="btn-group" role="group" aria-label="buttons">
				<button type="button" class="btn btn-default"
					onclick="location.href='adminAddPainting';">Add</button>

				<button type="button" class="btn btn-default" data-toggle="modal"
					data-target="#searchPainting">Search by painting name</button>
					
					<button type="button" class="btn btn-default" data-toggle="modal"
					data-target="#searchStyle">Search by style name</button>

				<button type="button" class="btn btn-default " onclick="location.href='printPainting';">Report</button>
			</div>
		</div>

		<!-- modal -->

		<div class="modal fade" id="searchPainting" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Search painting by
							name</h4>
					</div>
					<div class="modal-body">


						<form action="searchPaintingName" method="POST" role="form">

							<div class="form-group">
								<label for="nameOfPainting">Painting name</label> <input type="text"
									class="form-control" id="nameOfPainting" name="nameOfPainting" required />
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

		<div class="modal fade" id="searchStyle" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Search product by
							style name</h4>
					</div>
					<div class="modal-body">


						<form action="searchPaintingStyleName" method="POST" role="form">

							<div class="form-group">
								<label for="nameOfStyle">Style name</label> <input type="text"
									class="form-control" id="nameOfStyle" name="nameOfStyle" required />
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
			<table class="table table-bordered table-hover" id="paintingsTable">
				<thead>
					<tr>
						<th>Painting id</th>
						<th class="col-md-4">No</th>
						<th class="col-md-4">Artist name</th>
						<th class="col-md-4">Style name</th>
						<th class="col-md-4">Name of picture</th>
						<th class="col-md-4">Price of picture</th>
						<th class="col-md-4">Width of picture</th>
						<th class="col-md-4">Height of picture</th>
						<th class="col-md-4">Description</th>
						<th class="col-md-4">Action</th>

					</tr>
				</thead>

				<tbody>
					<c:forEach items="${paintings}" var="painting" varStatus="status">
						<tr>
							<td>${painting.paintingId}</td>
							<td>${status.index + 1}</td>
							<td>${painting.artist.lastName}</td>
							<td>${painting.style.nameOfStyle}</td>
							<td>${painting.nameOfPainting}</td>
							<td>${painting.priceOfPicture}</td>
							<td>${painting.widthSize}</td>
							<td>${painting.heightSize}</td>
							<td>${product.otherDetails}</td>

							<td><a href="adminEditPainting?paintingId=${painting.paintingId}">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="adminDeletePainting?paintingId=${painting.paintingId}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>

<script>
	$(document).ready(function() {
		var booksTable = $('#paintingsTable').DataTable({
			columns : [ {
				data : 'paintingId'
			}, {
				data : 'status'
			}, {
				data : 'style.nameOfStyle'
			}, {
				data : 'artist.lastName'
			}, {
				data : 'nameOfPainting'
			}, {
				data : 'priceOfPicture'
			}, {
				data : 'widthSize'
			}, {
				data : 'heightSize'
			}, {
				data : 'otherDetails'
			}, {
				data : 'action'
			} ],
			columnDefs : [ {
				targets : 0,
				visible : false
			} ],
			rowId : 'paintingId',
			order : [ [ 1, 'asc' ] ],
			lengthChange : false
		});
	});
</script>
<%@include file="footer.jsp"%>