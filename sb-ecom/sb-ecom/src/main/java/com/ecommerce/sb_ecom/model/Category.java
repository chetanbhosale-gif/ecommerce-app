package com.ecommerce.sb_ecom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Entity //@Entity(name="Categories") Sets name of table to categories.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryID;
    private String categoryName;

//    public Category(long categoryID, String categoryName) {
//        this.categoryID = categoryID;
//        this.categoryName = categoryName;
//    }
//    public Category(){
//
//    }
//
//    public long getCategoryID() {
//        return categoryID;
//    }
//
//    public void setCategoryID(long categoryID) {
//        this.categoryID = categoryID;
//    }
//
//    public String getCategoryName() {
//        return categoryName;
//    }
//
//    public void setCategoryName(String categoryName) {
//        this.categoryName = categoryName;
//    }
}
