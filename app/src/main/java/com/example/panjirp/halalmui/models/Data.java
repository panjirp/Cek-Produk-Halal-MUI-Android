package com.example.panjirp.halalmui.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by panjirp on 11/09/2017.
 */

public class Data {
    @SerializedName("nama_produk")
    @Expose
    private String namaProduk;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("kategori_id")
    @Expose
    private int kategori_id;
    @SerializedName("nama_produsen")
    @Expose
    private String namaProdusen;
    @SerializedName("berlaku_hingga")
    @Expose
    private String berlakuHingga;
    @SerializedName("url")
    @Expose
    private String mUrl;

        /**
         *
         * @return
         * namaProduk
         */
        public String getNamaProduk() {
            return namaProduk;
        }
        /**
         *
         * @param namaProduk
         * The overview
         */
        public void setNamaProduk(String namaProduk) {
            this.namaProduk = namaProduk;
        }
        /**
         *
         * @return
         * nama
         */
    public String getNama() {
        return nama;
    }
    /**
     *
     * @param nama
     * The overview
     */
    public void setNama(String nama) {this.nama= nama;}
    /**
     *
     * @return
     * kategori_id
     */
    public int getKategori_id() {
        return kategori_id;
    }
    /**
     *
     * @param kategori_id
     * The overview
     */
    public void setKategori_id(int kategori_id) {
        this.kategori_id= kategori_id;
    }
    /**
     *
     * @return
     * nama produsen
     */
    public String getNamaProdusen() {
        return namaProdusen;
    }
    /**
     *
     * @param namaProdusen
     * The overview
     */
    public void setNamaProdusen(String namaProdusen) {
        this.namaProdusen = namaProdusen;
    }
    /**
     *
     * @return
     * berlaku hingga
     */
    public String getBerlakuHingga() {
        return berlakuHingga;
    }
    /**
     *
     * @param berlakuHingga
     * The overview
     */
    public void setBerlakuHingga(String berlakuHingga) {
        this.berlakuHingga = berlakuHingga;
    }
    /**
     *
     * @return
     * Url
     */
    public String getUrl() {
        return mUrl;
    }
    /**
     *
     * @param mUrl
     * The overview
     */
    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
