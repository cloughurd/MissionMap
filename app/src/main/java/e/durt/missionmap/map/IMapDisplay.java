package e.durt.missionmap.map;

import java.io.InputStream;
import java.util.List;

import e.durt.missionmap.shared.Epistle;
import e.durt.missionmap.shared.IPlottable;

public interface IMapDisplay {

    void placePOIs(List<IPlottable> thingsToPlace);

    InputStream getFileFromAssets(String filename);

    void showMessage(String message);

    void startListActivity(String areaName);
}
