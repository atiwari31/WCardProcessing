<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
 <nav class="navbar navbar-expand-lg navbar-light nav-color">
 
    	<font style="color:white;font-size:25px"><c:if test = "${login.userType == 1}">Admin Dhashboard</c:if> <c:if test = "${login.userType == 2}">User Dhashboard</c:if></font></br>
      <a class="navbar-brand " href="#"></a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      	

      <div class="collapse navbar-collapse nav-text nav-dropdown" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
        <c:if test = "${login.userType == 1}">
          <li class="nav-item dropdown nav-list-color">
            <a class="nav-link dropdown-toggle nav-list-color" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
             Profile Management
            </a>
             
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="/userprofile/userProfilePage">Add Profile</a>
              <a class="dropdown-item" href="/admin/dashboard">View Profile</a>
            
            </div>
          </li></c:if>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Customer Management
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="/customer/addCustomerPage">Add Customer</a>
              <a class="dropdown-item" href="/customer/allcustomer">View Customer</a>
            
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              License Management 
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="/license/getlicensepage">Add License</a>
              <a class="dropdown-item" href="/license/getAllLicense">View License</a>
            
            </div>
          </li>
           <c:if test = "${login.userType == 1}">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              User Management 
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="/user/adduserpage">Add User</a>
              <a class="dropdown-item" href="/user/alluser">View User</a>
            
            </div>
          </li>   </c:if>
        </ul>

         <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="/card/logout"><i class="fa fa-power-off"></i> Logout</a>
          </li>
        </ul>
      </div>
    </nav>