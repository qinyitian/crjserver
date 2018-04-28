package com.edu.fjnu.cjrserver.model;

/**
 * Created by 朱仲 on 2018/4/24.
 */
public class InviteCode {
    private String invite_code;
    private int state;

    @Override
    public String toString() {
        return "InviteCode{" +
                "invite_code='" + invite_code + '\'' +
                ", state=" + state +
                '}';
    }

    public String getInvite_code() {
        return invite_code;
    }

    public void setInvite_code(String invite_code) {
        this.invite_code = invite_code;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
