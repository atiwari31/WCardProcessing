<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="fonts/icomoon/style.css">

    <link rel="stylesheet" href="/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="/css/style.css">

    <title>Card Reader</title>
  </head>
  <body class="login-main-div">
   <form:form name='loginForm'
          action="/card/loginAuthentication" method="POST" modelAttribute="login">

  
    <div class="content ">
      <div class="container">
        <div class="row align-items-center">
          <div class="col-md-5">
            <!-- <span class="d-block text-center my-4 text-muted"> or sign in with</span> -->
            <div class="social-login text-center">
              <h3 class="chg">Card Readers / Scanners</h3>
              <p class="chgs">We develop and provide high-quality and reliable smart card readers, based on various industry standards.</p>
            </div>

          </div>
          <div class="col-md-2 text-center">
            &mdash; or &mdash;
          </div>
          <div class="col-md-5 contents">
            <div class="form-block">
            <div class="mb-4 chgs">
                <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
        </c:if>
                  <h3><strong>Login</strong></h3>
                </div>
              
                  <div class="form-group first">
                   <input type="text" class="form-control login-input" id="username" name="username" placeholder="Username">

                  </div>                  
                  <div class="form-group last mb-4">
                   <input type="password" class="form-control login-input" id="password" name="password" placeholder="Password">
                    
                  </div>
                  
                  <div class="d-flex mb-5 align-items-center">
                    <label class="control control--checkbox mb-0"><span class="caption">Remember me</span>
                      <input type="checkbox" checked="checked"/>
                      <div class="control__indicator"></div>
                    </label>
                    <span class="ml-auto"><a href="#" class="forgot-pass">Forgot Password</a></span> 
                  </div>
					
                    
                  <input type="submit" value="Log In" class="btn btn-pill text-white btn-block btn-primary">

                  
                  
                  
                    
              </div>
          </div>
        </div>
      </div>
    </div>

  </form:form>
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/popper.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/main.js"></script>
  </body>
</html>