package org.booking.data;

import java.util.HashMap;
import java.util.Map;

public class PropertiesDataConfig
{
    private static Map<String, String> bookingProperties;

    public PropertiesDataConfig(){
        bookingProperties = new HashMap<String, String>();
    }

    public void addPropertiesDataConfig(String key, String value){
        bookingProperties.put(key, value);
    }

    public String getValue(String key){
        if(bookingProperties.containsKey(key)){
            return bookingProperties.get(key);
        }
        return null;
    }
}
