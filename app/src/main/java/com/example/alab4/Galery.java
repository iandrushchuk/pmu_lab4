package com.example.alab4;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Galery extends Fragment
{
    public static int mojpls = 0;
    public static RecyclerView recyclerView;
    public static ArrayList<Item> items = new ArrayList<Item>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_galery, container, false);
        Button AddButton = (Button) view.findViewById(R.id.Add);

        recyclerView = view.findViewById(R.id.Recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        AddButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (mojpls == 0)
                {
                    mojpls = 1;
                    Fragment fragment = null;
                    fragment = new AddPhoto();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();

                    ft.add(R.id.fr_dad, fragment);
                    ft.commit();
                    MainActivity.whatscene = 2;
                }
            }
        });

        return view;
    }

    public static void AddItemPLS(String titleda, Uri imageda, String infda)
    {
        items.add(new Item(titleda,infda, imageda));
        ItemAdapter itemAdapter = new ItemAdapter(items);
        recyclerView.setAdapter(itemAdapter);
    }

}
