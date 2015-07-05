'use strict';

app.factory('ConnexionService', function ($resource) {
	
	var accountResource = $resource('rest/account/:id', {}, {
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


