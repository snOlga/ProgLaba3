import java.util.ArrayList;

public class prog3
{
    public static void main(String[] args) throws RocketIsBrokenExeption, NoneOfStatusExeption, HumanIsDiedExeption
    {
        Character znayka = createCharacter("Знайка");
        znayka.location = Location.HOUSE;
        Character seledochka = createCharacter("Селедочка");
        seledochka.location = Location.HOUSE;
        Character fuchsia = createCharacter("Фуксия");
        fuchsia.location = Location.HOUSE;
        Character neznayka = createCharacter("Незнайка");
        neznayka.location = Location.ROCKET;

        FictionRocket rocket = new FictionRocket();
        rocket.name = "Ракета";
        rocket.status = Rocket.Status.NORMAL;


        znayka.nature = Human.Nature.IMPATIENT;
        seledochka.nature = Human.Nature.PRIDEFUL;

        Gate thatGate = new Gate()
        {
            @Override
            public void close()
            {
                System.out.println("Калитка захлопнулась!");
            }
        };



        rocket.fly(Location.COSMOS, neznayka);

        if (znayka.location != Location.HOUSE)
        {
            thatGate.close();
        }

        if (rocket.location == Location.COSMOS && rocket.status == Rocket.Status.NORMAL)
        {
            seledochka.emotions = Character.Emotions.NERVOUS;
            znayka.seePeople(Location.STREET);
        }


        seledochka.ask(znayka);

        znayka.ask(seledochka);

        if (seledochka.location != fuchsia.location)
        {
            fuchsia.go(Location.HOUSE);
            znayka.emotions = Character.Emotions.SCARED;
            znayka.newEmotion();
        }

        if (seledochka.location != znayka.location && fuchsia.location != znayka.location && znayka.emotions == Character.Emotions.SCARED)
        {
            znayka.go(seledochka.location);
        }
        znayka.seePeople(Location.HOUSE);
    }
    static Character createCharacter(String name)
    {
        Character object = new Character();
        object.name = name;
        characters.add(object);
        return object;
    }
    static ArrayList<Character> characters = new ArrayList<Character>();
}

