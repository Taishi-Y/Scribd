package com.taishi.scribd.adapters;

/**
 * Created by yamasakitaishi on 2016/11/24.
 */

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.taishi.scribd.R;
import com.taishi.scribd.models.SingleItemModel;
import com.taishi.scribd.models.book.Book;
import com.taishi.scribd.models.book.Item;
import com.taishi.scribd.services.BookService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {

	private List<Item> itemsList;
	private Context mContext;

	public SectionListDataAdapter(Context context, List<Item> itemsList) {
		this.itemsList = itemsList;
		this.mContext = context;
	}

	@Override
	public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
		View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_single_card, null);
		SingleItemRowHolder mh = new SingleItemRowHolder(v);
		return mh;
	}

	@Override
	public void onBindViewHolder(SingleItemRowHolder holder, int i) {

		Item singleItem = itemsList.get(i);

		String title = singleItem.getVolumeInfo().getTitle();
		String authors = "";

		if (singleItem.getVolumeInfo().getPageCount() != null) {
			String pageCount = singleItem.getVolumeInfo().getPageCount().toString();
			holder.tvPageCount.setText(pageCount + " PAGES");
		}


		if (singleItem.getVolumeInfo().getAuthors().size() == 1) {
			authors = singleItem.getVolumeInfo().getAuthors().get(0);
		}else if(singleItem.getVolumeInfo().getAuthors().size() > 1){
			authors = singleItem.getVolumeInfo().getAuthors().get(0);
			for(int j=1;j<singleItem.getVolumeInfo().getAuthors().size();j++){
				authors = authors + ", " + singleItem.getVolumeInfo().getAuthors().get(j);
			}
		}

		holder.tvTitle.setText(title);
		holder.tvAuthor.setText(authors);



		if(!(singleItem.getVolumeInfo().getImageLinks().getSmallThumbnail().isEmpty())){
			Glide.with(mContext)
					.load(singleItem.getVolumeInfo().getImageLinks().getSmallThumbnail())
					.diskCacheStrategy(DiskCacheStrategy.ALL)
					.centerCrop()
					.error(R.mipmap.ic_launcher)
					.into(holder.itemImage);
		}

	}

	@Override
	public int getItemCount() {
		return (null != itemsList ? itemsList.size() : 0);
	}

	public class SingleItemRowHolder extends RecyclerView.ViewHolder {

		protected TextView tvTitle;
		protected TextView tvAuthor;
		protected TextView tvPageCount;
		protected ImageView itemImage;


		public SingleItemRowHolder(View view) {
			super(view);

			this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
			this.itemImage = (ImageView) view.findViewById(R.id.itemImage);
			this.tvAuthor = (TextView) view.findViewById(R.id.tvAuthor);
			this.tvPageCount = (TextView) view.findViewById(R.id.tvPageCount);


			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Toast.makeText(v.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();

				}
			});
		}

	}

//	public class BookAsyncTask extends AsyncTask<Void,Void,List<Item>> {
//		public BookAsyncTask() {
//			super();
//		}
//		@Override
//		protected void onPreExecute() {
//			super.onPreExecute();
//		}
//
//		@Override
//		protected List<Item> doInBackground(Void... voids) {
//			BookService bookService = BookService.retrofit.create(BookService.class);
//			final Call<Book> call = bookService.requestBook("android");
//
//			try {
//				Book book =  call.execute().body();
//				List<Item> item = book.getItems();
////				book.getItems().get(0).getVolumeInfo().getImageLinks().getSmallThumbnail();
////				item_list = explore.getResponse().getGroups().get(0).getItems();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			return null;
//		}
//
//		@Override
//		protected void onPostExecute(List<Item> item_s) {
//			super.onPostExecute(item_s);
//			ExploreListAdapter exploreListAdapter = new ExploreListAdapter(getApplicationContext(), R.layout.item_list, item_list);
//			listView.setAdapter(exploreListAdapter);
//		}
//	}

}