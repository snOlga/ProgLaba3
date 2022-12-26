public class SmallRock extends NotAliveObject
{
    @Override
    public void beMoved(Location newLocation)
    {
        this.setLocation(newLocation);
    }

    @Override
    public void getLocation()
    {
        System.out.println(this.name + " сейчас " + location.getStatus());
    }

    @Override
    public void setLocation(Location newLocation)
    {
        this.location = newLocation;
        getLocation();
    }

    @Override
    public void beHarmed(int harm)
    {
        System.out.println("Камень не пострадал");
    }

    @Override
    public void beThrownForDamage(newObject victim) throws CannotThrowHumans
    {
        victim.beHarmed(force);
    }
}
