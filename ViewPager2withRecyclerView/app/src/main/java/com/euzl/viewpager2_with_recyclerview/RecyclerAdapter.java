package com.euzl.viewpager2_with_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private Context context;
    private ArrayList<String> arrayList;

    public RecyclerAdapter(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    /**
     * Create view holder that contains contents
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        RecyclerAdapter.RecyclerViewHolder viewHolder = new RecyclerAdapter.RecyclerViewHolder(view);
        return viewHolder;
    }

    /**
     * Decorate view holder (ex. Set text, ...)
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.textView.setText(arrayList.get(position));
    }

    /**
     * If you don't return correct num, you must see error
     * @return item count (total)
     */
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    /**
     * 리사이클러뷰에서 재사용되는 아이템의 view holder
     */
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textview_item);
        }
    }
}
