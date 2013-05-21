package sound;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class SoundButton extends JButton 
{
	private URL urlBC;
	private URL urlBH;
	private AudioInputStream audioBC;
	private AudioInputStream audioBH;
	private Clip clipBC;
	private Clip clipBH;
	private FloatControl volumeBC;
	private FloatControl volumeBH;
	
	private static int glosnosc=80;	//przedzial 0 do 100
	private static int wyciszony=0;	//przechowuje stan glosnosci podczas wyciszenia

//konstruktory
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
	
//metody dostepowe
	public static int getGlosnosc() {
		return glosnosc;
	}
	
	public static void setGlosnosc(int glosnosc) {
		SoundButton.glosnosc = glosnosc;
	}
	
	public static int wczytajWyciszony() {
		return wyciszony;
	}

	public static void zapiszWyciszony() {
		wyciszony=glosnosc;
	}
	
//metody
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
			volumeBC=(FloatControl) clipBC.getControl(FloatControl.Type.MASTER_GAIN);
			volumeBH=(FloatControl) clipBH.getControl(FloatControl.Type.MASTER_GAIN);
			
		}
		catch(Exception ex) {}
		
		
		super.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (clipBC.isRunning()) 
					clipBC.stop();	//jeśli poprzedni nie skończył się odtwarzać to zatrzymaj
				
				ustawGlosnosc(volumeBC);
				clipBC.setFramePosition(0);
				clipBC.start();
				clipBC.getControl(FloatControl.Type.MASTER_GAIN);
			}
		});
		
		super.addMouseListener(new MouseListener() 
		{
			public void mouseEntered(MouseEvent e) 
			{
				if (clipBH.isRunning()) 
					clipBH.stop();	//jeśli poprzedni nie skończył się odtwarzać to zatrzymaj
					
				ustawGlosnosc(volumeBH);
				clipBH.setFramePosition(0);
				clipBH.start();
			}
			
			public void mouseExited(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
		});
	}
	
	private void ustawGlosnosc(FloatControl c)
	{
		float glosn = (float)(c.getMinimum()+glosnosc*(c.getMaximum()-c.getMinimum())/100.0f);
		c.setValue(glosn);
	}
	
	

}
