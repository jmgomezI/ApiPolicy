package jmgomez.wiremock.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sinister {
    @JsonProperty("siniestroId")
    private String id;
    @JsonProperty("estado")
    private String status;

    public Sinister() {
    }
    public Sinister(String id, String status) {
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
