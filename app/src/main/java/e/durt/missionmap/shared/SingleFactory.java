package e.durt.missionmap.shared;

import e.durt.missionmap.map.IMapPresenter;

public class SingleFactory {
    private static AssetAccessor assetAccessor = null;
    private static IDataRetriever dataRetriever = new AssetRetriever();
    private static IUIFacade uiFacade = new UIFacade(dataRetriever);

    public static AssetAccessor getAssetAccessor(){
        return assetAccessor;
    }

    public static void setAssetAccessor(AssetAccessor newAssetAccessor){
        assetAccessor = newAssetAccessor;
    }

    public static IUIFacade getUIFacade(){
        return uiFacade;
    }
}
