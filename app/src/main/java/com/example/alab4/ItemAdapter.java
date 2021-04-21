package com.example.alab4;

import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>
{

    ArrayList<Item> items;

    public ItemAdapter (ArrayList<Item> items)
    {
        this.items = items;
    }
    public class ItemViewHolder extends RecyclerView.ViewHolder
    {
        TextView tit;
        ImageView img;
        TextView inf;
        public ItemViewHolder(View view)
        {
            super(view);
            tit = (TextView) view.findViewById(R.id.TitleText);
            img = (ImageView) view.findViewById(R.id.Kartinochka);
            inf = (TextView) view.findViewById(R.id.InfoText);
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, final int position)
    {
        holder.tit.setText(items.get(position).getTitile());
        //
        //holder.img.setImageResource(items.get(position).getImg());
        holder.img.setImageURI(items.get(position).getPh());
        //
        holder.inf.setText(items.get(position).getInfo());

        holder.img.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentActivity activity = (FragmentActivity)v.getContext();
                Fragment fragment = null;
                fragment = new Cardochka();
                FragmentManager fm = activity.getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.add(R.id.fr_dad, fragment);
                ft.commit();
                MainActivity.whatscene = 2;
                Cardochka.carduri = items.get(position).getPh();
                Cardochka.inftext  = items.get(position).getInfo();
                Cardochka.titltext = items.get(position).getTitile();
            }
        });
        holder.inf.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentActivity activity = (FragmentActivity)v.getContext();
                Fragment fragment = null;
                fragment = new Cardochka();
                FragmentManager fm = activity.getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.add(R.id.fr_dad, fragment);
                ft.commit();
                MainActivity.whatscene = 2;
                Cardochka.carduri = items.get(position).getPh();
                Cardochka.inftext  = items.get(position).getInfo();
                Cardochka.titltext = items.get(position).getTitile();
            }
        });
        holder.tit.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentActivity activity = (FragmentActivity)v.getContext();
                Fragment fragment = null;
                fragment = new Cardochka();
                FragmentManager fm = activity.getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.add(R.id.fr_dad, fragment);
                ft.commit();
                MainActivity.whatscene = 2;
                Cardochka.carduri = items.get(position).getPh();
                Cardochka.inftext  = items.get(position).getInfo();
                Cardochka.titltext = items.get(position).getTitile();
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return items.size();
    }

}
