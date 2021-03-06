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
   <form:form class="form-horizontal" action="saveProductInformation.html" method="post" commandName="product">
      <div class="content-wrapper">
       <section class="content-header">
         <h1>
            Free Mind Services<small>Product Information Master</small>
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
                  <div class="form-group">
                    <label class="col-sm-2 control-label">Product Code:<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <form:input type="text" class="form-control" placeholder="Product Code" value="${product.product_code}" path="product_code"/>
                      <form:input type="hidden" path="product_id"/>
                    </div> 
                    <label class="col-sm-2 control-label">Product Name:<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <form:input type="text" class="form-control" placeholder="Product Name" path="product_name"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">Technical Name:<span class="required">*</span></label>
                    <div class="col-sm-8">
                       <form:select class="form-control" path="technical_id">
                         <form:option value="" label="Select Technical Name"/>
                         <form:options items="${technicalList}" />
                       </form:select>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">Packing:<span class="required">*</span></label>
                    <div class="col-sm-3">
                       <form:select class="form-control" path="packing_id">
                         <form:option value="" label="Select Packing"/>
                         <form:options items="${packingList}" />                         
                       </form:select>
                    </div> 
                    <label class="col-sm-2 control-label">Category:<span class="required">*</span></label>
                    <div class="col-sm-3">
                       <form:select class="form-control" path="catagory_id">
                         <form:option value="" label="select Category"/>
                         <form:options items="${catagoryList}" /> 
                       </form:select>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">Company Code:<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <form:input type="text" class="form-control" placeholder="Company Code" path="company_code"/>
                    </div> 
                    <label class="col-sm-2 control-label">Quantity On Hand:<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <form:input type="text" path="quantity_on_hand" class="form-control" placeholder="Quantity on hand"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">Purchase Rate:<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <form:input type="text" class="form-control" placeholder="Purchase Rate" path="purchase_rate"/>
                    </div> 
                    <label class="col-sm-2 control-label">Sale Rate:<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <form:input type="text" class="form-control" placeholder="Sale Rate" path="sale_rate"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">Max Retail Price:<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <form:input path="mrp" type="text" class="form-control" placeholder="Max retail price" />
                    </div> 
                    <label class="col-sm-2 control-label">V A T %:<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <form:input type="text" path="vat" class="form-control" placeholder="V A T %"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-5">
                      <button type="submit" formmethod="post" formaction="productList.html" class="btn btn-success pull-right">View</button>
                    </div> 
                    <div class="col-sm-1">
                      <input type="reset" class="btn btn-danger" value="Clear">
                    </div> 
                    <div class="col-sm-2">
                      <input type="submit" class="btn btn-primary" value="save">
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