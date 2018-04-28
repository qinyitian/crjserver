package com.edu.fjnu.cjrserver.model;

/**
 * Created by 朱仲 on 2018/4/24.
 */
public class Media {
    private int mediaId;
    private String phone;
    private String password;
    private String inviteCode;
    private String mediaName;
    private int state;

    @Override
    public String toString() {
        return "Meida{" +
                "mediaId=" + mediaId +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", inviteCode='" + inviteCode + '\'' +
                ", mediaName='" + mediaName + '\'' +
                ", state=" + state +
                '}';
    }

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
