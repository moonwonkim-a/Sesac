package com.ohgirafferas.associationmapping.section01.manytoone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="Section01Category")
@Table(name="tbl_category")
public class Category {

    @Id
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;  // null값을 취급해야 하는데 기본자료형은 null값을 취급하지 못함. 그래서 wrapper형으로 씀

    public Category() {}

    public Category(int categoryCode, String categoryName, Integer ref_categoryCode) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = ref_categoryCode;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getRef_categoryCode() {
        return refCategoryCode;
    }

    public void setRef_categoryCode(Integer ref_categoryCode) {
        this.refCategoryCode = ref_categoryCode;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", ref_categoryCode=" + refCategoryCode +
                '}';
    }
}
