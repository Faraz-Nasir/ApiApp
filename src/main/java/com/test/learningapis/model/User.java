package com.test.learningapis.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="first_name",nullable=false)
    private String firstName;
    
    @Column(name="last_name",nullable=false)
    private String lastName;

    @Column(name="email",nullable=false)
    private String email;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at",nullable=false)
    private Date createdAt;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_by",nullable=false)
    private String createdBy;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at",nullable=false)
    private Date updatedAt;
    
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_by",nullable=false)
    private String updatedBy;

    @Override
    public String toString(){
        return "User{"+
                    "id="+id+
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", email='" + email + '\'' +
                    ", createdAt=" + createdAt +
                    ", createdBy='" + createdBy + '\'' +
                    ", updatedAt=" + updatedAt +
                    ", updatedby='" + updatedBy + '\'' +
                    '}';
    }
}
