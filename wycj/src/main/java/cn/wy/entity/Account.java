package cn.wy.entity;

public class Account {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 用户密码
     */
    private String userPwd;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 用户联系方式
     */
    private Integer userTel;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 用户性别
     */
    private String userSex;

    /**
     * 收货地址
     */
    private String userAddress;

    /**
     * 是否删除
     */
    private String isDelete;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Integer getUserTel() {
        return userTel;
    }

    public void setUserTel(Integer userTel) {
        this.userTel = userTel;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userId='" + userId + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userName='" + userName + '\'' +
                ", roleId='" + roleId + '\'' +
                ", userTel=" + userTel +
                ", userEmail='" + userEmail + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", isDelete='" + isDelete + '\'' +
                '}';
    }
}
