package org.jdesktop.swing.animation.timing.demos.ch15;

import java.applet.AudioClip;

import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.KeyFrames;
import org.jdesktop.core.animation.timing.TimingTarget;
import org.jdesktop.swing.animation.demos.DemoResources;

/**
 * Simple utility class used to load and play sound effects for MultiStepRace.
 * 
 * @author Chet Haase
 */
public class SoundEffects implements TimingTarget {

  AudioClip f_drivingClip;
  AudioClip f_turningClip;
  KeyFrames<Integer> f_keyFrames;

  /** Creates a new instance of SoundEffects */
  public SoundEffects(KeyFrames<Integer> keyFrames) {
    f_keyFrames = keyFrames;
    try {
      f_drivingClip = java.applet.Applet.newAudioClip(DemoResources.getResource(DemoResources.VROOM));
      f_turningClip = java.applet.Applet.newAudioClip(DemoResources.getResource(DemoResources.DRIFT));
    } catch (Exception e) {
      System.out.println("Problem loading track/car images: " + e);
    }
  }

  /**
   * Plays the driving clip
   */
  public void drive() {
    if (f_drivingClip != null) {
      f_drivingClip.loop();
    }
  }

  /**
   * Stops current clips
   */
  public void stop() {
    if (f_drivingClip != null) {
      f_drivingClip.stop();
    }
    if (f_turningClip != null) {
      f_turningClip.stop();
    }
  }

  /**
   * Plays the turning clip
   */
  public void turn() {
    if (f_turningClip != null) {
      f_turningClip.play();
    }
  }

  // TimingTarget implementation

  boolean pastFirstTurn = false;
  boolean pastSecondTurn = false;
  boolean pastThirdTurn = false;
  boolean pastFourthTurn = false;

  @Override
  public void begin(Animator source) {
    drive();
    pastFirstTurn = false;
    pastSecondTurn = false;
    pastThirdTurn = false;
    pastFourthTurn = false;
  }

  @Override
  public void end(Animator source) {
    stop();
  }

  @Override
  public void repeat(Animator source) {
    pastFirstTurn = false;
    pastSecondTurn = false;
    pastThirdTurn = false;
    pastFourthTurn = false;
  }

  /**
   * This method figures out when the car hits one of the turns and plays the
   * turn clip appropriately
   */
  @Override
  public void timingEvent(Animator source, double fraction) {
    if (!pastFirstTurn) {
      if (f_keyFrames.getFrameIndexAt(fraction) == 1) {
        turn();
        pastFirstTurn = true;
      }
    } else if (!pastSecondTurn) {
      if (f_keyFrames.getFrameIndexAt(fraction) == 3) {
        turn();
        pastSecondTurn = true;
      }
    } else if (!pastThirdTurn) {
      if (f_keyFrames.getFrameIndexAt(fraction) == 5) {
        turn();
        pastThirdTurn = true;
      }
    } else if (!pastFourthTurn) {
      if (f_keyFrames.getFrameIndexAt(fraction) == 7) {
        turn();
        pastFourthTurn = true;
      }
    }
  }
}
