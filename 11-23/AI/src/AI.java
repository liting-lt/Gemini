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
	int x,y;
	int flag;
	Image  heroImg[][]=new Image[4][3];
	Image currentImg;
	public MainCanvas(){
		try
		{
			for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++){

					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}
			currentImg=heroImg[3][1];
			x=120;
			y=100;
			flag=1;
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
	public void ChangePicAndMov(int direction){
		if (flag==1)
		{
		currentImg=heroImg[direction][0];
		flag++;
		}
		else if (flag==2)
		{
			currentImg=heroImg[direction][2];
			flag--;
		}
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT){
			ChangePicAndMov(0);
			x=x-1;
		}
		if(action==RIGHT){
			ChangePicAndMov(1);
			x=x+1;
		}
		if(action==UP){
			ChangePicAndMov(2);
			y=y-1;
		}
		if(action==DOWN){
			ChangePicAndMov(3);
			y=y+1;
		}
		repaint();
	}
}