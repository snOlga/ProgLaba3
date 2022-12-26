public class Character extends Human
{
    Location mainLocation;
    Location cityLocation;
    Emotions emotions;
    Nature nature;
    Status status;


    @Override
    public void getEmotion()
    {
        System.out.println(this.name + " сейчас " + emotions.getStatus());
    }

    @Override
    public void setEmotion(Emotions newEmotion)
    {
        this.emotions = newEmotion;
        getEmotion();
    }

    @Override
    public void getLocation()
    {
        System.out.println(this.name + " сейчас " + mainLocation.getStatus());
    }

    @Override
    public void setLocation(Location newLocation)
    {
        this.mainLocation = newLocation;
        getLocation();
    }

    @Override
    public void setLocation(Location newLocation, Location newCityLocation)
    {
        this.cityLocation = newCityLocation;
        this.mainLocation = newLocation;
        System.out.println(this.name + " теперь " + cityLocation.getStatus() + " " + mainLocation.getStatus());
    }

    @Override
    public void throwForDamage(NotAliveObject thrownObject, newObject victim) throws CannotThrowHumans
    {
        thrownObject.beThrownForDamage(victim);
        System.out.println(this.name + " кинул/a " + thrownObject.name + " в " + victim.name);
    }

    @Override
    public void beThrownForDamage(newObject victim) throws CannotThrowHumans
    {
        throw new CannotThrowHumans("Здесь не кидаются людьми!");
    }

    @Override
    public void beHarmed(int harm)
    {
        health -= harm;
        if (health <= 30)
        {
            this.status = Status.PUSHED;
            this.setEmotion(Emotions.ANGRY);
        }
    }

    @Override
    public void go(Location newLocation)
    {
        System.out.println(name + " ушёл/а");
        setLocation(newLocation);
    }

    @Override
    public void go(Location newCityLocation, Location newLocation)
    {
        System.out.println(name + " ушёл/а");
        setLocation(newLocation, newCityLocation);
    }

    @Override
    public void run(Location newLocation)
    {
        System.out.println(name + " убежал/а");
        setLocation(newLocation);
    }
    @Override
    public void shake(Character victim)
    {
        System.out.println(this.name + " трясёт " + victim.name);
        victim.setEmotion(Emotions.ANGRY);

        if(victim.nature == Nature.PRIDEFUL && victim.mainLocation == Location.STREET)
        {
            victim.go(Location.HOUSE);
        }
        else if(victim.nature == Nature.PRIDEFUL && victim.mainLocation == Location.HOUSE)
        {
            victim.go(Location.STREET);
        }
        else if(victim.nature == Nature.TESTY)
        {
            victim.push(this);
        }
    }

    @Override
    public void shake(NotAliveObject victim)
    {
        victim.status = NotAliveObject.Status.BROKEN;
        System.out.println(this.name + " потряс " + victim.name);
    }

    @Override
    public void push (Character victim)
    {
        victim.setEmotion(Emotions.SCARED);
        System.out.println(this.name + " толкнул " + victim.name + "!");

        victim.beHarmed(force);
    }

    @Override
    public void ask (Character victim) throws HumanIsDiedExeption
    {
        if (this.status != Status.DIED)
        {
            System.out.println(this.name + " спросил " + victim.name);


            if (this.emotions == Emotions.NERVOUS)
            {
                System.out.println(this.name + " ничего не смог/ла сказать");
            }
            if (this.nature == Nature.IMPATIENT)
            {
                System.out.println(this.name + " не дождался/ась ответа");
                this.shake(victim);
            }
            if (this.nature == Nature.USUAL && victim.nature == Nature.PRIDEFUL && victim.mainLocation == Location.STREET && this.emotions == Emotions.NORMAL)
            {
                victim.go(Location.HOUSE);
                this.setEmotion(Emotions.SAD);
            } else if (this.nature == Nature.USUAL && victim.nature == Nature.PRIDEFUL && victim.mainLocation == Location.HOUSE)
            {
                victim.go(Location.STREET);
                this.setEmotion(Emotions.SAD);
            }
        }
        else
        {
            throw new HumanIsDiedExeption("Персонаж " + this.name + " мертв/а");
        }
    }

    @Override
    public void seePeople(Location location)
    {
        System.out.println(this.name + " увидел/а таких персонажей:");

        for (int i = 0; i < prog3.characters.size(); i++)
        {
            if (prog3.characters.get(i).name == this.name)
            {
                continue;
            }
            else if (prog3.characters.get(i).mainLocation == location)
            {
                System.out.println(prog3.characters.get(i).name);
            }
        }
    }

    @Override
    public boolean lookFor(newObject object)
    {
        if (object.location == this.mainLocation)
        {
            this.setEmotion(Emotions.HAPPY);
            System.out.println(this.name + " нашёл/а " + object.name);
            return true;
        }
        else
        {
            //this.setEmotion(Emotions.ANGRY);
            return false;
        }
    }

    @Override
    public void move(NotAliveObject object, Location newLocation)
    {
        object.beMoved(newLocation);
        System.out.println(this.name + " перемеcтил/а " + object.name);
    }

























    //    @Override
//    public boolean equals(Object obj)
//    {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//
//        Character character = (Character) obj;
//        return name == character.name;
//    }
//
//    @Override
//    public int hashCode()
//    {
//        int result = 17;
//        result = 31 * result + (name == null ? 0 : name.hashCode());
//        result = 31 * result + age;
//        result = 31 * result + (gender == null ? 0 : gender.hashCode());
//
//        return result;
//    }
}
