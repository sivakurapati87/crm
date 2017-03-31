;(function(angular){
	"use Strict";

	angular.module('common_module', ['bsTable','headermodule','footermodule','dashboardmodule', 'leads_module'])
	.config(['$stateProvider', '$urlRouterProvider',  function($stateProvider,  $urlRouterProvider) {
            
                $urlRouterProvider.otherwise("/dashboard"); 
                $stateProvider

                .state('dashboardmodule', {
                    url: "/dashboard",
                    templateUrl: "views/Dashboard/dashboard.html",            
                    controller: "dashboardcontroller"  
                })
                
                
                
                
               

            }])
            
            
	
	
	
    
	
})
(angular);