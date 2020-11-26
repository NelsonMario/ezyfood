package com.example.ezyfood.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ezyfood.R;
import com.example.ezyfood.model.Stuff;
import com.example.ezyfood.utils.StuffAdapter;

import java.util.ArrayList;


public class DrinkFragment extends Fragment {

    private RecyclerView recyclerView;
    private StuffAdapter stuffAdapter;
    private ArrayList<Stuff> drinks;

    public DrinkFragment() {


    }

    // TODO: Rename and change types and number of parameters
    public static DrinkFragment newInstance() {
        DrinkFragment fragment = new DrinkFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    private void addData(){
        drinks.add(new Stuff("Wedang Jahe", "Drink","hidangan minuman sari jahe tradisional dari daerah Jawa Tengah, DI Yogyakarta dan Jawa Timur, Indonesia yang umumnya disajikan hangat atau panas.", 10000));
        drinks.add(new Stuff("Marble Soda", "Drink","minuman ringan berkarbonasi yang mulut botolnya disumbat dengan sebuah kelereng.", 30000));
        drinks.add(new Stuff("Merlot", "Drink","sebuah varietas anggur wine berwarna biru tua, yang digunakan sebagai anggur campuran dan untuk wine varietal.", 150000));
        drinks.add(new Stuff("Hot Ocha", "Drink","eh yang dibuat dari daun tanaman teh yang dipetik dan mengalami proses pemanasan untuk mencegah oksidasi", 20000));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_drinks, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.rv_drinks);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        drinks = new ArrayList<>();
        addData();
        stuffAdapter = new StuffAdapter(getActivity(), drinks);
        recyclerView.setAdapter(stuffAdapter);

        return view;
    }
}
