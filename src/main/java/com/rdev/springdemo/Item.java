package com.rdev.springdemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Integer id;
    String item;
    String category;
    Boolean available;    
}
