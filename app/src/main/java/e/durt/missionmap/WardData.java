package e.durt.missionmap;

public class WardData implements IPlottable {
    private String label;
    private String latitude;
    private String longitude;

    public WardData(){

    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getLatitude() {
        return latitude;
    }

    @Override
    public String getLongitude() {
        return longitude;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public double getLatDouble() {
        return Double.parseDouble(latitude);
    }

    @Override
    public double getLongDouble() {
        return Double.parseDouble(longitude);
    }
}
