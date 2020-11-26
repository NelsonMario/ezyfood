package com.example.ezyfood.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ezyfood.R;
import com.example.ezyfood.model.Stuff;
import com.example.ezyfood.utils.StuffAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FoodFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodFragment extends Fragment {

    private RecyclerView recyclerView;
    private StuffAdapter stuffAdapter;
    private ArrayList<Stuff> foods;

    public FoodFragment() {


    }

    // TODO: Rename and change types and number of parameters
    public static FoodFragment newInstance() {
        FoodFragment fragment = new FoodFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    private void addData(){
        foods.add(new Stuff("Taco", "Food","makanan khas Meksiko yang terdiri atas gulungan atau lipatan tortilla yang diisi dengan berbagai macam masakan di dalamnya.", 20000));
        foods.add(new Stuff("Pizza", "Food","hidangan gurih dari Italia sejenis adonan bundar dan pipih, yang dipanggang di oven dan biasanya dilumuri saus tomat serta keju dengan bahan makanan tambahan lainnya yang bisa dipilih.", 30000));
        foods.add(new Stuff("Lasagna", "Food","pasta yang dipanggang di oven dan merupakan makanan tradisional Italia. Lasagna sendiri secara harfiah adalah lasagne yang berisikan daging.", 15000));
        foods.add(new Stuff("Rendang", "Food","masakan daging yang berasal dari Minangkabau. Masakan ini dihasilkan dari proses memasak suhu rendah dalam waktu lama menggunakan aneka rempah-rempah dan santan.", 20000));
        foods.add(new Stuff("Opor Ayam", "Food"," masakan sejenis kari ayam yang sangat dikenal di Indonesia.", 20000));
        foods.add(new Stuff("Onsen Egg", "Food","telur bersuhu rendah tradisional dari Jepang yang dimasak dengan lambat dalam air onsen di Jepang.", 15000));
        foods.add(new Stuff("Takoyaki", "Food"," nama makanan asal daerah Kansai di Jepang, berbentuk bola-bola kecil dengan diameter 3-5 cm yang dibuat dari adonan tepung terigu diisi potongan gurita di dalamnya.", 20000));
        foods.add(new Stuff("Sushi", "Food","makanan Jepang yang terdiri dari nasi yang dibentuk bersama lauk berupa makanan laut, daging, sayuran mentah atau sudah dimasak.", 45000));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_foods, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.rv_foods);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        foods = new ArrayList<>();
        addData();
        stuffAdapter = new StuffAdapter(getActivity(), foods);
        recyclerView.setAdapter(stuffAdapter);

        return view;
    }
}
