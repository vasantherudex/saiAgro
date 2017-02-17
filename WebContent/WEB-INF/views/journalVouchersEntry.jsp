<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">
  <div class="wrapper">
   <form class="form-horizontal" method="post">
      <div class="content-wrapper">
       <section class="content-header">
         <h1>
            Free Mind Services<small>Working</small>
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
            <li class="active"><a href="#general_info" data-toggle="tab">Journal Voucher</a></li>
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
                    <label class="col-sm-2 control-label">J.V. No.<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <input type="text" class="form-control" placeholder="J.V. No." name="emp_uid" id="emp_uid" value="" onKeyUp="existedEmp(this.value)">
                    </div>
                    <label class="col-sm-3 control-label">Date<span class="required">*</span></label>
                    <div class="col-sm-4">
                    <input type="text" class="datepicker" name="emp_uid" id="emp_uid" value="" onKeyUp="existedEmp(this.value)">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-5">
                      <input type="button" id="add-row" class="btn btn-success pull-right" value="+ Add More">
                    </div>
                    <div class="col-sm-3">
                      <input type="reset" class="btn btn-danger" value="Delete">
                    </div>
                    <div class="col-sm-12 text-center" align="center">
                     <br>
                     <table class="table table-striped table-hover table-bordered " id="advice_product_table">
                      <thead>
                           <tr>
                              <th class="">#</th>
                              <th class="">Acd</th>
                              <th class="">Account Particulars</th>
                              <th class="">Db/Cr.</th>
                              <th class="">Amount</th>
                              <th class="">Remarks/Narration</th>
                            </tr>
                      </thead>
                      <tbody>
                          <tr>
                            <td><input type="checkbox" id="first_check_box" class="form-check-input" name=""></td>
                            <td><input type="text" class="form-control" id="item_name" name="item_name"></td>
                            <td><input type="text" class="form-control" id="brand" name="brand"></td>
                            <td><input type="text" class="form-control" id="model_no" name="model_no"></td>
                            <td><input type="text" class="form-control" id="qty" name="qty"></td>
                            <td><input type="text" class="form-control" id="mode_of_delivery" name="mode_of_delivery"></td>
                          </tr>
                      </tbody>
                     </table>                    
                    </div>
                    <div class="col-sm-4">
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">Debit Amt:<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <input type="text" class="form-control" placeholder="Credit Limit" name="phone">
                    </div> 
                    <label class="col-sm-2 control-label">Credit Amt:<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <input type="text" class="form-control" placeholder="Credit Days">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-3">
                      <input type="reset" class="btn btn-danger pull-right" value="cancel">
                    </div> 
                    <div class="col-sm-3">
                      <input type="submit" class="btn btn-success" value="save">
                    </div>
                  </div>
                </div>
                </div>
                </div>
             </div>
      </section>
    </div>
   </form>
 </div>
</body>
</html>