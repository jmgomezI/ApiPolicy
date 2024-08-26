package jmgomez.apipolicy.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @JsonProperty("dni")
    private String id;
    private String password;
    private List<Policy> policies;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
