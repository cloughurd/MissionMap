package e.durt.missionmap;


import java.io.InputStream;

public interface IMapPresenter {

    void setMapDisplay(IMapDisplay relatedView);

    void notifyMapReady();

    void selectArea(String areaName);

    IMapDisplay getView();

}
