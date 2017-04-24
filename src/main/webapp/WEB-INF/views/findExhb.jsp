<%@include file="header2.jsp"%>


<div class="container-fluid">

	<div class="row-fluid">


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