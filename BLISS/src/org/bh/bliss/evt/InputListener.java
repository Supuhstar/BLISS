package org.bh.bliss.evt;

import java.awt.event.InputEvent;
import java.util.EventListener;

/**
 * InputListener, made for BLISS, is copyright Blue Husky Programming ©2013 CC 3.0 BY-SA<HR/>
 * 
 * @author Supuhstar of Blue Husky Programming
 * @version 1.0.0
 * @since 2013-07-31
 */
public interface InputListener extends EventListener, BLISSListener
{
	public void inputPerforming(InputEvent evt);
	public void inputPerformed(InputEvent evt);
}
