package id.sch.smktelkom_mlg.privateassignment.xirpl333.shown;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import id.sch.smktelkom_mlg.privateassignment.xirpl333.shown.adapter.Rated;
import id.sch.smktelkom_mlg.privateassignment.xirpl333.shown.model.ResultResponds;
import id.sch.smktelkom_mlg.privateassignment.xirpl333.shown.model.Results;
import id.sch.smktelkom_mlg.privateassignment.xirpl333.shown.service.GsonGetRequest;
import id.sch.smktelkom_mlg.privateassignment.xirpl333.shown.service.VolleySingleton;


/**
 * A simple {@link Fragment} subclass.
 */
public class RatedFragment extends Fragment {
    ArrayList<Results> mList = new ArrayList<>();
    Rated rated;

    public RatedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_rated, container, false);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.recycler_rated);
        rv.setHasFixedSize(true);
        rated = new Rated(this, mList, getContext());
        rv.setAdapter(rated);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        downloadDataResource();
        return rootView;
    }

    private void downloadDataResource() {
        String url = "https://api.themoviedb.org/3/tv/top_rated?api_key=061e719562f20d0f5127bab6f3e5148a&language=en-US&page=1";

        GsonGetRequest<ResultResponds> myRequest = new GsonGetRequest<ResultResponds>
                (url, ResultResponds.class, null, new Response.Listener<ResultResponds>() {

                    @Override
                    public void onResponse(ResultResponds response) {
                        Log.d("FLOW", "onResponse: " + (new Gson().toJson(response)));
                        fillColor(response.results);
                        mList.addAll(response.results);
                        rated.notifyDataSetChanged();
                    }

                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("FLOW", "onErrorResponse: ", error);
                    }
                });
        VolleySingleton.getInstance(this).addToRequestQueue(myRequest);
    }

    private void fillColor(List<Results> results) {
        for (int i = 0; i < results.size(); i++)
            results.get(i).color = ColorUtil.getRandomColor();
    }

}
