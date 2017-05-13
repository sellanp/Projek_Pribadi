package id.sch.smktelkom_mlg.privateassignment.xirpl333.shown.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl333.shown.AiringFragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl333.shown.model.AiringModel;

/**
 * Created by Sella_NP on 13-May-17.
 */

public class AiringAdapter extends RecyclerView.Adapter<AiringAdapter.AiringViewHolder> {
    public String url = "";
    public String image;
    ArrayList<AiringModel> mList;
    AiringFragment airingFragment;
    Context context;
    private int lastposition = -1;

    public AiringAdapter(AiringFragment airingFragment, ArrayList<Result> mList, Context context) {
        this.mList = mList;
        this.airingFragment = airingFragment;
        this.context = context;
    }

    @Override
    public AiringAdapter.AiringViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        AiringViewHolder vh = new AiringViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AiringAdapter.AiringViewHolder holder, int position) {
        AiringModel airingmodel = mList.get(position);
        holder.tvName.setText(airingmodel.title);
        holder.tvDesc.setText(airingmodel.overview);
        image = url + result.backdrop_path;
        Glide.with(contaxt).load(image)
                .crossFade()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher)
                .
                .into
    }
}
