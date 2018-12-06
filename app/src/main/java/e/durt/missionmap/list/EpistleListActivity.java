package e.durt.missionmap.list;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import e.durt.missionmap.shared.AssetAccessor;
import e.durt.missionmap.shared.Epistle;
import e.durt.missionmap.R;
import e.durt.missionmap.shared.SingleFactory;

public class EpistleListActivity extends AppCompatActivity implements AssetAccessor {
    private List<Epistle> epistles;
    private RecyclerView listRecyclerView;
    private EpistleListRecyclerAdapter listRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epistle_list);

        SingleFactory.setAssetAccessor(this);

        String areaName = getIntent().getExtras().getString("area");
        epistles = SingleFactory.getUIFacade().getAreaEpistles(areaName);

        listRecyclerView = findViewById(R.id.list_recycler);
        listRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        listRecyclerAdapter = new EpistleListRecyclerAdapter(epistles, new ListItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                showEpistle(position);
            }
        });
        listRecyclerView.setAdapter(listRecyclerAdapter);
    }

    private void showEpistle(int index){
        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.epistle_popup, null);
        TextView content = v.findViewById(R.id.epistle_content);

        Epistle e = epistles.get(index);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(e.getSubject() + "\n" + e.getDateString() + "\n");

        content.setText(e.getContent());

        builder.setView(v);
        builder.setPositiveButton("OK", null);
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public InputStream getFileFromAssets(String filename) {
        try {
            return getAssets().open(filename);
        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
