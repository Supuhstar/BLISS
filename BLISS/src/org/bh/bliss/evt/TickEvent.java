package org.bh.bliss.evt;

import java.util.EventObject;

/**
 * TickEvent, made for BLISS, is copyright Blue Husky Programming ©2013 CC 3.0 BY-SA<HR/>
 * 
 * @author Supuhstar of Blue Husky Programming
 * @version 1.0.0
 * @since 2013-07-31
 */
public class TickEvent extends BLISSEvent
{
	public final long TICK_NUM, TICK_TIME_IN_MILLIS;
	public TickEvent(Object source, long tickNum, long tickTimeInMilliseconds)
	{
		super(source);
		TICK_NUM = tickNum;
		TICK_TIME_IN_MILLIS = tickTimeInMilliseconds;
	}
}
