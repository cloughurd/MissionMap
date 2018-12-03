package e.durt.missionmap;

public class SingleFactory {
    private static IMapPresenter mapPresenter = null;
    private static IDataRetriever dataRetriever = new AssetRetriever();
    private static IUIFacade uiFacade = new UIFacade(dataRetriever);

    public static IMapPresenter getMapPresenter(){
        return mapPresenter;
    }

    public static void setMapPresenter(IMapPresenter newMapPresenter){
        mapPresenter = newMapPresenter;
    }

    public static IUIFacade getUIFacade(){
        return uiFacade;
    }
}
