package com.hubilo.pojo.api.setting;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"isChatEnabled",
"isMeetingEnabled",
"isNotificationEnabled",
"showEventDate",
"isOtpMailSupported",
"isHiddenInMultiEventApp"
})
@Generated("jsonschema2pojo")
public class SettingGeneral_Data {

@JsonProperty("isChatEnabled")
private String isChatEnabled;
@JsonProperty("isMeetingEnabled")
private String isMeetingEnabled;
@JsonProperty("isNotificationEnabled")
private String isNotificationEnabled;
@JsonProperty("showEventDate")
private String showEventDate;
@JsonProperty("isOtpMailSupported")
private String isOtpMailSupported;
@JsonProperty("isHiddenInMultiEventApp")
private String isHiddenInMultiEventApp;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("isChatEnabled")
public String getIsChatEnabled() {
return isChatEnabled;
}

@JsonProperty("isChatEnabled")
public void setIsChatEnabled(String isChatEnabled) {
this.isChatEnabled = isChatEnabled;
}

@JsonProperty("isMeetingEnabled")
public String getIsMeetingEnabled() {
return isMeetingEnabled;
}

@JsonProperty("isMeetingEnabled")
public void setIsMeetingEnabled(String isMeetingEnabled) {
this.isMeetingEnabled = isMeetingEnabled;
}

@JsonProperty("isNotificationEnabled")
public String getIsNotificationEnabled() {
return isNotificationEnabled;
}

@JsonProperty("isNotificationEnabled")
public void setIsNotificationEnabled(String isNotificationEnabled) {
this.isNotificationEnabled = isNotificationEnabled;
}

@JsonProperty("showEventDate")
public String getShowEventDate() {
return showEventDate;
}

@JsonProperty("showEventDate")
public void setShowEventDate(String showEventDate) {
this.showEventDate = showEventDate;
}

@JsonProperty("isOtpMailSupported")
public String getIsOtpMailSupported() {
return isOtpMailSupported;
}

@JsonProperty("isOtpMailSupported")
public void setIsOtpMailSupported(String isOtpMailSupported) {
this.isOtpMailSupported = isOtpMailSupported;
}

@JsonProperty("isHiddenInMultiEventApp")
public String getIsHiddenInMultiEventApp() {
return isHiddenInMultiEventApp;
}

@JsonProperty("isHiddenInMultiEventApp")
public void setIsHiddenInMultiEventApp(String isHiddenInMultiEventApp) {
this.isHiddenInMultiEventApp = isHiddenInMultiEventApp;
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
