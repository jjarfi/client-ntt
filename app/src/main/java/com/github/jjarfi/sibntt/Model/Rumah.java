package com.github.jjarfi.sibntt.Model;

public class Rumah {
    private int id;
    private String namarumah;
    private String deskripsi;
    private String link;
    private String createdate;
    private int createdby;
    private int suku;

    public Rumah() {
    }

    public Rumah(int id, String namarumah, String deskripsi, String link, String createdate, int createdby, int suku) {
        this.id = id;
        this.namarumah = namarumah;
        this.deskripsi = deskripsi;
        this.link = link;
        this.createdate = createdate;
        this.createdby = createdby;
        this.suku = suku;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamarumah() {
        return namarumah;
    }

    public void setNamarumah(String namarumah) {
        this.namarumah = namarumah;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public int getCreatedby() {
        return createdby;
    }

    public void setCreatedby(int createdby) {
        this.createdby = createdby;
    }

    public int getSuku() {
        return suku;
    }

    public void setSuku(int suku) {
        this.suku = suku;
    }
}
