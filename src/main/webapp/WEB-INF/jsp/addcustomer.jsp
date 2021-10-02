<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<form:form action="/customer/addcustomer" method="post"

	modelAttribute="customerDto">
	<div class="container my-5 table-div">
		<div class="form-n">
			<Strong><font style="color: black; font-size: 23px;">Add
					New Customer</font></Strong>
		</div>
		<!--  <h3 class="form-n">Add New Customer</h3> -->
		<div class="form-n">
			<Strong><font style="color: green; font-size: 18px;">${msg}</font></Strong>
		</div>
		<div class="form-n">
			<Strong><font style="color: red; font-size: 18px;">${isUserErrorMsg}</font></Strong>
		</div>
		<div class="form-group">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label for="exampleInputEmail1">Customer Name:<span
					class="required-field"></span></label> <input type="text"
					class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter name"
					name="customerName" value="${customerDto.customerName}" required>
				<form:errors path="customerName" cssClass="csserror"></form:errors>
			</div>
		</div>

		<div class="form-group">
			<label for="exampleInputPassword1">Address:<span
				class="required-field"></span></label>
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<input type="text" class="form-control" id="exampleInputPassword1"
					placeholder="Enter Address" name="address"
					value="${customerDto.address}" required>
				<form:errors path="address" cssClass="csserror"></form:errors>
			</div>
		</div>
		<div class="form-group">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label for="exampleInputPassword1">Email:<span
					class="required-field"></span></label> <input type="email"
					class="form-control" id="exampleInputPassword1"
					placeholder="Enter email" name="email" value="${customerDto.email}"
					required>
				<form:errors path="email" cssClass="csserror"></form:errors>
			</div>
		</div>
		<div class="form-group">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label for="exampleInputPassword1">Mobile Number:<span
					class="required-field"></span></label> <input type="text"
					class="form-control" id="exampleInputPassword1"
					placeholder="Enter Mobile Number" name="mobile"
					value="${customerDto.mobile}" pattern="[7-9]{1}[0-9]{9}"
					title="Please Fill Correct Mobile Number" required>
				<form:errors path="mobile" cssClass="csserror"></form:errors>
			</div>
		</div>
		<div class="form-group">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label for="exampleInputPassword1">Contact Person Name:<span
					class="required-field"></span></label> <input type="text"
					class="form-control" id="exampleInputPassword1"
					placeholder="Contact Person Name" name="contactPerson"
					value="${customerDto.contactPerson}" required>
				<form:errors path="contactPerson" cssClass="csserror"></form:errors>
			</div>
		</div>
		<div class="form-group">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label for="exampleInputPassword1">Contact Person number:<span
					class="required-field"></span></label> <input type="text"
					class="form-control" id="exampleInputPassword1"
					placeholder="Enter mobile number" name="contactMobile"
					value="${customerDto.contactMobile}" pattern="[7-9]{1}[0-9]{9}"
					title="Please Fill Correct Mobile Number" required>
				<form:errors path="contactMobile" cssClass="csserror"></form:errors>
			</div>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1" style="margin-top: -50px">Please
				Select Profile:<span class="required-field"></span>
			</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<select name="profile" id="profile" multiple>
				<c:forEach items="${userProfileListPage}" var="userProfileList">
					<option value="${userProfileList.id}">${userProfileList.profileName}</option>
				</c:forEach>
			</select>
		</div>
		<div style="margin-top: -10px">
			<font style="color: red"> ${ErrorMsg}</font>
		</div>
		<div>&nbsp;</div>
		<button type="submit" class="btn btn-danger">Cancel</button>
		<button type="submit" class="btn btn-primary">Submit</button>
		<div>&nbsp;</div>
	</div>

</form:form>
