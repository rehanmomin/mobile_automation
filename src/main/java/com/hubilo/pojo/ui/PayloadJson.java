package com.hubilo.pojo.ui;

/**
 * @created: 2022-05-14-11:42 PM
 * @project: Hubilo_App_Automation under @package: @package: com.hubilo.pojo.ui
 * @author: Rehan
 **/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "loginData",
        "signUpData"
})
@Generated("jsonschema2pojo")
public class PayloadJson {

    @JsonProperty("loginData")
    private List<LoginData> loginData = null;
    @JsonProperty("signUpData")
    private List<SignUpData> signUpData = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("loginData")
    public List<LoginData> getLoginData() {
        return loginData;
    }

    @JsonProperty("loginData")
    public void setLoginData(List<LoginData> loginData) {
        this.loginData = loginData;
    }

    @JsonProperty("signUpData")
    public List<SignUpData> getSignUpData() {
        return signUpData;
    }

    @JsonProperty("signUpData")
    public void setSignUpData(List<SignUpData> signUpData) {
        this.signUpData = signUpData;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}