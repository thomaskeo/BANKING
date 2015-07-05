app.controller('AccountsController', function($log,$http) {
    var vm = this;
    
    vm.uid = 1;
 
    vm.message="";

    vm.accountDetail = {}; 

    
    vm.loaddata=function(){
    	vm.message="Loading...";
          $log.info("loaddata");
	  $http.get("/api/account/1/1").success(function(data) {
	    	vm.message= "OK";
	    	data.dateCreation = new Date(data.dateCreation);
	    	vm.accountDetail = data;
	  })
  }
    
    vm.generate=function(){
    	vm.message="Generate...";
	  $http.post("/rest/account/generateMany").success(function(data) {
	    	vm.message= "OK";
	    	vm.accounts = data;
	  })
  }
    
    vm.findItem=function(account){
    	vm.message="Generate...";
	  $http.get("/api/account/1/1").success(function(data) {
	    	vm.message= "OK";
	    	vm.accountDetail = data;
	  })
  }
    
    vm.save=function(account){
    	vm.message="Generate...";
	  $http.post("/rest/account", account).success(function(data) {
	    	vm.message= "OK";
	    	vm.accountDetail = data;
	  })
  }
  
});
