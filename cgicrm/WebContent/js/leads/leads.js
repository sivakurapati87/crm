;(function(angular){
	"use Strict";
	angular.module("leadsmodule", ['ngStorage'])
	.controller('leadscontroller',function($scope, $http, $localStorage, $sessionStorage, $window,$state){
		
		$scope.leads = [];
		$scope.leads.push({});
		var leadData = [];
		$scope.leadTable = false;
		$scope.pageNumber = 1;
		
		$scope.onload = function()
		{
			$scope.pagename = "Leads";
		}
		
		var response = $http.get("/cgicrmservice/LeadController/getLeads");
		response.success(function(data, status,headers, config) 
				{
			//alert(JSON.stringify(data));
			leadData = [];
			$scope.leadsdata =  data.data;
			for (var i = 0; i < $scope.leadsdata.length; i++) {
				var leadObj = $scope.leadsdata[i];
				leadData.push(leadObj);
			}
			dispalyTable();
	      });
		response.error(function(data, status, headers, config){
			  if(status == constants.FORBIDDEN){
				location.href = 'login.html';
			  }else{  			  
				//$state.transitionTo("ErrorPage",{statusvalue  : status});
			  }
		  });
		
	       $scope.leadTable = true;
			
			function dispalyTable() {
				$scope.leads
						.forEach(function(lead, index) {
							lead.leadsBsTableControl = {
								options : {
									data : leadData || {},
									striped : true,
									pagination : true,
									paginationVAlign : "both",
									pageSize : 10,
									pageList : [ 10, 20, 50 ],
									search : false,
									showColumns : false,
									pageNumber:  ($scope.pageNumber? $scope.pageNumber:1),
									showRefresh : false,
									clickToSelect : false,
									showToggle : false,
									//detailView : true,
									maintainSelected : true,
									columns : [
											{
												field : '',
												title : '',
												align : 'center',
												sortable : true,
												events : window.editEvent,
												formatter : editFormatter
											},
											{
												field : 'firstName',
												title : 'First Name',
												align : 'left',
												sortable : true,
												events : window.firstNameEvent,
												formatter : firstNameFormatter
											},{
												field : 'lastName',
												title : 'Last Name',
												align : 'left',
												sortable : true
											},
											{
												field : 'email',
												title : 'Email',
												align : 'left',
												sortable : true,
												events : window.emailEvent,
												formatter : emailFormatter
											},{
												field : 'phone',
												title : 'Phone',
												align : 'left',
												sortable : true
											},
											{
												field : 'company',
												title : 'Company',
												align : 'left',
												sortable : true
											},
											{
												field : 'title',
												title : 'Title',
												align : 'left',
												sortable : true
											},
											{
												field : 'actions',
												title : '',
												align : 'center',
												sortable : false,
												width:"80px",
												events : window.operateEvents,
												formatter : actionFormatter
											}],
											
											onPageChange: function (number, size) {
												   $scope.pageNumber = number;
												   $scope.pageSize = size;
													
												},
											
										
											
											
								}
							    };
							
							function editFormatter(value, row,
									index) {
								return [
								'<a class="edit actionIcons" title="Edit Lead"><i class="tbl_redicon fa fa-pencil" style="font-size:14px;"></i></a>'
								 ]
								.join('');
							}
							
							window.editEvent = {
									'click .edit' : function(e, value,
											row, index) {
										$state.transitionTo("editleadmodule",{leadId : row.id});
										
									}
							};
							
							
							function firstNameFormatter(value, row,
									index) {
								return [
								'<a class="tbl_lnk fstName actionIcons">'+row.firstName+'</a>'
								 ]
								.join('');
							}
							
							window.firstNameEvent = {
									'click .fstName' : function(e, value,
											row, index) {
										$state.transitionTo("viewleadmodule",{leadId : row.id});
									}
							};
							
							
							
							function emailFormatter(value, row,
									index) {
								return [
								'<a class="tbl_lnk email actionIcons">'+row.email+'</a>'
								 ]
								.join('');
							}
							
							window.emailEvent = {
									'click .email' : function(e, value,
											row, index) {
									}
							};
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							function actionFormatter(value, row,
									index) {
								return [
										
										'<a class="copy actionIcons" title="Clone Lead" ><i class="hdsw tbl_redicon fa fa-copy" style="font-size:15px;"></i></a> &nbsp;&nbsp;&nbsp; ',
										'<a class="remove actionIcons" title="Delete Lead"><i class="hdsw tbl_redicon fa fa-trash-o" style="font-size:15px;"></i></a>',
										 ]
										.join('');
							}
							
							window.operateEvents = {
									'click .copy' : function(e, value,
											row, index) {
										$state.transitionTo("editleadmodule",{cloneLeadId : row.id});
									},
									'click .remove' : function(e, value,
											row, index) {
									},
									
							};
							
							
				
								});
				
			}






	});
	
	
})(angular);