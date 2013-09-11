package org.bh.bliss.test.evt;

import bht.tools.util.math.Vector2D;
import org.bh.bliss.evt.BLISSEvent;
import org.bh.bliss.test.Collider;

/**
 * CollisionEvent, made for BLISS, is copyright Blue Husky Programming ©2013 CC 3.0 BY-SA<HR/>
 *
 * @author Supuhstar of Blue Husky Programming
 * @version 1.0.0
 * @since 2013-08-01
 */
public class CollisionEvent extends BLISSEvent
{
	public final Collider COLLIDER_A, COLLIDER_B;

	public CollisionEvent(Object source, Collider a, Collider b)
	{
		super(source);
		COLLIDER_A = a;
		COLLIDER_B = b;
	}

	public Vector2D getDirectionToGo()
	{
		return Vector2D.add(COLLIDER_A.getMovement(), COLLIDER_B.getMovement());
	}
}
