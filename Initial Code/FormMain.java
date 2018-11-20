package mygui;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FormMain extends javax.swing.JFrame{

    private static final long serialVersionUID = 1L;
    //Creates the form and adds the cards
    public FormMain()
    {
        setSize(1000, 750);

        myCards = new ArrayList<>();
        for(int i = 0; i < 18; i++)
        {
            Random r = new Random();
            Color color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
            Card card1 = new Card(color);
            Card card2 = new Card(color);
            card1.setText("Card1");
            card2.setText("Card2");
            myCards.add(card1);
            myCards.add(card2);


            card1.AddListener((Card card) -> {
                if(selectedCard1 == null)
                {
                    selectedCard1 = card;
                    selectedCard1.setText("Card 1 selectedCard1");
                }
                else if(selectedCard2 == null)
                {
                    selectedCard2 = card;
                    selectedCard2.setText("Card 1 selectedCard2");
                    
                    //check for match with selectedCard1
                    if(selectedCard1.getBackground() == selectedCard2.getBackground())
                    {
                        selectedCard1.setText("Clicked SC1");
                        selectedCard2.setText("Clicked SC2");
                        Color black = new Color(0,0,0);
                        card1.setBackground(black);
                        card2.setBackground(black);
                        
                    }
//                    if(selectedCard1 == card1) //works only one way
//                        //I am selecting myself
//                    {
//                        Color black = new Color(0,0,0); 
//                      //card2.setBackground(black);
//                      card1.setBackground(black);
//                      
//                    }

try {
    //delay for 1 sec
    Thread.sleep(1000);
} catch (InterruptedException ex) {
    Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
}

//flip the cards back over

selectedCard1.setBackground(card1.originalColor);
selectedCard2.setBackground(card1.originalColor);
selectedCard1 = null;
selectedCard2 = null;

                }
            });

             card2.AddListener((Card card) -> {
                 if(selectedCard1 == null)
                 {
                     selectedCard1 = card;
                     selectedCard1.setText("cArd 2 selected card 1");
                 }
                 else if(selectedCard2 == null)
                 {
                     selectedCard2 = card;
                     selectedCard2.setText("Card 2 selected card 2");
                     
                     //check for match with selectedCard1
                     if(selectedCard1.getBackground() == selectedCard2.getBackground())
                     {
                         Color black = new Color(0,0,0);
                         card1.setBackground(black);
                         card2.setBackground(black);
                     }
                     
                     
                     try {
                         //delay for 1 sec
                         Thread.sleep(1000);
                     } catch (InterruptedException ex) {
                         Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     
                     // flip the cards back over
                     selectedCard1.setBackground(card2.originalColor);
                     selectedCard2.setBackground(card2.originalColor);
                     selectedCard1 = null;
                     selectedCard2 = null;
                 }
            });

        }
        Collections.shuffle(myCards);
        myCards.forEach((card) -> {
            add(card);
        });


        GridLayout layout = new GridLayout(6,6);
        getContentPane().setLayout(layout);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(() -> {
            new FormMain().setVisible(true);
        });





}

    private final ArrayList<Card> myCards;
    Card selectedCard1;
    Card selectedCard2;

}
