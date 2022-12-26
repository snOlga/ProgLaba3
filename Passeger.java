public class Passeger extends Character implements canBreatheInRocket
{
    public void lookAtWindow()
    {
        System.out.println("Земля в иллюминаторе видна!");
    }
    @Override
    public void breathe(Rocket rocket)
    {
        rocket.air--;
    }
}
