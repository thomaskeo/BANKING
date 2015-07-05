'use strict';

app.factory('AccountService', function ($resource) {
	
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
