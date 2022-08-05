package com.hubilo.pojo.ui;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

/**
 * @created: 2022-07-14-12:26 PM
 * @project: Mobile_UI_Automation under @package: @package: com.hubilo.pojo.ui
 * @author: preetam
 **/

@JsonPropertyOrder({
        "sigup",
        "onboarding_profile"
})

public class BulkData {

    @JsonProperty("chat")
    private List<BChatMessage> chatMessages=null;
    @JsonProperty("sigup")
    private List<BSignUp> bSignUp = null;
    @JsonProperty("onboarding_profile")
    private List<BProfileOnboarding> bProfileOnboardings = null;

    @JsonProperty("sigup")
    public List<BSignUp> getBSignUp() {
        return bSignUp;
    }

    @JsonProperty("sigup")
    public void setBSignUp(List<BSignUp> bSignUp) {
        this.bSignUp = bSignUp;
    }

    @JsonProperty("onboarding_profile")
    public List<BProfileOnboarding> getBProfileOnboarding() {
        return bProfileOnboardings;
    }

    @JsonProperty("onboarding_profile")
    public void setBProfileOnboarding(List<BProfileOnboarding> bProfileOnboardings) {
        this.bProfileOnboardings = bProfileOnboardings;
    }

    @JsonProperty("chat")
    public List<BChatMessage> getChatMessages() {
        return chatMessages;
    }

    @JsonProperty("chat")
    public void setChatMessages(List<BChatMessage> chatMessages) {
        this.chatMessages = chatMessages;
    }

}
