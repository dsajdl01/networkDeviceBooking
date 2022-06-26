package org.booking.config;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.LoggerFactory;

public class BookingConfigLoader extends AbstractBookingProperties implements ServletContextListener
{
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent)
    {
        loader();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent)
    {
        printLoading();
        Properties prop = new Properties();
        InputStream input = null;
        try {
            String filename = CONFIG_FILE;
            input = getClass().getClassLoader().getResourceAsStream(filename);
            if (input == null) {
                LOGGER.info("DepartmentConfigLoader Sorry, unable to find " + filename);
                return;
            }
            prop.load(input);
            new BookingProperties().loadPropeties(prop.propertyNames(), prop);

        } catch (IOException ex) {
            LOGGER.error("DepartmentConfigLoader error={}", ex);
            return;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    LOGGER.error("DepartmentConfigLoader unable to close input={}", e);
                    return;
                }
            }
        }

    }

    @Override
    public void loader() {

    }

    private void printLoading() {
        System.out.println("[INFO] DEVICE BOOKING is launching ...\n");
    }
}
