<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
   <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
 
  <form:form action="/user/addusers" method="post" id="saveUser" modelAttribute="rag">

<!-- #FF9800 -->
 <div class="container my-5 table-div">
<div class="form-n"><Strong><font style="color: black; font-size: 23px;">Add New User</font></Strong></div>
        <!-- <h3 class="form-n">Add New User </h3> -->
  		<c:if test = "${exragmsg != null}"><div class="form-n"><span style="margin-left:50px"><Strong><font style="color:#FF9800;font-size: 18px;">${exragmsg}</font></Strong></span></div></c:if>
  		<c:if test = "${usermsg != null}"><div class="form-n"><span style="margin-left:50px"><Strong><font style="color:#FF9800;font-size: 18px;">${usermsg}</font></Strong></span></div></c:if>
  		<c:if test = "${pragmsg != null}"><div class="form-n"><span style="margin-left:50px"><Strong><font style="color:#FF9800;font-size: 18px;">${pragmsg}</font></Strong></span></div></c:if>
  		<c:if test = "${ragmsg != null}"><div class="form-n"><span style="margin-left:50px"><Strong><font style="color:green;font-size: 18px;">${ragmsg}</font></Strong></span></div></c:if>
        <div class="form-group">
        <div class="form-group ">
          <label for="exampleInputEmail1">User Name:<span class="required-field"></span></label>
          <input type="email" class="form-control"  aria-describedby="emailHelp" placeholder="Enter User name" name="username"  value="${rag.username}" required>
        <form:errors path="username" cssClass="csserror"></form:errors>
        </div>
        </div>
        
         <div class="form-group">
          <label for="exampleInputPassword1">Mobile No:<span class="required-field"></span></label>
          <div class="form-group">
          <input type="number" class="form-control"  placeholder="Enter Mobile No" name="mobile" value="${rag.mobile}" required >
        </div>
        </div>
  
         <div class="form-group">
          <label for="exampleInputPassword1">Password:<span class="required-field"></span></label>
          <div class="form-group">
          <input type="password" class="form-control"  placeholder="Enter Passsword" name="password" required>
         
        </div>
        </div>
        
         <div class="form-group">
          <label for="exampleInputPassword1">Confirm Password:<span class="required-field"></span></label>
          <div class="form-group">
          <input type="Password" class="form-control"  placeholder="Enter Confirm Password" name="confirmPassword" required>
          
        </div>
        </div>
        
        
        <div class="form-group">
          <label for="exampleInputPassword1">License Password:<span class="required-field"></span></label>
          <div class="form-group">
          <input type="Password" class="form-control" placeholder="Enter License Password" name="licensePassword" required>
        </div>
        </div>
        
        
         <div>&nbsp;</div>
        <button type="submit" class="btn btn-danger">Cancel</button>
        <button type="submit" class="btn btn-primary" >Submit</button>
    <div>&nbsp;</div>
    </div>
</form:form>

  