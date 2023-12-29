package com.example.kiemtra.model;

public class SanPham {
    private int masp;
    private String tensp;
    private double giatien;
    private String Image;

    public SanPham(int masp, String tensp, double giatien, String image) {
        this.masp = masp;
        this.tensp = tensp;
        this.giatien = giatien;
        Image = image;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public double getGiatien() {
        return giatien;
    }

    public void setGiatien(double giatien) {
        this.giatien = giatien;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
