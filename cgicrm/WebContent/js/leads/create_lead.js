;(function(angular){
	"use Strict";
	angular.module("createleadmodule", ['ngStorage', 'ui.bootstrap', 'jcs-autoValidate'])
	.controller('createleadcontroller',function($scope, $http, $localStorage, $sessionStorage, $window,$state,$stateParams){
		
		$scope.buttons = { chosen: "" };
		$scope.createlead = {};
		$scope.saveNewButton = false;
		$scope.cloneButton = false;
		
		$scope.onload = function()
		{
			$scope.editid = $stateParams.leadId;
			$scope.cloneid = $stateParams.cloneLeadId;
			
			
			if($scope.editid || $scope.cloneid){
				$scope.saveNewButton = true;
				var response = $http.get("/cgicrmservice/LeadController/getLeadById/"+($scope.editid ? $scope.editid : $scope.cloneid));
				response.success(function(data, status,headers, config) 
						{
									if (data) {
										$scope.createlead = data;
										if ($scope.cloneid) {
											$scope.cloneButton = true;
											$scope.createlead.id = null;
										}
						}
			      });
				response.error(function(data, status, headers, config){
					 
				  });
				
				
			}
			
		}
		
$scope.savelead = function()
{
	//alert(JSON.stringify($scope.createlead));
	
	var response = $http.post("/cgicrmservice/LeadController/saveOrUpdateLead",$scope.createlead);
	response.success(function(data, status,headers, config) 
			{
	if($scope.buttons.chosen=="save"){
		$state.transitionTo("leadsmodule");
	}
	else if($scope.buttons.chosen=="saveNew"){
		$scope.createlead = {};
		$scope.createleadForm.$setPristine();
		$state.transitionTo("createleadmodule");
	}else{
		
	}
	
	//$.growl.success({title : "Info !", message : "Lead created successfully"});
	growl.success("Lead created successfully");
	
	
      });
	response.error(function(data, status, headers, config){
		 /* if(status == constants.FORBIDDEN){
			location.href = 'login.html';
		  }else{  			  
			$state.transitionTo("ErrorPage",{statusvalue  : status});
		  }*/
	  });
	
}

$scope.cancelButton = function(){
	$state.transitionTo("leadsmodule");
}


	})
	
	.directive('buttonId', function() {
	    return {
	    restrict: "A",
	    link: function(scope, element, attributes) {
	                  element.bind("click", function(){
	          // able to get the name of the button and pass it to the $scope
	          // this is executed on every click
	          scope.buttons.chosen = attributes.buttonId;
	           //alert(attributes.buttonId + scope.buttons.chosen);
	          });           
	        }
	    }
	});
	
	

	
	
})(angular);