<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header2.jsp"%>

<div align="center">
	</br>
	<h3>Add or Edit Painting</h3>
	</br>

	<div class="container-fluid" id="loginCont">
		<form:form action="adminSavePainting" method="post" modelAttribute="painting">

			<form:hidden path="paintingId" />
			
			
			<div class="form-group ">
				<label for="artist" class="control-label">Artist</label> </br>
				<select	id="artistID" name="artistID">
<!-- 					<option value="NONE"> --SELECT--<option>
					<option value="${painting.artist.artistId}">${painting.artist.lastName}</option>
 -->					<option value="NONE" label="--SELECT--"/>
					<option value="Aivazovsky" label="Aivazovsky"/>
					<option value="Picasso" label="Picasso"/>
					<option value="Monet" label="Monet"/>
					<option value="Van Gogh" label="Van Gogh"/>
					<c:forEach items="${artists}" var="artist">
						<option value="<c:out value="${artist.artistId}"/>">
							<c:out value="${artist.lastName}" />
						</option>
					</c:forEach>
				</select>
 			</div>
 
  			<div class="form-group ">
				<label for="style" class="control-label">Style</label> 
				</br>
				<select id="styleId" name="styleId">
<!-- 				<option value="NONE" style="center"> --SELECT--<option> 
					<option value="NONE" label="--SELECT--"/>		-->
					<option value="Romanticism" label="Romantisism"/>
					<option value="Analytic cubism" label="Analytic cubism"/>
					<option value="Crystal cubism" label="Crystal cubism"/>
					<option value="Impressionism" label="Impressionism"/>
					<option value="Post-Impressionism" label="Post-Impressionism"/>
<!-- 					<option value="${painting.style.styleId}"><c:out value="${painting.style.nameOfStyle}" /><option>
	 -->				
					<c:forEach items="${styles}" var="style">
						<option value="<c:out value="${style.styleId}"/>">
							<c:out value="${style.nameOfStyle}" />
						</option>
					</c:forEach>
				</select>
 			</div>
 			
			<spring:bind path="nameOfPainting">
				<div class="form-group ">
					<label for="nameOfPainting" class="control-label">Name of picture</label>

					<form:input path="nameOfPainting" type="text" class="form-control" id="nameOfPainting"
						name="nameOfPainting" placeholder="Name of picture" data-error="Wrong input!"
						required="true" />
					<form:errors path="nameOfPainting" class="control-label" />

				</div>
			</spring:bind>
			
			<spring:bind path="priceOfPicture">
				<div class="form-group">
					<label for=priceOfPicture class="control-label">Price of picture</label>
					<form:input path="priceOfPicture" type="number" class="form-control"
						id="priceOfPicture" name="priceOfPicture" placeholder="Price of picture"
						data-error="Wrong input!" min="1" step="any" required="true" />
					<form:errors path="priceOfPicture" class="control-label" />
				</div>
			</spring:bind>
			
			<spring:bind path="widthSize">
				<div class="form-group">
					<label for=widthSize class="control-label">Width of picture</label>
					<form:input path="widthSize" type="number" class="form-control"
						id="widthSize" name="widthSize" placeholder="Width of picture"
						data-error="Wrong input!" min="1" step="any" required="true" />
					<form:errors path="widthSize" class="control-label" />
				</div>
			</spring:bind>
			
			<spring:bind path="heightSize">
				<div class="form-group">
					<label for=heightSize class="control-label">Height of picture</label>
					<form:input path="heightSize" type="number" class="form-control"
						id="heightSize" name="heightSize" placeholder="Height of picture"
						data-error="Wrong input!" min="1" step="any" required="true" />
					<form:errors path="heightSize" class="control-label" />
				</div>
			</spring:bind>
			
			<spring:bind path="otherDetails">
				<div class="form-group ">
					<label for="otherDetails" class="control-label">Description</label>

					<form:input path="otherDetails" type="text" class="form-control" id="otherDetails"
						name="otherDetails" placeholder="Description" data-error="Wrong input!"
						required="true" />
					<form:errors path="otherDetails" class="control-label" />

				</div>
			</spring:bind>
			
			

			<div class="form-group">
				<button type="submit" class="btn btn-default">Submit</button>
			</div>
		</form:form>
	</div>
</div>


<%@include file="footer.jsp"%>>
