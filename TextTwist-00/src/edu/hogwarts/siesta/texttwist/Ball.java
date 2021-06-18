package edu.hogwarts.siesta.texttwist;

import android.graphics.Bitmap;
import android.graphics.Canvas;

class Ball {

	char letter;
	double x,y;
	double size;
	double destx,desty;
	double speed=16;
	boolean isMoving=false;
	double epsilon=0.01;
	boolean used=false;
	int containerIndex=-1;

	static Bitmap font;
	static Bitmap bitmap;

	public Ball(char letter,double x,double y,int size) {
		this.letter=letter;
		this.x=x;
		this.y=y;
		this.size=size;
	}

	public void draw(Canvas canvas) {
		Graphics.draw(canvas,bitmap,(int)x,(int)y,(int)size);
		Graphics.print(canvas,font,8,8,Character.toString(letter),
				(int)(x+(bitmap.getWidth()*size-8*size)/2),
				(int)(y+(bitmap.getHeight()*size-8*size)/2),
				(int)size);
	}

	public void update(Canvas canvas) {
		if(isMoving) {
			double diffx=destx-x;
			double diffy=desty-y;
			if(Math.abs(diffx)<=epsilon && Math.abs(diffy)<=epsilon) {
				isMoving=false;
			} else {
				x+=diffx/speed;
				y+=diffy/speed;
			}
		}
	}

}

