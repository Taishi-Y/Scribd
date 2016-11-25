package com.taishi.scribd.services;

import com.taishi.scribd.models.book.Book;
import com.taishi.scribd.models.book.Item;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yamasakitaishi on 2016/11/24.
 */

public interface BookService {
	//	https://www.googleapis.com/books/v1/volumes?q=android
		@GET("volumes/")
		Call<Book> requestBook(
				@Query("q") String q);

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://www.googleapis.com/books/v1/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
}
