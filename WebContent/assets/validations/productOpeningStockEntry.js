
function getProductCode(product_code){
	 $('#product_code').autocomplete({
	        minLength: 2,
	        search: function (e, u) {
             $('#product_code').addClass('loader');
         },
         response: function (e, u) {
             $('#product_code').removeClass('loader');
         },
	        source:function(request, response) {
              $.ajax({
                     url : "getProductName.html?product_code="+product_code,
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
                                	label: item.product_code/*+', '+item.brand*/, 
                                    value: item.product_code, //value: item.route_name+', '+item.route_grade+', '+item.area_name, 
                                    product_name: item.product_name/*, //value: item.route_name+', '+item.route_grade+', '+item.area_name, 
                                    model_no: item.model_no, //value: item.route_name+', '+item.route_grade+', '+item.area_name, 
                                    qty: item.qty,
                                    product_info_id: item.product_info_id,
                                    approx_cost: item.approx_cost*/
                                  }   
                            }));
                     	 }
                     }
                 });
             },
	        select:function (e, t) {
	             console.log($(this).val(t.item.label));
	             $("#product_name").val(t.item.product_name);
//	             $("#product_name").val(t.item.product_name);
/*	              $(this).closest('tr').find('.product_info_id').val(t.item.product_info_id);
	              $(this).closest('tr').find('.brand').val(t.item.brand);
	              $(this).closest('tr').find('.model_no').val(t.item.model_no);
	              $(this).closest('tr').find('.qty').val(t.item.qty);
	              $(this).closest('tr').find('.approx_cost').val(t.item.approx_cost);
*/             return false;
	        }
	    }) 
}
