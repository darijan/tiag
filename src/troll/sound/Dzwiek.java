package sound;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Dzwiek {
	
	private URL urldz1;
	private AudioInputStream audiodz1;
	private Clip clipdz1;
	
	private URL urldz2;
	private AudioInputStream audiodz2;
	private Clip clipdz2;
	
	private boolean przelacznik;

	public Dzwiek() {
		this("dzw/bclick.wav", "dzw/bhover.wav");
	}
	
	public Dzwiek(String dz)
	{
		this(dz, dz);
	}
	
	public Dzwiek(String dz1, String dz2)
	{
		przelacznik=true;
		urldz1=this.getClass().getClassLoader().getResource(dz1);
		urldz2=this.getClass().getClassLoader().getResource(dz2);
		try 
		{
			audiodz1 = AudioSystem.getAudioInputStream(urldz1);
			clipdz1=AudioSystem.getClip();
			clipdz1.open(audiodz1);
			
			audiodz2 = AudioSystem.getAudioInputStream(urldz2);
			clipdz2=AudioSystem.getClip();
			clipdz2.open(audiodz2);
			
		}
		catch(Exception ex) {}
	}
	
	public void graj()
	{
		if(SoundButton.getGlosnosc()!=0)
		{
			if(przelacznik)
			{
				graj(clipdz1);
			}
			else
			{
				graj(clipdz2);
			}
			przelacznik=!przelacznik;
		}
	}
	
	private void graj(Clip cl)
	{
		if (cl.isRunning()) 
			cl.stop();	//jeśli poprzedni nie skończył się odtwarzać to zatrzymaj
		
		ustawGlosnosc(cl);
		cl.setFramePosition(0);
		cl.start();
	}
	
	private void ustawGlosnosc(Clip clip)
	{
		FloatControl c=(FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		float glosn = (float)(c.getMinimum()+SoundButton.getGlosnosc()*(c.getMaximum()-c.getMinimum())/100.0f);
		c.setValue(glosn);
		System.out.println(c.getMinimum()+ " " + c.getMaximum()+ " " + c.getValue());
	}
}
