package e.durt.missionmap.shared;

import java.io.InputStream;

public interface AssetAccessor {
    InputStream getFileFromAssets(String filename);
}
