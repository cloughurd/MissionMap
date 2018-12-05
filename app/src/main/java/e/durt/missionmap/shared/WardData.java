package e.durt.missionmap.shared;

import e.durt.missionmap.shared.IPlottable;

public class WardData implements IPlottable {
    private String label;
    private String latitude;
    private String longitude;
    private String dateRange;

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

    @Override
    public String getDateString() {
        return dateRange;
    }

    public void setDateRange(String dateRange) {
        this.dateRange = dateRange;
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
