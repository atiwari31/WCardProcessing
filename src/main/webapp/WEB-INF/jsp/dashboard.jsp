<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!doctype html>
<html lang="en">
  <head>

  <style>  
        .csserror {
        color:red
        }  
    </style>
    
    <style>
    .required-field::before {
  content: "*";
  color: red;
}
    </style>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
   
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" />
    <!-- External CSS -->
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <title>Card Reader</title>
  </head>
  <body>
    <!-- Start Navbar <img src="/img/download.jpg" alt="logo" />-->
   <tiles:insertAttribute name="header" />
    <!-- End Navbar -->

    <!-- table start -->
    <c:if test = "${userProfileListPage == 'userProfileListPage'}">
  		<tiles:insertAttribute name="body" />
 
    </c:if>

     <c:if test = "${userProfilePage == 'userProfilePage'}">
   			<tiles:insertAttribute name="body" />
    </c:if>
       <!-- table start -->
      <c:if test = "${customerAll == 'customerAll'}">
      
       <tiles:insertAttribute name="body" />
      
       
</c:if>

   <c:if test = "${addcustomerpageList == 'addcustomerpage'}">
   <tiles:insertAttribute name="body" />
     </c:if>
     
      <c:if test = "${addlicensepage == 'addlicensepage'}">
	      	  <tiles:insertAttribute name="body" />
</c:if>

  <!-- Modal -->

  
   
    <!-- Form end -->
    <!-- table end -->
    
     <!-- table start -->
      <c:if test = "${alllicense == 'alllicense'}">
       <tiles:insertAttribute name="body" />
</c:if>

<c:if test = "${adduserpage == 'adduserpage'}">
	      	  <tiles:insertAttribute name="body" />

</c:if>

  
         <!-- table start -->
      <c:if test = "${userAll == 'userAll'}">
        <tiles:insertAttribute name="body" />
    
      
   </c:if>

<tiles:insertAttribute name="footer" />
    <!-- End Footer -->

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
 	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
 

    <script type="text/javascript">

    function msgHidden(){
    	$('#errorConfirmMsg').empty();
    	 $('#passerrormsg').empty();
    }
  
    function confirmPasswordValidation(){
    	    	
       var val= document.getElementById("confirmpassword").value;
       if($("#day").prop("checked") && (document.getElementById("days").value==null || document.getElementById("days").value=="")){
    	   $('#errorConfirmMsg').html("Please Select Scanning Date");
    	   return false;
       } if(($("#date").prop("checked")) && (document.getElementById("licenseEndDate").value==null || document.getElementById("licenseEndDate").value=="")){
    	   $('#errorConfirmMsg').html("Please Select Date");
       }if(($("#user").prop("checked")) && (document.getElementById("hostip").value==null || document.getElementById("hostip").value=="")){
    	   $('#errorConfirmMsg').html("Please Fill Host IP");
       }else if(($("#user").prop("checked")) && (document.getElementById("startLicenseDate").value==null || document.getElementById("startLicenseDate").value=="")){
    	   $('#errorConfirmMsg').html("Please Select Start Date");
       }else if(($("#user").prop("checked")) && (document.getElementById("endLicenseDate").value==null || document.getElementById("endLicenseDate").value=="")){
    	   $('#errorConfirmMsg').html("Please Select End Date");
       }
       
    	var data = {};
     
        $.ajax({
            url : "/license/confirmpassword/"+val,
            success : function(data) {
                console.log("SUCCESS: ", data);
                display(data);
            },
            error : function(e) {
                console.log("ERROR: ", e);
                display(e);
            },
            done : function(e) {
                console.log("DONE");
            }
        });
    
    }
    
    function display(data) {
    	if(data!='success'){
    	 $('#passerrormsg').html(data);
    	 }else{
    		 $('#addcustomerlicense').submit(); 
    	 }
    
    }
    
      
    
    // handle click button
    function test() {
    
    	
        const rbs = document.querySelectorAll('input[name="licenseType"]');
        let selectedValue;
        for (const rb of rbs) {
            if (rb.checked) {
                selectedValue = rb.value;
           
                if(selectedValue=='day'){
                	document.getElementById("days").disabled =false;
                	document.getElementById("licenseEndDate").disabled =true;
                	document.getElementById("hostip").disabled =true;
                	document.getElementById("startLicenseDate").disabled =true;
                	document.getElementById("endLicenseDate").disabled =true;
                }
                if(selectedValue=='date'){
                	document.getElementById("licenseEndDate").disabled =false;
                	document.getElementById("days").disabled =true;
                	document.getElementById("hostip").disabled =true;
                	document.getElementById("startLicenseDate").disabled =true;
                	document.getElementById("endLicenseDate").disabled =true;
                }
                if(selectedValue=='host'){
                	document.getElementById("startLicenseDate").disabled =false;
                	document.getElementById("endLicenseDate").disabled =false;
                	document.getElementById("hostip").disabled =false;
                	document.getElementById("days").disabled =true;
                	document.getElementById("licenseEndDate").disabled =true;
                	
                }
                break;
            }
        }
        
    };

</script>
   
  </body>
</html>
