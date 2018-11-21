package com.myApp.pages.entities;

public class ProductSearchDetail {
    public String title;
    public String brandName;
    public String ratingCount;
    public String evaluationRate;

    public ProductSearchDetail(String title, String brandName, String ratingCount, String evaluationRate) {
        this.title = title;
        this.brandName = brandName;
        this.ratingCount = ratingCount;
        this.evaluationRate = evaluationRate;
    }
}
