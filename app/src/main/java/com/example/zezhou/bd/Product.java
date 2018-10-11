package com.example.zezhou.bd;
import java.lang.StringBuilder;

public class Product {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCategoryInt() {
        return category;
    }

    public String getCategoryString() {
        return category2String(category);
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }



    private String name;
    private String id;
    // category：
    // 1 - bulb
    // 2 - speaker
    // 3 - power board
    // 4 - switch
    // 5 - timer
    private int category;
    private int imageId;

    Product(){

    }

    Product(String name, String id, int category, int imageId){
        this.name  = name;
        this.id = id;
        this.category = category;
        this.imageId = imageId;
    }

    static String category2String(int category){
        switch(category){
            case 1:
                return "bulb";
            case 2:
                return "speaker";
            case 3:
                return "power board";
            case 4:
                return "switch";
            case 5:
                return "timer";
        }
        return "ErrorCategoryCode";
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Product name: ");
        builder.append(getName() + "  ");
        builder.append("ID: ");
        builder.append(getId() + "  ");
        builder.append("Category: " + getCategoryString());
        return builder.toString();
    }

}
