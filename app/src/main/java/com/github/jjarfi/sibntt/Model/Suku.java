package com.github.jjarfi.sibntt.Model;

import java.sql.Timestamp;

public class Suku {

    private int id;
    private String namasuku;
    private String deskripsi;
    private String link;
    private Timestamp createdate;
    private int createdby;

    public Suku() {
    }

    public Suku(int id, String namasuku, String deskripsi, String link, Timestamp createdate, int createdby) {
        this.id = id;
        this.namasuku = namasuku;
        this.deskripsi = deskripsi;
        this.link = link;
        this.createdate = createdate;
        this.createdby = createdby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamasuku() {
        return namasuku;
    }

    public void setNamasuku(String namasuku) {
        this.namasuku = namasuku;
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

    public Timestamp getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }

    public int getCreatedby() {
        return createdby;
    }

    public void setCreatedby(int createdby) {
        this.createdby = createdby;
    }
}
