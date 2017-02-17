<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- DataTables -->
  <link rel="stylesheet" href="resources/plugins/datatables/dataTables.bootstrap.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
  <div class="wrapper">
   <form:form class="form-horizontal" action="saveProductInformation.html" method="post" commandName="product">
      <div class="content-wrapper">
       <section class="content-header">
         <h1>
            Free Mind Services<small>Product Opening Stock List</small>
         </h1>
         <ol class="breadcrumb">
           <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
           <li class="active">Here</li>
         </ol>
       </section>
       <section class="content">
          <!-- Custom Tabs -->
         <div class="nav-tabs-custom">
           <ul class="nav nav-tabs">
            <li class="active"><a href="#general_info" data-toggle="tab">Product Information</a></li>
            <li class="tabs"  style="display:none"  id="education_tab"><a href="#education" data-toggle="tab">Education</a></li>
            <li class="tabs"  style="display:none"  id="certification_tab"><a href="#certification" data-toggle="tab">Certifications</a></li>
            <li class="tabs"  style="display:none"  id="experience_tab"><a href="#experience" data-toggle="tab">Experience</a></li>
            <li class="tabs"  style="display:none" id="personal_tab" ><a href="#personel_details" data-toggle="tab">Personal Details</a></li>
            <li class="dropdown tabs"  style="display:none" id="family_tab" > <a class="dropdown-toggle" data-toggle="dropdown" href="#">Family Details<span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#father_info" data-toggle="tab">Father Info</a></li>
                <li><a href="#mother_info" data-toggle="tab">Mother Info</a></li>
                <li><a href="#partner_info" data-toggle="tab">Partner Info</a></li>
                <li><a href="#children_info" data-toggle="tab">Children Info</a></li>
                <li><a href="#siblings_info" data-toggle="tab">Siblings Info</a></li>
              </ul>
            </li>
            <li class="pull-right"><a href="#" class="text-muted"><i class="fa fa-gear"></i></a></li>
          </ul>
          <div class="tab-content">
            <div class="tab-pane active" id="general_info">
                <div class="box-body">
                  <h3 class="text-center">Available Opening Stock Products</h3>
                   
                   <table id="productListTable" class="table table-bordered table-hover dataTableList">
                      <thead>
		                <tr>
			              <th>Product Code</th>
			              <th>Product Name</th>
			              <th>Mfg Date</th>
			              <th>Exp Date</th>
			              <th>Opening Qty</th>
			              <th>Opening Rate</th>
			              <th>Action</th>
		                </tr>
		               </thead>
		               <tbody>
		               <c:if test="${!empty productOpeningStockList}">    
		                <c:forEach items="${productOpeningStockList}" var="product">
			             <tr>
				           <td><c:out value="${product.product_code}"/></td>
				           <td><c:out value="${product.product_name}"/></td>
				           <td><c:out value="${product.mfg_date}"/></td>
				           <td><c:out value="${product.exp_date}"/></td>
				           <td><c:out value="${product.opening_qty}"/></td>
				           <td><c:out value="${product.opening_rate}"/></td>
				           <td>
				            <div class="col-sm-3">
				            <button type="submit" formmethod="post" formaction='editProductOpeningStockEntry.html?product_opening_stock_id=<c:out value="${product.product_opening_stock_id}"/>' class="btn btn-default">Edit</button>
				           </div>
				            <div class="col-sm-2">
				            <button type="submit" formmethod="post" formaction='deleteProductOpeningStockEntry.html?product_opening_stock_id=<c:out value="${product.product_opening_stock_id}"/>' class="btn btn-danger">Delete</button>
				           </div>
				           </td>
			             </tr>
		                </c:forEach>
		               </c:if>
		               </tbody>
	                 </table>
                 
                </div>
                </div>
             </div>
             </div>
      </section>
    </div>
   </form:form>
 </div>
</body>
</html>
