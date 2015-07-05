'use strict';

app.factory('CustomerService', function ($resource) {
	
	var accountResource = $resource('rest/customer/:id', {}, {
		'save': {method:'PUT'}
	});
	
	var saveCustomer = function(customer) {
		customerResource.save(customer);
	};
	
	return {
		customerResource: customerResource,
		saveCustomer: saveCustomer
	};
});
