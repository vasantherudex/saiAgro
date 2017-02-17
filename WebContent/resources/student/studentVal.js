
$(document).ready(function(){
    $("#add-phone").click(function(){
        var phone = "<div class='col-sm-4'><span>Phone Number<span class='required'>*</span></span><input type='text' class='form-control' name='phone'></div>";
        var type="<div class='col-sm-4'><span>Phone Type<span class='required'>*</span></span><input type='text' class='form-control' name='phone_type'></div>";
        var del="<div class='col-sm-4'><span>Delete<span class='required'>*</span></span><input type='button' class='form-control btn btn-danger' name='phone_type' value='delete'></div>";
        var markup = "<div>"+phone+type+del+"</div>";
        $("#append-phone").append(markup);
        
        //var row_no = $('#advice_product_table tbody tr').length;
        //alert(row_no);
        if($('#advice_product_table tbody tr').length)
        	{
        	console.log("tr exists");
        	$("#delete-row").show();
            $("#advice_product_table").show();
        	}else
              {
        		console.log("tr not existed");
        		$("#delete-row").hide();
                $("#advice_product_table").hide();
              }
    });
    /*
    $("#add-row2").click(function(){
    	var count = 1;
    	var sno=(parseInt(count++))+"</td>";
        var item_name = "<input type='text' class='form-control' name='item_name'></td>";
        var brand="<td><input type='text' class='form-control' name='brand'></td>";
        var model_no="<td><input type='text' class='form-control' name='model_no'></td>";
        var qty="<td><input type='text' class='form-control' name='qty'></td>";
        var place_mode="<td><input type='text' class='form-control' name='place_mode'></td>";
        var approx_cost="<td><input type='text' class='form-control' name='approx_cost'></td>";
        var markup = "<tr><td><input type='checkbox' name='record'></td><td>" +item_name+brand+model_no+qty+place_mode+approx_cost+"</tr>";
        $("table tbody").append(markup);
        
        //var row_no = $('#advice_product_table tbody tr').length;
        //alert(row_no);
        if($('#advice_product_table tbody tr').length)
        	{
        	console.log("tr exists");
        	$("#delete-row").show();
            $("#advice_product_table").show();
        	}else
              {
        		console.log("tr not existed");
        		$("#delete-row").hide();
                $("#advice_product_table").hide();
              }
    });
    */
    // Find and remove selected table rows
    $("#delete-row").click(function(){
    	  if($("#first_check_box").prop("checked")==true)
      	      {
    		    console.log("fromm--");
            	$("#item_name").val("");
            	$("#brand").val("");
            	$("#model_no").val("");
            	$("#qty").val("");
            	$("#mode_of_delivery").val("");
            	$("#approx_cost").val("");
            	$("#first_check_box").prop("checked",false);
      	        }
        $("table tbody").find('input[name="record"]').each(function(){
        	if($(this).is(":checked")){
                $(this).parents("tr").remove();
                if($('#advice_product_table tbody tr').length)
            	{
            	console.log("tr exists");
            	$("#delete-row").show();
                $("#advice_product_table").show();
            	}else
                  {
            		console.log("tr not existed");
            		$("#delete-row").hide();
                    $("#advice_product_table").hide();
                  }
            }
        });
    });
});  /**
 * 
 */