public class Pilot extends Character implements PilotRocketSwitcher, canBreatheInRocket
{
    @Override
    public boolean SwitchOn(FictionRocket rocket)
    {
        this.emotions = Emotions.NERVOUS;
        return rocket.SwitchOn(this);
    }

    @Override
    public void SwitchOff(FictionRocket rocket)
    {

    }
//наследовать от пассажира
    @Override
    public void breathe(Rocket rocket)
    {
        rocket.air--;
    }
}
