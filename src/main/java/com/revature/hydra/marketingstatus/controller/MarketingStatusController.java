package com.revature.hydra.marketingstatus.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.MarketingStatus;
import com.revature.hydra.marketingstatus.service.MarketingStatusService;

/**
 * Service requests for MarketingStatus information
 * 
 * @author Omowumi
 *
 */
@RestController
@CrossOrigin
@EnableAutoConfiguration
public class MarketingStatusController {
	
	private MarketingStatusService marketingStatusService;
	
	@Autowired
	public void setMarketingStatusService(MarketingStatusService marketingStatusService) {
		this.marketingStatusService = marketingStatusService;
	}

	/**
	 * Retrieves all MarketingStatus's
	 * @return ResponseEntity<List<MarketingStatus>>
	 */
	@RequestMapping(value = "/all/marketingstatus", method = RequestMethod.GET)
    public ResponseEntity<List<MarketingStatus>> getAllMarketingStatus() {
		return new ResponseEntity<>(marketingStatusService.findAll(), HttpStatus.OK);
    }
	
	/**
	 * Retrieves all MarketingStatus's in a Map
	 * @return ResponseEntity<Map<Integer, MarketingStatus>>
	 */
	@RequestMapping(value = "/all/marketingstatus/mapped", method = RequestMethod.GET)
    public ResponseEntity<Map<Integer, MarketingStatus>> getAllMarketingStatusMapped() {
		return new ResponseEntity<>(marketingStatusService.findAllStatus(), HttpStatus.OK);
    }
	
	@RequestMapping(value = "/one/marketingstatus/{name}", method = RequestMethod.GET)
    public ResponseEntity<MarketingStatus> getOneMarketingStatus(@PathVariable String name) {
		return new ResponseEntity<>(marketingStatusService.findOneByMarketingStatus(name), HttpStatus.OK);
    }
	
	@RequestMapping(value = "/add/marketingstatus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addMarketingStatus(@RequestBody String marketingStatusName) {
		marketingStatusService.addMarketingStatus(marketingStatusName);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/marketingstatus/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteMarketingStatus(@PathVariable Integer id) {
		marketingStatusService.deleteMarketingStatusById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
