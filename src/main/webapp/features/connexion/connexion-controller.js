'use strict';

app.factory('ConnexionController', function ($resource) {
	
	var accountResource = $resource('api/accounts/1/1', {}, {
		'save': {method:'PUT'}
	});
	
	var saveAccount = function(account) {
		accountResource.save(account);
	};
	
	return {
		accountResource: accountResource,
		saveAccount: saveAccount
	};
});


