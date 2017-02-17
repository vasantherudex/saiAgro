function addTest()
{
alert('hiiii');	
//return false;
}

function getProducts(product_code){
	$('.product_code').autocomplete({
		minLength: 2,
		search: function (e, u) {
//			$('.product_code').addClass('loader');
			 $(this).closest('tr').find('.product_code').addClass('loader');
		},
		response: function (e, u) {
//			$('.product_code').removeClass('loader');
			$(this).closest('tr').find('.product_code').removeClass('loader');
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
								product_id: item.product_id,
								product_name: item.product_name,
								technical_name: item.technical_id,
								packing_name: item.packing_id
							}   
						}));
					}
				}
			});
		},
		select:function (e, t) {
			console.log($(this).val(t.item.label));
//			$("#product_name").val(t.item.product_name);
//			$("#technical_name").val(t.item.technical_name);
//			$("#packing_name").val(t.item.packing_name);
//			$("#sale_rate").val(t.item.sale_rate);
				  $(this).closest('tr').find('.product_name').val(t.item.product_name);
				  $(this).closest('tr').find('.product_id').val(t.item.product_id);
				  $(this).closest('tr').find('.technical_name').val(t.item.technical_name);
				  $(this).closest('tr').find('.packing_name').val(t.item.packing_name);
//				  $(this).closest('tr').find('.sale_rate').val(t.item.sale_rate);
//	              $(this).closest('tr').find('.brand').val(t.item.brand);
//	              $(this).closest('tr').find('.model_no').val(t.item.model_no);
//	              $(this).closest('tr').find('.qty').val(t.item.qty);
//	              $(this).closest('tr').find('.approx_cost').val(t.item.approx_cost);
			              return false;
		}
	}) 
}


function addMoreProduct(e)
{
	console.log('hiii');
	console.log('the value is : '+e);
	console.log('key code is : '+e.keyCode);
	if (e.keyCode == 13) {
        confirm("Are you sure to add another product");
//        var markup='<tr><th class="col-sm-2"><input type="text" placeholder="Product Code" name="product_code" id="product_code" class="form-control" onKeypress="getProducts(this.value);"></th><th class="col-sm-2"><input type="text" placeholder="Product Name" name="product_name" id="product_name" class="form-control"></th><th class="col-sm-2"><input type="text" placeholder="Technical Name" name="technical_name" id="technical_name" class="form-control"></th><th class="col-sm-2"><input type="text" placeholder="Packing Name" name="packing_name" id="packing_name" class="form-control"></th><th class="col-sm-2"><input type="text" placeholder="Rate" name="sale_rate" id="sale_rate" class="form-control" onclick="addProductRate()"></th></tr>';
        var markup='<tr>'+
        '<th class="col-sm-1"><input type="text" placeholder="ProductCode" name="product_code" id="product_code" class="form-control product_code" onKeyup="getProducts(this.value);"><input type="hidden" name="product_id" id="product_id" class="product_id" value=""></th>'+
        '<th class="col-sm-2"><input type="text" placeholder="Description" name="product_name" id="product_name" class="form-control product_name"></th>'+
        '<th class="col-sm-1"><input type="text" placeholder="Technical" name="technical_name" id="technical_name" class="form-control technical_name"></th>'+
        '<th class="col-sm-1"><input type="text" placeholder="Packing" name="packing_name" id="packing_name" class="form-control packing_name"></th>'+
        '<th class="col-sm-1"><input type="text" placeholder="Quantity" name="quantity" id="quantity" class="form-control" ></th>'+
        '<th class="col-sm-1"><input type="text" placeholder="Rate" name="sale_rate" id="sale_rate" class="form-control" ></th>'+
        '<th class="col-sm-1"><input type="text" placeholder="Batch" name="batch" id="batch" class="form-control" ></th>'+
        '<th class="col-sm-2"><input type="text" placeholder="MfgDate" name="batch" id="batch" class="form-control" ></th>'+
        '<th class="col-sm-2"><input type="text" placeholder="ExpDate" name="sale_rate" id="sale_rate" class="form-control sale_rate" onkeydown="addMoreProduct(event);"></th>'+
      '</tr>';
   	    $("#addEmailRow").before(markup);
//   	    $(this).removeClass('sale_rate');
        e.preventDefault();
    }
	if (e.keyCode == 27) {
		$('#saveMaterialReceivedEntry').attr('disabled',false);
        alert("Escape pressed");
        return false; // prevent the button click from happening
    }
}
$('#sale_rate1').bind('keydown',function(e){
//	$('sale_rate')
	console.log('hiiii');
	addMoreProduct(e);
});	
	
function getSupplierCode(product_code){
	 $('#supllier_code').autocomplete({
	        minLength: 2,
	        search: function (e, u) {
             $('#supllier_code').addClass('loader');
         },
         response: function (e, u) {
             $('#supllier_code').removeClass('loader');
         },
	        source:function(request, response) {
              $.ajax({
                     url : "getSupplierName.html?product_code="+product_code,
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
                                	label: item.account_code/*+', '+item.brand*/, 
                                    value: item.account_code, //value: item.route_name+', '+item.route_grade+', '+item.area_name, 
                                    account_name: item.account_name/*, //value: item.route_name+', '+item.route_grade+', '+item.area_name, 
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
	             $("#supplier_name").val(t.item.account_name);
/*	              $(this).closest('tr').find('.product_info_id').val(t.item.product_info_id);
	              $(this).closest('tr').find('.brand').val(t.item.brand);
	              $(this).closest('tr').find('.model_no').val(t.item.model_no);
	              $(this).closest('tr').find('.qty').val(t.item.qty);
	              $(this).closest('tr').find('.approx_cost').val(t.item.approx_cost);
*/             return false;
	        }
	    }) 
}
