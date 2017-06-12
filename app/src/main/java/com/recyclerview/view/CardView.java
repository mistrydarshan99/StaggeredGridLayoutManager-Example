package com.recyclerview.view;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by darshan.mistry on 6/8/2017.
 */

public class CardView extends android.support.v7.widget.CardView {

  private double mHeightRatio;

  public CardView(Context context) {
    super(context);
  }

  public CardView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public CardView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    if (mHeightRatio > 0.0) {
      // set the image views size
      int width = MeasureSpec.getSize(widthMeasureSpec);
      int height = (int) (width * mHeightRatio);
      setMeasuredDimension(width, height);
    } else {
      super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
  }
}
