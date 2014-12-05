package com.ade.cityville;

import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

import android.content.Intent;

public class ImageButton extends PApplet {

/**
 * Image button. 
 * 
 * Loading images and using them to create a button. 
 */
 

ImageButtons button;
ImageButtons button2;
PImage icon;  // Declare variable "a" of type PImage

public void setup()
{
 // Set the background color here in rgb
  background(0,75,255);
  /***icon****/
  icon = loadImage("ic_launcher.png");  // Load the image into the program  
  //noLoop();  // Makes draw() only run once
  /***end icon***/
  // Define and create image button
  PImage b = loadImage("themes.png");
  PImage r = loadImage("themes-roll.png");
  PImage d = loadImage("themes-down.png");
  int x = width/2 - b.width/2;
  int y = height/2 - b.height/2; 
  int w = b.width;
  int h = b.height;
  button = new ImageButtons(x, y, w, h, b, r, d);
  // Define and create image button 2
  PImage b2 = loadImage("cityville.png");
  PImage r2 = loadImage("cityville-roll.png");
  PImage d2 = loadImage("cityville-down.png");
  int x2 = x;
  int y2 = y+h+5; 
  int w2 = b2.width;
  int h2 = b2.height;
  button2 = new ImageButtons(x2, y2, w2, h2, b2, r2, d2);
}

public void draw()
{
  /***icon***/
  image(icon, width/2-((height/4)/2), 5, height/4, height/4);
  /***end icon***/
  
  if(button.update()){
    Intent intent = new Intent(this, ThemesActivity.class);
	startActivity(intent);
  }
  button.display();
  if(button2.update()){
    Intent intent = new Intent(this, InitializationActivity.class);
	startActivity(intent);
  }
  button2.display();
}

class Button
{
  int x, y;
  int w, h;
  int basecolor, highlightcolor;
  int currentcolor;
  boolean over = false;
  boolean pressed = false;   
  
  public void pressed() {
    if(over && mousePressed) {
      pressed = true;
    } else {
      pressed = false;
    }    
  }
  
  public boolean overRect(int x, int y, int width, int height) {
  if (mouseX >= x && mouseX <= x+width && 
      mouseY >= y && mouseY <= y+height) {
    return true;
  } else {
    return false;
  }
}
}

class ImageButtons extends Button 
{
  PImage base;
  PImage roll;
  PImage down;
  PImage currentimage;

  ImageButtons(int ix, int iy, int iw, int ih, PImage ibase, PImage iroll, PImage idown) 
  {
    x = ix;
    y = iy;
    w = iw;
    h = ih;
    base = ibase;
    roll = iroll;
    down = idown;
    currentimage = base;
  }
  
  public boolean update() 
  {
    boolean result = false;
    over();
    pressed();
    if(pressed) {
      currentimage = down;
      result=true;
    } else if (over){
      currentimage = roll;
    } else {
      currentimage = base;
    }
    return result;
  }
  
  public void over() 
  {
    if( overRect(x, y, w, h) ) {
      over = true;
    } else {
      over = false;
    }
  }
  
  public void display() 
  {
    image(currentimage, x, y);
  }
}





  public int sketchWidth() { return displayWidth; }
  public int sketchHeight() { return displayHeight; }
}
