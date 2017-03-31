;(function(angular){
	"use Strict";
	angular.module("footermodule", [])
	.controller('footercontroller',function($scope, $http){
		
		$scope.onload = function()
		{
			$scope.pagename = "Header Page";
			
		}
	});
	
	
})(angular);