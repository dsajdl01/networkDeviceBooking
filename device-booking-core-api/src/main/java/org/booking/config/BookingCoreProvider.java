package org.booking.config;
import java.util.function.Supplier;

import javax.ws.rs.ext.Provider;

import org.boooking.prvider.BookingCoreServices;

@Provider
public class BookingCoreProvider implements Supplier<BookingCoreServices>
{
    public BookingCoreServices get() {
        return BookingCoreFactory.getInstance();
    }
}
