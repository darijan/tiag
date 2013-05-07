package sound;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class SoundButton extends JButton {
	
	private URL urlBC;
	private URL urlBH;
	private AudioInputStream audioBC;
	private AudioInputStream audioBH;
	private Clip clipBC;
	private Clip clipBH;

	public SoundButton() {
		init();
	}

	public SoundButton(Icon icon) {
		super(icon);
		init();
	}

	public SoundButton(String text) {
		super(text);
		init();
	}

	public SoundButton(Action a) {
		super(a);
		init();
	}

	public SoundButton(String text, Icon icon) {
		super(text, icon);
		init();
	}
	
	private void init()
	{
		urlBC=this.getClass().getClassLoader().getResource("dzw/bclick.wav");
		urlBH=this.getClass().getClassLoader().getResource("dzw/bhover.wav");
		try 
		{
			audioBC = AudioSystem.getAudioInputStream(urlBC);
			audioBH = AudioSystem.getAudioInputStream(urlBH);
			clipBC=AudioSystem.getClip();
			clipBC.open(audioBC);
			clipBH=AudioSystem.getClip();
			clipBH.open(audioBH);

		}
		catch(Exception ex) {}
		
		
		super.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (clipBC.isRunning()) 
					clipBC.stop();	//jeśli poprzedni nie skończył się odtwarzać to zatrzymaj
				
				clipBC.setFramePosition(0);
				clipBC.start();
			}
		});
		
		super.addMouseListener(new MouseListener() 
		{
			public void mouseEntered(MouseEvent e) 
			{
				if (clipBH.isRunning()) 
					clipBH.stop();	//jeśli poprzedni nie skończył się odtwarzać to zatrzymaj
					
				clipBH.setFramePosition(0);
				clipBH.start();
			}
			
			public void mouseExited(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
		});
	}
	
	

}
