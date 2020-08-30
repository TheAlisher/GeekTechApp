package com.alis.geektech.adapters;

import android.graphics.Color;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alis.geektech.R;
import com.alis.geektech.models.Project;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.ArrayList;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ProjectsViewHolder> {

    private ArrayList<Project> list;

    public ProjectsAdapter(ArrayList<Project> list) {
        this.list = list;

        addItem();
    }

    private void addItem() {
        Project project1 = new Project(
                R.drawable.icon_planner,
                "Planner",
                "AzamatGit",
                "planner.market.com",
                false,
                false);
        Project project2 = new Project(
                R.drawable.icon_planner,
                "Planner",
                "https://github.com/Azamat753/YouTubeParcer",
                "planner.market.com",
                true,
                false);
        Project project3 = new Project(
                R.drawable.icon_planner,
                "Planner",
                "https://github.com/Azamat753/YouTubeParcer",
                "https://play.google.com/store/apps/details?id=com.lawlett.taskmanageruikit",
                true,
                true);
        list.clear();
        list.add(project1);
        list.add(project2);
        list.add(project3);
    }

    @NonNull
    @Override
    public ProjectsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProjectsViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_projects_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectsViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ProjectsViewHolder extends RecyclerView.ViewHolder {

        private TextView textName;
        private TextView textGitHub;
        private TextView textPlayMarket;
        private ImageView imageLogo;

        public ProjectsViewHolder(@NonNull View itemView) {
            super(itemView);

            initializationViews(itemView);
            setHyperlink();
        }

        private void initializationViews(View itemView) {
            textName = itemView.findViewById(R.id.text_project_name);
            textGitHub = itemView.findViewById(R.id.text_project_github);
            textPlayMarket = itemView.findViewById(R.id.text_project_play_market);
            imageLogo = itemView.findViewById(R.id.row_image);
        }

        private void setHyperlink() {
            textGitHub.setMovementMethod(LinkMovementMethod.getInstance());
            textPlayMarket.setMovementMethod(LinkMovementMethod.getInstance());
            textGitHub.setLinkTextColor(Color.BLUE);
            textPlayMarket.setLinkTextColor(Color.BLUE);
        }

        public void onBind(Project project) {
            Glide
                    .with(imageLogo.getContext())
                    .load(project.getProjectLogo())
                    .transform(new RoundedCorners(40))
                    .into(imageLogo);
            textName.setText(project.getProjectName());
            if (project.isProjectGit()) {
                textGitHub.setText(project.getProjectGit());
            }
            if (project.isProjectPlayMarket()) {
                textPlayMarket.setText(project.getProjectPlayMarket());
            }
        }
    }
}
