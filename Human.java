public abstract class Human
{
    protected String name;

    public String getName()
    {
        return name;
    }

    protected int age;
    protected String gender;


    enum Status
    {
        NORMAL ("обычный/ая"),
        PUSHED ("побитый/ая"),
        ILL ("больной/ая"),
        DIED ("умер/ла");

        private String status;

        Status (String status)
        {
            this.status = status;
        }

        public String getStatus()
        {
            return status;
        }
    }

    enum Nature
    {
        TESTY ("вспыльчивый/ая"),
        USUAL ("обычный/ая"),
        IMPATIENT ("нетерпеливый/ая"),
        PRIDEFUL ("горделивый/ая");

        private String status;

        Nature (String status)
        {
            this.status = status;
        }

        public String getStatus()
        {
            return status;
        }
    }
}
