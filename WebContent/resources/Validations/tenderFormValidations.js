$(document).ready(function(){
   
	//first check box validation
	$("#bank_garantee_checkbox").click(function(){
    	if($('#bank_garantee_checkbox').is(':checked'))
    		{
			console.log('checked');
			$("#bank_garrante").prop('disabled', false);
    		}else
    			{	
    			$("#bank_garrante").prop('disabled', true);
        		$("#bank_garrante").val("");
        		console.log('unchecked');
    			}
    });

	//D.D1 check box validation
	$("#demand_draft1_checkbox").click(function(){
    	if($('#demand_draft1_checkbox').is(':checked'))
    		{
			console.log('checked');
			$("#demand_draft1").prop('disabled', false);
    		}else
    			{	
    			$("#demand_draft1").prop('disabled', true);
        		$("#demand_draft1").val("");
        		console.log('unchecked');
    			}
    });

	//D.D2 check box validation
	$("#demand_draft2_checkbox").click(function(){
    	if($('#demand_draft2_checkbox').is(':checked'))
    		{
			console.log('checked');
			$("#demand_draft2").prop('disabled', false);
    		}else
    			{	
    			$("#demand_draft2").prop('disabled', true);
        		$("#demand_draft2").val("");
        		console.log('unchecked');
    			}
    });

	//RTGS check box validation
	$("#real_time_gross_settlement_checkbox").click(function(){
    	if($('#real_time_gross_settlement_checkbox').is(':checked'))
    		{
			console.log('checked');
			$("#real_time_gross_settlement").prop('disabled', false);
    		}else
    			{	
    			$("#real_time_gross_settlement").prop('disabled', true);
        		$("#real_time_gross_settlement").val("");
        		console.log('unchecked');
    			}
    });

});

$(document).ready(function(){
    $("#add-row").click(function(){
        var item_name = "<input type='text' class='form-control' name='item_name'></td>";
        var brand="<td><input type='text' class='form-control' name='brand'></td>";
        var model_no="<td><input type='text' class='form-control' name='model_no'></td>";
        var qty="<td><input type='text' class='form-control' name='qty'></td>";
        var place_mode="<td><input type='text' class='form-control' name='mode_of_delivery'></td>";
        var markup = "<tr><td><input type='checkbox' name='record'></td><td>" +item_name+brand+model_no+qty+place_mode+"</tr>";
        $("table tbody").append(markup);
        console.log('data added');        
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
    
    $("#add-row2").click(function(){
        var item_name = "<input type='text' class='form-control' name='item_name'></td>";
        var brand="<td><input type='text' class='form-control' name='brand'></td>";
        var model_no="<td><input type='text' class='form-control' name='model_no'></td>";
        var qty="<td><input type='text' class='form-control' name='qty'></td>";
        var place_mode="<td><input type='text' class='form-control' name='mode_of_delivery'></td>";
        var approx_cost="<td><input type='text' class='form-control' name='approx_cost'></td>";
        var markup = "<tr><td><input type='checkbox' name='record'></td><td>" +item_name+brand+model_no+qty+place_mode+approx_cost+"</tr>";
        $("table tbody").append(markup);
        console.log('data added');        
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
});  