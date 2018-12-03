package e.durt.missionmap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AssetRetriever implements IDataRetriever {
    private final String WARDS_FILENAME = "areaCoordinates.txt";

    @Override
    public List<IPlottable> getPoints() {
        Gson gson = new Gson();
        InputStream asset = SingleFactory.getMapPresenter().getView().getFileFromAssets(WARDS_FILENAME);
        Type listType = new TypeToken<ArrayList<WardData>>(){}.getType();

        return gson.fromJson(new InputStreamReader(asset), listType);
    }
}
