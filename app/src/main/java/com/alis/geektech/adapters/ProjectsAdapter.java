package com.alis.geektech.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alis.geektech.R;
import com.alis.geektech.models.Project;

import java.util.ArrayList;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ProjectsViewHolder> {

    private ArrayList<Project> list;

    public ProjectsAdapter(ArrayList<Project> list) {
        this.list = list;
        Project project1 = new Project(
                R.mipmap.ic_launcher_round,
                "Planner",
                "AzamatGit",
                "planner.market.com",
                true,
                false);
        list.add(project1);
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

        private TextView tvNameApp, tvGit, tvPlayMarket;
        private ImageView imageLogo;

        public ProjectsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameApp = itemView.findViewById(R.id.text_project_name_app);
            tvGit = itemView.findViewById(R.id.text_project_git);
            tvPlayMarket = itemView.findViewById(R.id.text_project_play_market);
            imageLogo = itemView.findViewById(R.id.row_image);
        }

        public void onBind(Project project) {
            tvNameApp.setText(project.getProjectName());
            if (project.isProjectGit()){
                tvGit.setText(project.getProjectGit());
            }
            if (project.isProjectPlayMarket()){
                tvPlayMarket.setText(project.getProjectPlayMarket());
            }
            imageLogo.setImageResource(project.getProjectLogo());
        }
    }
}
