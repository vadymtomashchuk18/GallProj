<%@include file="header2.jsp"%>


<div class="container-fluid">

	<div class="row-fluid">


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
						<th class="col-md-2">Description</th>
						

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
				data : 'artistID'
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
			}],
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