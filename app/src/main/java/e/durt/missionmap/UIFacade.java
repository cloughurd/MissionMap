package e.durt.missionmap;

import java.util.List;

public class UIFacade implements IUIFacade {
    private IDataRetriever dataRetriever;

    public UIFacade(IDataRetriever dataRetriever){
        this.dataRetriever = dataRetriever;
    }

    @Override
    public List<IPlottable> getPoints() {
        return dataRetriever.getPoints();
    }
}
