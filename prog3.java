public class prog3
{
    public static void main(String[] args)
    {
        Character Znayka = new Character();
        Znayka.name = "Знайка";
        Character Seledochka = new Character();
        Seledochka.name = "Селедочка";
        Character Fuksia = new Character();
        Fuksia.name = "Фуксия";

        Znayka.nature = Human.Nature.IMPATIENT;
        Seledochka.nature = Human.Nature.PRIDEFUL;

        Znayka.ask(Znayka, Seledochka);

        if (Seledochka.loc != Fuksia.loc)
        {
            Fuksia.go(Character.Locations.HOUSE);
            Znayka.emo = Character.Emotions.SCARED;
            Znayka.newEmotion();
        }

        if (Seledochka.loc != Znayka.loc && Fuksia.loc != Znayka.loc && Znayka.emo == Character.Emotions.SCARED)
        {
            Znayka.go(Seledochka.loc);
        }
    }
}

