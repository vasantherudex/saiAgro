<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>
	<tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Akshara | Tender</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="resources/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
        page. However, you can choose any other skin. Make sure you
        apply the skin class to the body tag so the changes take effect.
  -->
  <link rel="stylesheet" href="resources/dist/css/skins/skin-blue.min.css">
  
  <!-- Date Picker css -->
  <link rel="stylesheet" href="resources/datepicker/datepicker.css">
  
  <!--      data table -->
  <link rel="stylesheet" href="resources/plugins/datatables/dataTables.bootstrap.css">
    
  <!-- Auto Complete css -->
  <link rel="stylesheet" href="assets/autoComplete/jquery-ui.min.css">
  
  <!--      custom -->
  <link rel="stylesheet" href="assets/custom/css/custom.css">
    
    

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
           <div>
              <tiles:insertAttribute name="header"></tiles:insertAttribute>
           </div>
           <div>
        	  <tiles:insertAttribute name="menu"></tiles:insertAttribute>
           </div>
           <div>
              <tiles:insertAttribute name="body"></tiles:insertAttribute>
           </div>
           <div>
              <tiles:insertAttribute name="footer"></tiles:insertAttribute>
           </div>
        	
</body>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 2.2.0 -->
<script src="resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="resources/dist/js/app.min.js"></script>
<!-- Datae Picker Js -->
<script src="resources/datepicker/bootstrap-datepicker.js"></script>
<!-- Check box and validations -->
<script src="resources/Validations/tenderFormValidations.js"></script>

<script src="resources/student/studentVal.js"></script>

<!-- tender Validations -->
<script src="assets/validations/tender.js"></script>

<!-- Product Validations -->
<script src="assets/validations/product.js"></script>

<!--       Data Table -->
<script src="resources/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="resources/plugins/datatables/dataTables.bootstrap.min.js"></script>

<!--  custom js -->
<script src="assets/custom/js/custom.js"></script>

<!-- Auto Complete JS  -->
<script src="assets/autoComplete/jquery-ui.min.js"></script>

<!--  productOpeningStockEntry -->
<script src="assets/validations/productOpeningStockEntry.js"></script>

<!--  materialReceivedEntry -->
<script src="assets/validations/materialReceivedEntry.js"></script>

<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. Slimscroll is required when using the
     fixed layout. -->
<script>
 runproductListTable();
 function runproductListTable()
 {
 $('.dataTableList').DataTable();
 }
 </script>
 <script>
   $('.datepicker').datepicker({
	      autoclose: true
	    });

   </script>

</html>