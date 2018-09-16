package com.example.rajnikantpandey.gridviewnew;

import android.widget.ImageView;
import com.bignerdranch.expandablerecyclerview.model.Parent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rajnikant Pandey on 8/16/2018.
 */

public class DataProvider implements Parent<Object> {
    List<Object> mchilItem =new ArrayList<Object>();

    private int image;

    public DataProvider(int img) {
        this.setImage(img);
      //  this.mparentItem = mparentItem1;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage() {

        return image;
    }

    public List<Object> getChildList() {
        return mchilItem;
    }
    public void setChilItemList(List<Object> list) {
         mchilItem=list;
    }

    public boolean isInitiallyExpanded() {
        return false;
    }
}

