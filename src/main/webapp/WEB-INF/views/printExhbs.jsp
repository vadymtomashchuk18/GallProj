<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		
		<h4  align="center">All Exhibitions</h4>
		
		</br>
		
		
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
</br>
<button type="button" class="btn btn-default " onclick="PrintElem('#print')">Print</button>

<%@include file="footer.jsp"%>