import java.util.ArrayList;
import java.util.Scanner;
class Main 
{
  
  static ArrayList <Card> player1Deck = new ArrayList <Card> ();
  static ArrayList <Card> player2Deck = new ArrayList <Card> ();
  static ArrayList <Card> discardPile = new ArrayList <Card> ();
  static ArrayList <Card> playingPile = new ArrayList <Card> ();
  static int player1Miles = 0;
  static int player2Miles = 0;
  static boolean player1IsPlaying = false;
  static boolean player2IsPlaying = false;
  static String player1Hazard = "none";
  static String player2Hazard = "none";
  static int player1SpeedLimit = 200;
  static int player2SpeedLimit = 200;
 
  static Card playedCard;
  
  
  public static void main(String[] args) 
  {
    Deck.fillDeck();
    Deck.shuffle();
    introduction();
    dealCards();
    player1DrawCard();
    printPlayer1Deck();
    player1PlayFirst();
  }

  public static void introduction()
  {
    System.out.println("Welcome to the 'Mille Bornes' card game! 🚕🚙🚗");
    System.out.println();
    //add instructions if time 
  }

  public static void dealCards()
  {
    for (int l = 0; l < 6; l++)
      {
        player1Deck.add(Deck.deck.get(0));
        Deck.deck.remove(0);

        player2Deck.add(Deck.deck.get(0));
        Deck.deck.remove(0);
      }
  }

  public static void printPlayer1Deck()
  {
    System.out.println("Here are your cards:");
    
    int cardNumber = 1;
    for (int l= 0; l < player1Deck.size(); l++)
      {
        System.out.println(cardNumber +". "+ player1Deck.get(l).getTitle() +", worth "+ player1Deck.get(l).getMiles() +" miles");

        cardNumber++;
      }
    System.out.println();
    System.out.println("8. Choose to discard a card");
    System.out.println();
    System.out.println("Play a card! 🚗");
  }

  public static void player1DrawCard()
  {
    checkIfDeckEmpty();
    player1Deck.add(Deck.deck.get(0));
    Deck.deck.remove(0);
  }
  
  public static void player1PlayFirst()
  {
    checkForWinner();
    checkIfDeckEmpty();

    Scanner userIntInput = new Scanner (System.in);
    int player1Choice = userIntInput.nextInt();
    int player1Card = player1Choice -1;

    if (player1Choice == 8)
    {
      System.out.println("Choose which card to discard:");
      System.out.println();
      
    //print player cards:
      int cardNumber = 1;
      for (int l= 0; l < player1Deck.size(); l++)
        {
          System.out.println(cardNumber +". "+ player1Deck.get(l).getTitle() +", worth "+ player1Deck.get(l).getMiles() +" miles");

          cardNumber++;
        }

      Scanner userNumberInput = new Scanner (System.in);
      int discardChoice = userNumberInput.nextInt()-1;
      discardPile.add(player1Deck.get(discardChoice));
      player1Deck.remove(discardChoice);
      player1DrawCard();   


      //player 2 play
       if (player2IsPlaying == true)
         {
           System.out.println();
           player2NormalTurn();
         }
      //if no green light card
          else if (player2IsPlaying == false && player2Hazard.equals("none"))
          {
            System.out.println();
            player2PlayFirst();
          }
      //if hazard
          else if (player2IsPlaying == false && player2Hazard != "none")
          {
            System.out.println();
            player2HazardTurn();
          }
    }

   else if (player1Deck.get(player1Card).getTitle().equals("Green Light") )
    {
      player1IsPlaying = true;
      player1Miles += player1Deck.get(player1Card).getMiles();
      playingPile.add(player1Deck.get(player1Card));
      player1Deck.remove(player1Card);
      System.out.println("The next card is...");
      //System.out.println();
      player1DrawCard();


      //player 2 play
       if (player2IsPlaying == true)
         {
           System.out.println();
           player2NormalTurn();
         }
      //if no green light card
          else if (player2IsPlaying == false && player2Hazard.equals("none"))
          {
            System.out.println();
            player2PlayFirst();
          }
      //if hazard
          else if (player2IsPlaying == false && player2Hazard != "none")
          {
            System.out.println();
            player2HazardTurn();
          }
    }
 
    else
    {
      System.out.println("oops 🤨");
      System.exit(0);
    }

  }

