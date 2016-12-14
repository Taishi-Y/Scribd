package com.taishi.scribd.adapters;

/**
 * Created by yamasakitaishi on 2016/11/24.
 */


import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.taishi.scribd.MainActivity;
import com.taishi.scribd.R;
import com.taishi.scribd.SubActivity;
import com.taishi.scribd.models.book.Item;
import java.util.List;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {

	private List<Item> itemsList;
	private Context mContext;
	AppCompatActivity activity;
//	Item singleItem;
//	SingleItemRowHolder holder;
	String authors = "";
//	String title = "";
	String author = "";

	private SectionListDataAdapter thisAdapter = this;

	public SectionListDataAdapter(Context context, List<Item> itemsList, AppCompatActivity activity) {
		this.itemsList = itemsList;
		this.mContext = context;
		this.activity = activity;
	}

	@Override
	public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
		View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_single_card, null);
		SingleItemRowHolder mh = new SingleItemRowHolder(v);
		return mh;
	}

	@Override
	public void onBindViewHolder(final SingleItemRowHolder holder, int i) {

//		this.holder = holder;

		final RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder)holder;
//		viewHolder.getLayoutPosition()
		Item singleItem = itemsList.get(viewHolder.getLayoutPosition());

		final String title = singleItem.getVolumeInfo().getTitle();

		final String description = singleItem.getVolumeInfo().getDescription();


		if (!(singleItem.getVolumeInfo().getAuthors().size() == 0)) {
			author = singleItem.getVolumeInfo().getAuthors().get(0);
			holder.tvAuthor.setText(authors);
		}
//		author = singleItem.getVolumeInfo().getAuthors().get(0);


		final String imageLink = singleItem.getVolumeInfo().getImageLinks().getSmallThumbnail();
		final String sampleLink = singleItem.getAccessInfo().getWebReaderLink();

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
//		holder.tvAuthor.setText(authors);


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


		holder.v.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View view) {
				Toast.makeText(mContext,"wooo",Toast.LENGTH_SHORT).show();



				Bundle bundle = new Bundle();
				bundle.putString("DESCRIPTION",description);
				bundle.putString("TITLE",title);

				com.taishi.scribd.DialogFragment newFragment = new com.taishi.scribd.DialogFragment();


				newFragment.setArguments(bundle);
				newFragment.show(activity.getSupportFragmentManager(),"test");
//						show(activity.getFragmentManager(), "test");

				return true;
			}
		});

		holder.v.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				Toast.makeText(mContext, title, Toast.LENGTH_SHORT).show();
				String isbn = "";
//				if(!(singleItem.getVolumeInfo().getIndustryIdentifiers().size() == 0)){
//					isbn = singleItem.getVolumeInfo().getIndustryIdentifiers().get(0).getIdentifier();
//				}

//				title = singleItem.getVolumeInfo().getTitle();

				Intent intent = new Intent(mContext, SubActivity.class);

				intent.putExtra("TITLE",title);
				intent.putExtra("AUTHOR",author);
				intent.putExtra("IMAGELINK",imageLink);
				intent.putExtra("SAMPLELINK",sampleLink);
				intent.putExtra("ISBN",isbn);

//
////					}
//				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					mContext.startActivity(intent);
//					mContext.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation((Activity) mContext, SectionListDataAdapter.this.holder.itemImage, "image").toBundle());
//				}
			}
		});

	}

	public static class ViewHolder extends RecyclerView.ViewHolder {
		public View v;

		public ViewHolder(View v){
			super(v);
			this.v = v;
		}
	}

	@Override
	public int getItemCount() {
		return (null != itemsList ? itemsList.size() : 0);
	}

	public class SingleItemRowHolder extends RecyclerView.ViewHolder {

		public View v;

		protected TextView tvTitle;
		protected TextView tvAuthor;
		protected TextView tvPageCount;
		public ImageView itemImage;


		public SingleItemRowHolder(View view) {
			super(view);

			this.v = view;
			this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
			this.itemImage = (ImageView) view.findViewById(R.id.itemImage);
			this.tvAuthor = (TextView) view.findViewById(R.id.tvAuthor);
			this.tvPageCount = (TextView) view.findViewById(R.id.tvPageCount);

		}
	}
}