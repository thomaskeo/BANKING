app.controller('CustomersController', function($log,$http) {
    var vm = this;
     
    vm.message="";

    vm.loaddata=function(customer){
    	vm.message="Loading...";
        $log.info("loaddata");
	  $http.get("/api/account/1/1").success(function(data) {
	    	vm.message= "OK";
	    	vm.customers = data;
  }
  
});
