function getDistricts(name) {
	    $('.product_name').autocomplete({
	        minLength: 1,
	        search: function (e, u) {
                $('.product_name').addClass('loader');
            },
            response: function (e, u) {
                $('.product_name').removeClass('loader');
            },
	        source:function(request, response) {
                 $.ajax({
                        url : "getProducts.html?name="+name,
                        type : "POST",
                        dataType : "json",
                        success : function( data ) {
                        	if(!data.length){
                        		var result = [
                        		       {
                        		       label: 'No Data found', 
                        		       value: response.term
                        		       }
                        		     ];
                        		 console.log("no Data Found");
                        		 response(result);
                           }else
                        	   {
                        	   response( $.map( data, function( item ) {
                                   return { 
                                   	label: item.product_name/*+', '+item.brand*/, 
                                       value: item.product_name, //value: item.route_name+', '+item.route_grade+', '+item.area_name, 
                                       brand: item.brand, //value: item.route_name+', '+item.route_grade+', '+item.area_name, 
                                       model_no: item.model_no, //value: item.route_name+', '+item.route_grade+', '+item.area_name, 
                                       qty: item.qty,
                                       product_info_id: item.product_info_id,
                                       approx_cost: item.approx_cost
                                     }   
                               }));
                        	 }
                        }
                    });
                },
	        select:function (e, t) {
	             console.log($(this).val(t.item.label));
//	             $("#item_serial_no").val(t.item.brand);
	              $(this).closest('tr').find('.product_info_id').val(t.item.product_info_id);
	              $(this).closest('tr').find('.brand').val(t.item.brand);
	              $(this).closest('tr').find('.model_no').val(t.item.model_no);
	              $(this).closest('tr').find('.qty').val(t.item.qty);
	              $(this).closest('tr').find('.approx_cost').val(t.item.approx_cost);
//         	      $("#qty").val(t.item.qty);
                return false;
	        }
	    })     
	 };
	 
function getDistricts(state){
	console.log("state_id:"+state);
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "getDistricts.html?state_id="+state,
		dataType : 'json',
		success : function(data) {
			 var options="<option value='' id='districtId'>Please Select District</option>";
             for (var key in data) {
                 console.log(key + ': ' + data[key]);
                 options+="<option value='"+key+"'>"+data[key]+"</option>";
             }
            var districts = $("#district_id").html(options);
		},
		error : function(e) {
			console.log("ERROR: ", e);
		},
		done : function(e) {
			console.log("DONE");
		}
	});
	}

$('#addPhoneButton').click(function() {
	var markup='<tr><th class="col-xs-3 "><input type="text" class="form-control" name="phone_no" placeholder="Phone No"><input type="hidden" class="form-control" name="phone_id" value="0"></th><th class="col-xs-3 "><select class="form-control" name="phone_type" id="phone_type"><option value="" label="Select Phone Type"></option><option value="Others">Other Value</option></select></th><th class="col-xs-3 "><input type="button" value="Delete" class="btn btn-danger deletePhone" id="delete" onClick="deleteRow($(this));"></th><tr>';
	$("#addPhoneRow").before(markup);
});

$('#addEmailButton').click(function() {
	var markup='<tr><th class="col-xs-3 "><input type="text" class="form-control" name="email" placeholder="Email"><input type="hidden" class="form-control" name="email_id" value="0"></th><th class="col-xs-3 "><select class="form-control" name="email_type" id="email_type"><option value="" label="Select Email Type"></option><option value="Others">Other Value</option></select></th><th class="col-xs-3 "><input type="button" value="Delete" class="btn btn-danger deletePhone" id="delete" onClick="deleteRow($(this));"></th><tr>';
	console.log('hiii');
	alert('done');
	$("#addEmailRow").before(markup);
});

function deleteRow(row){
	console.log("hii");
//	$(this).closest('tr').remove();
	row.closest('tr').remove();
}
$('.deletePhone').on('click','.remove',function() {
    $(this).parent().remove();
});

function getProduct(name)
{
	console.log('hiii');
	console.log(name);
}