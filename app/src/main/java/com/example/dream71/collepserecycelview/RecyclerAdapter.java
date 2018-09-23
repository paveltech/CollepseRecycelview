package com.example.dream71.collepserecycelview;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ReyclerViewHolder> {


    private LayoutInflater layoutInflater;
    private Animation animationUp, animationDown;
    private Context context;
    private final int COUNTDOWN_RUNNING_TIME = 500;
    public ArrayList<Pojo> pojoArrayList;


    public RecyclerAdapter(Context context, Animation animationUp, Animation animationDown , ArrayList<Pojo> pojoArrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.animationDown = animationDown;
        this.animationUp = animationUp;
        this.context = context;
        this.pojoArrayList = pojoArrayList;
    }

    @NonNull
    @Override
    public ReyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View item = layoutInflater.inflate(R.layout.item_recycler_view, viewGroup, false);
        return new ReyclerViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull final ReyclerViewHolder reyclerViewHolder, int position) {


        Pojo pojo = pojoArrayList.get(position);
        reyclerViewHolder.title_text.setText(pojo.getTitle());
        reyclerViewHolder.details.setText(pojo.getDetails());


        reyclerViewHolder.showMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (reyclerViewHolder.contentLayout.isShown()) {
                    reyclerViewHolder.contentLayout.startAnimation(animationUp);

                    CountDownTimer countDownTimerStatic = new CountDownTimer(COUNTDOWN_RUNNING_TIME, 16) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                        }

                        @Override
                        public void onFinish() {
                            reyclerViewHolder.contentLayout.setVisibility(View.GONE);
                        }
                    };
                    countDownTimerStatic.start();

                    reyclerViewHolder.showMore.setText(context.getString(R.string.show));
                    reyclerViewHolder.showMore.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_down, 0);
                } else {
                    reyclerViewHolder.contentLayout.setVisibility(View.VISIBLE);
                    reyclerViewHolder.contentLayout.startAnimation(animationDown);

                    reyclerViewHolder.showMore.setText(context.getString(R.string.hide));
                    reyclerViewHolder.showMore.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_up, 0);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return pojoArrayList.size();
    }

    public class ReyclerViewHolder extends RecyclerView.ViewHolder{

        private ImageView image;
        private TextView showMore;
        private TextView contentLayout;
        private TextView title_text;
        private TextView details;

        private ReyclerViewHolder(final View v) {
            super(v);
            image = (ImageView) v.findViewById(R.id.image);
            contentLayout = (TextView) v.findViewById(R.id.content);
            showMore = (TextView) v.findViewById(R.id.show_more);
            title_text = (TextView) v.findViewById(R.id.title);
            details = (TextView) v.findViewById(R.id.content);
        }
    }
}