  public static void player2PlayFirst()
  {
   // System.out.println();
    checkForWinner();
    checkIfDeckEmpty();
    int counter = 0;
    int player2Card = 0;
    for (int l=0; l < player2Deck.size(); l++)
      {
        if (player2Deck.get(l).getTitle().equals("Green Light"))
        {
          player2IsPlaying = true;
          counter ++;
          player2Card = l;
        }    
      }

    if (counter > 0)
    {
      System.out.println("Your opponent's first card is a " + player2Deck.get(player2Card).getTitle());
      playingPile.add(player2Deck.get(player2Card));
      player2Deck.remove(player2Card);
    }

    else 
    {
      System.out.println("Your opponent couldn't play and chose to draw a card!");
      discardPile.add(player2Deck.get(0));
      player2Deck.remove(0);
      player2Deck.add(Deck.deck.get(0));
    }

    //player 1 play:
     if (player1IsPlaying == true)
       {
         System.out.println();
         //printPlayer1Deck();
         player1NormalTurn();
       }
    //if no green light card
        else if (player1IsPlaying == false && player1Hazard.equals("none"))
        {
          System.out.println();
          printPlayer1Deck();
          player1PlayFirst();
        }
    //if hazard
        else if (player1IsPlaying == false && player1Hazard != "none")
        {
          System.out.println();
          //printPlayer1Deck();
          player1HazardTurn();
        }
   

  } 

  public static void player1NormalTurn()
  {
    checkForWinner();
    checkIfDeckEmpty();

    printPlayer1Deck();
   
    Scanner userIntInput = new Scanner (System.in);
    int player1Choice = userIntInput.nextInt();
    int player1Card = player1Choice -1;

    if (player1Choice == 8)
    {
      //Player 1 discards a card:
      System.out.println("Choose which card to discard:");
      System.out.println();

      int cardNumber = 1;
      for (int l= 0; l < player1Deck.size(); l++)
        {
          System.out.println(cardNumber +". "+ player1Deck.get(l).getTitle() +", worth "+ player1Deck.get(l).getMiles() +" miles");

          cardNumber++;
        }

      Scanner userNumberInput = new Scanner (System.in);
      int discardChoice = userNumberInput.nextInt()-1;
      discardPile.add(player1Deck.get(discardChoice));
      player1Deck.remove(discardChoice);
      player1DrawCard();    

      
    }

      //if speed limit:

       else if (player1Deck.get(player1Card).getTitle().equals("End of Speed Limit"))
      {
        
        player1IsPlaying = true;
        player1SpeedLimit = 200;

        System.out.println();
        System.out.println("You ended your hazard! Yay!");

        playingPile.add(player1Deck.get(player1Card));
        player1Deck.remove(player1Card);
        player1DrawCard();   

      }
        

     else if (player1Deck.get(player1Card).getCategory().equals("hazard") || player1Deck.get(player1Card).getCategory().equals("limit"))
      {
        System.out.println("Your opponent now has a hazard.");
        player2Hazard = player1Deck.get(player1Card).getTitle();
        player2IsPlaying = false;

        if (player1Deck.get(player1Card).getTitle().equals("Speed Limit"))
        {
          player2IsPlaying = true;
          player2SpeedLimit = 50;
        }
        
        playingPile.add(player1Deck.get(player1Card));
        player1Deck.remove(player1Card);
        player1DrawCard();
        System.out.println("You also drew a replacement card.");

      }

    else if (player1Deck.get(player1Card).getCategory().equals("miles"))
    {
      if (player1Deck.get(player1Card).getMiles() <= player1SpeedLimit)
      {
    player1Miles += player1Deck.get(player1Card).getMiles();
    System.out.println("You now have " + player1Miles + " miles!");
    playingPile.add(player1Deck.get(player1Card));
    player1Deck.remove(player1Card);
    player1DrawCard();
    System.out.println("You also drew a replacement card.");
      }
      else 
      {
        System.out.println("Oops! That card wasn't within the speed limit!");
        System.exit(0);
      }
    }

    //check for winner:
    if (player1Miles >= 1000)
    {
      System.out.println("You reached 1000 miles and won! 🎉");
      System.exit(0);
    }

    //player2Play
        if (player2IsPlaying == true)
        {
          System.out.println();
          player2NormalTurn();
        }
    //if no green light card
        else if (player2IsPlaying == false && player2Hazard.equals("none"))
        {
          System.out.println();
          player2PlayFirst();
        }
    //if hazard
        else if (player2IsPlaying == false && player2Hazard != "none")
        {
          System.out.println();
          player2HazardTurn();
        }
  }

