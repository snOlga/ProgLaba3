public abstract class Human extends newObject implements beHarmed, canThrowForDamage, canMove, canShakeObjects, canGo, canShakePeople, canPush, canAsk, canRun, canSee, LookFor, Locatable, LocatableForCity, canGoToAnotherCity
{
    protected String name;

    public String getName()
    {
        return name;
    }

    protected int age;
    protected String gender;
    Status status;

    protected int health;
    protected int force;

    public abstract void getEmotion();

    public abstract void setEmotion(Emotions newEmotion);


    enum Status
    {
        NORMAL ("обычный/ая"),
        PUSHED ("побитый/ая"),
        ILL ("больной/ая"),
        DIED ("умер/ла");

        protected String status;

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

        protected String status;

        Nature (String status)
        {
            this.status = status;
        }

        public String getStatus()
        {
            return status;
        }
    }

    enum Emotions
    {
        SAD ("грустный/ая"),
        ANGRY ("злой/ая"),
        HAPPY ("счастливый/ая"),
        NORMAL ("обычный/ая"),
        SCARED ("испугался/ась"),
        CALM ("спокоен/а"),
        CONFUSED ("растерянн/а"),
        NERVOUS ("взволнован/а");

        protected String status;

        Emotions(String status)
        {
            this.status = status;
        }

        public String getStatus()
        {
            return status;
        }
    }

    //надо будто бы задать здесь "если пресонаж мёртв, то выдать ошибку" во всех наследуемых интерфейсах
}
