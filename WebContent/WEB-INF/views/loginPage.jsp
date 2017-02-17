<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="resources/dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="resources/plugins/iCheck/square/blue.css">
</head>
<body>
   <div class="login-box">
  <div class="login-logo">
<!--     <a href="http://erudex.com/"><b>Akshara</b>Enterprises</a> -->
<div class=""><b>Sai</b>Agro</div>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg">Sign in to start your session</p>
    <c:if test="${error != null}">
        <div class="control-label required alert alert-danger">${error}</div>
    </c:if>
    <c:if test="${message != null}">
        <div class="control-label required alert alert-success">${message}</div>
    </c:if>
    <c:if test="${warning != null}">
        <div class="control-label required alert alert-warning">${warning}</div>
    </c:if>
    <form:form action="login.html" method="post">
      <div class="form-group has-feedback">
        <input type="text" class="form-control" name="user_name" placeholder="User name">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" name="password" placeholder="Password">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <!-- <div class="col-sm-8">
          <div class="checkbox icheck pull-left">
          </div>
        </div> -->
        <!-- /.col -->
        <div class="col-sm-4 pull-right">
            <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>          
        </div>
        <!-- /.col -->
        <div class="col-sm-4">
          <button type="reset" class="btn btn-danger btn-block btn-flat">Cancel</button>
        </div>
        <!-- /.col -->
      </div>
    </form:form>
  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->
<!-- jQuery 2.2.0 -->
<script src="resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>

<!-- Bootstrap 3.3.6 -->
<script src="resources/bootstrap/js/bootstrap.min.js"></script>

<!-- I check -->
<script src="resources/plugins/iCheck/icheck.min.js"></script>
</body>
</body>
</html>
