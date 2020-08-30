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
import com.alis.geektech.models.User;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentsViewHolder> {

    private ArrayList<User> list;
    private OnItemClickListener onItemClickListener;

    public StudentsAdapter(ArrayList<User> list) {
        this.list = list;

        addItem();
    }

    private void addItem() {
        User student1 = new User(
                "2131230816",
                "Aдильхан",
                true,
                true
        );
        User student2 = new User(
                "2131230816",
                "Данил",
                true,
                false
        );
        User student3 = new User(
                "2131230816",
                "Рахат",
                true,
                true
        );
        User student4 = new User(
                "2131230816",
                "Бакыт",
                false,
                false
        );
        User student5 = new User(
                "2131230816",
                "Азамжон",
                false,
                false
        );
        User student6 = new User(
                "2131230816",
                "Тилек",
                false,
                false
        );
        User student7 = new User(
                "2131230816",
                "Кундуз",
                true,
                false
        );
        User student8 = new User(
                "2131230816",
                "Азиз",
                true,
                false
        );
        User student9 = new User(
                "2131230816",
                "Нургазы",
                true,
                false
        );
        list.clear();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student7);
        list.add(student8);
        list.add(student9);
        list.add(student4);
        list.add(student5);
        list.add(student6);
    }

    @NonNull
    @Override
    public StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StudentsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_students_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class StudentsViewHolder extends RecyclerView.ViewHolder {

        private CardView cardStudents;
        private ImageView imageUserPhoto;
        private TextView textName;
        private ImageView imageVerified;
        private TextView textInOffice;

        public StudentsViewHolder(@NonNull View itemView) {
            super(itemView);

            initializationViews(itemView);
            cardStudents.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(getAdapterPosition());
                }
            });
        }

        private void initializationViews(View itemView) {
            cardStudents = itemView.findViewById(R.id.cardStudents);
            imageUserPhoto = itemView.findViewById(R.id.image_students_user_photo);
            textName = itemView.findViewById(R.id.text_students_name);
            imageVerified = itemView.findViewById(R.id.image_students_verified);
            textInOffice = itemView.findViewById(R.id.text_students_inOffice_or_not);
        }

        public void onBind(User user) {
            if (user.getUserPhoto().equals("2131230816")) {
                imageUserPhoto.setImageResource(R.drawable.icon_navigation_account_circle);
            } else {
                Glide
                        .with(imageUserPhoto.getContext())
                        .load(user.getUserPhoto())
                        .circleCrop()
                        .into(imageUserPhoto);
            }
            textName.setText(user.getUserName());
            if (user.isTopMentor()) {
                imageVerified.setVisibility(View.VISIBLE);
            } else {
                imageVerified.setVisibility(View.INVISIBLE);
            }
            if (user.isInOffice()) {
                textInOffice.setVisibility(View.VISIBLE);
                textInOffice.setText("В офисе");
            } else {
                textInOffice.setVisibility(View.GONE);
            }
        }
    }
}
