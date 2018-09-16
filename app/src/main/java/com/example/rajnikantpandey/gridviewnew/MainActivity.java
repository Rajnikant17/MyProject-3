package com.example.rajnikantpandey.gridviewnew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.GridLayoutAnimationController;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import com.bignerdranch.expandablerecyclerview.model.Parent;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static android.support.v7.widget.GridLayoutManager.*;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager ;
    List<Parent<Object>> parent=new ArrayList<>();
   // LinearLayoutManager linearLayoutManager;
    int i=0;
    int image[]={R.drawable.cart,R.drawable.cart,R.drawable.cart,R.drawable.cart,R.drawable.cart,R.drawable.cart,R.drawable.cart,
            R.drawable.cart,R.drawable.cart,R.drawable.cart,R.drawable.cart,R.drawable.cart,R.drawable.cart,R.drawable.cart,
            R.drawable.cart,R.drawable.cart,};
    String str[]={"detail1","detail2","detail3","detail4","detail5","detail6","detail7","detail8","detail9","detail10","detail11",
            "detail12","detail13","detail14","detail15","detail16",};
   // ArrayList arrayList;
   public static final int LANDSCAPE_GRID_COLUME = 2;
   Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  String str[]=getResources().getStringArray(R.array.details);
        recyclerView=findViewById(R.id.recycle);
        adapter=new Adapter(this,getData());
        adapter.setExpandCollapseListener(new ExpandableRecyclerAdapter.ExpandCollapseListener() {
            @Override
            public void onParentExpanded(int parentPosition) {
              //  Toast.makeText(MainActivity.this,"Hi parent"+parentPosition,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onParentCollapsed(int parentPosition) {

            }
        });
        gridLayoutManager =new GridLayoutManager(this,2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
               // Toast.makeText(MainActivity.this, "child Adapter" +position, Toast.LENGTH_SHORT).show();
                switch (adapter.getItemViewType(position))
                {
                    case Adapter.TYPE_PARENT:
                        return 1;
                default:
                    return 2;
                }
            }

          /* @Override
            public int getSpanGroupIndex(int adapterPosition, int spanCount) {
                Toast.makeText(MainActivity.this, "child Adapter" +spanCount, Toast.LENGTH_SHORT).show();
                return super.getSpanGroupIndex(adapterPosition, spanCount);
            }*/
        });
      //  gridLayoutManager.generateLayoutParams(new )

                recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

        public List<Parent<Object>> getData()
        {
            TitleCreater titleCreater=TitleCreater.get(getApplication());
            List<DataProvider> newlist=titleCreater.getall();
      // List<Parent<Object>> parent=new ArrayList<>();

      for(DataProvider newl:newlist)
      {
          List<Object> itemlist=new ArrayList();

          ItemRow itemRow=new ItemRow(str[i]);
          itemlist.add(itemRow);

          newl.setChilItemList(itemlist);
          i++;
          parent.add(newl);
      }
            return parent;

    }
}

