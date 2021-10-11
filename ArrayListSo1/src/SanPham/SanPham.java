/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanPham;

/**
 *
 * @author Admin
 */
public class SanPham {
    String maSp, tenSp;
    double donGia;

    public SanPham() {
        maSp = "";
        tenSp = "";
        donGia = 0;
    }

    public SanPham(String maSp, String tenSp, double donGia) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.donGia = donGia;
    }

    public double getDonGia() {
        return donGia;
    }

    public String getMaSp() {
        return maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }
    
    @Override
    public String toString() {
        return maSp + " --- " + tenSp + " --- " + donGia;
    }
}
