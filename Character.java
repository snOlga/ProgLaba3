public class Character extends Human
{
    Location location = Location.STREET;
    Emotions emotions = Emotions.NORMAL;
    Nature nature = Nature.USUAL;
    Status status = Status.NORMAL;
    static Emotions emotionsForEveryone;





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

        private String status;

        Emotions(String status)
        {
            this.status = status;
        }

        public String getStatus()
        {
            return status;
        }
    }





    public void newEmotion()
    {
        System.out.println(name + " теперь " + emotions.status);

        if (this.emotions == Emotions.CONFUSED)
        {
            System.out.println(name + " растерянно развел/а руками");
        }
    }

    public void printLoc()
    {
        System.out.println(name + " " + location.getStatus());
    }


    @Override
    public void go(Location newLocation)
    {
        location = newLocation;
        System.out.println(name + " ушёл/а и теперь " + location.getStatus());
    }

    @Override
    public void run(Location newLocation)
    {
        location = newLocation;
        System.out.println(name + " убежал/а и теперь " + location.getStatus());
    }
    @Override
    public void shake(Character victim)
    {
        System.out.println(this.name + " трясёт " + victim.name);
        victim.emotions = Emotions.ANGRY;
        System.out.println("Теперь " + victim.name + " " + victim.emotions.status);

        if(victim.nature == Nature.PRIDEFUL && victim.location == Location.STREET)
        {
            victim.go(Location.HOUSE);
        }
        else if(victim.nature == Nature.PRIDEFUL && victim.location == Location.HOUSE)
        {
            victim.go(Location.STREET);
        }
        else if(victim.nature == Nature.TESTY)
        {
            victim.push(this);
        }
    }

    @Override
    public void push (Character victim)
    {
        this.emotions = Emotions.ANGRY;
        victim.emotions = Emotions.SCARED;

        victim.status = Status.PUSHED;
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
            if (this.nature == Nature.USUAL && victim.nature == Nature.PRIDEFUL && victim.location == Location.STREET && this.emotions == Emotions.NORMAL)
            {
                victim.go(Location.HOUSE);
                this.emotions = Emotions.SAD;
            } else if (this.nature == Nature.USUAL && victim.nature == Nature.PRIDEFUL && victim.location == Location.HOUSE)
            {
                victim.go(Location.STREET);
                this.emotions = Emotions.SAD;
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
            else if (prog3.characters.get(i).location == location)
            {
                System.out.println(prog3.characters.get(i).name);
            }
        }
    }

    @Override
    public boolean lookFor(newObject object)
    {
        if (object.location == this.location)
        {
            this.emotions = Emotions.HAPPY;
            System.out.println(this.name + " нашёл/а " + object.name);
            return true;
        }
        else
        {
            this.emotions = Emotions.ANGRY;
            return false;
        }
    }






























    //    @Override
//    public boolean equals(Object obj)
//    {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//
//        Character character = (Character) obj;
//        return  gender == character.gender;
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
