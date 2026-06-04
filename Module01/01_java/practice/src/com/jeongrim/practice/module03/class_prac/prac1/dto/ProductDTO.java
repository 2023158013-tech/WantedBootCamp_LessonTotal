package com.jeongrim.practice.module03.class_prac.prac1.dto;

public class ProductDTO {
    private String productId; //상품 아이디
    private String productName; //상품명
    private String productArea; //생산지
    private int price; //가격
    private double tax;

    public ProductDTO(String productId, String productName, String productArea,
                       int price, double tax) {
        this.productId = productId;
        this.productName = productName;
        this.productArea = productArea;
        this.price = price;
        this.tax = tax;
    }


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductArea() {
        return productArea;
    }

    public void setProductArea(String productArea) {
        this.productArea = productArea;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
    public String getInformation() {
        return this.productId + " " + this.productName + " " + this.productArea + " " +
                this.price + " " + this.tax;
    }
}