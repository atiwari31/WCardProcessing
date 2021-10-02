    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
   <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
 
   <div class="container my-5 table-div">
    <div align="center"> <Strong><font style="color:black;font-size:23px;">Profile Management</font></Strong></div>
    <div align="center"> <Strong><font style="color:red;font-size:18px;">${delmsg}</font></Strong></div>
    <div align="center"> <Strong><font style="color:green;font-size:18px;">${prupmsg}</font></Strong></div>
      <table class="table tablew">
        <thead>
          <tr>
            <th scope="col">No.</th>
            <th scope="col">User Profile</th>
            <th scope="col">Action</th>
           

          </tr>
        </thead>
        
        <tbody>
        <c:forEach var="userProfile" items="${userList}" varStatus="status">
          <tr>
            <td><c:out value="${status.count}" /></td>
            <td>${userProfile.profileName}</td>
            
             <td>
              <a data-toggle="modal" data-target="#staticBackdrop${userProfile.id}"><i class="fas fa-edit"></i></a>
             <!--  <a href="/userprofile/deleteuserprofile/${userProfile.id}"> <i class="fas fa-trash-alt delete"></i></a> 
              <a onclick="return confirm('Do You Want To Delete It?')" href="/userprofile/deleteuserprofile/${userProfile.id}"> <i class="fas fa-trash-alt delete"></i></a>-->
            	<a data-toggle="modal" data-target="#deletedrop${userProfile.id}"><i class="fas fa-trash-alt delete"></i></a>
            </td>
          </tr>
          
          
               <!-- user profile start -->
               
          <form:form action="/userprofile/updateuserprofile" method="post" modelAttribute="userProfileDto" id="updateuserprofile${userProfile.id}">
          <div class="modal fade" id="staticBackdrop${userProfile.id}" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <input type="hidden" name="id" value="${userProfile.id}">
     <div class="modal-dialog" role="document">
       <div class="modal-content">
         <div class="modal-header">
           <h5 class="modal-title" id="staticBackdropLabel">Edit Profile</h5>
           <button type="button" class="close" data-dismiss="modal" aria-label="Close">
             <span aria-hidden="true">&times;</span>
           </button>
         </div>
         <div class="modal-body">
          <div class="form-group">
          <h5 class="modal-title" id="staticBackdropLabel${userProfile.id}">Profile Name:<span class="required-field"></h5></span>
          <input type="text" class="form-control" name="profileName" id="profileName" aria-describedby="emailHelp" placeholder="Enter Profile Name" value="${userProfile.profileName}" required>
        </div>
       
        
	
        <div class="form-group">
          <h5 class="modal-title" id="staticBackdropLabel">Please Select Profile Features:<span class="required-field"></h5>
          <br>
           
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="scanning" name="scanning" value="SCANNING"  <c:if test="${userProfile.isSCAN}">checked</c:if>>
            <label class="form-check-label" for="inlineCheckbox1">Card Number Scanning :</label>
          </div>
         
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="ocr" name="ocr" value="OCR" <c:if test="${userProfile.isOCR}">checked</c:if>>
            <label class="form-check-label" for="inlineCheckbox2">Optical Character Recognition :</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="voice" name="voice" value="VOICE" <c:if test="${userProfile.isVOICE}">checked</c:if>>
            <label class="form-check-label" for="inlineCheckbox3">Voice Recognition :</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="all" name="all" value="ALL"  <c:if test="${userProfile.isALL}">checked</c:if>>
            <label class="form-check-label" for="inlineCheckbox3">All :</label>
          </div>
       
        </div>
    
         </div>
         <div class="modal-footer">
           <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
           <button type="submit" class="btn btn-primary" >Save</button>
         </div>
       </div>
     </div>
   </div>
       </form:form>
       
   <form:form action="/userprofile/deleteprofile" method="post" modelAttribute="userProfileDto" id="updateuserprofile${userProfile.id}">
          <div class="modal fade" id="deletedrop${userProfile.id}" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <input type="hidden" name="id" value="${userProfile.id}">
     <div class="modal-dialog" role="document">
       <div class="modal-content">
         <div class="modal-header">
           <h5 class="modal-title" id="staticBackdropLabel"></h5>
           <button type="button" class="close" data-dismiss="modal" aria-label="Close">
             <span aria-hidden="true">&times;</span>
           </button>
         </div>
         <div class="modal-body">
          	<h5 class="modal-title" id="staticBackdropLabel">Do You Want To Delete Profile?</h5>
    
         </div>
         <div class="modal-footer">
           <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
           <button type="submit" class="btn btn-primary" >Delete</button>
         </div>
       </div>
     </div>
   </div>
       </form:form>
   
          	</c:forEach>
          	<!-- user profile end -->
          	
          	
        </tbody>
      </table>
    </div>
   