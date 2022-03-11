package com.movierestapicall.interfaces;

import com.movierestapicall.response.MoviePopularResponse;
import com.movierestapicall.response.pojo.PopularMovieResultsPOJO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiName {

        @GET("/3/movie/popular")
        Call<MoviePopularResponse> getPopularMovie(@Query("api_key") String apiKey);
//    @GET("/posts")
//    Call<List<PostResposnse>> getPostsData();
//
//
//    @GET("/comments")
//    Call<List<CommentsResponse>> getCommentsData();
//
//    @GET("/albums")
//    Call<List<AlbumsResponse>> getAlbumsData();
//
//    @GET("/photos")
//    Call<List<PhotoResponse>> getPhotoData();
//
//    @GET("/todos")
//    Call<List<TodoResponse>> getTodoData();
//
//    @GET("/users")
//    Call<List<UserDetailsResponse>> getUsersData();
}
