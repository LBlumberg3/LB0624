package com.example.kewltewls.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RestController;

/**
 * Specialized controller used to populate the in-memory DB, when a proper external DB with extant records isn't available. In an actual deployed environment, there's the general assumption that the database the app will connect to will have the appropriate tables, columns, and records already present. 
 * 
 * Since this is a demo application, this controller will be used to add records to the in-memory DB (H2, in this case) so that the collection of tools, tool codes, brands, etc can be available for actual use of the application
 */
@RestController
@Profile("!prod") // if we're in a prod environment, we _absolutely_ should expect a DB with extant records to be present, so this controller would be superfluous
public class BootstrapController {
    private static final Logger logger = LoggerFactory.getLogger(BootstrapController.class);
}
