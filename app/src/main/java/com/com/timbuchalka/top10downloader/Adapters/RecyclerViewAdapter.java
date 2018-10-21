package com.com.timbuchalka.top10downloader.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.timbuchalka.top10downloader.Activities.CollapseActivity;
import com.timbuchalka.top10downloader.R;
import com.timbuchalka.top10downloader.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContext;
    private List<Movie> mData;
    // private List<Actor> mData1;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<Movie> mData) {
        this.mContext = mContext;
        this.mData = mData;
        // this.mData1 = mData1;
        option = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.loading_shape)
                .error(R.drawable.loading_shape);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.movie_list, parent, false);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, CollapseActivity.class);
                i.putExtra("ID", mData.get(viewHolder.getAdapterPosition()).getId());
                i.putExtra("Title", mData.get(viewHolder.getAdapterPosition()).getTitle());
                i.putExtra("Director", mData.get(viewHolder.getAdapterPosition()).getDirector());
                i.putExtra("Description", mData.get(viewHolder.getAdapterPosition()).getDescription());
                i.putExtra("Year", mData.get(viewHolder.getAdapterPosition()).getYear());
                i.putExtra("Runtime", mData.get(viewHolder.getAdapterPosition()).getRuntime());
                i.putExtra("Revenue", mData.get(viewHolder.getAdapterPosition()).getRevenue());
                i.putExtra("Votes", mData.get(viewHolder.getAdapterPosition()).getVotes());
                mContext.startActivity(i);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.ID.setText(Integer.toString(mData.get(position).getId()));
        holder.movieTitle.setText((mData.get(position).getTitle()));
        holder.director.setText(mData.get(position).getDirector());
        holder.rating.setText(mData.get(position).getRating());
        holder.year.setText(Integer.toString(mData.get(position).getYear()));
        holder.runtime.setText(Integer.toString(mData.get(position).getRuntime()));
        holder.revenue.setText(Float.toString(mData.get(position).getRevenue()));
        holder.votes.setText(Integer.toString(mData.get(position).getVotes()));
        //  holder.actor.setText(Integer.toString(mData.get(position).getActor()));

        // Glide.with(mContext).load(mData.get(position).getImage_url()).apply(option).into(holder.img_thumbnail);
    }

    @Override
    public int getItemCount() {

        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        final TextView ID;
        final TextView movieTitle;
        final TextView description;
        final TextView director;
        final TextView year;
        final TextView runtime;
        final TextView votes;
        final TextView revenue;
        final TextView rating;
        // final TextView genres;
        //   final TextView actor;
        LinearLayout view_container;
        // final ImageView img_thumbnail;


        public MyViewHolder(View itemView) {
            super(itemView);
            //   actor = itemView.findViewById(R.id.actor);
            ID = itemView.findViewById((R.id.ID));
            view_container = itemView.findViewById(R.id.container);
            rating = itemView.findViewById(R.id.rating);
            movieTitle = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            director = itemView.findViewById(R.id.director);
            year = itemView.findViewById(R.id.year);
            runtime = itemView.findViewById(R.id.runtime);
            votes = itemView.findViewById(R.id.votes);
            revenue = itemView.findViewById(R.id.revenue);
            // this.genres = itemView.findViewById(R.id.genres);
            //this.actor = itemView.findViewById(R.id.actors);
            //this.img_thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
}
