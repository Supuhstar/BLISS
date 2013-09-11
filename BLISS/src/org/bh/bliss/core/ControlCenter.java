package org.bh.bliss.core;

import bht.tools.util.ArrayPP;
import org.bh.bliss.evt.BLISSEvent;
import org.bh.bliss.evt.BLISSListener;

/**
 * ControlCenter, made for BLISS, is copyright Blue Husky Programming ©2013 CC 3.0 BY-SA<HR/>
 * 
 * @author Supuhstar of Blue Husky Programming
 * @version 1.0.0
 * @since 2013-07-30
 */
public class ControlCenter implements BLISSListener
{
	private ArrayPP<GameObject> gameObjects = new ArrayPP<>();
	
	public ControlCenter registerGameObject(GameObject go)
	{
		gameObjects.add(go);
		return this;
	}
	
	/**
	 * Deregisters the given GameObject from this ControlCenter. If there is more than one instance of the given object is registered, then only the first one is removed.
	 * @param go the GameObject to remove
	 * @return {@code this}
	 * @see ArrayPP#remove(Object, boolean)
	 */
	public ControlCenter deregisterGameObject(GameObject go)
	{
		gameObjects.remove(go, false);
		return this;
	}

	public GameObject[] getGameObjects()
	{
		return gameObjects.t;
	}

	@Override
	public boolean listensFor(Object eg)
	{
		return true;
	}

	@Override
	public void postEvent(BLISSEvent evt)
	{
		for (GameObject go : getGameObjects())
		{
			if (go != null)
				go.postEvent(evt);
		}
	}
}
