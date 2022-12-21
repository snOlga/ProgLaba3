public class FictionRocket extends Rocket
{

    @Override
    public void fly(Location location, Character pilot ) throws RocketIsBrokenExeption, NoneOfStatusExeption
    {
        if (this.status == Status.NORMAL)
        {
            if (motorOn() == false)
            {
                this.explode(pilot);

                System.out.println(this.name + " взорвалась!");
            }
            else
            {
                this.location = location;

                Character.emotionsForEveryone = Character.Emotions.SCARED;

                System.out.println(this.name + " теперь " + location.getStatus());

                System.out.println("Все теперь " + Character.emotionsForEveryone.getStatus());

                //вызвать go от всех экземпляров класса Character
                for (int i = 0; i < prog3.characters.size(); i++)
                {
                    if (prog3.characters.get(i).location != Location.ROCKET && prog3.characters.get(i).location != Location.STREET)
                    {
                        prog3.characters.get(i).go(Location.STREET);
                    }
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
    public void explode(Character pilot)
    {
        Character.emotionsForEveryone = Character.Emotions.SCARED;
        pilot.status = Character.Status.DIED;
        this.status = Status.BROKEN;
        this.speed = 0;
    }

    public void doNoize()
    {
        System.out.println("Ракета шумит!");
        Character.emotionsForEveryone = Character.Emotions.NERVOUS;
    }

    @Override
    public boolean motorOn()
    {
        double randomForMotorStop = Math.random();

        if (randomForMotorStop > 0.5)
        {
            System.out.println(this.name + " не заводится!");
            return false;
        }
        else
        {
            System.out.println("Мотор у объекта " + this.name + " гудит!");
            return true;
        }
    }
}
