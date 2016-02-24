package com.chris.app.saveme.models;

import android.media.Image;

import java.util.Date;

/**
 * Created by Chris on 12/09/2015.
 */
public class DealModel {

    private String saveType, title, link, details, retailer, urlImage, tags, user;
    private int votes, _id;
    private double price;
    private Image image;
    private Date startdate, enddate, created;

    public DealModel(int _id, String saveType, String title, String link, String details, String retailer, String urlImage, String tags, String user, int votes, double price, Image image, Date startdate, Date enddate, Date created) {
        this._id = _id;
        this.saveType = saveType;
        this.title = title;
        this.link = link;
        this.details = details;
        this.retailer = retailer;
        this.urlImage = urlImage;
        this.tags = tags;
        this.user = user;
        this.votes = votes;
        this.price = price;
        this.image = image;
        this.startdate = startdate;
        this.enddate = enddate;
        this.created = created;
    }

    public DealModel(){

    }

    public String getSaveType() {
        return saveType;
    }

    public void setSaveType(String saveType) {
        this.saveType = saveType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getRetailer() {
        return retailer;
    }

    public void setRetailer(String retailer) {
        this.retailer = retailer;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