  public static void player2NormalTurn()
  {   
    checkIfDeckEmpty();
    checkForWinner();
    if (player2IsPlaying == true)
    { 
      int counter3 = 0;
      
       if (player2Hazard.equals("Speed Limit"))
        { 
          int holderNumber = 0;
          for (int l = 0; l<player2Deck.size(); l++)
          {
            if (player2Deck.get(l).getTitle().equals("End of Speed Limit"))
            {
              counter3++;
              holderNumber = l;
            } 
        }
          if (counter3 > 0)
          {
              player2Hazard = "none";
              player2SpeedLimit = 200;

              playingPile.add(player2Deck.get(holderNumber));
              player2Deck.remove(holderNumber);
              player2Deck.add(Deck.deck.get(0));
              Deck.deck.remove(0);
              System.out.println();
              System.out.println("Your opponent overcame their hazard and can play any miles again!");
              //player 1 play;
               if (player1IsPlaying == true)
                 {
                   System.out.println();
                   //printPlayer1Deck();
                   player1NormalTurn();
                 }
              //if no green light card
                  else if (player1IsPlaying == false && player1Hazard.equals("none"))
                  {
                    System.out.println();
                    printPlayer1Deck();
                    player1PlayFirst();
                  }
              //if hazard
                  else if (player1IsPlaying == false && player1Hazard != "none")
                  {
                    System.out.println();
                   // printPlayer1Deck();
                    player1HazardTurn();
                  }
          }
            
         else if (counter3 < 1) 
            {
          //plays a card within the speed limit
              Card playerLimitCard = player2Deck.get(0);
              for (int i = 0; i < player2Deck.size(); i++)
                {
                  if (player2Deck.get(i).getCategory().equals("miles"))
                  {
                      if (player2Deck.get(i).getMiles() <= player2SpeedLimit)
                      {
                      playerLimitCard = player2Deck.get(i);
                      counter3++;
                      }   
                  } 
                }

              if (counter3 > 0)
              {
                //play card
                System.out.println("Your opponent played a " + playerLimitCard.getTitle() + " card.");
                player2Miles += playerLimitCard.getMiles();
                System.out.println("Your opponent has " + player2Miles + " miles.");
                playingPile.add(playerLimitCard);
                player2Deck.remove(playerLimitCard);
                //draw card
                player2Deck.add(Deck.deck.get(0));
                Deck.deck.remove(0);

                //player 1 play;
                 if (player1IsPlaying == true)
                   {
                     System.out.println();
                    // printPlayer1Deck();
                     player1NormalTurn();
                   }
                //if no green light card
                    else if (player1IsPlaying == false && player1Hazard.equals("none"))
                    {
                      System.out.println();
                      printPlayer1Deck();
                      player1PlayFirst();
                    }
                //if hazard
                    else if (player1IsPlaying == false && player1Hazard != "none")
                    {
                      System.out.println();
                    //  printPlayer1Deck();
                      player1HazardTurn();
                    }
            }
              else 
              {
                //discards a card
                discardPile.add(player2Deck.get(0));
                player2Deck.remove(0);
                player2Deck.add(Deck.deck.get(0));
                Deck.deck.remove(0);
                System.out.println();
                System.out.println("Your opponent discarded and drew a card.");

                //player 1 play;
                 if (player1IsPlaying == true)
                   {
                     System.out.println();
                    // printPlayer1Deck();
                     player1NormalTurn();
                   }
                //if no green light card
                    else if (player1IsPlaying == false && player1Hazard.equals("none"))
                    {
                      System.out.println();
                      printPlayer1Deck();
                      player1PlayFirst();
                    }
                //if hazard
                    else if (player1IsPlaying == false && player1Hazard != "none")
                    {
                      System.out.println();
                     // printPlayer1Deck();
                      player1HazardTurn();
                    }
              }
          }
      }

       if (player2Hazard.equals("none"))
      {
        
    Card highestCard = player2Deck.get(0);
        //highest card STARTS OFF AS NOT A MILES CARD!

    int cardCounter = 0;

    //player 2 plays mile card
    for (int l = 0; l < player2Deck.size(); l++)
      {
        if (player2Deck.get(l).getCategory().equals("miles"))
        {
          if (player2Deck.get(l).getMiles() > highestCard.getMiles())
          {
            if (player2Deck.get(l).getMiles() <= player2SpeedLimit)
            {
            highestCard.equals(player2Deck.get(l));
            cardCounter++;
            }
          }   
        } 
      }

    if (cardCounter > 0 && highestCard.getCategory().equals("miles"))
    {
   
      //play card
      System.out.println("Your opponent played a " + highestCard.getTitle() + " card.");
      player2Miles += highestCard.getMiles();
      System.out.println("Your opponent has " + player2Miles + " miles.");
      playingPile.add(highestCard);
      player2Deck.remove(highestCard);
      //draw card
      player2Deck.add(Deck.deck.get(0));
      Deck.deck.remove(0);
     

      //player 1 play;
       if (player1IsPlaying == true)
         {
           System.out.println();
           //printPlayer1Deck();
           player1NormalTurn();
         }
      //if no green light card
          else if (player1IsPlaying == false && player1Hazard.equals("none"))
          {
            System.out.println();
            printPlayer1Deck();
            player1PlayFirst();
          }
      //if hazard
          else if (player1IsPlaying == false && player1Hazard != "none")
          {
            System.out.println();
           // printPlayer1Deck();
            player1HazardTurn();
          }
    }
      
    //player 2 plays  hazard if no miles
    else if (cardCounter == 0 || highestCard.getCategory() != "miles")
    {
      
      int counter2 = 0;
      
      int cardNumber = 0;
      int cardSpot = -1;
      
      
      for (int l = 0; l < player2Deck.size(); l++)
        {
          cardSpot ++;
         if (player2Deck.get(l).getCategory().equals("hazard") && player1Hazard.equals("none") && player1IsPlaying == true)
        {    
          counter2 ++;
          //doesn't work: card number as l! l is not a number!
          cardNumber = cardSpot;
        }
          else if (player2Deck.get(l).getCategory().equals("limit") && player1Hazard.equals("none") && player1IsPlaying == true)
        {       
          counter2 ++;  
          cardNumber = cardSpot;
        }
        }

          if (counter2 > 0)
          {
             System.out.println("Uh oh! Your opponent played a " + player2Deck.get(cardNumber).getTitle() + " card !");
            playingPile.add(player2Deck.get(cardNumber));
            playedCard = player2Deck.get(cardNumber);
            player2Deck.remove(cardNumber);

            player1Hazard = playedCard.getTitle();

            if (playedCard.getCategory().equals("hazard"))
            {
              player1IsPlaying = false;
              //draws card
              player2Deck.add(Deck.deck.get(0));
              Deck.deck.remove(0);
         
              player1HazardTurn();
                  
            }

            else if (playedCard.getCategory().equals("limit"))
            {
              player1IsPlaying = true;
              player1SpeedLimit = 50;

              System.out.println("Your speed limit is at 50 miles.");

              //draws card
              player2Deck.add(Deck.deck.get(0));
              Deck.deck.remove(0);

              //player 1 play;
               if (player1IsPlaying == true)
                 {
                   System.out.println();
                  // printPlayer1Deck();
                   player1NormalTurn();
                 }
              //if no green light card
                  else if (player1IsPlaying == false && player1Hazard.equals("none"))
                  {
                    System.out.println();
                    printPlayer1Deck();
                    player1PlayFirst();
                  }
              //if hazard
                  else if (player1IsPlaying == false && player1Hazard != "none")
                  {
                    System.out.println();
                 //   printPlayer1Deck();
                    player1HazardTurn();
                  }
            }
            
          }
           else if (counter2 == 0)
          {
            //player2 draw card
            discardPile.add(player2Deck.get(0));
            player2Deck.remove(0);
            player2Deck.add(Deck.deck.get(0));
            Deck.deck.remove(0);
            System.out.println();
            System.out.println("Your opponent discarded and drew a card.");

            //player 1 play;
             if (player1IsPlaying == true)
               {
                 System.out.println();

                // printPlayer1Deck();
                 player1NormalTurn();
               }
            //if no green light card
                else if (player1IsPlaying == false && player1Hazard.equals("none"))
                {
                  System.out.println();

                  printPlayer1Deck();
                  player1PlayFirst();
                }
            //if hazard
                else if (player1IsPlaying == false && player1Hazard != "none")
                {
                  System.out.println();
                //  printPlayer1Deck();
                  player1HazardTurn();
                }
        } 
      
    }

    }
    }

  } 
  
