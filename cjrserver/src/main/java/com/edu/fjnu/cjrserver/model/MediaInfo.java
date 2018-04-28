package com.edu.fjnu.cjrserver.model;

/**
 * Created by 朱仲 on 2018/4/24.
 */
public class MediaInfo {
    private String mediaName;
    private String address;
    private String email;
    private String introduction;

    @Override
    public String toString() {
        return "MeidaInfo{" +
                "mediaName='" + mediaName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
