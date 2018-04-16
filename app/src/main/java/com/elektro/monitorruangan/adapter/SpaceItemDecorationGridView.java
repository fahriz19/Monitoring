//package com.elektro.monitorruangan.adapter;
//
//import android.content.Context;
//import android.graphics.Rect;
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//
///**
// * Created by Fahriz on 4/5/2018.
// */
//
//public class SpaceItemDecorationGridView extends RecyclerView.ItemDecoration {
//    int left, right, top, bottom;
//
//    public SpaceItemDecorationGridView(Context context, int left, int right, int top, int bottom) {
//        this.left = left;
//        this.right = right;
//        this.top = top;
//        this.bottom = bottom
//    }
//
//    @Override
//    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        outRect.set(left, top, bottom, right);
//        super.getItemOffsets(outRect, view, parent, state);
//    }
//}
