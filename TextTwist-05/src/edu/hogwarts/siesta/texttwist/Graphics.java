package edu.hogwarts.siesta.texttwist;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

class Graphics {

	static void print(Canvas canvas,Bitmap font,int w,int h,String text,int x,int y,int size) {
		int cx=x,cy=y;
		for(int i=0;i<text.length();i++) {
			int sx0=(text.charAt(i)%16)*w;
			int sy0=(text.charAt(i)/16)*h;
			int sx1=sx0+w;
			int sy1=sy0+h;
			int dx0=cx;
			int dy0=cy;
			int dx1=dx0+w*size;
			int dy1=dy0+h*size;
			Rect src=new Rect(sx0,sy0,sx1,sy1);
			Rect dst=new Rect(dx0,dy0,dx1,dy1);
			Paint paint=new Paint();
			paint.setFilterBitmap(false);
			canvas.drawBitmap(font,src,dst,paint);

			cx+=w*size;

			if(cx+w*size>canvas.getWidth()) {
				cx=0;
				cy+=h*size;
			}

		}
	}

	static void draw(Canvas canvas,Bitmap bitmap,int x,int y,int size) {
		int w=bitmap.getWidth();
		int h=bitmap.getHeight();
		int sx0=0;
		int sy0=0;
		int sx1=sx0+w;
		int sy1=sy0+h;
		int dx0=x;
		int dy0=y;
		int dx1=dx0+w*size;
		int dy1=dy0+h*size;
		Rect src=new Rect(sx0,sy0,sx1,sy1);
		Rect dst=new Rect(dx0,dy0,dx1,dy1);
		Paint paint=new Paint();
		paint.setFilterBitmap(false);
		canvas.drawBitmap(bitmap,src,dst,paint);
	}

	static void wave(Canvas canvas,Bitmap font,int w,int h,String text,int cx,int cy,int size,long startTime) {
		long elapsedTime=System.currentTimeMillis()-startTime;
		double pos=elapsedTime*0.125;
		for(int i=0;i<text.length();i++) {
			double posx=(pos+w*size*i)%(Animation.SCREEN_WIDTH-w*size)+cx;
			double posy=h*size+Math.sin(pos/(h*size/2)+i)*(h*size/2)+cy;
			print(canvas,font,w,h,Character.toString(text.charAt(i)),(int)posx,(int)posy,size);
		}
	}

	static boolean inrect(int x,int y,int rx,int ry,int w,int h) {
		return x>=rx && x<=rx+w && y>=ry && y<=ry+h;
	}

}
