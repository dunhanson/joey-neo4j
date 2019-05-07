package cn.joey.neo4j.entity;

import com.google.gson.annotations.SerializedName;

public class Project {
    @SerializedName("area")
    private String area;
    @SerializedName("info_type")
    private String infoType;
    @SerializedName("city")
    private String city;
    @SerializedName("zhong_biao_name")
    private String zhongBiaoName;
    @SerializedName("win_bid_price")
    private String winBidPrice;
    @SerializedName("project_code")
    private String projectCode;
    @SerializedName("industry")
    private String industry;
    @SerializedName("is_fei_biao")
    private String isFeiBiao;
    @SerializedName("project_name")
    private String projectName;
    @SerializedName("zhao_biao_uuid")
    private String zhaoBiaoUUID;
    @SerializedName("province")
    private String province;
    @SerializedName("district")
    private String district;
    @SerializedName("zhong_biao_page_time")
    private String zhongBiaoPageTime;
    @SerializedName("zhong_biao_uuid")
    private String zhongBiaoUUID;
    @SerializedName("zhao_biao_page_time")
    private String zhaoBiaoPageTime;
    @SerializedName("zhao_biao_name")
    private String zhaoBiaoName;
    @SerializedName("zhao_biao_id")
    private String zhaoBiaoId;
    @SerializedName("zhong_biao_id")
    private String zhongBiaoId;

    public Project() {

    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZhongBiaoName() {
        return zhongBiaoName;
    }

    public void setZhongBiaoName(String zhongBiaoName) {
        this.zhongBiaoName = zhongBiaoName;
    }

    public String getWinBidPrice() {
        return winBidPrice;
    }

    public void setWinBidPrice(String winBidPrice) {
        this.winBidPrice = winBidPrice;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getIsFeiBiao() {
        return isFeiBiao;
    }

    public void setIsFeiBiao(String isFeiBiao) {
        this.isFeiBiao = isFeiBiao;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getZhaoBiaoUUID() {
        return zhaoBiaoUUID;
    }

    public void setZhaoBiaoUUID(String zhaoBiaoUUID) {
        this.zhaoBiaoUUID = zhaoBiaoUUID;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getZhongBiaoPageTime() {
        return zhongBiaoPageTime;
    }

    public void setZhongBiaoPageTime(String zhongBiaoPageTime) {
        this.zhongBiaoPageTime = zhongBiaoPageTime;
    }

    public String getZhongBiaoUUID() {
        return zhongBiaoUUID;
    }

    public void setZhongBiaoUUID(String zhongBiaoUUID) {
        this.zhongBiaoUUID = zhongBiaoUUID;
    }

    public String getZhaoBiaoPageTime() {
        return zhaoBiaoPageTime;
    }

    public void setZhaoBiaoPageTime(String zhaoBiaoPageTime) {
        this.zhaoBiaoPageTime = zhaoBiaoPageTime;
    }

    public String getZhaoBiaoName() {
        return zhaoBiaoName;
    }

    public void setZhaoBiaoName(String zhaoBiaoName) {
        this.zhaoBiaoName = zhaoBiaoName;
    }

    public String getZhaoBiaoId() {
        return zhaoBiaoId;
    }

    public void setZhaoBiaoId(String zhaoBiaoId) {
        this.zhaoBiaoId = zhaoBiaoId;
    }

    public String getZhongBiaoId() {
        return zhongBiaoId;
    }

    public void setZhongBiaoId(String zhongBiaoId) {
        this.zhongBiaoId = zhongBiaoId;
    }

    @Override
    public String toString() {
        return "Project{" +
                "area='" + area + '\'' +
                ", infoType='" + infoType + '\'' +
                ", city='" + city + '\'' +
                ", zhongBiaoName='" + zhongBiaoName + '\'' +
                ", winBidPrice='" + winBidPrice + '\'' +
                ", projectCode='" + projectCode + '\'' +
                ", industry='" + industry + '\'' +
                ", isFeiBiao='" + isFeiBiao + '\'' +
                ", projectName='" + projectName + '\'' +
                ", zhaoBiaoUUID='" + zhaoBiaoUUID + '\'' +
                ", province='" + province + '\'' +
                ", district='" + district + '\'' +
                ", zhongBiaoPageTime='" + zhongBiaoPageTime + '\'' +
                ", zhongBiaoUUID='" + zhongBiaoUUID + '\'' +
                ", zhaoBiaoPageTime='" + zhaoBiaoPageTime + '\'' +
                ", zhaoBiaoName='" + zhaoBiaoName + '\'' +
                ", zhaoBiaoId='" + zhaoBiaoId + '\'' +
                ", zhongBiaoId='" + zhongBiaoId + '\'' +
                '}';
    }
}