  public static void player1HazardTurn()
  {
    checkIfDeckEmpty();
    checkForWinner();

    printPlayer1Deck();
   
    Scanner userIntInput = new Scanner (System.in);
    int player1Choice = userIntInput.nextInt();
    int player1Card = player1Choice -1;
    
    if (player1Hazard.equals("Car Crash"))
    {
      //player needs mechanics

      if (player1Choice == 8)
        {
          //Player 1 discards a card:
          System.out.println("Choose which card to discard:");
          System.out.println();

          int cardNumber = 1;
          for (int l= 0; l < player1Deck.size(); l++)
            {
              System.out.println(cardNumber +". "+ player1Deck.get(l).getTitle() +", worth "+ player1Deck.get(l).getMiles() +" miles");

              cardNumber++;
            }
          
          int playerPick = userIntInput.nextInt() -1;
          discardPile.add(player1Deck.get(playerPick));
          player1Deck.remove(playerPick);
          player1DrawCard();   

          //player2Play
              if (player2IsPlaying == true)
              {
                System.out.println();
                player2NormalTurn();
              }
          //if no green light card
              else if (player2IsPlaying == false && player2Hazard.equals("none"))
              {
                System.out.println();
                player2PlayFirst();
              }
          //if hazard
              else if (player2IsPlaying == false && player2Hazard != "none")
              {
                System.out.println();
                player2HazardTurn();
              }
        }

      else if (player1Deck.get(player1Card).getTitle().equals("Mechanics"))
        {
          player1IsPlaying = true;
          player1Hazard = "none";

          System.out.println();
          System.out.println("You ended your hazard! Yay!");
          playingPile.add(player1Deck.get(player1Card));
          player1Deck.remove(player1Card);
          player1DrawCard();  

          //player2Play
              if (player2IsPlaying == true)
              {
                System.out.println();
                player2NormalTurn();
              }
          //if no green light card
              else if (player2IsPlaying == false && player2Hazard.equals("none"))
              {
                System.out.println();
                player2PlayFirst();
              }
          //if hazard
              else if (player2IsPlaying == false && player2Hazard != "none")
              {

                System.out.println();
                player2HazardTurn();
              }
        }

      else
       {
       System.out.println("🤨");
       System.exit(0);
       }
    }
    
    else if (player1Hazard.equals("Out of Gas"))
    {
      //player needs gas station
       if (player1Choice == 8)
       {
        //Player 1 discards a card:
        System.out.println("Choose which card to discard:");
        System.out.println();

        int cardNumber = 1;
        for (int l= 0; l < player1Deck.size(); l++)
          {
            System.out.println(cardNumber +". "+ player1Deck.get(l).getTitle() +", worth "+ player1Deck.get(l).getMiles() +" miles");
            cardNumber++;
          }
         int playerPick = userIntInput.nextInt() -1;
         discardPile.add(player1Deck.get(playerPick));
         player1Deck.remove(playerPick);
         player1DrawCard(); 

        //player2Play
            if (player2IsPlaying == true)
            {
              System.out.println();
              player2NormalTurn();
            }
        //if no green light card
            else if (player2IsPlaying == false && player2Hazard.equals("none"))
            {
              System.out.println();
              player2PlayFirst();
            }
        //if hazard
            else if (player2IsPlaying == false && player2Hazard != "none")
            {
              System.out.println();
              player2HazardTurn();
            }
      }
      
      else if (player1Deck.get(player1Card).getTitle().equals("Gas Station"))
        {
          player1IsPlaying = true;
          player1Hazard = "none";

          System.out.println();
          System.out.println("You ended your hazard! Yay!");

          playingPile.add(player1Deck.get(player1Card));
          player1Deck.remove(player1Card);
          player1DrawCard();   

          //player2Play
              if (player2IsPlaying == true)
              {
                System.out.println();
                player2NormalTurn();
              }
          //if no green light card
              else if (player2IsPlaying == false && player2Hazard.equals("none"))
              {
                System.out.println();
                player2PlayFirst();
              }
          //if hazard
              else if (player2IsPlaying == false && player2Hazard != "none")
              {

                System.out.println();
                player2HazardTurn();
              }
        }
        
      else
        {
         System.out.println("🤨");
         }
    }
    
    else if (player1Hazard.equals("Flat Tire"))
    {
      //player needs spare tire

     if (player1Choice == 8)
       {
        //Player 1 discards a card:
        System.out.println("Choose which card to discard:");
        System.out.println();

        int cardNumber = 1;
        for (int l= 0; l < player1Deck.size(); l++)
          {
            System.out.println(cardNumber +". "+ player1Deck.get(l).getTitle() +", worth "+ player1Deck.get(l).getMiles() +" miles");

            cardNumber++;
          }
         int playerPick = userIntInput.nextInt() -1;
         discardPile.add(player1Deck.get(playerPick));
         player1Deck.remove(playerPick);
         player1DrawCard(); 

        //player2Play
            if (player2IsPlaying == true)
            {
              System.out.println();
              player2NormalTurn();
            }
        //if no green light card
            else if (player2IsPlaying == false && player2Hazard.equals("none"))
            {
              System.out.println();
              player2PlayFirst();
            }
        //if hazard
            else if (player2IsPlaying == false && player2Hazard != "none")
            {

              System.out.println();
              player2HazardTurn();
            }
      }
     else if (player1Deck.get(player1Card).getTitle().equals("Spare Tire"))
        {
          player1IsPlaying = true;
          player1Hazard = "none";

          System.out.println();
          System.out.println("You ended your hazard! Yay!");

          playingPile.add(player1Deck.get(player1Card));
          player1Deck.remove(player1Card);
          player1DrawCard();  

          //player2Play
              if (player2IsPlaying == true)
              {
                System.out.println();
                player2NormalTurn();
              }
          //if no green light card
              else if (player2IsPlaying == false && player2Hazard.equals("none"))
              {
                System.out.println();
                player2PlayFirst();
              }
          //if hazard
              else if (player2IsPlaying == false && player2Hazard != "none")
              {

                System.out.println();
                player2HazardTurn();
              }
        }

      else
        {
         System.out.println("🤨");
         }
    }

    else if (player1Hazard.equals("Stop Light"))
    {
      //player needs green light
      if (player1Deck.get(player1Card).getTitle().equals("Green Light"))
        {
          player1IsPlaying = true;
          player1Hazard = "none";

          System.out.println();
          System.out.println("You ended your hazard! Yay!");

          playingPile.add(player1Deck.get(player1Card));
          player1Deck.remove(player1Card);
          player1DrawCard();   

          //player2Play
              if (player2IsPlaying == true)
              {
                System.out.println();
                player2NormalTurn();
              }
          //if no green light card
              else if (player2IsPlaying == false && player2Hazard.equals("none"))
              {
                System.out.println();
                player2PlayFirst();
              }
          //if hazard
              else if (player2IsPlaying == false && player2Hazard != "none")
              {
                System.out.println();
                player2HazardTurn();
              }
        }

       else if (player1Choice == 8)
          {
            //Player 1 discards a card:
            System.out.println("Choose which card to discard:");
            System.out.println();

            int cardNumber = 1;
            for (int l= 0; l < player1Deck.size(); l++)
              {
                System.out.println(cardNumber +". "+ player1Deck.get(l).getTitle() +", worth "+ player1Deck.get(l).getMiles() +" miles");

                cardNumber++;
              }
            int playerPick = userIntInput.nextInt() -1;
            discardPile.add(player1Deck.get(playerPick));
            player1Deck.remove(playerPick);
            player1DrawCard(); 

            //player2Play
                if (player2IsPlaying == true)
                {
                  System.out.println();
                  player2NormalTurn();
                }
            //if no green light card
                else if (player2IsPlaying == false && player2Hazard.equals("none"))
                {
                  System.out.println();
                  player2PlayFirst();
                }
            //if hazard
                else if (player2IsPlaying == false && player2Hazard != "none")
                {

                  System.out.println();
                  player2HazardTurn();
                }
          }

        else
         {
         System.out.println("🤨");
           System.exit(0);
         }
    }

  }

