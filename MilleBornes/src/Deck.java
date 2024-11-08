import java.util.ArrayList;
import java.util.Collections;

public class Deck 
  {
    static ArrayList<Card> deck = new ArrayList<Card>();

    public static void fillDeck()
    {
      deck.add(new Card("Car Crash", 0, "hazard"));
      deck.add(new Card("Car Crash", 0, "hazard"));
      deck.add(new Card("Car Crash", 0, "hazard"));
      
      deck.add(new Card("Out of Gas", 0, "hazard"));
      deck.add(new Card("Out of Gas", 0, "hazard"));
      deck.add(new Card("Out of Gas", 0, "hazard"));
      
      deck.add(new Card("Flat Tire", 0, "hazard"));
      deck.add(new Card("Flat Tire", 0, "hazard"));
      deck.add(new Card("Flat Tire", 0, "hazard"));

      deck.add(new Card("Speed Limit", 0, "limit"));
      deck.add(new Card("Speed Limit", 0, "limit"));
      deck.add(new Card("Speed Limit", 0, "limit"));
      deck.add(new Card("Speed Limit", 0, "limit"));

      deck.add(new Card("Stop Light", 0, "hazard"));
      deck.add(new Card("Stop Light", 0, "hazard"));
      deck.add(new Card("Stop Light", 0, "hazard"));
      deck.add(new Card("Stop Light", 0, "hazard"));
      deck.add(new Card("Stop Light", 0, "hazard"));

      deck.add(new Card("Mechanics", 0, "help"));
      deck.add(new Card("Mechanics", 0, "help"));
      deck.add(new Card("Mechanics", 0, "help"));
      deck.add(new Card("Mechanics", 0, "help"));
      deck.add(new Card("Mechanics", 0, "help"));
      deck.add(new Card("Mechanics", 0, "help"));

      deck.add(new Card("Gas Station", 0, "help"));
      deck.add(new Card("Gas Station", 0, "help"));
      deck.add(new Card("Gas Station", 0, "help"));
      deck.add(new Card("Gas Station", 0, "help"));
      deck.add(new Card("Gas Station", 0, "help"));
      deck.add(new Card("Gas Station", 0, "help"));

      deck.add(new Card("Spare Tire", 0, "help"));
      deck.add(new Card("Spare Tire", 0, "help"));
      deck.add(new Card("Spare Tire", 0, "help"));
      deck.add(new Card("Spare Tire", 0, "help"));
      deck.add(new Card("Spare Tire", 0, "help"));
      deck.add(new Card("Spare Tire", 0, "help"));

      deck.add(new Card("Green Light", 0, "help"));
      deck.add(new Card("Green Light", 0, "help"));
      deck.add(new Card("Green Light", 0, "help"));
      deck.add(new Card("Green Light", 0, "help"));
      deck.add(new Card("Green Light", 0, "help"));
      deck.add(new Card("Green Light", 0, "help"));
      deck.add(new Card("Green Light", 0, "help"));
      deck.add(new Card("Green Light", 0, "help"));
      deck.add(new Card("Green Light", 0, "help"));
      deck.add(new Card("Green Light", 0, "help"));
      deck.add(new Card("Green Light", 0, "help"));
      deck.add(new Card("Green Light", 0, "help"));
      deck.add(new Card("Green Light", 0, "help"));
      deck.add(new Card("Green Light", 0, "help"));

      deck.add(new Card("End of Speed Limit", 0, "help"));
      deck.add(new Card("End of Speed Limit", 0, "help"));
      deck.add(new Card("End of Speed Limit", 0, "help"));
      deck.add(new Card("End of Speed Limit", 0, "help"));
      deck.add(new Card("End of Speed Limit", 0, "help"));
      deck.add(new Card("End of Speed Limit", 0, "help"));

      // deck.add(new Card("Driving Ace", 200, "ace"));
      // deck.add(new Card("Extra Tank", 200, "ace"));
      // deck.add(new Card("Puncture Proof", 200, "ace"));
      // deck.add(new Card("Fire Truck", 200, "ace"));

      deck.add(new Card("25 miles", 25, "miles"));
      deck.add(new Card("25 miles", 25, "miles"));
      deck.add(new Card("25 miles", 25, "miles"));
      deck.add(new Card("25 miles", 25, "miles"));
      deck.add(new Card("25 miles", 25, "miles"));
      deck.add(new Card("25 miles", 25, "miles"));
      deck.add(new Card("25 miles", 25, "miles"));
      deck.add(new Card("25 miles", 25, "miles"));
      deck.add(new Card("25 miles", 25, "miles"));
      deck.add(new Card("25 miles", 25, "miles"));

      deck.add(new Card("50 miles", 50, "miles"));
      deck.add(new Card("50 miles", 50, "miles"));
      deck.add(new Card("50 miles", 50, "miles"));
      deck.add(new Card("50 miles", 50, "miles"));
      deck.add(new Card("50 miles", 50, "miles"));
      deck.add(new Card("50 miles", 50, "miles"));
      deck.add(new Card("50 miles", 50, "miles"));
      deck.add(new Card("50 miles", 50, "miles"));
      deck.add(new Card("50 miles", 50, "miles"));
      deck.add(new Card("50 miles", 50, "miles"));
      
      deck.add(new Card("75 miles", 75, "miles"));
      deck.add(new Card("75 miles", 75, "miles"));
      deck.add(new Card("75 miles", 75, "miles"));
      deck.add(new Card("75 miles", 75, "miles"));
      deck.add(new Card("75 miles", 75, "miles"));
      deck.add(new Card("75 miles", 75, "miles"));
      deck.add(new Card("75 miles", 75, "miles"));
      deck.add(new Card("75 miles", 75, "miles"));
      deck.add(new Card("75 miles", 75, "miles"));
      deck.add(new Card("75 miles", 75, "miles"));

      deck.add(new Card("100 miles", 100, "miles"));
      deck.add(new Card("100 miles", 100, "miles"));
      deck.add(new Card("100 miles", 100, "miles"));
      deck.add(new Card("100 miles", 100, "miles"));
      deck.add(new Card("100 miles", 100, "miles"));
      deck.add(new Card("100 miles", 100, "miles"));
      deck.add(new Card("100 miles", 100, "miles"));
      deck.add(new Card("100 miles", 100, "miles"));
      deck.add(new Card("100 miles", 100, "miles"));
      deck.add(new Card("100 miles", 100, "miles"));
      deck.add(new Card("100 miles", 100, "miles"));
      deck.add(new Card("100 miles", 100, "miles"));
      
      deck.add(new Card("200 miles", 200, "miles"));
      deck.add(new Card("200 miles", 200, "miles"));
      deck.add(new Card("200 miles", 200, "miles"));
      deck.add(new Card("200 miles", 200, "miles"));
    }

    public static void shuffle()
    {
      Collections.shuffle(deck);
    }
  }

//      deck.add(new Card());
