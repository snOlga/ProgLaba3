public enum Location
{
    HOUSE ("в домике"),
    STREET ("на улице"),
    STARTROCKETSTREET ("на стартовой площадке"),
    ROCKET ("в ракете"),
    COSMOS ("в космосе"),
    SKY ("в небе"),
    COSMOSCITY ("в Космическом городке"),
    SUNCITY ("в Солнечном городке");


    private String status;

    Location(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
}
