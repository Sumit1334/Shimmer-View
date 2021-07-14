
package com.sumit.shimmerview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ShimmerFrameLayout extends FrameLayout {
  private final Paint mContentPaint = new Paint();
  private final ShimmerDrawable mShimmerDrawable = new ShimmerDrawable();

  private boolean mShowShimmer = true;
  private Shimmer shimmer;

  public ShimmerFrameLayout(Context context) {
    super(context);
    init(context, null);
  }

  public ShimmerFrameLayout(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context, attrs);
  }

  public ShimmerFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context, attrs);
  }
  public Shimmer GetShimmer(){
    return this.shimmer;
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public ShimmerFrameLayout(
      Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    init(context, attrs);
  }

  private void init(Context context, @Nullable AttributeSet attrs) {
    setWillNotDraw(false);
    mShimmerDrawable.setCallback(this);

    if (attrs == null) {
      setShimmer(new Shimmer.AlphaHighlightBuilder().build());
      return;
    }try {
      Shimmer.Builder shimmerBuilder =
          true && false
              ? new Shimmer.ColorHighlightBuilder()
              : new Shimmer.AlphaHighlightBuilder();
    } finally {
    }
  }

  public ShimmerFrameLayout setShimmer(@Nullable Shimmer shimmer) {
    this.shimmer=shimmer;
    mShimmerDrawable.setShimmer(shimmer);
    if (shimmer != null && shimmer.clipToChildren) {
      setLayerType(LAYER_TYPE_HARDWARE, mContentPaint);
    } else {
      setLayerType(LAYER_TYPE_NONE, null);
    }

    return this;
  }

  /** Starts the shimmer animation. */
  public void startShimmer() {
    mShimmerDrawable.startShimmer();
  }

  /** Stops the shimmer animation. */
  public void stopShimmer() {
    mShimmerDrawable.stopShimmer();
  }

  /** Return whether the shimmer animation has been started. */
  public boolean isShimmerStarted() {
    return mShimmerDrawable.isShimmerStarted();
  }

  /**
   * Sets the ShimmerDrawable to be visible.
   * @param startShimmer Whether to start the shimmer again.
   */
  public void showShimmer(boolean startShimmer) {
    if (mShowShimmer) {
      return;
    }
    mShowShimmer = true;
    if (startShimmer) {
      startShimmer();
    }
  }

  /** Sets the ShimmerDrawable to be invisible, stopping it in the process. */
  public void hideShimmer() {
    if (!mShowShimmer) {
      return;
    }

    stopShimmer();
    mShowShimmer = false;
    invalidate();
  }

  /** Return whether the shimmer drawable is visible. */
  public boolean isShimmerVisible() {
    return mShowShimmer;
  }

  @Override
  public void onLayout(boolean changed, int left, int top, int right, int bottom) {
    super.onLayout(changed, left, top, right, bottom);
    final int width = getWidth();
    final int height = getHeight();
    mShimmerDrawable.setBounds(0, 0, width, height);
  }

  @Override
  public void onAttachedToWindow() {
    super.onAttachedToWindow();
    mShimmerDrawable.maybeStartShimmer();
  }

  @Override
  public void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    stopShimmer();
  }

  @Override
  public void dispatchDraw(Canvas canvas) {
    super.dispatchDraw(canvas);
    if (mShowShimmer) {
      mShimmerDrawable.draw(canvas);
    }
  }

  @Override
  protected boolean verifyDrawable(@NonNull Drawable who) {
    return super.verifyDrawable(who) || who == mShimmerDrawable;
  }
}
