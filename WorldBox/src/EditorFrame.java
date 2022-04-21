import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EditorFrame extends JPanel {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	static JButton worldGegenerateButton = new JButton();
	
	// slider
	static JLabel seaLevelLabel = new JLabel();
    static JSlider seaLevelSlider = new JSlider();
    
    static JLabel sandReachLabel = new JLabel();
    static JSlider sandReachSlider = new JSlider();
    
    static JLabel snowLevelLabel = new JLabel();
    static JSlider snowLevelSlider = new JSlider();
    
    static JLabel stoneLevelLabel = new JLabel();
    static JSlider stoneLevelSlider = new JSlider();
 
    @Override
    public void paint(Graphics g)    
	{ 	
    	super.paint(g);
    	super.setLayout(null);
    	
    	//---- GENERATION-BUTTON ----
    	super.add(worldGegenerateButton);
    	worldGegenerateButton.setText("Generate world");
    	worldGegenerateButton.setBounds(0, 0, 500, 20);
    	worldGegenerateButton.addActionListener(actionListener);   	
    	
    	//---- SEA LEVEL ---
    	seaLevelSlider.setValue((int)(WorldGeneration.seaLevel * 1000));
    	seaLevelSlider.setBounds(0, 30, 250, 20);
    	seaLevelSlider.setMinimum(-1000);
    	seaLevelSlider.setMaximum(1000);    
	    seaLevelSlider.addChangeListener(new SliderListener());
    	super.add(seaLevelSlider);   
    	
    	seaLevelLabel.setText("Sea level: " + (float)seaLevelSlider.getValue()  / 1000f);
    	seaLevelLabel.setBounds(280, 30, 250, 20);     	
    	super.add(seaLevelLabel);
    	
    	//---- SAND REACH ----
    	sandReachSlider.setValue((int)(WorldGeneration.sandReach * 1000));
    	sandReachSlider.setBounds(0, 50, 250, 20);
    	sandReachSlider.setMinimum(-1000);
    	sandReachSlider.setMaximum(1000);    
    	sandReachSlider.addChangeListener(new SliderListener());
    	super.add(sandReachSlider);   
    	
    	sandReachLabel.setText("Sand reach: " + (float)sandReachSlider.getValue()  / 1000f);
    	sandReachLabel.setBounds(280, 50, 250, 20);     	
    	super.add(sandReachLabel);
    	
    	//---- SNOW LEVEL ----
    	snowLevelSlider.setValue((int)(WorldGeneration.snowLevel * 1000));
    	snowLevelSlider.setBounds(0, 80, 250, 20);
    	snowLevelSlider.setMinimum(-1000);
    	snowLevelSlider.setMaximum(1000);    
    	snowLevelSlider.addChangeListener(new SliderListener());
    	super.add(snowLevelSlider);   
    	
    	snowLevelLabel.setText("Snow level: " + (float)snowLevelSlider.getValue()  / 1000f);
    	snowLevelLabel.setBounds(280, 80, 250, 20);     	
    	super.add(snowLevelLabel);
    	
    	//---- STONE LEVEL ----    	
    	stoneLevelSlider.setValue((int)(WorldGeneration.stoneLevel * 1000));
    	stoneLevelSlider.setBounds(0, 110, 250, 20);
    	stoneLevelSlider.setMinimum(-1000);
    	stoneLevelSlider.setMaximum(1000);    
    	stoneLevelSlider.addChangeListener(new SliderListener());
    	super.add(stoneLevelSlider);   
    	
    	stoneLevelLabel.setText("Stone level: " + (float)stoneLevelSlider.getValue()  / 1000f);
    	stoneLevelLabel.setBounds(280, 110, 250, 20);     	
    	super.add(stoneLevelLabel);
    	
	}
    
    //Actions
	ActionListener actionListener = new ActionListener() 
	{	
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == worldGegenerateButton) 
			{
				WorldGeneration.worldSeed = 0;
				WorldGeneration.GenerateWorld();
				Main.UpdateSimulationWindow();
			}
    	}
	};
	
	//Class for slider events
    class SliderListener implements ChangeListener {
    	
        public void stateChanged(ChangeEvent e) 
        {          
          //---- SEA LEVEL ---
            WorldGeneration.seaLevel = (float)seaLevelSlider.getValue() / 1000f;
            seaLevelLabel.setText("Sea level: " + (float)seaLevelSlider.getValue()  / 1000f);
            
          //---- SAND REACH ----
            WorldGeneration.sandReach = (float)sandReachSlider.getValue() / 1000f;
            sandReachLabel.setText("Sand reach: " + (float)sandReachSlider.getValue()  / 1000f);
            
          //---- SNOW LEVEL ----
            WorldGeneration.snowLevel = (float)snowLevelSlider.getValue() / 1000f;
            snowLevelLabel.setText("Snow level: " + (float)snowLevelSlider.getValue()  / 1000f);
            
          //---- STONE LEVEL ----
            WorldGeneration.stoneLevel = (float)stoneLevelSlider.getValue() / 1000f;
            stoneLevelLabel.setText("Stone level: " + (float)stoneLevelSlider.getValue()  / 1000f);
        }
    }
}
