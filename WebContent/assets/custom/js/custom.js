$(document).ready(function(){
    /*$(".fa").mouseenter(function(event){
    	console.log('mouse overd');
    	$(this).closest('.fa').removeClass( "fa-angle-left" ).addClass( "fa-angle-right" );
    	$(this).parents('li').addClass( "dropdown-submenu");
    	console.log('addedd');
    });
    $(".fa").mouseleave(function(){
    	console.log('mouse overd');
    	$(this).closest('.fa').removeClass( "fa-angle-right" ).addClass( "fa-angle-left" );
//    	$(this).parents('li').removeClass( "dropdown-submenu");
    });
    */

  //custom dropdown
  $(".list-align").mouseenter(function(event){
  	$(this).closest('.list-align').addClass( "list-background" );
  });
  $(".list-align").mouseleave(function(event){
  $(this).closest('.list-align').removeClass( "list-background" );
  });
  
});

