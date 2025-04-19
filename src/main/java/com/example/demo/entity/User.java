package com.example.demo.entity;

import jakarta.persistence.*;

@Entity // Marks this as a JPA entity
@Table(name = "users") // Specifies the table name in the database
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments ID
    private Long id;

    @Column(nullable = false) // Ensures name cannot be null
    private String name;

    @Column(nullable = false, unique = true) // Ensures unique email constraint
    private String email;

    // ✅ Default Constructor (Required by JPA)
    public User() {
    }

    // ✅ Parameterized Constructor (For creating new users)
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // ✅ Getters and Setters (To access and modify private fields)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // ✅ Optional: Override `toString()` for debugging
    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}
