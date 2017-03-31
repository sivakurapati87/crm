;(function(angular){
	"use Strict";
	angular.module("headermodule", [])
	.controller('headercontroller',function($scope, $http){
		
		$scope.onload = function()
		{
			$scope.pagename = "Header Page";
			
		}
	});
	
	
})(angular);