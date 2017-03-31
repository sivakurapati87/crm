;(function(angular){
	"use Strict";
	angular.module('leads_module', ['leadsmodule', 'createleadmodule', 'viewleadmodule'])


	
	
	.config(['$stateProvider', '$urlRouterProvider',  function($stateProvider,  $urlRouterProvider) {
            
                $urlRouterProvider.otherwise("/dashboard"); 
                $stateProvider

                
                
                .state('leadsmodule', {
                    url: "/leads",
                    templateUrl: "views/leads/leads.html",            
                    controller: "leadscontroller"  
                })
                
                .state('createleadmodule', {
                    url: "/leads/createEditLead",
                    templateUrl: "views/leads/create_lead.html",            
                    controller: "createleadcontroller"  
                })
                
                .state('editleadmodule', {
                   url: "/leads/createEditLead/:leadId/:cloneLeadId",
                   templateUrl: "views/leads/create_lead.html",            
                   controller: "createleadcontroller"  
                })
                
                
                
                .state('viewleadmodule', {
                   url: "/leads/viewLead/:leadId",
                   templateUrl: "views/leads/view_lead.html",            
                   controller: "viewleadcontroller"  
                })
                
                
               

            }])
            
            
	
	
	
    
	
})
(angular);