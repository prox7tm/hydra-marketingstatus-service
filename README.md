#hydra-marketingstatus-service
Fields in the MarketingStatus beans are as follows:
* MarketingStatus

The controller can perform the following functions:
* MarketingStatusController
	* getAllMarketingStatus(), via a GET to /all/marketingstatus
	* getAllMarketingStatusMapped(), via a GET to /all/marketingstatus/mapped
	* getOneMarketingStatus(@PathVariable String name), via a GET to /one/marketingstatus/{name}
	* addMarketingStatus(@RequestBody String marketingStatusName), via a POST to /add/marketingstatus
	* updateMarketingStatus(@RequestBody MarketingStatus marketingStatus), via a PUT to /update/marketingstatus
	* deleteMarketingStatus(@PathVariable Integer id), via a DELETE to /delete/marketingstatus/{id}
