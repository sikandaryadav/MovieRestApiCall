package com.movierestapicall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.movierestapicall.R;
import com.movierestapicall.databinding.CustomListviewItemMovieBinding;
import com.movierestapicall.response.MoviePopularResponse;
import com.movierestapicall.response.pojo.PopularMovieResultsPOJO;
import com.movierestapicall.utility.Utility;

import java.util.ArrayList;
import java.util.List;

public class ListViewCustomAdapterRecycler extends RecyclerView.Adapter<ListViewCustomAdapterRecycler.MyViewHolder> {

    private Context context;
    private List<PopularMovieResultsPOJO> list;

    public ListViewCustomAdapterRecycler(Context context, List<PopularMovieResultsPOJO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//        View view = LayoutInflater.from(context).inflate(R.layout.custom_listview_item_movie, parent, false);
//        return new MyViewHolder(view);
        CustomListviewItemMovieBinding binding = CustomListviewItemMovieBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MyViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PopularMovieResultsPOJO popularMovie = list.get(position);
//        holder.movieBinding.tvMovieTitle.setText(popularMovie.getOriginalTitle());

        String imagePoster = Utility.IMAGE_BASE_URL + list.get(position).getPosterPath();
        String imageBackground = Utility.IMAGE_BASE_URL + list.get(position).getBackDropPath();

        Glide.with(context).load(imagePoster).into(holder.movieBinding.imageViewPosterPath);
        Glide.with(context).load(imageBackground).into(holder.movieBinding.imageViewBackdrop);

        holder.movieBinding.tvMovieTitle.setText(list.get(position).getOriginalTitle());
        holder.movieBinding.tvOriginalLanguage.setText("Original Language :  "+list.get(position).getOriginalLanguage());
        holder.movieBinding.tvReleaseDate.setText("Release Date :  "+list.get(position).getReleaseDate());
        holder.movieBinding.tvVoteCount.setText("Vote Count : "+list.get(position).getVoteCount());
        holder.movieBinding.tvVoteAvg.setText("Vote Avg. : " + list.get(position).getVoteAverage());
//        holder.Rating.setText("" + Popularmovies.get(position).getVoteAverage());
//        holder.MovieName.setText(Popularmovies.get(position).getOriginalTitle());
//        holder.ReleaseDate.setText(Popularmovies.get(position).getReleaseDate());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CustomListviewItemMovieBinding movieBinding;
        public MyViewHolder(CustomListviewItemMovieBinding itemView) {
            super(itemView.getRoot());
            movieBinding = itemView;
        }
    }
}
