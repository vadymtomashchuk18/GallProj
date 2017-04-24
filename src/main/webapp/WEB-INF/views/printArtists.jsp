<%@include file="header2.jsp"%>

<script type="text/javascript">

    function PrintElem(elem)
    {
        Popup($(elem).html());
    }

    function Popup(data) 
    {
        var mywindow = window.open('', 'print', 'height=400,width=600');
        mywindow.document.write('<html><head><title></title>');
        /*optional stylesheet*/ //mywindow.document.write('<link rel="stylesheet" href="main.css" type="text/css" />');
        mywindow.document.write('</head><body >');
        mywindow.document.write(data);
        mywindow.document.write('</body></html>');

        mywindow.document.close(); // necessary for IE >= 10
        mywindow.focus(); // necessary for IE >= 10

        mywindow.print();
        mywindow.close();

        return true;
    }

</script>


<div class="container-fluid" id="print">

	<div class="row-fluid">
	
	<h3  align="center">Gallery "Around the World"</h3>
		</br>
		
		<h4  align="center">All artists</h4>
		
		</br>
		
		
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
</br>
<button type="button" class="btn btn-default " onclick="PrintElem('#print')">Print</button>

<%@include file="footer.jsp"%>