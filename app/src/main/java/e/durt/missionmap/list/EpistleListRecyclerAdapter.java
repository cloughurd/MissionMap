package e.durt.missionmap.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import e.durt.missionmap.shared.Epistle;
import e.durt.missionmap.R;

public class EpistleListRecyclerAdapter extends RecyclerView.Adapter<EpistleListRecyclerAdapter.ViewHolder> {
    private List<Epistle> epistles;
    private ListItemClickListener listener;

    EpistleListRecyclerAdapter(List<Epistle> epistles, ListItemClickListener listener){
        this.epistles = epistles;
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull EpistleListRecyclerAdapter.ViewHolder holder, int position) {
        holder.onBind(epistles.get(position));
    }

    @Override
    public int getItemCount() {
        return epistles.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.epistle_list_item, parent, false);
        return new EpistleListRecyclerAdapter.ViewHolder(v, listener);
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView date;
        TextView subject;
        ListItemClickListener listener;

        ViewHolder(View v, ListItemClickListener listener){
            super(v);
            date = v.findViewById(R.id.item_date);
            subject = v.findViewById(R.id.item_subject);
            this.listener = listener;
            v.setOnClickListener(this);
        }

        void onBind(Epistle epistle){
            String dateString = epistle.getDateString() + ": ";
            date.setText(dateString);
            subject.setText(epistle.getSubject());
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, getAdapterPosition());
        }
    }
}
