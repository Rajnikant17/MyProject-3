package com.example.rajnikantpandey.gridviewnew;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rajnikant Pandey on 8/17/2018.
 */

public class TitleCreater {
   static TitleCreater titleCreater;
    List<DataProvider> parentTitle;
    int image[]={R.drawable.cart,R.drawable.cart,R.drawable.cart,R.drawable.cart,R.drawable.cart,R.drawable.cart,R.drawable.cart,
            R.drawable.cart,R.drawable.cart,R.drawable.cart,R.drawable.cart,R.drawable.cart,R.drawable.cart,R.drawable.cart,
            R.drawable.cart,R.drawable.cart,};
      TitleCreater(Context context)
    {
        parentTitle = new ArrayList<>();
        for(int i=0;i<10;i++)
        {
          DataProvider dataProvider=new DataProvider(image[i]);
          parentTitle.add(dataProvider);
        }

    }
    public static TitleCreater get(Context context)
    {
        if(titleCreater==null)
        {
          titleCreater=new TitleCreater(context);
        }
        return titleCreater;
    }
    public  List<DataProvider> getall()
    {
      return parentTitle;
    }
}
