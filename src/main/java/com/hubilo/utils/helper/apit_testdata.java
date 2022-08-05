package com.hubilo.utils.helper;

import io.appium.java_client.AppiumDriver;

import java.util.ArrayList;
import java.util.List;

public interface apit_testdata {
   ThreadLocal<String> env=new ThreadLocal<String>();
   ThreadLocal<AppiumDriver> appdriver=new ThreadLocal<AppiumDriver>();
   ThreadLocal<String> token=new ThreadLocal<String>();
   ThreadLocal<String> communitytoken=new ThreadLocal<String>();
   ThreadLocal<String> accesstoken=new ThreadLocal<String>();

   ThreadLocal<String> attendeenumber=new ThreadLocal<String>();
   ThreadLocal<String> attendeename=new ThreadLocal<String>();

   ThreadLocal<String> speakernumber=new ThreadLocal<String>();
   ThreadLocal<String> speakername=new ThreadLocal<String>();

   ThreadLocal<String> search_peopleid=new ThreadLocal<String>();
   ThreadLocal<String> boothnumber=new ThreadLocal<String>();
   ThreadLocal<String> boothname=new ThreadLocal<String>();

   ThreadLocal<String> roomnumber=new ThreadLocal<>();
   ThreadLocal<String> roomname=new ThreadLocal<>();

   ThreadLocal<String> modroomnumber=new ThreadLocal<>();
   ThreadLocal<String> modroomname=new ThreadLocal<>();

   ThreadLocal<String> codedroomnumber=new ThreadLocal<>();
   ThreadLocal<String> codedroomname=new ThreadLocal<>();
   ThreadLocal<String> mettingparticipation1=new ThreadLocal<>();

   ThreadLocal<String> mettingparticipation2=new ThreadLocal<>();
   ThreadLocal<String> mettingdescription=new ThreadLocal<>();
   ThreadLocal<String> mettingid=new ThreadLocal<>();
   ThreadLocal<String> loungenumber=new ThreadLocal<String>();
   ThreadLocal<String> loungename=new ThreadLocal<String>();
   ThreadLocal<String> agendanumber=new ThreadLocal<String>();
   ThreadLocal<String> agendaname=new ThreadLocal<String>();
   ThreadLocal<String> hbsagendanumber=new ThreadLocal<String>();
   ThreadLocal<String> search=new ThreadLocal<String>();

   ThreadLocal<String> groupid=new ThreadLocal<String>();
   ThreadLocal<String> agendastarttime=new ThreadLocal<String>();
   ThreadLocal<String> agendaendtime=new ThreadLocal<String>();
   ThreadLocal<String> eventid=new ThreadLocal<String>();
   ThreadLocal<String> eventname=new ThreadLocal<String>();
   ThreadLocal<String> expiredagendastarttime=new ThreadLocal<String>();
   ThreadLocal<String>futureagendastarttime=new ThreadLocal<String>();

   ThreadLocal<String> meetingtarttime=new ThreadLocal<String>();
   ThreadLocal<String> meetingtime=new ThreadLocal<String>();
   List<Integer> booths= new ArrayList<>();
   List<String> boothsnames= new ArrayList<>();
   List<String> agenda_numbers= new ArrayList<>();












}
