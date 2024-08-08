package jmgomez.wiremock.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Policy {
    @JsonProperty("polizaId")
    private String id;
    private User user;
    @JsonProperty("descripcion")
    private String description;
    @JsonProperty("coberturas")
    private String[] coverages;
    @JsonProperty("condiciones")
    private String[] conditions;
    @JsonProperty("siniestros")
    private Sinister[] accidents;

    public Policy() {}
    public Policy(Sinister[] accidents, User user, String[] coverages, String[] conditions, String description, String id) {
        this.id = id;
        this.user = user;
        this.description = description;
        this.coverages = coverages;
        this.conditions = conditions;
        this.accidents = accidents;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String[] getCoverages() {
        return coverages;
    }
    public void setCoverages(String[] coverages) {
        this.coverages = coverages;
    }
    public String[] getConditions() {
        return conditions;
    }
    public void setConditions(String[] conditions) {
        this.conditions = conditions;
    }
    public Sinister[] getAccidents() {
        return accidents;
    }
    public void setAccidents(Sinister[] accidents) {
        this.accidents = accidents;
    }
}
