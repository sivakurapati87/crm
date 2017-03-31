;(function(angular){
	"use Strict";
	angular.module("dashboardmodule", ['ngStorage'])
	.controller('dashboardcontroller',function($scope, $http, $localStorage, $sessionStorage, $window){
		
		$scope.onload = function()
		{
			$scope.pagename = "Dash Board";
		}






	});
	
	
})(angular);