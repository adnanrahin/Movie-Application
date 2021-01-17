package com.spring.boot.movie.app.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "customer", schema = "sakila")
public class Customer {

    public Customer() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "address_id")
    private Integer addressId;

    @Column(name = "active")
    private Integer active;

    @Column(name = "create_date")
    private Timestamp createDate;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long id) {
        this.customerId = id;
    }

    public Store getStoreId() {
        return store;
    }

    public void setStoreId(Store store) {
        this.store = store;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer tinyInt) {
        this.active = tinyInt;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp dateTime) {
        this.createDate = dateTime;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
