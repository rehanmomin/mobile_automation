package com.hubilo.pojo.ui;

/**
 * @created: 2022-05-14-11:39 PM
 * @project: Hubilo_App_Automation under @package: @package: com.hubilo.pojo.ui
 * @author: Rehan
 **/

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "EVENT_TYPE",
        "EVENT_NAME",
        "EMAIL",
        "PASSWORD",
        "IS_OTP",
        "OTP",
        "EVENTID",
        "ORGANIZERID",
        "EVENT"
})
public class LoginData {

    @JsonProperty("EVENTID")
    private String eventId;

    @JsonProperty("ORGANIZERID")
    private String orgId;

    @JsonProperty("EVENT")
    private String event;

    @JsonProperty("EVENT_TYPE")
    private String eventType;

    @JsonProperty("EVENT_NAME")
    private String eventName;
    @JsonProperty("EMAIL")
    private String email;
    @JsonProperty("PASSWORD")
    private String password;
    @JsonProperty("IS_OTP")
    private String isOtp;
    @JsonProperty("OTP")
    private String otp;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("EVENTID")
    public String getEventId() {
        return eventId;
    }

    @JsonProperty("ORGANIZERID")
    public String getOrgId() {
        return orgId;
    }

    @JsonProperty("EVENT")
    public String getEvent() {
        return event;
    }

    @JsonProperty("EVENT_TYPE")
    public String getEventType() {
        return eventType;
    }

    @JsonProperty("EVENT_TYPE")
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @JsonProperty("EVENT_NAME")
    public String getEventName() {
        return eventName;
    }

    @JsonProperty("EVENT_NAME")
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @JsonProperty("EMAIL")
    public String getEmail() {
        return email;
    }

    @JsonProperty("EMAIL")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("PASSWORD")
    public String getPassword() {
        return password;
    }

    @JsonProperty("PASSWORD")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("OTP")
    public String getOtp() {
        return otp;
    }

    @JsonProperty("OTP")
    public void setOtp(String otp) {
        this.otp = otp;
    }

}