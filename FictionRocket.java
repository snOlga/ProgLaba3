public class FictionRocket extends Rocket
{
    @Override
    public void beMoved(Location newLocation)
    {
        this.setLocation(newLocation);
    }

    @Override
    public void checkAirInRocket(Pilot pilot)
    {
        for (int i =  0; i < prog3.rocketTeam.size(); i++)
        {
            prog3.rocketTeam.get(i).breathe(this);
        }
        pilot.breathe(this);

        System.out.println("В ракете осталось " + air + " единиц воздуха.");
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
        System.out.println(this.name + " теперь " + location.getStatus());
    }

    @Override
    public boolean SwitchOn(Pilot pilot)
    {
        return InsideTheRocket.Motor.motorOn(this, pilot);
    }

    @Override
    public void SwitchOff(Pilot pilot)
    {

    }

    @Override
    public void beHarmed(int harm)
    {
        this.health -= harm;

        if (this.health < 30)
        {
            this.status = Status.BROKEN;
            System.out.println(this.name + " теперь " + this.status.getStatus());
        }
    }

    @Override
    public void beThrownForDamage(newObject victim) throws CannotThrowHumans
    {
        victim.beHarmed(force);
    }

    @Override
    public void fly(Location newLocation, Pilot pilot) throws RocketIsBrokenExeption, NoneOfStatusExeption
    {
        if (this.status == Status.NORMAL)
        {
            if (fuel > 40)
            {
                fuel -= 10;
                setLocation(newLocation);
            }
            else
            {
                fuel -= 5;
                setLocation(Location.SKY);
                System.out.println(this.name + " летит");
                fuel -= 5;
                setLocation(newLocation);
            }

            //вызвать go от всех экземпляров класса Character
            for (int i = 0; i < prog3.characters.size(); i++)
            {
                if (prog3.characters.get(i).mainLocation != Location.ROCKET && prog3.characters.get(i).mainLocation != Location.STREET && prog3.characters.get(i).cityLocation == Location.COSMOSCITY)
                {
                    prog3.characters.get(i).go(Location.STREET);
                }
            }

        }
        else if (this.status == Status.BROKEN)
        {
            throw new RocketIsBrokenExeption("Ракета сломана! Она не может взлететь.");
        }
        else
        {
            throw new NoneOfStatusExeption("Не задан статус ракеты.");
        }
    }

    @Override
    public void explode(Pilot pilot)
    {
        pilot.status = Character.Status.DIED;
        this.status = Status.BROKEN;
        this.speed = 0;
    }

    public void doNoize()
    {
        System.out.println("Ракета шумит!");
    }

    private class InsideTheRocket
    {
        protected class Motor
        {

            public static boolean motorOn(FictionRocket rocket, Pilot pilot) throws NotEnoughFuelExeption
            {
                if (rocket.fuel >= 50)
                {
                    double randomForMotorStop = Math.random();

                    if (randomForMotorStop > 0.5)
                    {
                        System.out.println(rocket.name + " не заводится!");

                        double randomForExplosion = Math.random();

                        if (randomForExplosion > 0.5)
                        {
                            rocket.explode(pilot);

                            System.out.println(rocket.name + " взорвалась!");
                        }
                        return false;
                    } else
                    {
                        System.out.println("Мотор у объекта " + rocket.name + " гудит!");
                        rocket.fuel -= 10;
                        return true;
                    }
                }
                else
                {
                    throw new NotEnoughFuelExeption("Задано недостаточное количество топлива!");
                }
            }
        }
    }
}
