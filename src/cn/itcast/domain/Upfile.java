package cn.itcast.domain;

import java.util.Date;

/**
 * Created by yvettee on 2017/10/19.
 */
public class Upfile {
    private String id;
    private String uuidName;  //上传文件的名称，文件的uuid名
    private String fileName; //上传文件的真实名称
    private String savePath;     //记住文件的位置
    private Date upTime;     //文件的上传时间
    private String description;  //文件的描述
    private String userName;   //上传人

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUuidName() {
        return uuidName;
    }

    public void setUuidName(String uuidName) {
        this.uuidName = uuidName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
