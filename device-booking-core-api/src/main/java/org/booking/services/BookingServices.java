package org.booking.services;
import java.sql.Connection;

import org.booking.config.BookingProperties;
import org.booking.dao.BookingDAOConnection;
import org.booking.dao.BookingDAOImp;
import org.booking.data.PropertiesDataConfig;
import org.boooking.prvider.BookingCoreServices;
import org.boooking.prvider.BookingInter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class BookingServices implements BookingCoreServices
{
    protected static final Logger LOGGER = LoggerFactory.getLogger(BookingServices.class);
   private BookingInter bookingServices;

    public BookingServices() {
        LOGGER.info("Constructor of Booking Services is loading ....");
        final Connection dbConnection = new BookingDAOConnection( new BookingProperties().getPropertiesDataConfig()).getDbConnection();
        this.bookingServices = new BookingImpl(new BookingDAOImp(dbConnection));
    }

    public BookingInter getBookingServices() {
        return this.bookingServices;
    }
}
