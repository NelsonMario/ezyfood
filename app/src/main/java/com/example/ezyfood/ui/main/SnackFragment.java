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
public class SnackFragment extends Fragment {

    private RecyclerView recyclerView;
    private StuffAdapter stuffAdapter;
    private ArrayList<Stuff> snacks;

    public SnackFragment() {


    }

    // TODO: Rename and change types and number of parameters
    public static SnackFragment newInstance() {
        SnackFragment fragment = new SnackFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    private void addData(){
        snacks.add(new Stuff("Telur Gulung", "Snack","ariasi dari telur goreng yang di mana sebuah telur akan digoreng dan kemudian digulung menggunakan sebuah tusukan yang biasanya di buat dari kayu pohon Bambu.", 10000));
        snacks.add(new Stuff("Tiramisu", "Snack","kue keju khas Italia dengan taburan bubuk kakao di atasnya. Kue ini merupakan hidangan penutup yang dimakan dengan sendok", 30000));
        snacks.add(new Stuff("Crepe", "Snack","panekuk tipis yang terbuat dari gandum dan merupakan makanan yang sangat digemari di seluruh Eropa dan tempat lainnya.", 15000));
        snacks.add(new Stuff("Cheese Stick", "Snack","potongan-potongan mozzarella yang dilapisi adonan encer atau tepung roti. Stik mozzarella disajikan dengan sauns tomat, kecap dan saus marinara", 20000));
        snacks.add(new Stuff("Dango", "Snack","kue Jepang berbentuk bulat seperti bola kecil, terbuat dari mochiko, dan dimatangkan dengan cara dikukus atau direbus di dalam air", 20000));
        snacks.add(new Stuff("Apple Candy", "Snack","apel utuh yang dilapisi dengan lapisan gula, dengan tongkat dimasukkan sebagai pegangan", 15000));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_snacks, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.rv_snacks);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        snacks = new ArrayList<>();
        addData();
        stuffAdapter = new StuffAdapter(getActivity(), snacks);
        recyclerView.setAdapter(stuffAdapter);

        return view;
    }
}
