<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div class="container my-5 table-div">
	<div align="center">
		<Strong><font style="color: black; font-size: 23px;">License
				Management</font></Strong>
	</div>

	<table class="table tablew">
		<thead>
			<tr>
				<th scope="col">No.</th>
				<th scope="col">Customer Name</th>
				<th scope="col">License Scanning</th>
				<th scope="col">Date Wise</th>
				<th scope="col">Number Of Host IP</th>
				<th scope="col">Start Date</th>
				<th scope="col">End Date</th>
				<th scope="col">Created By</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="customerLicenseEntityList"
				items="${customerLicenseEntityList}" varStatus="status">
				<tr>
					<th scope="row"><c:out value="${status.count}" /></th>
					<td>${customerLicenseEntityList.customerName}</td>

					<td>${customerLicenseEntityList.days}</td>

					<td><c:if
							test="${customerLicenseEntityList.days eq null && customerLicenseEntityList.hostIp eq null && customerLicenseEntityList.endDate ne null}">${customerLicenseEntityList.endDate}</c:if></td>


					<td><c:if test="${customerLicenseEntityList.hostIp ne null}">${customerLicenseEntityList.hostIp}</c:if></td>
					<td><c:if
							test="${customerLicenseEntityList.startDate ne null}">${customerLicenseEntityList.startDate}</c:if></td>
					<td><c:if test="${customerLicenseEntityList.endDate ne null}">${customerLicenseEntityList.endDate}</c:if></td>

					<td>${customerLicenseEntityList.user.username}</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
</div>
