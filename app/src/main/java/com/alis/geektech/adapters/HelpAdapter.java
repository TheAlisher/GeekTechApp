package com.alis.geektech.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.alis.geektech.R;
import com.alis.geektech.interfaces.OnItemClickListener;
import com.alis.geektech.models.Help;

import java.util.ArrayList;

public class HelpAdapter extends RecyclerView.Adapter<HelpAdapter.HelpViewHolder> {

    private ArrayList<Help> list;
    private OnItemClickListener onItemClickListener;

    public HelpAdapter(ArrayList<Help> list) {
        this.list = list;

        addItem();
    }

    private void addItem() {
        Help help1 = new Help(
                "У меня проблемы BottomNav",
                "Я хочу сделать чтобы при скролле",
                "Айдин"
        );
        Help help2 = new Help(
                "Почему данные в recycler не отображаются",
                "Данные приходят но не отображаются в recyclerView",
                "Медер"
        );
        Help help3 = new Help(
                "Не показывает fragment с navigation",
                "Подключил navigation но fragment подсвечивается черным и не работает",
                "Алтынбек"
        );
        list.clear();
        list.add(help1);
        list.add(help2);
        list.add(help3);
    }

    @NonNull
    @Override
    public HelpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HelpViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_help_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HelpViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class HelpViewHolder extends RecyclerView.ViewHolder {

        private CardView cardHelp;
        private TextView textTitle;
        private TextView textDescription;

        public HelpViewHolder(@NonNull View itemView) {
            super(itemView);

            initializationViews(itemView);
            cardHelp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(getAdapterPosition());
                }
            });
        }

        private void initializationViews(View itemView) {
            cardHelp = itemView.findViewById(R.id.cardHelp);
            textTitle = itemView.findViewById(R.id.text_help_title);
            textDescription = itemView.findViewById(R.id.text_help_description);
        }

        public void onBind(Help help) {
            textTitle.setText(help.getProblemTitle());
            textDescription.setText(help.getProblemDescription());
        }
    }
}
