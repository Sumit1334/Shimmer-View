package com.sumit.shimmerview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;

import java.util.HashMap;

public class ShimmerView extends AndroidNonvisibleComponent {
  private Context activity;
  private HashMap<String,ShimmerFrameLayout> shimmer=new HashMap<>();

  public ShimmerView(ComponentContainer container) {
    super(container.$form());
    this.activity=container.$context();
  }

  @SimpleEvent
  public void ErrorOccurred(String error){
    EventDispatcher.dispatchEvent(this,"ErrorOccurred",error);
  }
  @SimpleFunction
  public void CreateShimmer(String id,AndroidViewComponent component) {
    try {
      if (!idCheck(id)) {
        View view = component.getView();
        ShimmerFrameLayout shimmerFrameLayout = new ShimmerFrameLayout(this.activity);
        LinearLayout linearLayout = new LinearLayout(this.activity);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, Gravity.CENTER_HORIZONTAL));
        linearLayout.setVerticalGravity(1);
        linearLayout.setHorizontalGravity(16);
        int index = ((ViewGroup) view.getParent()).indexOfChild(view);
        ViewGroup viewGroup = ((ViewGroup) view.getParent());
        viewGroup.removeView(view);
        linearLayout.addView(view);
        shimmerFrameLayout.addView(linearLayout);
        viewGroup.addView(shimmerFrameLayout, index);
        this.shimmer.put(id, shimmerFrameLayout);
      } else
        ErrorOccurred("Id is already referenced with another shimmer");
    }catch (Exception e){
      ErrorOccurred(e.toString());
    }
  }
  @SimpleFunction
  public void SetDuration(String id,int duration){
    if (idCheck(id)){
      Shimmer shimmer=this.shimmer.get(id).GetShimmer();
      shimmer.animationDuration=duration;
      this.Update(shimmer);
      this.shimmer.get(id).setShimmer(shimmer);
    }
  }
  @SimpleFunction
  public int GetDuration(String id){
    return (int) this.shimmer.get(id).GetShimmer().animationDuration;
  }
  @SimpleFunction
  public void SetTilt(String id,int degree){
    if (idCheck(id)) {
      Shimmer shimmer=this.shimmer.get(id).GetShimmer();
      shimmer.tilt=degree;
      this.Update(shimmer);
      this.shimmer.get(id).setShimmer(shimmer);
    }
  }
  @SimpleFunction
  public int GetTilt(String id){
    return (int) this.shimmer.get(id).GetShimmer().tilt;
  }
  @SimpleFunction
  public void SetRepeat(String id,int repeatCount,int repeatDelay,boolean reverse){
    if (idCheck(id)){
      Shimmer shimmer=this.shimmer.get(id).GetShimmer();
      shimmer.repeatCount=repeatCount;
      shimmer.repeatDelay=repeatDelay;
      shimmer.repeatMode=reverse ? 2 : 1;
      this.Update(shimmer);
      this.shimmer.get(id).setShimmer(shimmer);
    }
  }
  @SimpleFunction
  public int GetRepeatCount(String id){
    return this.shimmer.get(id).GetShimmer().repeatCount;
  }
  @SimpleFunction
  public boolean IsReverseMode(String id){
    return this.shimmer.get(id).GetShimmer().repeatCount==2;
  }
  @SimpleFunction
  public int GetRepeatDelay(String id){
    return (int) this.shimmer.get(id).GetShimmer().repeatDelay;
  }
  @SimpleFunction
  public void SetShimmerColor(String id,int color){
    if (idCheck(id)){
      Shimmer shimmer=this.shimmer.get(id).GetShimmer();
      shimmer.baseColor=color;
      this.Update(shimmer);
      this.shimmer.get(id).setShimmer(shimmer);
    }
  }
  @SimpleFunction
  public int GetShimmerColor(String id){
    return this.shimmer.get(id).GetShimmer().baseColor;
  }
  @SimpleFunction
  public void SetIntensity(String id,float intensity){
    if (idCheck(id)){
      Shimmer shimmer=this.shimmer.get(id).GetShimmer();
      shimmer.intensity=intensity;
      this.Update(shimmer);
      this.shimmer.get(id).setShimmer(shimmer);
    }
  }
  @SimpleFunction
  public float GetIntensity(String id){
    return this.shimmer.get(id).GetShimmer().intensity;
  }
  @SimpleFunction
  public void SetHighlightColor(String id,int color){
    if (idCheck(id)){
      Shimmer shimmer=this.shimmer.get(id).GetShimmer();
      Shimmer.ColorHighlightBuilder colorHighlightBuilder= new Shimmer.ColorHighlightBuilder();
      shimmer = colorHighlightBuilder.setHighlightColor(color).build();
      this.Update(shimmer);
      this.shimmer.get(id).setShimmer(shimmer);
    }
  }
  @SimpleFunction
  public int GetHighlightColor(String id){
    return this.shimmer.get(id).GetShimmer().highlightColor;
  }
  @SimpleFunction
  public void SetShape(String id,int shape){
    if (idCheck(id)){
      Shimmer shimmer=this.shimmer.get(id).GetShimmer();
      if (shape==Radial())
        shimmer.shape= Shimmer.Shape.RADIAL;
      else if (shape==Linear())
        shimmer.shape= Shimmer.Shape.LINEAR;
      this.Update(shimmer);
      this.shimmer.get(id).setShimmer(shimmer);
    }
  }
  @SimpleFunction
  public String GetShape(String id){
    return this.shimmer.get(id).GetShimmer().shape==0 ? "Linear" : "Radial";
  }
  @SimpleFunction
  public void Start(String id,int direction){
    if (idCheck(id)){
      Shimmer shimmer=this.shimmer.get(id).GetShimmer();
      if (direction==LeftToRight()||direction==RightToLeft()||direction==TopToBottom()||direction==BottomToTop())
        shimmer.direction=direction;
      this.Update(shimmer);
      this.shimmer.get(id).setShimmer(shimmer);
      this.shimmer.get(id).startShimmer();
    }
  }
  @SimpleFunction
  public String GetDirection(String id){
    return new String[]{"Left To Right","Top To Bottom","Right To Left","Bottom To Top"}[this.shimmer.get(id).GetShimmer().direction];
  }
  @SimpleFunction
  public void Stop(String id){
    if (idCheck(id)){
      this.shimmer.get(id).stopShimmer();
    }
  }
  @SimpleFunction
  public void Hide(String id){
    if (idCheck(id)){
      this.shimmer.get(id).hideShimmer();
    }
  }
  @SimpleFunction
  public boolean IsShimmerStarted(String id){
    return this.shimmer.get(id).isShimmerStarted();
  }
  @SimpleFunction
  public boolean IsShimmerVisible(String id){
    return this.shimmer.get(id).isShimmerVisible();
  }
  @SimpleProperty
  public int Radial(){
    return Shimmer.Shape.RADIAL;
  }
  @SimpleProperty
  public int Linear(){
    return Shimmer.Shape.LINEAR;
  }
  @SimpleProperty
  public int LeftToRight(){
    return Shimmer.Direction.LEFT_TO_RIGHT;
  }
  @SimpleProperty
  public int RightToLeft(){
    return Shimmer.Direction.RIGHT_TO_LEFT;
  }
  @SimpleProperty
  public int TopToBottom(){
    return Shimmer.Direction.TOP_TO_BOTTOM;
  }
  @SimpleProperty
  public int BottomToTop(){
    return Shimmer.Direction.BOTTOM_TO_TOP;
  }

  private boolean idCheck(String id){
    return this.shimmer.containsKey(id);
  }
  private void Update(Shimmer shimmer){
    shimmer.updatePositions();
    shimmer.updateColors();
  }

}
