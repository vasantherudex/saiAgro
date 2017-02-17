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
   <form:form class="form-horizontal" action="saveAccounts.html" method="post" commandName="accounts">
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
            <li class="active"><a href="#general_info" data-toggle="tab">Accounts</a></li>
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
                    <label class="col-sm-2 control-label">Account Code<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <span class="required" id="exist_show"></span>
                      <form:input type="text" class="form-control" placeholder="Account Code" path="account_code" id="account_code" value="${accounts.account_code}"/>
                      <form:hidden path="account_id" id="account_id"/>
                    </div>
                    <label class="col-sm-2 control-label">Account Type<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <form:select class="form-control" path="account_type_id">
                        <form:option value="" label="Select Account Type"/>
                        <form:options items="${accountTypeList}"/>
                      </form:select>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">Account Name <span class="required">*</span></label>
                    <div class="col-sm-8">
                      <form:input type="text" class="form-control" placeholder="Account Name" path="account_name" id="account_name" value="${accounts.account_name}"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">Contact Person<span class="required">*</span></label>
                    <div class="col-sm-8">
                      <form:input class="form-control"  type="text" path="contact_person" placeholder="Contact Person" value="${accounts.contact_person}"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">House No/Do No.<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <form:input type="text" class="form-control" placeholder="House No/DO No" path="house_no"  value="${accounts.house_no}"/>
                      <span class="required" id="exist_show"></span>
                    </div>
                    <label class="col-sm-2 control-label">Street Name:<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <form:input type="text" class="form-control" placeholder="Street Name" path="street_name" id="street_name" value="${accounts.street_name}"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">Area<span class="required">*</span></label>
                    <div class="col-sm-8">
                      <form:input class="form-control"  id="area" type="text" path="area" placeholder="Area" value="${accounts.area}"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">State <span class="required">*</span></label>
                    <div class="col-sm-8">
                      <form:select class="form-control" path="state_id" onChange="getDistricts(this.value)">
                         <form:option value="" label="Please Select State"/>
                         <form:options  items="${stateList}"/> 
                       </form:select>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">District<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <form:select class="form-control" path="district_id" id="district_id">
                        <form:option value="" label="Please Select District"/>
                        <form:options value="" items="${districtList}"/>
                      </form:select>
                    </div>
                    <label class="col-sm-2 control-label">Pin code:<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <form:input type="text" class="form-control" path="pin_code" placeholder="Pin Code" value="${accounts.pin_code}"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">Route code:<span class="required">*</span></label>
                    <div class="col-sm-8">
                      <form:select class="form-control" path="route_code_id" id="route_code_id">
                        <form:option value="" label="Select Route Code"/>
                        <form:options items="${routeCodeList}"/>
                       </form:select>
                    </div> 
                  </div>
                 </div>
                <div class="box-body">
                 <div class="col-sm-10">
                  <label class="col-sm-2 control-label"></label>
                  <div class="col-sm-8">	
                  <label class="col-sm-4"><strong>Phone:</strong><span class="required">*</span></label>
                  <table id="example1" class="table">
                    <thead>
                     <c:forEach items="${phoneList}" var="phone">
                      <tr>
                        <th class="col-xs-5"><input type="text" class="form-control" name="phone_no" placeholder="Phone No" value="<c:out value="${phone.phone_no}"/>"><input type="hidden" class="form-control" name="phone_id" value="<c:out value="${phone.phone_id}"/>"></th>
                        <th class="col-xs-5">
                          <select class="form-control" name="phone_type" <c:out value="${phone.phone_no}"/>>
                            <option value="Personal" label="Personal"></option>
                            <option value="Other">Other Value</option>
                          </select>
                       </th>
                        <th class="col-xs-5"><input type="button" value="Delete" class="btn btn-danger deletePhone" id="delete" id="delete" onClick="deleteRow($(this));"></th>
                      </tr>
                     </c:forEach>
                      <tr id="addPhoneRow"></tr>
                      <tr>
                        <th class="col-sm-4"><input type="button" value="+" class="btn btn-success" id="addPhoneButton"></th>
                        <th class="col-sm-4"></th>
                        <th class="col-sm-2"></th>
                      </tr>
                    <thead>
                  </table>
                  </div>
                 </div>
                </div>
                
                <div class="box-body">
                 <div class="col-sm-10">
                  <label class="col-sm-2 control-label"></label>
                  <div class="col-sm-8">
                  <label class="col-sm-4"><strong>Email:</strong><span class="required">*</span></label>
                  <table id="example1" class="table">
                    <thead>
                    <c:forEach items="${emailList}" var="email">
                      <tr>
                        <th class="col-xs-5"><input type="text" class="form-control" name="email" placeholder="Email Id" value="<c:out value="${email.email}"/>"><input type="hidden" class="form-control" name="email_id" value="<c:out value="${email.email_id}"/>"></th>
                        <th class="col-xs-5 ">
                          <select class="form-control" name="email_type" id="email_type" <c:out value="${email.email_type}"/>>
                            <option value="" label="Select Email Type"></option>
                            <option value="Other">Other Value</option>
                          </select>
                       </th>
                        <th class="col-xs-5"><input type="button" value="Delete" class="btn btn-danger deletePhone" id="delete" id="delete" onClick="deleteRow($(this));"></th>
                      </tr>
                     </c:forEach>
                      <tr id="addEmailRow"></tr>
                      <tr>
                        <th class="col-sm-4"><input type="button" value="+" class="btn btn-success" id="addEmailButton"></th>
                        <th class="col-sm-4"></th>
                        <th class="col-sm-2"></th>
                      </tr>
                    <thead>
                  </table>
                  </div>
                 </div>
                </div>
                <div class="box-body">
                  <div class="form-group">
                    <label class="col-sm-2 control-label">APGST No.<span class="required">*</span></label>
                    <div class="col-sm-8" >
                       <form:input type="text" class="form-control" placeholder="APGST No." path="apgst_no" id="district" value="${accounts.apgst_no}"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">CST No.<span class="required">*</span></label>
                    <div class="col-sm-8" >
                       <form:input type="text" class="form-control" placeholder="CST No." path="cst_no" id="district" value="${accounts.cst_no}"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">PAN No.<span class="required">*</span></label>
                    <div class="col-sm-8" >
                       <form:input type="text" class="form-control" placeholder="PAN No." path="pan_no" id="pan_no" value="${accounts.pan_no}"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">VAT No.<span class="required">*</span></label>
                    <div class="col-sm-8" >
                       <form:input type="text" class="form-control" placeholder="VAT No." path="vat_no" id="vat_no" value="${accounts.vat_no}"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">TIN No.<span class="required">*</span></label>
                    <div class="col-sm-8" >
                       <form:input type="text" class="form-control" placeholder="TIN No." path="tin_no" id="tin_no" value="${accounts.tin_no}"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">PL No.<span class="required">*</span></label>
                    <div class="col-sm-8" >
                       <form:input type="text" class="form-control" placeholder="PL No." path="pl_no" id="pl_no" value="${accounts.pl_no}"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">Credit Limit:<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <form:input type="text" class="form-control" placeholder="Credit Limit" path="credit_limit" value="${accounts.credit_limit}"/>
                    </div> 
                    <label class="col-sm-2 control-label">Credit  Days:<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <form:input type="text" class="form-control" path="credit_days" placeholder="Credit Days" value="${accounts.credit_days}"/>
                    </div>
                  </div>
                  <div class="form-group">
                  <div class="col-sm-5">
                      <button type="submit" formmethod="post" formaction="accountsList.html" class="btn btn-success pull-right">View</button>
                    </div>
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
  </form:form>
 </div>
</body>
</html>