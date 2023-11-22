package main.org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private Integer id;
    private String name;
    private String details;

    private boolean isActive;
    private Role role;

    private Timestamp createdIs;
    private Timestamp update;


}
