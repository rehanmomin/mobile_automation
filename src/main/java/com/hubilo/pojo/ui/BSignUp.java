package com.hubilo.pojo.ui;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

/**
 * @created: 2022-07-14-12:26 PM
 * @project: Mobile_UI_Automation under @package: @package: com.hubilo.pojo.ui
 * @author: preetam
 **/


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "TC_NAME",
        "EMAIL",
        "FIRST_NAME",
        "LAST_NAME",
        "NEW_PASSWORD",
        "CONFIRM_PASSWORD"
})

public class BSignUp {

    @JsonProperty("TC_NAME")
    private String tc;

    @JsonProperty("EMAIL")
    private String email;
    @JsonProperty("FIRST_NAME")
    private String firstName;
    @JsonProperty("LAST_NAME")
    private String lastName;
    @JsonProperty("NEW_PASSWORD")
    private String newPassword;
    @JsonProperty("CONFIRM_PASSWORD")
    private String confirmPassword;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("TC_NAME")
    public String getTC() {
        return tc;
    }

    @JsonProperty("TC_NAME")
    public void setTC(String tc) { this.tc = tc; }

    @JsonProperty("EMAIL")
    public String getEmail() {
        return email;
    }

    @JsonProperty("EMAIL")
    public void setEmail(String email) { this.email = email; }

    @JsonProperty("FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("FIRST_NAME")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("LAST_NAME")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("NEW_PASSWORD")
    public String getNewPassword() {
        return newPassword;
    }

    @JsonProperty("NEW_PASSWORD")
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @JsonProperty("CONFIRM_PASSWORD")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    @JsonProperty("CONFIRM_PASSWORD")
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
