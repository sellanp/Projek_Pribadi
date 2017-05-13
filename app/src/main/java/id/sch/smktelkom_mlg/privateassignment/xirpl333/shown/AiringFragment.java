package id.sch.smktelkom_mlg.privateassignment.xirpl333.shown;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl333.shown.adapter.AiringAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class AiringFragment extends Fragment {

    ArrayList<AiringAdapter> mList;


    public AiringFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_airing, container, false);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.recycler_airing);
        rv.setHasFixedSize(true);
        Airing airing = new Airing(this, mList);
        rv.setAdapter(airing);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return rootView;
    }

}
