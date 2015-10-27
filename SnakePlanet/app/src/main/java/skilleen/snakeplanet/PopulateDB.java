package skilleen.snakeplanet;

import android.content.Context;

import skilleen.snakeplanet.Model.SnakeModel;
import skilleen.snakeplanet.Tables.DBAdapter;

/**
 * Created by Scilleen on 9/27/2015.
 */
public class PopulateDB {

    private DBAdapter dbHelper;

    public void populate(Context context){
        dbHelper = new DBAdapter(context);
        dbHelper.open();
        SnakeModel capeCobra = new SnakeModel(2, R.drawable.capecobra, "Cape Cobra", "Highly Venomous", "South Africa, Namibia, Botswana, Lesotho ",
                "The Cape Cobra(Naja nivea) is a medium sized species of cobra. Mature specimens typically are about 1.2 to 1.4 metres long. Cape cobras varies widely in coloration;" +
                        " it ranges from yellow through golden brown to dark brown and even black. In addition, individuals show a varying degree of black or pale stippling and blotches," +
                        " and although it has been stated that colour and marking are geographically related, it is also possible to observe virtually all colour varieties at one location",
                "This species of cobra is a feeding generalist. It feeds on a wide spectrum of prey, including other snakes, rodents, lizards, birds, and carrion.",
                "Predators of Cape cobras include the honey badger, other carnivorous mammals such as Meerkats and a few species of mongoose often prey on the Cape cobra and are its main predators;",
                "Immediately call for transportation to nearest emergency centre. Keep the victim calm and reassured. Allow him or her to lie flat and avoid as much movement as possible." +
                        " If possible, allow the bitten limb to rest at a level lower than the victim's heart.\n" + "DO NOT cut or incise the bite site\n" +
                        "DO NOT apply ice to the bite site");
        dbHelper.createSnake(capeCobra);
        SnakeModel blackMamba = new SnakeModel(3, R.drawable.blackmamba, "Black Mamba", "Highly Venomous", "Democratic Republic of the Congo, Sudan, Ethiopia, Eritrea, Somalia, Kenya, Uganda, Tanzania, Burundi, Rwanda, Mozambique, " +
                "Swaziland, Malawi, Zambia, Zimbabwe, Botswana, KwaZulu-Natal in South Africa, Namibia, Angola", "The black mamba (Dendroaspis polylepis) is a venomous snake endemic to sub-Saharan Africa. " +
                "It takes its common name not from the colour of its scales, but from the interior of its mouth, which is inky-black. It is the longest species of venomous snake on the African continent, with a length typically ranging" +
                " from 2 meters (6.6 ft) to 3 meters (9.8 ft) and up to 4.3 to 4.5 meters (14.1 to 14.8 ft). It is among the fastest moving snakes in the world, capable of moving at 11 km/h (6.8 mph) over short distances.",
                "Hyrax, Rock Hyrax, bushbabies, bats, and any other small animal it can overpower.", "Snake Eagles, Mongooses", "Immediately call for transportation to nearest emergency centre. Keep the victim calm and reassured. Allow him or her to lie flat and avoid as much movement as possible." +
                " If possible, allow the bitten limb to rest at a level lower than the victim's heart.\n" + "DO NOT cut or incise the bite site\n" +
                "DO NOT apply ice to the bite site");
        dbHelper.createSnake(blackMamba);
        SnakeModel blueRacer = new SnakeModel(4, R.drawable.blueracer, "Blue Racer", "Non-Venomous", "Eastern Canada, Eastern United States", "Blue racers often have creamy white ventral scales, dull grey to brilliant blue lateral scales, and pale brown to dark grey dorsums." +
                " They also have characteristic black masks, relatively large eyes, and often have brownish-orange rostral scales (snouts). Unlike adults, hatchlings and yearlings (first full active season) have dorsal blotches that fade completely by the third year;" +
                " however, juvenile patterning is still visible on the venter until late in the snake's third season.", " Rodents, Songbirds, and other snakes", "Larger birds of prey, carnivorous mammals such as raccoons, foxes, and coyotes",
                "Mild bites, wash and bandage wound.");
        dbHelper.createSnake(blueRacer);
        SnakeModel kingCobra = new SnakeModel(5, R.drawable.kingcobra, "King Cobra", "Highly Venomous", "Bangladesh, Bhutan, Burma, Cambodia, China, India, Indonesia, Laos, Nepal, the Philippines, Singapore, Thailand, and Vietnam", "The king cobra averages at 3 to 4 m (9.8 to 13.1 ft) in length and typically weighs about 6 kg (13 lb). " +
                "The skin of this snake is either olive-green, tan, or black, and it has faint, pale yellow cross bands down the length of the body. The belly is cream or pale yellow, and the scales are smooth. Juveniles are shiny black with narrow yellow bands.The head of a mature snake can be quite massive and bulky in appearance, though like all snakes, it can expand its jaws to swallow large prey items. " +
                "It has proteroglyph dentition, meaning it has two short, fixed fangs in the front of the mouth, which channel venom into the prey like hypodermic needles. The average lifespan of a wild king cobra is about 20 years.",
                "Snakes, Lizards, birds, rodents", "Mongoose", "Immediately call for transportation to nearest emergency centre. Keep the victim calm and reassured. Allow him or her to lie flat and avoid as much movement as possible." +
                " If possible, allow the bitten limb to rest at a level lower than the victim's heart.\n" + "DO NOT cut or incise the bite site\n" +
                "DO NOT apply ice to the bite site");
        dbHelper.createSnake(kingCobra);
        SnakeModel garterSnake = new SnakeModel(6, R.drawable.commongartersnake, "Common Garter Snake", "Harmless", "Eastern Canada, Eastern United States, Western Canada", "Common garter snakes are thin snakes." +
                " None grows over about 4 ft (1.2 m) long, and most stay smaller. Most have longitudinal stripes in many different colors. Common garter snakes come in a wide range of colors including: green, blue, yellow, gold, red, orange, brown, and black",
                "Toads, frogs, slugs, and worms, they will eat almost anything that they can overpower.", "Because of their small size, garter snakes have many predators, including hawks," +
                " crows, bears, bullfrogs, snapping turtles, foxes, squirrels and raccoons", "N/A");
        dbHelper.createSnake(garterSnake);
        dbHelper.close();
    }
}
