package e.durt.missionmap;

public class MapPresenter implements IMapPresenter{
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
        mapView.showMessage(areaName);
    }

    @Override
    public IMapDisplay getView() {
        return mapView;
    }
}
