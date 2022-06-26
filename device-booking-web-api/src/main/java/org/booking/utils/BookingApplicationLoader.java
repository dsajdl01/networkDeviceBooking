package org.booking.utils;
import java.util.HashMap;
import java.util.Map;

import org.booking.config.BookingCoreProvider;
import org.boooking.prvider.BookingCoreServices;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class BookingApplicationLoader extends ResourceConfig
{
    private static final Logger LOGGER = LoggerFactory.getLogger(BookingApplicationLoader.class);

    @SuppressWarnings({ "serial" })
    private static final Map<String,Object> PROPERTIES = new HashMap<String,Object>() {{
        put("com.sun.jersey.api.json.POJOMappingFeature",Boolean.TRUE);
        put("jersey.config.server.tracing","ALL");
        put("jersey.config.server.tracing.threshold","VERBOSE");
    }};

    public BookingApplicationLoader() {

        LOGGER.info("BookingApplicationLoader constructor {}", BookingApplicationLoader.class.toString());
        register(new DepartmentBinder());
        register(JacksonJsonProvider.class);
        register(MultiPartFeature.class);
        packages(true, "org.booking.web.api");
        addProperties(PROPERTIES);
        LOGGER.debug("Application components registered successfully");
    }

    class DepartmentBinder extends AbstractBinder
    {
        @Override
        protected void configure()
        {
            bindFactory(BookingCoreProvider.class).to(BookingCoreServices.class);
            LOGGER.info("Successfully registered DepartmentLoader {}", BookingApplicationLoader.class.toString());
        }
    }
}
