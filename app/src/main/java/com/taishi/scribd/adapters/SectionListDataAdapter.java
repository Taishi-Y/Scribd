package com.taishi.scribd.adapters;

/**
 * Created by yamasakitaishi on 2016/11/24.
 */

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
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
import com.taishi.scribd.SubActivity;
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
	Item singleItem;
	SingleItemRowHolder holder;
	String authors = "";
//	String imageLink = "";

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
	public void onBindViewHolder(final SingleItemRowHolder holder, int i) {

		this.holder = holder;
		singleItem = itemsList.get(i);

		final String title = singleItem.getVolumeInfo().getTitle();
		final String author = singleItem.getVolumeInfo().getAuthors().get(0);


		final String imageLink = singleItem.getVolumeInfo().getImageLinks().getSmallThumbnail();
		final String sampleLink = singleItem.getAccessInfo().getWebReaderLink();
		final String isbn = singleItem.getVolumeInfo().getIndustryIdentifiers().get(0).getIdentifier();



//		String authors = "";

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


		//getting imageLink if its exist
//		if(!(singleItem.getVolumeInfo().getImageLinks().getSmallThumbnail().isEmpty())){
//			imageLink = singleItem.getVolumeInfo().getImageLinks().getSmallThumbnail();
			Glide.with(mContext)
					.load(imageLink)
					.diskCacheStrategy(DiskCacheStrategy.ALL)
					.centerCrop()
					.error(R.mipmap.ic_launcher)
					.into(holder.itemImage);
//		}

		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast.makeText(mContext, title, Toast.LENGTH_SHORT).show();
				Log.e("title",title);
				Log.e("imageLink",imageLink);
				Log.e("sampleLink",sampleLink);

				Intent intent = new Intent(mContext, SubActivity.class);
//				intent.putExtra("TITLE",tvTitle.getText());
//					intent.putExtra("AUTHOR",tvAuthor.getText());
//					if(!(singleItem.getVolumeInfo().getImageLinks().getSmallThumbnail().isEmpty())) {

				intent.putExtra("TITLE",title);
				intent.putExtra("AUTHOR",author);
				intent.putExtra("IMAGELINK",imageLink);
				intent.putExtra("SAMPLELINK",sampleLink);
				intent.putExtra("ISBN",isbn);

//
////					}
//				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
					mContext.startActivity(intent);
////					mContext.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation((Activity) mContext, SectionListDataAdapter.this.holder.itemImage, "image").toBundle());
//				}
			}
		});

	}

	@Override
	public int getItemCount() {
		return (null != itemsList ? itemsList.size() : 0);
	}

	public class SingleItemRowHolder extends RecyclerView.ViewHolder {

		protected TextView tvTitle;
		protected TextView tvAuthor;
		protected TextView tvPageCount;
		public ImageView itemImage;


		public SingleItemRowHolder(View view) {
			super(view);

			this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
			this.itemImage = (ImageView) view.findViewById(R.id.itemImage);
			this.tvAuthor = (TextView) view.findViewById(R.id.tvAuthor);
			this.tvPageCount = (TextView) view.findViewById(R.id.tvPageCount);


//			view.setOnClickListener(new View.OnClickListener() {
//				@Override
//				public void onClick(View v) {
//					Toast.makeText(v.getContext(), singleItem.getVolumeInfo().getTitle(), Toast.LENGTH_SHORT).show();
//					Intent intent = new Intent(v.getContext(), SubActivity.class);
//					intent.putExtra("TITLE",tvTitle.getText());
//					intent.putExtra("AUTHOR",tvAuthor.getText());
////					if(!(singleItem.getVolumeInfo().getImageLinks().getSmallThumbnail().isEmpty())) {
//						intent.putExtra("IMAGELINK",itemsList.get(0).getVolumeInfo().getImageLinks().getSmallThumbnail());
////					}
////					intent.putExtra();
//					if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//						mContext.startActivity(intent,
//								ActivityOptions.makeSceneTransitionAnimation((Activity) v.getContext(), itemImage, "image").toBundle());
//					}
//				}
//			});
		}

	}



}