package e.durt.missionmap.shared;

import java.util.List;

public interface IUIFacade {
    List<IPlottable> getPoints();

    List<Epistle> getAreaEpistles(String areaName);
}
