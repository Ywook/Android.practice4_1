package com.examples.androidpractice4_1;

/**
 * Created by Mac on 2017. 3. 30..
 */

public class Restaurant {
    private String tableName, enterTime, spagetti, pizza, member, price;


    public Restaurant(String tableName, String enterTime) {
        this.tableName = tableName;
        this.enterTime = enterTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTableName() {
        return tableName;
    }

    public String getEnterTime() {
        return enterTime;
    }

    public String getSpagetti() {
        return spagetti;
    }

    public String getPizza() {
        return pizza;
    }

    public String getMember() {
        return member;
    }

    public void setSpagetti(String spagetti) {
        this.spagetti = spagetti;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public void setMember(String member) {
        this.member = member;
    }
}
