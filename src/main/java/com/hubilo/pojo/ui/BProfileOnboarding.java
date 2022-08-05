package com.hubilo.pojo.ui;

import com.fasterxml.jackson.annotation.*;

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
        "GENDER",
        "ABOUT",
        "DESIGNATION",
        "ORGANISATION",
        "COUNTRY",
        "STATE",
        "CITY",
        "INDUSTRY",
        "WEBSITE",
        "FACEBOOK",
        "LINKEDIN",
        "TWITTER",
        "INSTAGRAM",
        "LOOKING_FOR",
        "OFFERING",
        "INTEREST",
        "PASSWORD",
        "OTP"
})

public class BProfileOnboarding {

    @JsonProperty("TC_NAME")
    private String tc;
    @JsonProperty("EMAIL")
    private String email;
    @JsonProperty("FIRST_NAME")
    private String firstName;
    @JsonProperty("LAST_NAME")
    private String lastName;
    @JsonProperty("GENDER")
    private String gender;
    @JsonProperty("ABOUT")
    private String about;
    @JsonProperty("DESIGNATION")
    private String designation;
    @JsonProperty("ORGANISATION")
    private String organisation;
    @JsonProperty("COUNTRY")
    private String country;
    @JsonProperty("STATE")
    private String state;
    @JsonProperty("CITY")
    private String city;
    @JsonProperty("INDUSTRY")
    private String industry;
    @JsonProperty("WEBSITE")
    private String website;
    @JsonProperty("FACEBOOK")
    private String facebook;
    @JsonProperty("LINKEDIN")
    private String linkedin;
    @JsonProperty("TWITTER")
    private String twitter;
    @JsonProperty("INSTAGRAM")
    private String instagram;
    @JsonProperty("LOOKING_FOR")
    private String lookingFor;
    @JsonProperty("OFFERING")
    private String offering;
    @JsonProperty("INTEREST")
    private String interest;
    @JsonProperty("PASSWORD")
    private String password;
    @JsonProperty("OTP")
    private String otp;
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
    public void setEmail(String email) {
        this.email = email;
    }

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

    @JsonProperty("GENDER")
    public String getGender() {
        return gender;
    }

    @JsonProperty("GENDER")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("ABOUT")
    public String getAbout() {
        return about;
    }

    @JsonProperty("ABOUT")
    public void setAbout(String about) {
        this.about = about;
    }

    @JsonProperty("DESIGNATION")
    public String getDesignation() {
        return designation;
    }

    @JsonProperty("DESIGNATION")
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @JsonProperty("ORGANISATION")
    public String getOrganisation() {
        return organisation;
    }

    @JsonProperty("ORGANISATION")
    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    @JsonProperty("COUNTRY")
    public String getCountry() {
        return country;
    }

    @JsonProperty("COUNTRY")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("STATE")
    public String getState() {
        return state;
    }

    @JsonProperty("STATE")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("CITY")
    public String getCity() {
        return city;
    }

    @JsonProperty("CITY")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("INDUSTRY")
    public String getIndustry() {
        return industry;
    }

    @JsonProperty("INDUSTRY")
    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @JsonProperty("WEBSITE")
    public String getWebsite() {
        return website;
    }

    @JsonProperty("WEBSITE")
    public void setWebsite(String website) {
        this.website = website;
    }

    @JsonProperty("FACEBOOK")
    public String getFacebook() {
        return facebook;
    }

    @JsonProperty("FACEBOOK")
    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    @JsonProperty("LINKEDIN")
    public String getLinkedin() {
        return linkedin;
    }

    @JsonProperty("LINKEDIN")
    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    @JsonProperty("TWITTER")
    public String getTwitter() {
        return twitter;
    }

    @JsonProperty("TWITTER")
    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    @JsonProperty("INSTAGRAM")
    public String getInstagram() {
        return instagram;
    }

    @JsonProperty("INSTAGRAM")
    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    @JsonProperty("LOOKING_FOR")
    public String getLookingFor() {
        return lookingFor;
    }

    @JsonProperty("LOOKING_FOR")
    public void setLookingFor(String lookingFor) {
        this.lookingFor = lookingFor;
    }

    @JsonProperty("OFFERING")
    public String getOffering() {
        return offering;
    }

    @JsonProperty("OFFERING")
    public void setOffering(String offering) {
        this.offering = offering;
    }

    @JsonProperty("INTEREST")
    public String getInterest() {
        return interest;
    }

    @JsonProperty("INTEREST")
    public void setInterest(String interest) {
        this.interest = interest;
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
