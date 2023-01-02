public class Pilot extends Passeger implements PilotRocketSwitcher, canBreatheInRocket
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
}
