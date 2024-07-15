package com.ecommerce.demo.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
public class Customer extends BaseEntity{
    private String name;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;

    public Customer(Long customerId) {
    }
}
