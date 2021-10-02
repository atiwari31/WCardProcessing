<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<form:form action="/license/addcustomerlicense" method="post"
	modelAttribute="customerLicenseDTO" id="addcustomerlicense">
	<div class="container my-5 table-div">
<div class="form-n"><Strong><font style="color: black; font-size: 23px;">Add New License</font></Strong></div>
		<!-- <h3 class="form-n">Add New License</h3> -->
		<c:if test="${msg != null}">
			<div>
				<span style="margin-left: 320px"><strong><font
					style="font-size:18px; color: green">${msg}</font></strong></span>
			</div>
		</c:if>
		<c:if test="${licmsg != null}">
			<div>
				<span style="margin-left: 400px"><strong><font
					style="font-size:18px; color: #FF9800">${licmsg}</font></strong></span>
			</div>
		</c:if>
		<div class="form-group">
			<label for="exampleFormControlSelect1">Please Select
				Customer:<span class="required-field"></span>
			</label> <select class="form-control" name="customer" id="customer">
				<c:forEach items="${customerList}" var="customerList">
					<option value="${customerList.id}">${customerList.customerName}</option>
				</c:forEach>
			</select>



		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Please Select License
				Type:<span class="required-field"></span>
			</label> <br>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" id="day"
					name="licenseType" value="day" onClick="test();" checked> <label
					class="form-check-label" for="inlineCheckbox1">License
					Scanning:</label>
			</div>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" id="date"
					name="licenseType" value="date" onClick="test();"> <label
					class="form-check-label" for="inlineCheckbox2">Date Wise:</label>
			</div>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" id="user"
					name="licenseType" value="host" onClick="test();"> <label
					class="form-check-label" for="inlineCheckbox3">Host IP:</label>
			</div>
			<div style="margin-top: 10px">
				<font style="color: red"> ${errormsg}</font>
			</div>

		</div>
		<div class="form-group">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label for="exampleInputEmail1">License Scanning End Date:</label> <input
					type="date" class="form-control" id="days"
					aria-describedby="emailHelp" placeholder="Enter Date" name="days">

			</div>
		</div>
		<div class="form-group">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label for="exampleInputEmail1">Please Select Date :</label> <input
					type="date" class="form-control" id="licenseEndDate"
					aria-describedby="emailHelp" name="licenseEndDate" disabled>

			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-3">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label for="exampleInputEmail1">How Many Host:</label> <input
						type="text" style="width: 200px;" class="form-control" id="hostip"
						aria-describedby="emailHelp" placeholder="NO. OF IP" name="hostip"
						disabled> <font style="color: red"> ${daydatemsg}</font>
				</div>


			</div>

			<div class="form-group col-md-3">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label for="exampleInputEmail1">From Date</label> <input
						type="date" style="width: 200px;" class="form-control"
						id="startLicenseDate" aria-describedby="emailHelp"
						name="startLicenseDate" disabled>

				</div>
			</div>

			<div class="form-group col-md-6">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label for="exampleInputEmail1">End Date</label> <input type="date"
						style="width: 200px;" class="form-control" id="endLicenseDate"
						aria-describedby="emailHelp" name="endLicenseDate" disabled>

				</div>

			</div>

			&nbsp;&nbsp;
			<button type="submit" class="btn btn-danger">Cancel</button>
			&nbsp;&nbsp;
			<button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#staticBackdrop" onClick="msgHidden();">Submit</button>

		</div>
		<div>&nbsp;</div>

		<div class="modal fade" id="staticBackdrop" data-backdrop="static"
			tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel"
			aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<div>
							<h5 class="modal-title" id="staticBackdropLabel">Please
								Confirm License Password</h5>
							</br>
							<div style="margin-top: 10px; color: red" id="errorConfirmMsg"></div>
							<div id="passerrormsg" style="color: red"></div>
						</div>


						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<!--mayur -->
						<input type="text" class="form-control" id="confirmpassword"
							name="confirmpassword" aria-describedby="emailHelp" required>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary"
							onclick="confirmPasswordValidation();">Save</button>
					</div>
				</div>
			</div>
		</div>
</form:form>
