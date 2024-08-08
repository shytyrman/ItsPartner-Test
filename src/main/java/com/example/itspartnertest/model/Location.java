package com.example.itspartnertest.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Data
public class Location {

    @Id
    private Long id;
    private String name;
    private String address;
}
