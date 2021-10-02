<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div class="container my-5 table-div">
	<div class="form-n">
		<Strong><font style="color: black; font-size: 23px;">User
				Management</font></Strong>
	</div>
	<c:if test="${ragmsg != null}">
	<div class="form-n">
		<Strong><font style="color: green; font-size: 18px;">${ragmsg}</font></Strong>
	</div></c:if>
	<c:if test="${delragmsg != null}">
	<div class="form-n">
		<Strong><font style="color: red; font-size: 18px;">${delragmsg}</font></Strong>
	</div></c:if>

	<table class="table tablew">
		<thead>
			<tr>
				<th scope="col">No.</th>
				<th scope="col">User Name</th>
				<th scope="col">Action</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="user" items="${userList}" varStatus="status">
				<tr>
					<th scope="row"><c:out value="${status.count}" /></th>
					<td>${user.username}</td>

					<td><a data-toggle="modal"
						data-target="#staticBackdrop${user.id}"><i class="fas fa-edit"></i></a>
						<a data-toggle="modal" data-target="#deletedrop${user.id}"><i
							class="fas fa-trash-alt delete"></i></a> 
						
							<form:form
							action="/user/updateusers" method="post" modelAttribute="rag">
							<div class="modal fade" id="staticBackdrop${user.id}"
								data-backdrop="static" tabindex="-1" role="dialog"
								aria-labelledby="staticBackdropLabel" aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="staticBackdropLabel">Edit
												User</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body" align="left">
											<input type="hidden" value="${user.id}" name="id">
											<div class="form-group ">
												<label for="exampleInputEmail1"> User Name:<span
													class="required-field"></span></label>
												<div class="form-group ">
													<input type="email" class="form-control"
														aria-describedby="emailHelp" placeholder="Enter User name"
														name="username" value="${user.username}" required>
												</div>
											</div>

											<div class="form-group">
												<label for="exampleInputPassword1">Mobile No:<span
													class="required-field"></span></label>
												<div class="form-group">
													<input type="number" class="form-control"
														placeholder="Enter Mobile No" name="mobile"
														value="${user.mobile}" required>
												</div>
											</div>

											<div class="form-group">
												<label for="exampleInputPassword1">Password:<span
													class="required-field"></span></label>
												<div class="form-group">
													<input type="password" class="form-control"
														placeholder="Enter Passsword" name="password"
														value="${user.password}" required>
												</div>
											</div>

											<div class="form-group">
												<label for="exampleInputPassword1">License Password:<span
													class="required-field"></span></label>
												<div class="form-group">
													<input type="Password" class="form-control"
														placeholder="Enter License Password"
														name="licensePassword" value="${user.licensePassword}"
														required>
												</div>
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
						</form:form></td>
				</tr>
				
				<form:form action="/user/deleteuser" method="post"
					modelAttribute="rag" id="rag${userProfile.id}">
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
										Want To Delete User?</h5>

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
</body>
			</c:forEach>
		</tbody>
	</table>
</div>
