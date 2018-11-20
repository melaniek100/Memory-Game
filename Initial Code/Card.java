package mygui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;


interface FlipListener
{
    void flipped(Card card);
}

public class Card extends JButton{

    private static final long serialVersionUID = 1L;
    private List<FlipListener> listeners = new ArrayList<>();
    private Color backColor;
    public final Color originalColor;

    public void AddListener(FlipListener listener)
    {
        listeners.add(listener);
    }

    public Card(Color color)
    {
        originalColor = getBackground();
        backColor = color;
        //Click action Listener
        addActionListener((ActionEvent e) -> {
            if(getBackground().equals(backColor))
            {
                setBackground(originalColor);
            }
            else
            {
                setBackground(backColor);
                
            }
            
            listeners.forEach((flipListener) -> {
                flipListener.flipped((Card)e.getSource());
            });
        });
    }
}
