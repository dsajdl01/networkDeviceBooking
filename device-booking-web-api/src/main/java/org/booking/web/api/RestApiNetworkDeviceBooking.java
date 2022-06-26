package org.booking.web.api;

import static org.response.json.RestResponseHandler.badRequest;
import static org.response.json.RestResponseHandler.success;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.inject.Inject;

import org.booking.data.NetworkDeviceBooking;
import org.booking.utils.InvalidArgumentProblem;
import org.boooking.prvider.BookingCoreServices;
import org.response.json.BookingFilterJson;
import org.response.json.NetworkDeviceBookingJson;


@Path("/device/booking")
public class RestApiNetworkDeviceBooking
{
    @Inject
    BookingCoreServices bookingService;


    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartmentsList(BookingFilterJson data)
    {
        try
        {
            basicFilterValidation(data);
            List<NetworkDeviceBooking> networkDeviceBooking = bookingService.getBookingServices().getNetworkDeviceBooking(data.getDeviceId(), data.getStartDate(), data.getEndDate());
            List<NetworkDeviceBookingJson> networkDeviceBookingJson = networkDeviceBooking.stream()
                    .map(ndb -> new NetworkDeviceBookingJson(ndb.getId(), ndb.getNetworkDeviceName(), ndb.getBookBy(), ndb.getBookStart(), ndb.getBookEnd()))
                    .collect(Collectors.toList());
            return success(networkDeviceBookingJson);
        } catch (InvalidArgumentProblem e)
        {
            return badRequest(e.getMessage());
        }
    }
    private void basicFilterValidation(BookingFilterJson data) throws InvalidArgumentProblem {
        if (data == null) throw new InvalidArgumentProblem("Filter Date missing");
        if (data.getDeviceId() == null || data.getDeviceId() <= 0) throw new InvalidArgumentProblem("Invalid Device Id");
        if (data.getStartDate() == null) throw new InvalidArgumentProblem("Start Date missing");
        if (data.getEndDate() == null ) throw new InvalidArgumentProblem("Edd Date missing");
    }

    private void basicNetworkDeviceBookingValidation(NetworkDeviceBookingJson device) throws InvalidArgumentProblem {
        if (device == null) throw new InvalidArgumentProblem("Filter Date missing");
        if (device.getDeviceId() == null || device.getDeviceId() <= 0) throw new InvalidArgumentProblem("Invalid Device Id");
        if (device.getBookStart() == null) throw new InvalidArgumentProblem("Start Date missing");
        if (device.getBookEnd() == null ) throw new InvalidArgumentProblem("Edd Date missing");
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response bookNetworkDevice(NetworkDeviceBookingJson device, @Context HttpServletRequest request) {
        try
        {
            basicNetworkDeviceBookingValidation(device);
            // who is allowed to book device only logon user or anyone can book
            //User logonUser auth.getLogonUser(request)
            bookingService.getBookingServices().endBooking(new NetworkDeviceBooking(device.getDeviceId(), device.getNetworkDeviceName(), device.getBookBy(),  device.getBookStart(), null));
            return success();
        } catch (InvalidArgumentProblem e) {
            return badRequest(e.getMessage());
        }
    }

    @POST
    @Path("/terminate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response terminateDevioceBooking(NetworkDeviceBookingJson device, @Context HttpServletRequest request) {
        try
        {
            basicNetworkDeviceBookingValidation(device);
            // who is allowed to book device only logon user or anyone can book
            //User logonUser auth.getLogonUser(request)
            // to check who terminate booking only person who booked network device or someone else
            bookingService.getBookingServices().endBooking(new NetworkDeviceBooking(device.getDeviceId(), device.getNetworkDeviceName(), "name",  device.getBookStart(), device.getBookEnd()));
            return success();
        } catch (InvalidArgumentProblem e) {
            return badRequest(e.getMessage());
        }
    }

}
