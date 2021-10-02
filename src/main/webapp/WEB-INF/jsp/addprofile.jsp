     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
   <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
 
 <div class="container my-5 table-div">
      
	<form:form action="/userprofile/adduserprofile" method="post" modelAttribute="userProfileDto">
	<div class="form-n"><Strong><font style="color: black; font-size: 23px;">Add Profile</font></Strong></div>
       <!-- <h3 class="form-n">Add Profile </h3> -->
       <c:if test = "${msg != null}"><div class="form-n"><Strong><font style="color:green;font-size: 18px;">${msg}</font></Strong></div> </c:if>
        <div class="form-group">
        <div class="form-group ${status.error ? 'has-error' : ''}">
          <label for="exampleInputEmail1"><h5>Profile Name:<span class="required-field"></h5></span></h5></label>
          <input type="text" class="form-control" name="profileName" id="profileName" aria-describedby="emailHelp" placeholder="Enter Profile Name" value="${userProfileDto.profileName}" required>
        <form:errors path="profileName" cssClass="csserror"></form:errors>
        </div>
        </div>
        
        <div class="form-group">
          <label for="exampleInputPassword1"><h5>Please Select Profile Features :<span class="required-field"/></h5></label>
          <br>
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="scanning" name="scanning" value="SCANNING">
            <label class="form-check-label" for="inlineCheckbox1">Card Number Scanning :</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="ocr" name="ocr" value="OCR">
            <label class="form-check-label" for="inlineCheckbox2">Optical Character Recognition :</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="voice" name="voice" value="VOICE">
            <label class="form-check-label" for="inlineCheckbox3">Voice Recognition :</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="all" name="all" value="ALL">
            <label class="form-check-label" for="inlineCheckbox3">All :</label>
          </div>
         
     
        </div>
        <div style="margin-top:-10px"><font style="color:red"> ${ErrorMsg}</font></div>
         <div>&nbsp;</div>
        <button type="submit" class="btn btn-danger">Cancel</button>
        <button type="submit" class="btn btn-primary">Submit</button>
        
     </form:form>
     <div>&nbsp;</div>
    </div>
   