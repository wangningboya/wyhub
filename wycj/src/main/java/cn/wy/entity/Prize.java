package cn.wy.entity;

public class Prize {

    /**
     * 奖品id
     */
    private String prizeId;

    /**
     * 奖品名称
     */
    private String prizeName;

    /**
     * 奖品概率
     */
    private Double prizePro;

    /**
     * 奖品颜色
     */
    private String prizeColor;

    /**
     * 是否删除
     */
    private String isDelete;

    public String getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(String prizeId) {
        this.prizeId = prizeId;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public Double getPrizePro() {
        return prizePro;
    }

    public void setPrizePro(Double prizePro) {
        this.prizePro = prizePro;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getPrizeColor() {
        return prizeColor;
    }

    public void setPrizeColor(String prizeColor) {
        this.prizeColor = prizeColor;
    }

    @Override
    public String toString() {
        return "Prize{" +
                "prizeId='" + prizeId + '\'' +
                ", prizeName='" + prizeName + '\'' +
                ", prizePro=" + prizePro +
                ", prizeColor='" + prizeColor + '\'' +
                ", isDelete='" + isDelete + '\'' +
                '}';
    }
}
