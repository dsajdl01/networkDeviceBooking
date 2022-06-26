package org.response.json;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingFilterJson
{
    @JsonProperty("deviceId")
    private Integer deviceId;

    @JsonProperty("startDate")
    private Date startDate;

    @JsonProperty("endDate")
    private Date endDate;

    @JsonCreator
    public BookingFilterJson(@JsonProperty("deviceId") final Integer deviceId,
                             @JsonProperty("startDate") final Date startDate,
                             @JsonProperty("endDate") final Date endDate)
    {
        this.deviceId = deviceId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getDeviceId()
    {
        return deviceId;
    }

    public Date getStartDate()
    {
        return startDate;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    @Override
    public String toString()
    {
        return "BookingFilterJson{" +
                "deviceId=" + deviceId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
