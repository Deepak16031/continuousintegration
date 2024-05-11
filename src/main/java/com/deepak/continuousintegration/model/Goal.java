package com.deepak.continuousintegration.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class Goal implements Serializable {

    @Serial
    private static final long serialVersionUID = -2396568209586372737L;

    @NotBlank
    String name;
    String description;
    String reason;
    Date createdOn;
    Date updatedOn;
    String status;

}
