package com.liturtle.youquan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.MyViewHolder> {

    private Context mcontext;

    public MyAdapter(Context context) {
        this.mcontext = context;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.layout_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private Button btnPop;

        private PopupWindow mPop;

        public MyViewHolder(final View itemView) {
            super(itemView);
            btnPop = itemView.findViewById(R.id.button_pop);
            btnPop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View popView = LayoutInflater.from(mcontext).inflate(R.layout.layout_pop, (ViewGroup) itemView,false);
                    mPop = new PopupWindow(popView,ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
                    mPop.setOutsideTouchable(true);
                    mPop.setFocusable(true);
                    mPop.showAsDropDown(btnPop);
                }
            });
        }
    }
}
