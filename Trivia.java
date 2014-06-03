import java.util.Random;
import java.util.ArrayList;

public class Trivia{
    private ArrayList<String> things = new ArrayList<String>();

    public Trivia() {	
	things.add("'Hello!'");
	things.add("'Hii!!!'");
	things.add("'Hey. What's up?'");
	things.add("'Nice to meet you!'");
	things.add("'How are you today?'");
	things.add("'Nice weather today isn't it?'");
	things.add("'You must be new here!'");
	things.add("'How do you like our town?'");
	things.add("'Hey you're cute ;).'");
	    things.add("'The creators of this country are in a group called 'DayBreak' . Strange, isn't it?'");
	things.add("'.. period 9 is so much cooler than period 8... Wait what?'");
	things.add("'I heard there's a really weird desert in this country, I'm never able to recognize anyone who returns'");
	things.add("'Last I heard, Seaporte was overrun by pirates, Oh no!'");
	things.add("'I heard the powerful wizard Wesarde lived in that tower all the way to the north'");
	things.add("'There's a rumor going around that Wesarde is sick but that cant be true, right?'");
	things.add("'All hail our ruler, King Brown-Mykolyk!!'");
	//addmore c:
	things.add("Hm.. doesn't seem like anybody wants to talk to me...");
    }   
	 
    public String getTrivia(){// ONLY 3 CHANCES PER DAY, keep track when calling this. After that,only print that no one wants to talk, it's too late.
	Random r= new Random();
	return things.get(r.nextInt(things.size()));
    }
}
