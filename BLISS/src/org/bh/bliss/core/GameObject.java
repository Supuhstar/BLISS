package org.bh.bliss.core;

import org.bh.bliss.evt.BLISSEvent;
import org.bh.bliss.evt.BLISSListener;

/**
 * GameObject, made for BLISS, is copyright Blue Husky Programming ©2013 CC 3.0 BY-SA<HR/>
 * 
 * @author Supuhstar of Blue Husky Programming
 * @version 1.0.0
 * @since 2013-07-31
 */
public interface GameObject extends BLISSListener
{
	/**
	 * Returns an array of all the child game objects within this one
	 * @return an array of all the child game objects within this one
	 */
	public GameObject[] getChildren();
}
