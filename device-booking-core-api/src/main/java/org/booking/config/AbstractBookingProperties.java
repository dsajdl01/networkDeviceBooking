package org.booking.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractBookingProperties
{
    protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractBookingProperties.class);

    protected static final String CONFIG_FILE = "configbooking.properties";

    public AbstractBookingProperties(){
        LOGGER.info("in AbstractBookingProperties CLASS: {}", AbstractBookingProperties.class);
    }

    public void loader(){}
}
