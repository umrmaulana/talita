package com.example.gramedia.ui.profile;

public class DataUser {
    private String email, nama, alamat, kota, provinsi, telp, kodepos;
    public void setEmail(String email) { this.email=email; }
    public void setNama(String nama) { this.nama=nama; }
    public void setAlamat(String alamat) { this.alamat=alamat; }
    public void setKota(String kota) { this.kota=kota; }
    public void setProvinsi(String provinsi) { this.provinsi=provinsi; }
    public void setTelp(String telp) { this.telp=telp; }
    public void setKodepos(String kodepos) { this.kodepos=kodepos; }

    public String getEmail() {return  email;}
    public String getNama() {return  nama;}
    public String getAlamat() {return  alamat;}
    public String getKota() {return  kota;}
    public String getProvinsi() {return  provinsi;}
    public String getKodepos() {return  kodepos;}
    public String getTelp() {return  telp;}
}
