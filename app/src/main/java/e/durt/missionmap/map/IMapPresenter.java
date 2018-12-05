package e.durt.missionmap.map;


public interface IMapPresenter {

    void setMapDisplay(IMapDisplay relatedView);

    void notifyMapReady();

    void selectArea(String areaName);

    IMapDisplay getView();

}
