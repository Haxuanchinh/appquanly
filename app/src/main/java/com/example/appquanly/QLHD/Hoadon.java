package com.example.appquanly.QLHD;

public class Hoadon {
    private int mahd;
    private String tensp;
    private  int soluong;
    private int giatien;
    private  String date;
    private  int tien;

    public Hoadon(int mahd, String tensp, int soluong, int giatien, String date) {
        this.mahd = mahd;
        this.tensp = tensp;
        this.soluong = soluong;
        this.giatien = giatien;
        this.date = date;
        this.tien = tien;
    }

    public Hoadon() {
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getGiatien() {
        return giatien;
    }

    public void setGiatien(int giatien) {
        this.giatien = giatien;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTien() {
        return tien;
    }

    public void setTien(int tien) {
        this.tien = tien;
    }
}
