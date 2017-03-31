;(function(angular){
	"use Strict";
	angular.module("viewleadmodule", ['ngStorage', 'ui.bootstrap', 'jcs-autoValidate'])
	.controller('viewleadcontroller',function($scope, $http, $localStorage, $sessionStorage, $window,$state,$stateParams){
		
		$scope.buttons = { chosen: "" };
		$scope.createlead = {};
		
		$scope.onload = function()
		{
			if($stateParams.leadId!=null){
				
				
				var response = $http.get("/cgicrmservice/LeadController/getLeadById/"+$stateParams.leadId);
				response.success(function(data, status,headers, config) 
						{
					$scope.createlead = data;
					
			      });
				response.error(function(data, status, headers, config){
					 
				  });
			}
			
		}
		
$scope.savelead = function()
{
	
	if($scope.buttons.chosen=="edit"){
		$state.transitionTo("editleadmodule",{leadId : $stateParams.leadId});
	}
	else if($scope.buttons.chosen=="clone"){
		$state.go("editleadmodule",{cloneLeadId : $stateParams.leadId});
	}else{
		
	}
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