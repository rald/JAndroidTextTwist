package edu.hogwarts.siesta.texttwist;

import android.graphics.Bitmap;
import android.graphics.Canvas;

class Peg {

	static Bitmap bitmap;
	double x,y;
	double size;
	int ballIndex=-1;

	public Peg(double x,double y,double size) {
		this.x=x;
		this.y=y;
		this.size=size;
	}

	public void draw(Canvas canvas){
		Graphics.draw(canvas,bitmap,(int)x,(int)y,(int)size);
	}

}

