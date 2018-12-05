package e.durt.missionmap.map;

import e.durt.missionmap.shared.SingleFactory;

public class MapPresenter implements IMapPresenter {
    private IMapDisplay mapView;

    public MapPresenter(IMapDisplay mapView){
        this.mapView = mapView;
    }

    @Override
    public void setMapDisplay(IMapDisplay relatedView) {
        mapView = relatedView;
    }

    @Override
    public void notifyMapReady() {
        mapView.placePOIs(SingleFactory.getUIFacade().getPoints());
    }

    @Override
    public void selectArea(String areaName) {
        mapView.startListActivity(areaName);
    }

    @Override
    public IMapDisplay getView() {
        return mapView;
    }
}
