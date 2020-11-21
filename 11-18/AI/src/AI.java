import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	int x,y,LeftFlag,RightFlag,UpFlag,DownFlag;
	Image currentImg,downImg,leftImg,upImg,rightImg,leftImg1,leftImg2,upImg1,upImg2,rightImg1,rightImg2,downImg1,downImg2;
	public MainCanvas(){
		try
		{
			downImg=Image.createImage("/sayo10.png");
			leftImg=Image.createImage("/sayo12.png");
			upImg=Image.createImage("/sayo14.png");
			rightImg=Image.createImage("/sayo16.png");
			leftImg1=Image.createImage("/sayo02.png");
			leftImg2=Image.createImage("/sayo22.png");
			upImg1=Image.createImage("/sayo04.png");
			upImg2=Image.createImage("/sayo24.png");
			rightImg1=Image.createImage("/sayo06.png");
			rightImg2=Image.createImage("/sayo26.png");
			downImg1=Image.createImage("/sayo00.png");
			downImg2=Image.createImage("/sayo20.png");
			currentImg=downImg;
			x=120;
			y=100;
			LeftFlag=1;
			RightFlag=1;
			UpFlag=1;
			DownFlag=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT){
			if(LeftFlag==1){
				currentImg=leftImg1;
				LeftFlag++;
			}
			else if(LeftFlag==2){
				currentImg=leftImg2;
				LeftFlag--;
			}
			x=x-1;
		}
		if(action==RIGHT){
			if(RightFlag==1){
			currentImg=rightImg1;
			RightFlag++;
			}
			else if(RightFlag==2){
				currentImg=rightImg2;
				RightFlag--;
			}
			x=x+1;
		}
		if(action==UP){
			if(UpFlag==1){
			currentImg=upImg1;
			UpFlag++;
			}
			else if(UpFlag==2){
				currentImg=upImg2;
				UpFlag--;
			}
			y=y-1;
		}
		if(action==DOWN){
			if(DownFlag==1){
			currentImg=downImg1;
			DownFlag++;
			}
			else if(DownFlag==2){
				currentImg=downImg2;
				DownFlag--;
			}
			y=y+1;
		}
		repaint();
	}
}