package com.recyclerview.fresco;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.recyclerview.R;
import java.util.List;

/**
 * Created by darshan.mistry on 6/7/2017.
 */

public class FrescoAdapter extends RecyclerView.Adapter<FrescoAdapter.ViewHolder> {

  private Activity activity;
  private LayoutInflater layoutInflater;
  private List<String> listItem;

  public void setListItem(List<String> listItem) {
    this.listItem = listItem;
    notifyDataSetChanged();
  }

  public FrescoAdapter(Activity activity) {
    this.activity = activity;
    layoutInflater = LayoutInflater.from(activity);
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    View view = layoutInflater.inflate(R.layout.row_fresco, viewGroup, false);
    ViewHolder viewHolder = new ViewHolder(view);
    //view.setTag(viewHolder);
    return viewHolder;
  }

  @Override public void onBindViewHolder(final ViewHolder viewHolder, final int i) {

    //viewHolder.ivImageView.getLayoutParams().height = FrescoActivity.height[i];
    //viewHolder.ivImageView.setImageURI(FrescoActivity.GOOGLEIMGARY[i]);
    viewHolder.ivImageView.setImageURI(listItem.get(i));

    //viewHolder.ivImageView.getLayoutParams().height = FrescoActivity.height1[i];
    //viewHolder.ivImageView.setImageURI("file://"+listItem.get(i));
  }

  @Override public int getItemCount() {
    return listItem.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    private WrapContentDraweeView ivImageView;

    public ViewHolder(View itemView) {
      super(itemView);
      ivImageView = (WrapContentDraweeView) itemView.findViewById(R.id.ivImageView);
    }
  }
}
