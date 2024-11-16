package com.example.demo.ModelEntity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModelProduct {

    private String name;
    private Double price;
    private Integer quantity;
}
