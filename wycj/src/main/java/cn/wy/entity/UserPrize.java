package cn.wy.entity;

import java.util.Date;

public class UserPrize {

    /**
     * id
     */
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 奖品id
     */
    private String prizeId;

    /**
     * 获奖时间
     */
    private Date prizeTime;

    /**
     * 奖品状态 0未领取/1已领取
     */
    private String state;

    /**
     * 是否删除
     */
    private String isDelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(String prizeId) {
        this.prizeId = prizeId;
    }

    public Date getPrizeTime() {
        return prizeTime;
    }

    public void setPrizeTime(Date prizeTime) {
        this.prizeTime = prizeTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "UserPrize{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", prizeId='" + prizeId + '\'' +
                ", prizeTime=" + prizeTime +
                ", state='" + state + '\'' +
                ", isDetele='" + isDelete + '\'' +
                '}';
    }
}
