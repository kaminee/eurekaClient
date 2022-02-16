package com.eurekaClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@RestController
public class EurekaClientRestController {
	@Autowired 
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("/clients/{applicationName}")
	public @ResponseBody String getClientsByApplicationName(@PathVariable String applicationName)
	{
		return this.discoveryClient.getInstances(applicationName).toString();
	}

}
