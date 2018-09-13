package cn.wy.entity;

public class Auth {

    /**
     * 权限id
     */
    private String authId;

    /**
     * 权限名称
     */
    private String authName;

    /**
     * 权限说明
     */
    private String authDes;

    /**
     * 权限地址
     */
    private String authUrl;

    /**
     * 是否删除
     */
    private String isDelete;

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getAuthDes() {
        return authDes;
    }

    public void setAuthDes(String authDes) {
        this.authDes = authDes;
    }

    public String getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
}
