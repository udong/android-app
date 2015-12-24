/*
 * Copyright (c) 2015.  In-Kyu Heyden Han
 * 문의 : dlsrb0412@naver.com
 */

package haninkyu.yoo_dong.doing.model;

import haninkyu.yoo_dong.done.model.Constant;

/**
 * Created by IVE on 2015-12-11.
 */

public class ClubData implements MyData{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(int leaderId) {
        this.leaderId = leaderId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getPublicLevel() {
        return publicLevel;
    }

    public void setPublicLevel(int publicLevel) {
        this.publicLevel = publicLevel;
    }

    public int getCurrentMember() {
        return currentMember;
    }

    public void setCurrentMember(int currentMember) {
        this.currentMember = currentMember;
    }

    public int getMaxMember() {
        return maxMember;
    }

    public void setMaxMember(int maxMember) {
        this.maxMember = maxMember;
    }

    public String getMeeting() {
        return meeting;
    }

    public void setMeeting(String meeting) {
        this.meeting = meeting;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public int getClubLevel() {
        return clubLevel;
    }

    public void setClubLevel(int clubLevel) {
        this.clubLevel = clubLevel;
    }

    public double getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(double averageAge) {
        this.averageAge = averageAge;
    }

    public String getModDate() {
        return modDate;
    }

    public void setModDate(String modDate) {
        this.modDate = modDate;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    String name = "우동";
    int regionId = 1;
    int leaderId = 1;
    int categoryId = 1;
    int publicLevel = 1;
    int currentMember = 12;
    int maxMember = 20;
    String meeting = "2015-12-13";
    int fee = 20000;
    String description = "벌레들의 천국";
    String logoUrl = Constant.URLS[12];
    int clubLevel = 1;
    double averageAge = 27.5;
    String modDate = "2015-12-11";
    String regDate = "2015-12-11";
}
