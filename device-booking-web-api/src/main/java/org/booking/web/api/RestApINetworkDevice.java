package org.booking.web.api;

import static java.util.Arrays.asList;
import static org.response.json.RestResponseHandler.badRequest;
import static org.response.json.RestResponseHandler.success;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import org.booking.data.NetworkDevice;

@Path("device")
public class RestApINetworkDevice
{

   // @Inject
    // DeviceService: deviceService

    // @Inject
    // Authentication: auth


    @GET
    @Produces(MediaType.APPLICATION_JSON)
 //   RequiresPermissions("view Network Device")
    public Response getNetworkDeviceList(@Context HttpServletRequest request) {
        List<NetworkDevice> networkDevices = asList(); // deviceService.getNetworkDeviceList();
        return success(networkDevices);
    }

    @POST
    @Path("/{deviceName}")
    @Produces(MediaType.APPLICATION_JSON)
 //   RequiresPermissions("Add New Network Device")
    public Response addNetworkDevice(@PathParam("deviceName") String deviceName, @Context HttpServletRequest request) {
        try
        {
            if (deviceName == null || deviceName.trim().isEmpty())
                return badRequest("Network Denice name is not provided");
            //User logonUser = auth.getLogonUser(request) // log on user to keep record who added device
            //NetworkDevice newNetworkDevice = deviceService.addNetworkDevice(deviceName, logonUser); //
            return success(/*new NetworkDeviceJson(newNetworkDevice)*/);
        } catch (Exception e) {
            // service layer needs to check if device name exist if yes the needs to throw exeption
            return badRequest("Device Name Already exist");
        }
    }

    @PUT
    @Path("/{deviceId}")
    @Produces(MediaType.APPLICATION_JSON)
  //  RequiresPermissions("Modify Network Device")
    public Response modifyNetworkDevice(@PathParam("deviceId") Integer deviceId, @Nullable String deviceName, @Context HttpServletRequest request) {
        if (deviceId == null || deviceId <= 0) return badRequest("Invalid Network Denice id");
        if (deviceName == null || deviceName.trim().isEmpty()) return badRequest("Network Denice name is not provided");
        //User logonUser = auth.getLogonUser(request) // log on user to keep record who modify device
        // deviceService.modifyNetworkDevice(deviceId, deviceName, logonUser);
        return success();
    }

    // in service layer
    public NetworkDevice modifyNetworkDevice(int deviceId, String newDeviceName /*, User user*/) {
        /*

        if (networkDeviceDAO.networkDeviceNameExist(newDeviceName) ) {
            ew throw InvalidException("Network Device name already exist");
        }
        NetworkDevice netDevice = networkDeviceDAO.getNetworkDevice(deviceId);
        if (netDevice == null) new throw InvalidException("Network Device does not exist");
        NetworkDevice modifyNetDev = new NetworkDevice(netDevice.getId(), newDeviceName, netDevice.isCurrentlyBooked());
        LOOGER.info("deviceId={}, Modify network device name form {}, to {} by {}", netDevice.getId(), netDevice.getName(), newDeviceName, user.getName() );
        return networkDeviceDAO.modifyNetworkDevice(modifyNetDev)
        * */
        return null;
    }

    @DELETE
    @Path("/{deviceId}")
    @Produces(MediaType.APPLICATION_JSON)
 //   RequiresPermissions("delete Network Device")
    public Response deleteNetworkDevice(@PathParam("deviceId") Integer deviceId, @Context HttpServletRequest request) {
        if (deviceId == null || deviceId <= 0) return badRequest("Invalid Network Denice id");
        //User logonUser = auth.getLogonUser(request) // log on user to keep record who delete device
        // deviceService.deleteNetworkDevice(deviceId, logonUser);
        return success();
    }

}
