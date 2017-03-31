;(function(angular){
	"use Strict";
	angular.module("indexapp", ['ngStorage', 'ui.router',  'common_module'])
	.controller('homecontroller',function($scope){
		
		$scope.onload = function()
		{
			$scope.pagename = "Tonyasdfsdf";
		}
	})
	
	
    
	
})
(angular);