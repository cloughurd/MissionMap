package e.durt.missionmap;

public class MapPresenter implements IMapPresenter{
    IMapDisplay mapView;

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
    public IMapDisplay getView() {
        return mapView;
    }
}
