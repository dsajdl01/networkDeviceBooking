package org.booking.config;

import org.booking.services.BookingServices;
import org.boooking.prvider.BookingCoreServices;

public class BookingCoreFactory
{
    private static class LazyHolder {
        static BookingCoreServices INSTANCE;
        static {
            try
            {
                INSTANCE = new BookingServices();
            } catch (Exception e) {
                throw  new ExceptionInInitializerError(e);
            }
        }
    }

    public static BookingCoreServices getInstance() {
        return LazyHolder.INSTANCE;
    }
}
