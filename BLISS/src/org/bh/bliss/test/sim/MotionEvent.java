package org.bh.bliss.test.sim;

import bht.tools.util.math.Vector2D;
import org.bh.bliss.evt.BLISSEvent;

/**
 * MotionEvent, made for BLISS, is copyright Blue Husky Programming ©2013 CC 3.0 BY-SA<HR/>
 * 
 * @author Supuhstar of Blue Husky Programming
 * @version 1.0.0
 * @since 2013-08-01
 */
public class MotionEvent extends BLISSEvent
{
	public final Vector2D OLD_MOTION, NEW_MOTION;

	public MotionEvent(Object source, Vector2D initOldMotion, Vector2D initNewMotion)
	{
		super(source);
		OLD_MOTION = initOldMotion;
		NEW_MOTION = initNewMotion;
	}
}
