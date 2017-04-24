<%@include file="header2.jsp"%>


<div class="container-fluid">

	<div class="row-fluid">
		<h4 style="position: absolute; left: 45%;">All artists</h4>
		</br> </br>

		<div class="span1">

			<div class="btn-group" role="group" aria-label="buttons">
				<button type="button" class="btn btn-default"
					onclick="location.href='adminAddArtist';">Add</button>

				<button type="button" class="btn btn-default" data-toggle="modal"
					data-target="#searchArtist">Search by artist name</button>
					
					<button type="button" class="btn btn-default" data-toggle="modal"
					data-target="#searchDir">Search by direction name</button>

				<button type="button" class="btn btn-default " onclick="location.href='printArtists';">Report</button>
			</div>
		</div>

		<!-- modal -->

		<div class="modal fade" id="searchArtist" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Search artist by
							name</h4>
					</div>
					<div class="modal-body">

						<form action="searchArtistName" method="POST" role="form">

							<div class="form-group">
								<label for="name">Artist name</label> <input type="text"
									class="form-control" id="lastName" name="lastName" required />
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

		<div class="modal fade" id="searchCat" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Search artist by
							movement name</h4>
					</div>
					<div class="modal-body">
						<form action="searchProdCatName" method="POST" role="form">

							<div class="form-group">
								<label for="name">Movement name</label> <input type="text"
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
		
		<c:if test="${msg != null}">
			</br>
			<div class="well well-sm">
				<p>${msg}</p>
			</div>
		</c:if>
		
		<div class="span11">
			<table class="table table-bordered table-hover" id="artistTable">
				<thead>
					<tr>
						<th>Artist id</th>
						<th class="col-md-1">No</th>
						<th class="col-md-2">Last name</th>
						<th class="col-md-2">First name</th>
						<th class="col-md-2">Birth country</th>
						<th class="col-md-1">Birthday</th>
						<th class="col-md-2">Date of death</th>
						<th class="col-md-1">Description</th>
						<th class="col-md-1">Action</th>

					</tr>
				</thead>

				<tbody>
					<c:forEach items="${artists}" var="artist" varStatus="status">
						<tr>
							<td>${artist.artistId}</td>
							<td>${status.index + 1}</td>
							<td>${artist.lastName}</td>
							<td>${artist.firstName}</td>
							<td>${artist.birthCountry}</td>
							<td>${artist.birthday}</td>
							<td>${artist.dateOfDeath}</td>
							<td>${artist.otherDetails}</td>

							<td><a href="adminEditArtist?artistId=${artist.artistId}">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="adminDeleteArtist?artistId=${artist.artistId}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>

<script>
	$(document).ready(function() {
		var booksTable = $('#artistTable').DataTable({
			columns : [ {
				data : 'artistId'
			}, {
				data : 'status'
			}, {
				data : 'lastName'
			}, {
				data : 'firstName'
			}, {
				data : 'birthCountry'
			}, {
				data : 'birthday'
			}, {
				data : 'dateOfDeath'
			}, {
				data : 'otherDetails'
			}, {
				data : 'action'
			} ],
			columnDefs : [ {
				targets : 0,
				visible : false
			} ],
			rowId : 'artistID',
			order : [ [ 1, 'asc' ] ],
			lengthChange : false
		});
	});
</script>
<%@include file="footer.jsp"%>