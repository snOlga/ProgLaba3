import java.util.ArrayList;

public class prog3
{
    public static void main(String[] args) throws RocketIsBrokenExeption, NoneOfStatusExeption, HumanIsDiedExeption, CannotThrowHumans
    {
        Character znayka = createCharacter("Знайка");
        znayka.setLocation(Location.HOUSE, Location.COSMOSCITY);
        Character seledochka = createCharacter("Селедочка");
        seledochka.setLocation(Location.HOUSE, Location.COSMOSCITY);
        Character fuchsia = createCharacter("Фуксия");
        fuchsia.setLocation(Location.HOUSE, Location.COSMOSCITY);
        Character neznayka = createCharacter("Незнайка");
        neznayka.setLocation(Location.HOUSE, Location.COSMOSCITY);
        Character professor = createCharacter("Профессор Звездочкин");
        professor.setLocation(Location.HOUSE, Location.SUNCITY);
        Character stranger = createCharacter("Незнакомец");
        stranger.setLocation(Location.HOUSE, Location.COSMOSCITY);

        Pilot neznaykaPilot = createPilot("Незнайка");

        FictionRocket rocket = new FictionRocket();
        rocket.name = "Ракета";
        rocket.status = Rocket.Status.NORMAL;
        rocket.setLocation(Location.STREET);
        rocket.fuel = 50;
        rocket.air = 100;
        rocket.health = 300;

        SmallRock rock = new SmallRock();
        rock.force = 5;
        rock.name = "камень";

        znayka.throwForDamage(rock, rocket);
        System.out.println(rocket.health);
        rocket.checkAirInRocket();


        znayka.nature = Human.Nature.IMPATIENT;
        seledochka.nature = Human.Nature.PRIDEFUL;
        stranger.nature = Human.Nature.TESTY;

        Gate thatGate = new Gate()
        {
            @Override
            public void close()
            {
                System.out.println("Калитка захлопнулась!");
            }
        };


        boolean tryToSwitch = neznaykaPilot.SwitchOn(rocket);

            if (tryToSwitch == true)
            {
                rocket.fly(Location.COSMOS, neznaykaPilot);
            } else if (rocket.status != Rocket.Status.BROKEN)
            {
                tryToSwitch = neznaykaPilot.SwitchOn(rocket);
                if(tryToSwitch == true)
                {
                    rocket.fly(Location.COSMOS, neznaykaPilot);
                }
            }
        if(rocket.location != Location.STREET)
        {
            if (znayka.mainLocation != Location.HOUSE)
            {
                thatGate.close();
            }

            if (rocket.location == Location.COSMOS && rocket.status == Rocket.Status.NORMAL)
            {
                seledochka.setEmotion(Human.Emotions.NERVOUS);
                znayka.seePeople(Location.STREET);
            }

            if (znayka.lookFor(rocket) != true)
            {
                seledochka.ask(znayka);

                znayka.ask(seledochka);
            }
            if (seledochka.mainLocation != fuchsia.mainLocation)
            {
                fuchsia.go(Location.HOUSE);
                znayka.setEmotion(Human.Emotions.SCARED);
            }

            if (seledochka.mainLocation != znayka.mainLocation && fuchsia.mainLocation != znayka.mainLocation && znayka.emotions == Character.Emotions.SCARED)
            {
                znayka.go(seledochka.mainLocation);
            }
            znayka.seePeople(Location.HOUSE);

            professor.go(Location.COSMOSCITY, Location.STREET);

            if (professor.lookFor(rocket) != true && professor.lookFor(znayka) != true)
            {
                professor.shake(stranger);
            }
        }
    }
    static Character createCharacter(String name)
    {
        Character object = new Character();
        object.name = name;
        characters.add(object);
        return object;
    }

    static Passeger createPasseger(String name)
    {
        Passeger object = new Passeger();
        object.name = name;
        rocketTeam.add(object);
        return object;
    }

    static Pilot createPilot(String name)
    {
        Pilot object = new Pilot();
        object.name = name;
        rocketTeam.add(object);
        return object;
    }
    static ArrayList<Character> characters = new ArrayList<Character>();
    static ArrayList<Passeger> rocketTeam = new ArrayList<>();
}

