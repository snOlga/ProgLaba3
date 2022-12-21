public abstract class Rocket implements canExplode, MachineFly, MotorOn
{
    protected String name;
    protected Location location;
    Status status;

    public String getName()
    {
        return name;
    }

    protected int speed;

    protected enum Status
    {
        BROKEN ("сломана"),
        NORMAL ("нормальная");
        private String status;

        Status(String status)
        {
            this.status = status;
        }

        public String getStatus()
        {
            return status;
        }
    }

    public static class Air
    {
        protected int amountOfAir;

        protected enum Smells
        {
            BAD,
            GOOD,
            NORMAL;
        }
    }
}
