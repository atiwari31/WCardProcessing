<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div class="container my-5 table-div">
	<div align="center">
		<Strong><font style="color: black; font-size: 18px;">Customer
				Management</font></Strong>
	</div>
	<div class="form-n">
		<Strong><font style="color: green; font-size: 18px;">${updateMsg}</font></Strong>
	</div>
	<div class="form-n">
		<Strong><font style="color: red; font-size: 18px;">${cdelmsg}</font></Strong>
	</div>

	<table class="table tablew">
		<thead>
			<tr>
				<th scope="col">No.</th>
				<th scope="col">Customer Name</th>
				<th scope="col">Address</th>
				<th scope="col">Mobile</th>
				<th scope="col">Email</th>
				<th scope="col">Contact Person</th>
				<th scope="col">Action</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="user" items="${customerList}" varStatus="status">
				<tr>
					<th scope="row"><c:out value="${status.count}" /></th>
					<td>${user.customerName}</td>
					<td>${user.address}</td>
					<td>${user.mobile}</td>
					<td>${user.email}</td>
					<td>${user.contactPerson}</td>
					<td><a href="" data-toggle="modal"
						data-target="#staticBackdrop${user.id}"><i class="fas fa-edit"></i></a>
						<a href="" data-toggle="modal" data-target="#deletedrop${user.id}"><i
							class="fas fa-trash-alt delete"></i></a></td>
				</tr>
				<form:form action="/customer/updatecustomer" method="post"
					modelAttribute="customerDto">
					<div class="modal fade" id="staticBackdrop${user.id}"
						data-backdrop="static" tabindex="-1" role="dialog"
						aria-labelledby="staticBackdropLabel" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="staticBackdropLabel">Edit
										Customer</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">

									<div class="form-group">
										<div class="form-group">
											<label for="exampleInputEmail1">Customer Name:<span
												class="required-field"></span></label> <input type="text"
												class="form-control" id="exampleInputEmail1"
												aria-describedby="emailHelp" placeholder="Enter name"
												name="customerName" value="${user.customerName}" required>
											<input type="hidden" value="${user.id}" name="id">
											<form:errors path="customerName" cssClass="csserror"></form:errors>
										</div>
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">Address:<span
											class="required-field"></span></label>
										<div class="form-group">
											<input type="text" class="form-control"
												id="exampleInputPassword1" placeholder="Enter Address"
												name="address" value="${user.address}" required>
											<form:errors path="address" cssClass="csserror"></form:errors>
										</div>
									</div>
									<div class="form-group">
										<div class="form-group">
											<label for="exampleInputPassword1">Email:<span
												class="required-field"></span></label> <input type="email"
												class="form-control" id="exampleInputPassword1"
												placeholder="Enter email" name="email" value="${user.email}"
												required>
											<form:errors path="email" cssClass="csserror"></form:errors>
										</div>
									</div>

									<div class="form-group">
										<div class="form-group">
											<label for="exampleInputPassword1">Mobile Number:<span
												class="required-field"></span></label> <input type="text"
												class="form-control" id="exampleInputPassword1"
												placeholder="Enter Mobile Number" name="mobile"
												value="${user.mobile}" pattern="[7-9]{1}[0-9]{9}"
												title="Please Fill Correct Mobile Number" required>
											<form:errors path="mobile" cssClass="csserror"></form:errors>
										</div>
									</div>
									<div class="form-group">
										<div class="form-group">
											<label for="exampleInputPassword1">Contact Person
												Name:<span class="required-field"></span>
											</label> <input type="text" class="form-control"
												id="exampleInputPassword1" placeholder="Contact Person Name"
												name="contactPerson" value="${user.contactPerson}" required>
											<form:errors path="contactPerson" cssClass="csserror"></form:errors>
										</div>
									</div>
									<div class="form-group">
										<div class="form-group">
											<label for="exampleInputPassword1">Contact Person
												number:<span class="required-field"></span>
											</label> <input type="number" class="form-control"
												id="exampleInputPassword1" placeholder="Enter mobile number"
												name="contactMobile" value="${user.contactMobile}"
												pattern="[7-9]{1}[0-9]{9}"
												title="Please Fill Correct Mobile Number" required>
											<form:errors path="contactMobile" cssClass="csserror"></form:errors>
										</div>
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1" style="margin-top: -50px">Please
											Select Profile:<span class="required-field"></span>
										</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

										<select name="profile" id="profile" multiple>
											<c:forEach items="${user.userProfileList}" var="userProfile1">
												<c:forEach items="${user.userProfile}" var="userProfile2">
													<c:choose>
														<c:when test="${userProfile2.id==userProfile1.id}">
															<option value="${userProfile1.id}" selected>${userProfile1.profileName}</option>
														</c:when>
														<c:otherwise>
															<option value="${userProfile1.id}">${userProfile1.profileName}</option>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Close</button>
									<button type="submit" class="btn btn-primary">Save</button>
								</div>


							</div>
						</div>
					</div>
				</form:form>
				<form:form action="/customer/deletecustomer" method="post"
					modelAttribute="customerDto" id="customerDto${user.id}">
					<div class="modal fade" id="deletedrop${user.id}"
						data-backdrop="static" tabindex="-1" role="dialog"
						aria-labelledby="staticBackdropLabel" aria-hidden="true">
						<input type="hidden" name="id" value="${user.id}">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="staticBackdropLabel"></h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<h5 class="modal-title" id="staticBackdropLabel">Do You
										Want To Delete Customer?</h5>

								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Cancel</button>
									<button type="submit" class="btn btn-primary">Delete</button>
								</div>
							</div>
						</div>
					</div>
				</form:form>
			</c:forEach>
		</tbody>
	</table>

</div>
