package id.sch.smktelkom_mlg.privateassignment.xirpl333.shown.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl333.shown.AiringFragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl333.shown.DetailActivity;
import id.sch.smktelkom_mlg.privateassignment.xirpl333.shown.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl333.shown.model.Results;

/**
 * Created by Sella_NP on 14-May-17.
 */

public class Airing extends RecyclerView.Adapter<Airing.ViewHolder> {
    public String url = "https://image.tmdb.org/t/p/w500";
    public String image;
    ArrayList<Results> mList;
    AiringFragment airingFragment;
    Context context;
    private int lastpositin = -1;

    public Airing(AiringFragment airingFragment, ArrayList<Results> mList, Context context) {
        this.mList = mList;
        this.airingFragment = airingFragment;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        Airing.ViewHolder vh = new Airing.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Results results = mList.get(position);
        holder.tvName.setText(results.title);
        holder.tvDesc.setText(results.overview);
        image = url + results.backdrop_path;
        Glide.with(context).load(image)
                .crossFade()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher)
                .into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("movie_title", results.title);
                intent.putExtra("poster_path", results.backdrop_path);
                intent.putExtra("description", results.overview);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mList != null)
            return mList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDesc;
        ImageView imageView;
        CardView cardView;

        public ViewHolder(View v) {
            super(v);

            tvDesc = (TextView) v.findViewById(R.id.tv_desc);
            tvName = (TextView) v.findViewById(R.id.tv_text);
            imageView = (ImageView) v.findViewById(R.id.iv_image);
            cardView = (CardView) v.findViewById(R.id.cardView);
        }
    }
}
