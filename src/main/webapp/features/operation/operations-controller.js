app.controller('OperationsController', function($log,$http) {
    var vm = this;
    
    vm.uid = 1;
 
    vm.message="";

    vm.operations = {}; 

    
    vm.loaddata=function(){
    	vm.message="Loading...";
          $log.info("loaddata");
	  $http.get("/api/account/1/1?details=true").success(function(data) {
	    	vm.message= "OK";
	    	vm.operations = data.operations;
	  })
      }
});