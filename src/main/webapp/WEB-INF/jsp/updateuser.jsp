<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" />
    <!-- External CSS -->
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>


<form:form action="/user/updateuserpassword" method="post"  modelAttribute="user">


 <div class="container my-5 table-div">
 <div class="form-n"><Strong><font style="color: black; font-size: 23px;">Update User Password</font></Strong></div>
        <h3 class="form-n">Update User Password</h3>
        <c:if test = "${msg != null}"><div class="form-n"><font style="color:green;font-size: 18px;">${msg}</font></div></c:if>
        <c:if test = "${usermsg != null}"><div class="form-n"><font style="color:red;font-size: 18px;">${usermsg}</font></div></c:if>
        <c:if test = "${passmsg != null}"><div class="form-n"><font style="color:red;font-size: 18px;">${passmsg}</font></div></c:if>
        <c:if test = "${confmsg != null}"><div class="form-n"><font style="color:red;font-size: 18px;">${confmsg}</font></div></c:if>
        <div class="form-group">
        <div class="form-group ">
          <label for="exampleInputEmail1">User Name:<span class="required-field"></span></label>
          <input type="text" class="form-control"  aria-describedby="emailHelp" placeholder="Enter User name" name="username"  value="${username}" required >
        <form:errors path="username" cssClass="csserror"></form:errors>
        </div>
        </div>
        
         <div class="form-group">
          <label for="exampleInputPassword1">Old Password:<span class="required-field"></span></label>
          <div class="form-group">
          <input type="password" class="form-control"  placeholder="Enter Old Passsword" name="password" required>
        </div>
        </div>
  
         <div class="form-group">
          <label for="exampleInputPassword1">New Password:<span class="required-field"></span></label>
          <div class="form-group">
          <input type="password" class="form-control"  placeholder="Enter New Passsword" name="newpassword" required>
        </div>
        </div>
        
         <div class="form-group">
          <label for="exampleInputPassword1">Confirm Password:<span class="required-field"></span></label>
          <div class="form-group">
          <input type="Password" class="form-control"  placeholder="Enter confirm password" name="confirmpassword" required>
        </div>
        </div>
        
         <div>&nbsp;</div>
        <button type="submit" class="btn btn-danger">Cancel</button>
        <button type="submit" class="btn btn-primary">Submit</button>
    <div>&nbsp;</div>
    </div>
</form:form>








</html>
   <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
 	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
 