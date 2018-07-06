package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserRole implements Serializable {

    private static final long serialVersionUID = -6884405461844911485L;

    private Integer id;
    private String roleName;
    private List<String> authInfo;
    private AuthToken authToken;
}
