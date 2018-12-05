package e.durt.missionmap.shared;

public interface IPlottable {

    String getLabel();

    String getDateString();

    String getLatitude();
    String getLongitude();

    double getLatDouble();
    double getLongDouble();

}
