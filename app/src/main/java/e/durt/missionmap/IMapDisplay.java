package e.durt.missionmap;

import java.io.InputStream;
import java.util.List;

public interface IMapDisplay {

    void placePOIs(List<IPlottable> thingsToPlace);

    InputStream getFileFromAssets(String filename);

    void showMessage(String message);
}
