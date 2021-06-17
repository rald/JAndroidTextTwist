package edu.hogwarts.siesta.texttwist;

import android.app.Activity;
import android.os.Bundle;

public class TextTwist extends Activity {

  Animation animation;

  @Override
  public void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    animation=new Animation(this);
    setContentView(animation);
  }

}
