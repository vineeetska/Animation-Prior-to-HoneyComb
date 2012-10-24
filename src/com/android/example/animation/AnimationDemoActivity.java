package com.android.example.animation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AnimationDemoActivity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */

	private Button slideLeft, slideRight, slideUp, slideDown, rotate, scale, fadeIn, fadeOut, shake;
	private ImageView mImgFrameAnimation;
	private LinearLayout mLayout;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		slideLeft = (Button)findViewById(R.id.left);
		slideRight = (Button)findViewById(R.id.right);
		slideUp = (Button)findViewById(R.id.up);
		slideDown = (Button)findViewById(R.id.down);
		rotate = (Button)findViewById(R.id.rotate);
		scale = (Button)findViewById(R.id.scale);
		fadeIn = (Button)findViewById(R.id.fadeIn);
		fadeOut = (Button)findViewById(R.id.fadeOut);
		shake = (Button)findViewById(R.id.shake);

		mImgFrameAnimation = (ImageView)findViewById(R.id.frameAnimation);
		mLayout = (LinearLayout)findViewById(R.id.rootLayout);

		mImgFrameAnimation.setBackgroundResource(R.drawable.frame_by_frame_animation);

		slideLeft.setOnClickListener(this);
		slideRight.setOnClickListener(this);
		slideUp.setOnClickListener(this);
		slideDown.setOnClickListener(this);
		rotate.setOnClickListener(this);
		scale.setOnClickListener(this);
		fadeIn.setOnClickListener(this);
		fadeOut.setOnClickListener(this);
		shake.setOnClickListener(this);


		/*
		 * NOTE: It's not possible to start the animation during the onCreate.
		 */
	}

	@Override
	/**
	 * This method is called whenever the Activity becomes visible or invisible to the user.
	 * During this method call its possible to start the animation.
	 */
	public void onWindowFocusChanged (boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		// Get the background, which has been compiled to an AnimationDrawable object.
		AnimationDrawable frameAnimation = (AnimationDrawable) mImgFrameAnimation.getBackground();

		if(hasFocus) {
			// Start the animation (looped playback by default).
			frameAnimation.start();
		} else {
			frameAnimation.stop();
		}
	}

	public void onClick(View v) {
		Animation animation = null;

		switch(v.getId()){
		case R.id.left:
			animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_left);
			slideLeft.startAnimation(animation);
			break;
		case R.id.right:
			animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_right);
			slideRight.startAnimation(animation);
			break;
		case R.id.up:
			animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
			mLayout.startAnimation(animation);
			break;
		case R.id.down:
			animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
			mLayout.startAnimation(animation);
			break;
		case R.id.rotate:
			animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_360);
			rotate.startAnimation(animation);
			break;
		case R.id.scale:
			animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_twice);
			scale.startAnimation(animation);
			break;
		case R.id.fadeIn:
			animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
			fadeIn.startAnimation(animation);
			break;
		case R.id.fadeOut:
			animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
			fadeOut.startAnimation(animation);
			break;
		case R.id.shake:
			animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
			shake.startAnimation(animation);
			break;
		}
	}
}