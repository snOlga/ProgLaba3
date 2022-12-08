public class Character extends Human implements canGo, canShake, canPush, canAsk
{
    Locations loc = Locations.STREET;
    Emotions emo = Emotions.NORMAL;
    Nature nature = Nature.USUAL;
    Status status = Status.NORMAL;




    enum Locations
    {
        HOUSE ("в домике"),
        STREET ("на улице");

        private String status;

        Locations(String status)
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
        SCARED("испугался/ась");

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
        System.out.println(name + " теперь " + emo.status);
    }

    public void printLoc()
    {
        System.out.println(name + " " + loc.status);
    }
    @Override
    public void go(Character.Locations newLoc)
    {
        loc = newLoc;
        System.out.println(name + " ушёл/а и теперь " + loc.status);
        loc = newLoc;
    }
    @Override
    public void shake(Character shaker, Character victim)
    {
        System.out.println(shaker.name + " трясёт " + victim.name);
        victim.emo = Emotions.ANGRY;
        System.out.println("Теперь " + victim.name + " " + victim.emo.status);

        if(victim.nature == Nature.PRIDEFUL && victim.loc == Locations.STREET)
        {
            victim.go(Locations.HOUSE);
        }
        else if(victim.nature == Nature.PRIDEFUL && victim.loc == Locations.HOUSE)
        {
            victim.go(Locations.STREET);
        }
        else if(victim.nature == Nature.TESTY)
        {
            victim.push(victim,shaker);
        }
    }

    @Override
    public void push (Character buller, Character victim)
    {
        buller.emo = Emotions.ANGRY;
        victim.emo = Emotions.SCARED;

        victim.status = Status.PUSHED;
    }

    @Override
    public void ask( Character victim)
    {
        System.out.println(this.name + " спросил " + victim.name);

        if (this.nature == Nature.IMPATIENT)
        {
            System.out.println(this.name + " не дождался/ась ответа");
            this.shake(this, victim);
        }
        if(this.nature == Nature.USUAL && victim.nature == Nature.PRIDEFUL && victim.loc == Locations.STREET)
        {
            victim.go(Locations.HOUSE);
            this.emo = Emotions.SAD;
        }
        else if(this.nature == Nature.USUAL && victim.nature == Nature.PRIDEFUL && victim.loc == Locations.HOUSE)
        {
            victim.go(Locations.STREET);
            this.emo = Emotions.SAD;
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
