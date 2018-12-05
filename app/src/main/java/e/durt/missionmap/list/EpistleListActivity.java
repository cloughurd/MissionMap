package e.durt.missionmap.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import e.durt.missionmap.shared.Epistle;
import e.durt.missionmap.R;
import e.durt.missionmap.shared.SingleFactory;

public class EpistleListActivity extends AppCompatActivity {
    private List<Epistle> epistles;
    private RecyclerView listRecyclerView;
    private EpistleListRecyclerAdapter listRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epistle_list);

        String areaName = savedInstanceState.getString("area");
        epistles = SingleFactory.getUIFacade().getAreaEpistles(areaName);

        listRecyclerView = findViewById(R.id.list_recycler);
        listRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        listRecyclerAdapter = new EpistleListRecyclerAdapter(epistles, new ListItemClickListener() {
            @Override
            public void onClick(View v, int position) {

            }
        });
        listRecyclerView.setAdapter(listRecyclerAdapter);
    }

    private void showEpistle(int index){
        Epistle e = epistles.get(index);
    }
}
