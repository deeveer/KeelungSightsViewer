package com.example.demo;

public class Sight {
    private String SightName;
    private String Zone;
    private String Category;
    private String PhotoURL;
    private String Description;
    private String Address;

    @Override
    public String toString() {
        return "SightName: " +this.getSightName()+"\n"+
                "Zone: " +this.getZone()+"\n"+
                "Category: " +this.getCategory()+"\n"+
                "PhotoURL: " +this.getPhotoURL()+"\n"+
                "Description: " +this.getDescription()+"\n"+
                "Address: " +this.getAddress()+"\n\n";
    }

    public String getSightName() {
        return SightName;
    }

    public void setSightName(String sightName) {
        SightName = sightName;
    }

    public String getZone() {
        return Zone;
    }

    public void setZone(String zone) {
        Zone = zone;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhotoURL() {
        return PhotoURL;
    }

    public void setPhotoURL(String photoURL) {
        PhotoURL = photoURL;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
