package com.example.rajnikantpandey.gridviewnew;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import com.bignerdranch.expandablerecyclerview.model.Parent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rajnikant Pandey on 8/16/2018.
 */

public class Adapter  extends ExpandableRecyclerAdapter<Parent<Object>,Object,Adapter.ParentMyHandler,Adapter.ChildMyHandler>{

   static Context cont;
    public static final int TYPE_PARENT = 0;
    public static final int TYPE_CHILD = 1;
    List<ParentViewHolder> parentholder=new ArrayList<>();
    List<ChildViewHolder> childholder=new ArrayList<>();

    public Adapter(Context context,@NonNull List<Parent<Object>> parentList) {
        super(parentList);
        this.cont=context;

    }

    @NonNull
    @Override
    public ParentMyHandler onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parentViewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row, parentViewGroup, false);
        ParentMyHandler parentMyHandler = new ParentMyHandler(view);
        return parentMyHandler;
    }

    @NonNull
    @Override
    public ChildMyHandler onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) childViewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.chil_row, childViewGroup, false);
        ChildMyHandler childhandler = new ChildMyHandler(view);
        return childhandler;
    }
    @Override
    public void onBindParentViewHolder(@NonNull ParentMyHandler parentViewHolder, int parentPosition, @NonNull Parent parent) {
        DataProvider dataProvider = (DataProvider) parent;
        parentViewHolder.image.setImageResource(dataProvider.getImage());
        parentholder.add(parentViewHolder);
    }
    @Override
    public void onBindChildViewHolder(@NonNull ChildMyHandler childViewHolder, int parentPosition, int childPosition, @NonNull Object child) {
        ItemRow itemRow = (ItemRow) child;
        childViewHolder.textView.setText(itemRow.getImage());
        childholder.add(childViewHolder);
      //  Toast.makeText(cont, "Parent Adapter" +(parentholder.get(parentPosition)).getAdapterPosition(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public int getItemViewType(int flatPosition) {
        return super.getItemViewType(flatPosition);
    }

    public static class ParentMyHandler extends ParentViewHolder {
        ImageView image;
        TextView text;
        ParentMyHandler(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
        }
    }


    public static class ChildMyHandler extends ChildViewHolder {
        TextView textView;
        TextView text;

        ChildMyHandler(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
        }

    }
}
//ExpandableRecyclerAdapter<Adapter.ParentMyHandler,Adapter.ChildMyHandler> {
    // ArrayList list=new ArrayList();
  // int positionOfClickedItem;
 /*  Context cont;
    public static final int TYPE_PARENT = 0;
    public static final int TYPE_CHILD = 1;
    public Adapter(Context context, List<DataProvider> list) {
        super(list);
        this.cont=context;
    }


    @Override
    public ParentMyHandler onCreateParentViewHolder(ViewGroup parentViewGroup) {
        Context cont;
    public static final int TYPE_PARENT = 0;
    public static final int TYPE_CHILD = 1;
    }

    @Override
    public ChildMyHandler onCreateChildViewHolder(ViewGroup childViewGroup) {
        LayoutInflater inflater = (LayoutInflater) childViewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.chil_row, childViewGroup, false);
        ChildMyHandler childhandler = new ChildMyHandler(view);
        return childhandler;
    }

    @Override
    public void onBindParentViewHolder(ParentMyHandler parentViewHolder, int position,ParentListItem parentListItem) {
        DataProvider dataProvider = (DataProvider) parentListItem;
        parentViewHolder.image.setImageResource(dataProvider.getImage());

        parentViewHolder.setParentListItemExpandCollapseListener(new ParentViewHolder.ParentListItemExpandCollapseListener() {
            @Override
            public void onParentListItemExpanded(int position) {
                Adapter.super.onParentListItemExpanded(position);
                Toast.makeText(cont,"Hi Rajni"+position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onParentListItemCollapsed(int position) {
                Adapter.super.onParentListItemCollapsed(position);
                Toast.makeText(cont,"Hi Ravi"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBindChildViewHolder(ChildMyHandler childViewHolder, int position, Object childListItem) {
        ItemRow itemRow = (ItemRow) childListItem;
       // this.positionOfClickedItem=position;
        childViewHolder.textView.setText(itemRow.getImage());
        Toast.makeText(cont,"Hi child"+position,Toast.LENGTH_SHORT).show();
    }

 /*   @Override
    public void onParentListItemExpanded(int position) {
        super.onParentListItemExpanded(position);
        Toast.makeText(cont,"Hi Rajni"+position,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onParentListItemCollapsed(int position) {
        super.onParentListItemCollapsed(position);
        Toast.makeText(cont,"Hi Ravi"+position,Toast.LENGTH_LONG).show();
    }*/

  /*  @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    /* @Override
    public int getItemViewType(int position) {
        if (position == getPositionOfClickedItem() + 2){
            return 2;
        } else {
            return 2;
        }
    }*/
  /* public int getPositionOfClickedItem() {
       return positionOfClickedItem;
   }*/

    // public int getItemCount() {
    //   return list.size();


   /* public static class ParentMyHandler extends ParentViewHolder {
        ImageView image;
        TextView text;

        ParentMyHandler(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);

            //text=itemView.findViewById(R.id.textView2);
        }
    }

    public static class ChildMyHandler extends ChildViewHolder {
        TextView textView;
        TextView text;

        ChildMyHandler(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
        }
    }*/



