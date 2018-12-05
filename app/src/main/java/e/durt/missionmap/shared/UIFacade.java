package e.durt.missionmap.shared;

import java.util.List;

import e.durt.missionmap.shared.Epistle;
import e.durt.missionmap.shared.IDataRetriever;
import e.durt.missionmap.shared.IPlottable;
import e.durt.missionmap.shared.IUIFacade;

public class UIFacade implements IUIFacade {
    private IDataRetriever dataRetriever;

    public UIFacade(IDataRetriever dataRetriever){
        this.dataRetriever = dataRetriever;
    }

    @Override
    public List<IPlottable> getPoints() {
        return dataRetriever.getPoints();
    }

    @Override
    public List<Epistle> getAreaEpistles(String areaName) {
        return dataRetriever.getAreaEpistles(areaName);
    }
}
