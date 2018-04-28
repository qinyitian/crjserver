package com.edu.fjnu.cjrserver.model;

/**
 * DisabledUser 使用主体残疾人用户
 *
 * @version 	2018-02-22
 * @author 	吴祖根
 */
public class DisabledUser {

    /* 残疾人用户ID */
    private Integer disabilityId;
    /* 账号密码 */
    private String password;
    /* 用户联系电话 */
    private String telephone;
    /* 残疾人证号 */
    private String disabilityIdentity;

    public Integer getDisabilityId() {
        return disabilityId;
    }

    public void setDisabilityId(Integer disabilityId) {
        this.disabilityId = disabilityId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDisabilityIdentity() {
        return disabilityIdentity;
    }

    public void setDisabilityIdentity(String disabilityIdentity) {
        this.disabilityIdentity = disabilityIdentity;
    }
}
