package com.example.infogram.View.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infogram.R;
import com.example.infogram.adapter.CardViewAdapter;
import com.example.infogram.model.Image;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //toolbar
        showToolBar(getString(R.string.title_home_fragment),false,view);

        //recycleview
        RecyclerView recyclerView = view.findViewById(R.id.recycle_view);

        //layoud manager
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        //el adapter
        CardViewAdapter cardViewAdapter = new CardViewAdapter(buidImages(),R.layout.cardview_image,getActivity());
        recyclerView.setAdapter(cardViewAdapter);

        return view;
    }

    public void showToolBar(String titulo, boolean botonSubir , View view){

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(titulo);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(botonSubir);
    }

    //creamos la lista de imagenes
    public ArrayList<Image> buidImages(){
        ArrayList<Image> images = new ArrayList<>();

        images.add(new Image("https://www.comparaonline.com.co/blog-statics/co/uploads/2017/03/lugares-turisticos-bolivia-salar.png","Daniel Rojas","2 dias","1 me gusta"));
        images.add(new Image("https://lugaresturisticos365.com/wp-content/uploads/mejores-lugares-turisticos-de-bolivia.jpg","Wiber Luis","3 dias","5 me gusta"));
        images.add(new Image("https://boliviaturistica.com/wp-content/uploads/2019/06/mejores-sitios-turisticos-bolivia-parque-nacional-sajama.jpg","David Quevedo","6 dias","4 me gusta"));
        images.add(new Image("https://boliviamia.net/Images/Tourpics/atop-potosi-01.jpg","Jose Maria","5 dias","6 me gusta"));
        images.add(new Image("https://queverenz.com/wp-content/uploads/2016/11/Que-cosas-ver-hacer-en-bolivia-lugares-sitios-puntos-destinos-turismo-dias.jpg","Miguel Angel","3 dias","2 me gusta"));
        images.add(new Image("https://boliviadventure.com/wp-content/uploads/2017/11/misiones-jesu%C3%ADticas-e1537550828843.jpg","Alex Moreira","4 dias","5 me gusta"));
        images.add(new Image("https://fundacion-milenio.org/wp-content/uploads/2018/11/Econom%C3%ADa-de-Potos%C3%AD-va-al-ritmo-de-la-miner%C3%ADa.jpg","Ana Dewid","2 dias","3 me gusta"));
        images.add(new Image("https://www.surfingtheplanet.com/wp-content/uploads/2012/06/DSC2653a.jpg","Antonio Banderas","2 dias","8 me gusta"));
        images.add(new Image("https://www.tangol.com/Fotos/Tours/city-tour-sucre_2704_201812311040216.Mobile.JPG","Andrea Laura","6 dias","3 me gusta"));
        images.add(new Image("https://www.surfingtheplanet.com/wp-content/uploads/2012/06/pano_sanfelipneri1a.jpg","Luisa Garsia","9 dias","1 me gusta"));
        return images;
    }
}