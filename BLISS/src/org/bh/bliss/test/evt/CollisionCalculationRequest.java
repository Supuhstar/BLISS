package org.bh.bliss.test.evt;

import org.bh.bliss.evt.BLISSEvent;
import org.bh.bliss.test.Collider;

/**
 * CollisionCalculationRequest, made for BLISS, is copyright Blue Husky Programming ©2013 CC 3.0 BY-SA<HR/>
 * 
 * @author Supuhstar of Blue Husky Programming
 * @version 1.0.0
 * @since 2013-08-01
 */
public class CollisionCalculationRequest extends BLISSEvent
{
	public final Collider A, B;
	public CollisionCalculationRequest(Object source, Collider a, Collider b)
	{
		super(source);
		A = a;
		B = b;
	}
	
}
