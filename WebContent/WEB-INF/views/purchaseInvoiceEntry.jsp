<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">
  <div class="wrapper">
  <form:form class="form-horizontal" action="savePurchaseInvoiceEntry.html" method="post" commandName="materialReceivedEntry">
      <div class="content-wrapper">
       <section class="content-header">
         <h1>
            Free Mind Services<small>Material Received Entry</small>
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
            <li class="active"><a href="#general_info" data-toggle="tab">Purchase Invoice Entry</a></li>
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
                  <div class="form-group">
                    <label class="col-sm-2 control-label">Voucher No:<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <form:input type="text" class="form-control" id="voucher_no" placeholder="Voucher No" path="voucher_no" />
                      <form:hidden  path="material_received_entry_id" />
                    </div> 
                    <label class="col-sm-2 control-label">Transaction Date:<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <form:input type="text" class="datepicker" path="transaction_date"/>
<%--                          <form:input type="text" class="form-control" placeholder="Dc No" path="dc_no"/> --%>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">Supplier Code:<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <form:input type="text" class="form-control" placeholder="Supplier Code" id="supllier_code" path="supplier_code" onKeypress="getSupplierCode(this.value);"/>
                    </div> 
                    <label class="col-sm-2 control-label">Supplier Name:<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <form:input type="text" class="form-control" placeholder="Supplier Name" id="supplier_name" path="supplier_name"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">DC No:<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <form:input type="text" class="form-control" placeholder="Dc No" path="dc_no"/>
                    </div> 
                    <label class="col-sm-2 control-label">Dc Date:<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <form:input type="text" class="datepicker" path="dc_date"/>
                    </div>
                  </div>
                  </div>
                <div class="box-body">
                 <div class="col-sm-12">
                  <label class="col-sm-2 control-label"></label>
                  <div class="col-sm-14">
                  <table id="example1" class="table">
                    <thead>
                      <tr>
                         <th class="col-sm-1">P.Code</th>
                         <th class="col-sm-1">Description</th>
                         <th class="col-sm-1">Technical</th>
                         <th class="col-sm-1">Packing</th>
                         <th class="col-sm-1">Quantity</th>
                         <th class="col-sm-1">Rate</th>
                         <th class="col-sm-1">Batch</th>
                         <th class="col-sm-2">MfgDate</th>
                         <th class="col-sm-2">Expiry Date</th>
                      </tr>
                      <tr>
                        <!-- <th class="col-sm-1"><input type="text" placeholder="ProductCode" name="product_code" id="product_code" class="form-control product_code" onKeyup="getProducts(this.value);"></th>
                        <th class="col-sm-2"><input type="text" placeholder="Description" name="product_name" id="product_name" class="form-control product_name"></th>
                        <th class="col-sm-1"><input type="text" placeholder="Technical" name="technical_name" id="technical_name" class="form-control technical_name"></th>
                        <th class="col-sm-1"><input type="text" placeholder="Packing" name="packing_name" id="packing_name" class="form-control packing_name"></th>
                        <th class="col-sm-1"><input type="text" placeholder="Quantity" name="quantity" id="quantity" class="form-control" ></th>
                        <th class="col-sm-1"><input type="text" placeholder="Rate" name="sale_rate" id="sale_rate" class="form-control" ></th>
                        <th class="col-sm-1"><input type="text" placeholder="Batch" name="batch" id="batch" class="form-control" ></th>
                        <th class="col-sm-2"><input type="text" placeholder="MfgDate" name="batch" id="batch" class="form-control" ></th>
                        <th class="col-sm-2"><input type="text" placeholder="ExpDate" name="sale_rate" id="sale_rate" class="form-control sale_rate" onkeydown="addMoreProduct(event);"></th> -->
                      </tr>
                      <tr id="addEmailRow"></tr>
                    <thead>
                   </table>
                  </div>
                 </div>
                </div>
                <div class="box-body">
                  <div class="form-group">
                   <div class="col-sm-5">
                      <button type="submit" formmethod="post" formaction="materialRecievedEntryList.html" class="btn btn-success pull-right">View</button>
                    </div> 
                    <div class="col-sm-3">
                      <input type="reset" class="btn btn-danger pull-right" value="cancel">
                    </div> 
                    <div class="col-sm-3">
                      <input type="submit" class="btn btn-success" id="saveMaterialReceivedEntry" disabled value="save">
                    </div>	
                  </div>
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