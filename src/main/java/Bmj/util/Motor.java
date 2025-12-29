
package Bmj.util;

public class Motor {
    private String id_motor;
    private String merk;
    private String tipe;
    private String tahun;
    private String warna;
    private double harga_beli;
    private double harga;
    private String stok;
    private String gambar;

    public String getId_motor() {
        return id_motor;
    }

    public void setId_motor(String id_motor) {
        this.id_motor = id_motor;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }
    
    public String getGambar() {
        return gambar;
    }
    
    public void setGambar(String gambar){
        this.gambar = gambar;
    }

    public double getHarga_beli() {
        return harga_beli;
    }

    public void setHarga_beli(double harga_beli) {
        this.harga_beli = harga_beli;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

  
}