  public static void player2HazardTurn()
  {
    checkIfDeckEmpty();
    checkForWinner();

    if (player2Hazard != "none" )
    {
    int counter = 0;
      
    if (player2Hazard.equals("Car Crash"))
    {
      for (int l = 0; l<player2Deck.size(); l++)
        {
          if (player2Deck.get(l).getTitle().equals("Mechanics"))
          {
            player2Hazard = "none";
            player2IsPlaying = true;
            
            playingPile.add(player2Deck.get(l));
            player2Deck.remove(l);
            player2Deck.add(Deck.deck.get(0));
            Deck.deck.remove(0);
            counter++;
            System.out.println();
            System.out.println("Your opponent overcame their hazard and can play again!");

            //player 1 play;
           if (player1IsPlaying == true)
             {
               System.out.println();
            //   printPlayer1Deck();
               player1NormalTurn();
             }
          //if no green light card
              else if (player1IsPlaying == false && player1Hazard.equals("none"))
              {
                System.out.println();
                printPlayer1Deck();
                player1PlayFirst();
              }
          //if hazard
              else if (player1IsPlaying == false && player1Hazard != "none")
              {
                System.out.println();
               // printPlayer1Deck();
                player1HazardTurn();
              }          
          }
          
          if (counter <= 0) 
          {
            //discards a card
            discardPile.add(player2Deck.get(0));
            player2Deck.remove(0);
            player2Deck.add(Deck.deck.get(0));
            Deck.deck.remove(0);
            System.out.println();
            System.out.println("Your opponent discarded and drew a card.");

            //player 1 play;
             if (player1IsPlaying == true)
               {
                 System.out.println();
                // printPlayer1Deck();
                 player1NormalTurn();
               }
            //if no green light card
                else if (player1IsPlaying == false && player1Hazard.equals("none"))
                {
                  System.out.println();
                  printPlayer1Deck();
                  player1PlayFirst();
                }
            //if hazard
                else if (player1IsPlaying == false && player1Hazard != "none")
                {
                  System.out.println();
                //  printPlayer1Deck();
                  player1HazardTurn();
                }
          }
        }
    }

    else if (player2Hazard.equals("Out of Gas"))
    {
      for (int l = 0; l<player2Deck.size(); l++)
      {
        if (player2Deck.get(l).getTitle().equals("Gas Station"))
        {
          player2Hazard = "none";
          player2IsPlaying = true;

          playingPile.add(player2Deck.get(l));
          player2Deck.remove(l);
          player2Deck.add(Deck.deck.get(0));
          Deck.deck.remove(0);
          counter++;
          System.out.println();
          System.out.println("Your opponent overcame their hazard and can play again!");
         
          //player 1 play;
           if (player1IsPlaying == true)
             {
               System.out.println();
             //  printPlayer1Deck();
               player1NormalTurn();
             }
          //if no green light card
              else if (player1IsPlaying == false && player1Hazard.equals("none"))
              {
                System.out.println();
                printPlayer1Deck();
                player1PlayFirst();
              }
          //if hazard
              else if (player1IsPlaying == false && player1Hazard != "none")
              {
                System.out.println();
            //    printPlayer1Deck();
                player1HazardTurn();
              }
        }
        if (counter <= 0) 
        {
          //discards a card
          discardPile.add(player2Deck.get(0));
          player2Deck.remove(0);
          player2Deck.add(Deck.deck.get(0));
          Deck.deck.remove(0);
          System.out.println();
          System.out.println("Your opponent discarded and drew a card.");
          
          //player 1 play;
           if (player1IsPlaying == true)
             {
               System.out.println();
           //    printPlayer1Deck();
               player1NormalTurn();
             }
          //if no green light card
              else if (player1IsPlaying == false && player1Hazard.equals("none"))
              {
                System.out.println();
                printPlayer1Deck();
                player1PlayFirst();
              }
          //if hazard
              else if (player1IsPlaying == false && player1Hazard != "none")
              {
                System.out.println();
            //    printPlayer1Deck();
                player1HazardTurn();
              }
        }
      }
    }

    else if (player2Hazard.equals("Flat Tire"))
    {
      for (int l = 0; l<player2Deck.size(); l++)
      {
        if (player2Deck.get(l).getTitle().equals("Spare tire"))
        {
          player2Hazard = "none";
          player2IsPlaying = true;

          playingPile.add(player2Deck.get(l));
          player2Deck.remove(l);
          player2Deck.add(Deck.deck.get(0));
          Deck.deck.remove(0);
          counter++;
          System.out.println();
          System.out.println("Your opponent overcame their hazard and can play again!");

          //player 1 play;
           if (player1IsPlaying == true)
             {
               System.out.println();
              // printPlayer1Deck();
               player1NormalTurn();
             }
          //if no green light card
              else if (player1IsPlaying == false && player1Hazard.equals("none"))
              {
                System.out.println();
                printPlayer1Deck();
                player1PlayFirst();
              }
          //if hazard
              else if (player1IsPlaying == false && player1Hazard != "none")
              {
                System.out.println();
              //  printPlayer1Deck();
                player1HazardTurn();
              }
        }
        if (counter <= 0) 
        {
          //discards a card
          discardPile.add(player2Deck.get(0));
          player2Deck.remove(0);
          player2Deck.add(Deck.deck.get(0));
          Deck.deck.remove(0);
          System.out.println();
          System.out.println("Your opponent discarded and drew a card.");

          //player 1 play;
           if (player1IsPlaying == true)
             {
               System.out.println();
            //   printPlayer1Deck();
               player1NormalTurn();
             }
          //if no green light card
              else if (player1IsPlaying == false && player1Hazard.equals("none"))
              {
                System.out.println();
                printPlayer1Deck();
                player1PlayFirst();
              }
          //if hazard
              else if (player1IsPlaying == false && player1Hazard != "none")
              {
                System.out.println();
            //    printPlayer1Deck();
                player1HazardTurn();
              }
        }
      }
    }
      
    else if (player2Hazard.equals("Stop Light"))
    {
      for (int l = 0; l<player2Deck.size(); l++)
      {
        if (player2Deck.get(l).getTitle().equals("Green Light"))
        {
          player2Hazard = "none";
          player2IsPlaying = true;

          playingPile.add(player2Deck.get(l));
          player2Deck.remove(l);
          player2Deck.add(Deck.deck.get(0));
          Deck.deck.remove(0);
          counter++;
          System.out.println();
          System.out.println("Your opponent overcame their hazard and can play again!");
         
          //player 1 play;
           if (player1IsPlaying == true)
             {
               System.out.println();
             //  printPlayer1Deck();
               player1NormalTurn();
             }
          //if no green light card
              else if (player1IsPlaying == false && player1Hazard.equals("none"))
              {
                System.out.println();
                printPlayer1Deck();
                player1PlayFirst();
              }
          //if hazard
              else if (player1IsPlaying == false && player1Hazard != "none")
              {
                System.out.println();
               // printPlayer1Deck();
                player1HazardTurn();
              }
        }
        if (counter <= 0) 
        {
          //discards a card
          discardPile.add(player2Deck.get(0));
          player2Deck.remove(0);
          player2Deck.add(Deck.deck.get(0));
          Deck.deck.remove(0);
          System.out.println();
          System.out.println("Your opponent discarded and drew a card.");
          
          //player 1 play;
           if (player1IsPlaying == true)
             {
               System.out.println();
            //   printPlayer1Deck();
               player1NormalTurn();
             }
          //if no green light card
              else if (player1IsPlaying == false && player1Hazard.equals("none"))
              {
                System.out.println();
                printPlayer1Deck();
                player1PlayFirst();
              }
          //if hazard
              else if (player1IsPlaying == false && player1Hazard != "none")
              {
                System.out.println();
             //   printPlayer1Deck();
                player1HazardTurn();
              }
        }
      }
    }
      
    }
  }

  public static void checkForWinner()
  {
    if (player1Miles >= 1000)
    {
      System.out.println("You reached 1000 miles and won! 🎉");
      System.exit(0);
    }

    if (player2Miles >= 1000)
    {
      System.out.println("Your opponent reached 1000 miles and won. Better luck next time!");
      System.exit(0);
    }
  }

  public static void checkIfDeckEmpty()
  {
    if (Deck.deck.size() == 0)
    {
      System.out.println("Uh oh, the deck of cards is empty!");

      if (player1Miles > player2Miles)
      {
        System.out.println("You won since you have the most miles!");
        System.exit(0);
      }

      else if (player1Miles < player2Miles)
      {
        System.out.println("Your opponent won since they had more miles!");
        System.exit(0);
      }

      else 
      {
        System.out.println("You tied with the computer since you have the same amount of miles!");
        System.exit(0);
      }
      //end game
      //whoever  has most miles won
    }
   }
  
}
