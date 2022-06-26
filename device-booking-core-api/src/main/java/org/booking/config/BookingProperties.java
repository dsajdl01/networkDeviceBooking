package org.booking.config;

import java.util.Enumeration;
import java.util.Properties;

import org.booking.data.PropertiesDataConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookingProperties
{
    private static final Logger LOGGER = LoggerFactory.getLogger(BookingProperties.class);
    static PropertiesDataConfig propertiesDataConfig = new PropertiesDataConfig();


    public BookingProperties(){
        super();
        LOGGER.info("BookingProperties CLASS: {}", BookingProperties.class);
    }

    public void loadPropeties(Enumeration<?> e, Properties prop){

        System.out.println("\nPROPERTIES VALUES:");
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = prop.getProperty(key);
            propertiesDataConfig.addPropertiesDataConfig(key, value);
            System.out.println(key + ": " + value);
        }
        System.out.println("\nProperties loaded successfully ...");
    }

    public PropertiesDataConfig getPropertiesDataConfig(){
        return propertiesDataConfig;
    }
}
