package com.app.sharecabs;

import com.app.sharecabs.service.maps_api.CheckForShare;
import com.app.sharecabs.service.maps_api.TimeShareThreshold;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SharecabsApplication {

	public static void main(String[] args) {
	//Example of how to use CheckForShare - Should have written junit - my bad
	boolean isSharePossible = CheckForShare.newRequest().setTimeThreshold(TimeShareThreshold.HIGH).isSharePossible("Egmore", "mayajaal resort", "Ascendas IT park");
	System.out.println(isSharePossible);
	//Need to setup data source
	SpringApplication.run(SharecabsApplication.class, args);
	}

}
