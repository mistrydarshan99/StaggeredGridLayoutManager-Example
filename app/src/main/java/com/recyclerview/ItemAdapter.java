package com.recyclerview;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.recyclerview.fresco.FrescoActivity;
import com.squareup.picasso.Picasso;
import java.util.List;
import q.rorbin.fastimagesize.FastImageSize;
import q.rorbin.fastimagesize.request.ImageSizeCallback;

/**
 * Created by darshan.mistry on 6/7/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

  private Activity activity;
  private LayoutInflater layoutInflater;
  private List<String> listItem;

  public void setListItem(List<String> listItem) {
    this.listItem = listItem;
    notifyDataSetChanged();
  }

  public ItemAdapter(Activity activity) {
    this.activity = activity;
    layoutInflater = LayoutInflater.from(activity);
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    View view = layoutInflater.inflate(R.layout.row_item, viewGroup, false);
    ViewHolder viewHolder = new ViewHolder(view);
    view.setTag(viewHolder);
    return viewHolder;
  }

  @Override public void onBindViewHolder(final ViewHolder viewHolder, final int i) {

    //viewHolder.ivImageView.setImageResource(MainActivity.IMAGES[i]);

    //ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
    //layoutParams.height = (int) ((i + 1) / 5.0 * 500);
    //viewHolder.itemView.setLayoutParams(layoutParams);

   /* Glide.with(activity)
        .load(MainActivity.IMAGES[i])
        .asBitmap()
        .fitCenter()
        .placeholder(R.color.white)
        .dontTransform()
        .dontAnimate()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(viewHolder.ivImageView);*/

   /* Glide.with(activity)
        .load(MainActivity.GOOGLEIMGARY[i])
        .placeholder(R.color.white)
        .dontTransform()
        .dontAnimate()
        .fitCenter()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(viewHolder.ivImageView);
*/

    //TODO done but some issue
    /*Glide.with(activity)
        .load(MainActivity.GOOGLEIMGARY[i])
        .asBitmap()
        .dontAnimate()
        .fitCenter()    
        .diskCacheStrategy(DiskCacheStrategy.RESULT)
        .into(new SimpleTarget<Bitmap>() {
          @Override public void onResourceReady(Bitmap bitmap, GlideAnimation anim) {

            if (bitmap != null) {
              viewHolder.ivImageView.setImageBitmap(bitmap);
              viewHolder.ivImageView.setHeightRatio(bitmap.getHeight() / bitmap.getWidth());
            }
          }
        });*/

   /* Glide.with(activity)
        .load(MainActivity.IMAGES[i])
        .asBitmap()
        .placeholder(R.color.white)
        .dontTransform()
        .dontAnimate()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(new BitmapImageViewTarget(viewHolder.ivImageView){
          @Override public void onResourceReady(Bitmap resource,
              GlideAnimation<? super Bitmap> glideAnimation) {
            super.onResourceReady(resource, glideAnimation);
            Glide.with(activity).load(MainActivity.IMAGES[i]).centerCrop().into(viewHolder.ivImageView);
          }
        });*/

    //viewHolder.ivImageView.requestLayout();

    /*Picasso.with(activity)
        .load(MainActivity.GOOGLEIMGARY[i])
        .placeholder(R.drawable.rounde_rect_placeholder)
        .into(viewHolder.ivImageView);*/

    FastImageSize.with(FrescoActivity.GOOGLEIMGARY[i]).get(new ImageSizeCallback() {

      @Override public void onSizeReady(int[] size) {
        final int[] imageSize;
        imageSize = size;

        int imageWidth = imageSize[0];
        int imageHeight = imageSize[1];
        Log.e("height", imageHeight + "");
        Log.e("width", imageWidth + "");


        //Picasso.with(activity).load(MainActivity.GOOGLEIMGARY[i]).into(viewHolder.ivImageView);
        Picasso.with(activity)
            .load(MainActivity.GOOGLEIMGARY[i])
            .resize(imageWidth, imageHeight)
            .placeholder(R.drawable.rounde_rect_placeholder)
            .into(viewHolder.ivImageView);
      }
    });
  }

  @Override public int getItemCount() {
    return listItem.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.ivImageView) DynamicHeightImageView ivImageView;
    @BindView(R.id.tvName) TextView tvName;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
