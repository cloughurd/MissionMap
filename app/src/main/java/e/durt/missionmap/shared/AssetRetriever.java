package e.durt.missionmap.shared;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AssetRetriever implements IDataRetriever {
    private final String WARDS_FILENAME = "areaCoordinates.json";

    @Override
    public List<IPlottable> getPoints() {
        Gson gson = new Gson();
        InputStream asset = SingleFactory.getMapPresenter().getView().getFileFromAssets(WARDS_FILENAME);
        Type listType = new TypeToken<ArrayList<WardData>>(){}.getType();

        return gson.fromJson(new InputStreamReader(asset), listType);
    }

    @Override
    public List<Epistle> getAreaEpistles(String areaName) {
        String areaFile = areaName.replaceAll("\\s", "") + ".json";

        Gson gson = new Gson();
        InputStream asset = SingleFactory.getMapPresenter().getView().getFileFromAssets(areaFile);
        Type listType = new TypeToken<ArrayList<Epistle>>(){}.getType();
        return gson.fromJson(new InputStreamReader(asset), listType);
    }
}
