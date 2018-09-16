package com.example.rajnikantpandey.gridviewnew;

/**
 * Created by Rajnikant Pandey on 8/16/2018.
 */

public class ItemRow {
    String  data;

    public ItemRow(String dat)
    {

        // this.number = number;
        this.setImage(dat);
        // this.setNumber(number);
    }

    public void setImage(String dat) {
        this.data = dat;
    }

    public String getImage() {

        return data;
    }
}
