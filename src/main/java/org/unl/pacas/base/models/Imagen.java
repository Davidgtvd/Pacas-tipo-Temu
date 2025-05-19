package org.unl.pacas.base.models;

public class Imagen {
    private Integer id;
    private String url;
    private Integer prendaId; // Puede ser null si la imagen es de una paca
    private Integer pacaId;   // Puede ser null si la imagen es de una prenda

    public Imagen() {}

    public Imagen(Integer id, String url, Integer prendaId, Integer pacaId) {
        this.id = id;
        this.url = url;
        this.prendaId = prendaId;
        this.pacaId = pacaId;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public Integer getPrendaId() { return prendaId; }
    public void setPrendaId(Integer prendaId) { this.prendaId = prendaId; }

    public Integer getPacaId() { return pacaId; }
    public void setPacaId(Integer pacaId) { this.pacaId = pacaId; }
}