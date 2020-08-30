package com.alis.geektech.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.alis.geektech.R;
import com.alis.geektech.interfaces.OnItemClickListener;
import com.alis.geektech.models.Events;

import java.util.ArrayList;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventsViewHolder> {

    private ArrayList<Events> list;
    private OnItemClickListener onItemClickListener;

    public EventsAdapter(ArrayList<Events> list) {
        this.list = list;

        addItem();
    }

    private void addItem() {
        Events event1 = new Events(
                R.drawable.background_profile,
                "Мастер класс",
                "Будем проводить мастер класс и бла бла бла",
                "23.08.20",
                "17:00"
        );
        Events event2 = new Events(
                R.drawable.background_profile,
                "Митап",
                "Будем проводить митап с ведущим программистам и т д",
                "01.09.20",
                "18:00"
        );
        Events event3 = new Events(
                R.drawable.background_profile,
                "Играем в мафию приходите все студенты ГикТека",
                "Будем играть в мафию сегодня",
                "31.08.20",
                "23:00"
        );
        list.clear();
        list.add(event1);
        list.add(event2);
        list.add(event3);
    }

    @NonNull
    @Override
    public EventsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EventsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_events_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EventsViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EventsViewHolder extends RecyclerView.ViewHolder {

        private CardView cardEvent;
        private ImageView imagePhoto;
        private TextView textName;

        public EventsViewHolder(@NonNull View itemView) {
            super(itemView);

            initializationViews(itemView);
            cardEvent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(getAdapterPosition());
                }
            });
        }

        private void initializationViews(View itemView) {
            cardEvent = itemView.findViewById(R.id.cardEvent);
            imagePhoto = itemView.findViewById(R.id.image_events_photo);
            textName = itemView.findViewById(R.id.text_events_name);
        }

        public void onBind(Events events) {
            imagePhoto.setImageResource(events.getEventPhoto());
            textName.setText(events.getEventName());
        }
    }
}
