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
   <form:form class="form-horizontal" action="savePacking.html" method="post" commandName="packing">
      <div class="content-wrapper">
       <section class="content-header">
         <h1>
            Free Mind Services<small>Packing</small>
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
            <li class="active"><a href="#general_info" data-toggle="tab">Packing Information</a></li>
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
                    <label class="col-sm-2 control-label">Packing Id:<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <form:input type="text" class="form-control" readonly="true" placeholder="Packing Id" value="${packing.packing_id}" path="packing_id" />
                    </div> 
                    <label class="col-sm-2 control-label">Packing Name:<span class="required">*</span></label>
                    <div class="col-sm-3">
                      <form:input type="text" class="form-control" placeholder="Packing Name" path="packing_name" value="${packing.packing_name}"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-5">
                      <button type="submit" formmethod="post" formaction="packingList.html" class="btn btn-success pull-right">View</button>
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