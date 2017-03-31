$(document).ready(function(){
	
	
	
	
	setTimeout(function(){ 
		$(".tablescroll table tbody tr td").mouseover(function(){
			$(this).parent().find(".hdsw").show();
		});
		
		$(".tablescroll table tbody tr td a").mouseover(function(){
			$(this).parent().parent().find(".hdsw").show();
		});
		
		
		
		
		
		
		$(".tablescroll table tbody tr td").mouseout(function(){
			$(this).parent().find(".hdsw").hide();
		});
		
		}, 500);
	
	
	
	
});