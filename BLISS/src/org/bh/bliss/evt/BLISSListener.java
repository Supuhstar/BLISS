package org.bh.bliss.evt;

import java.util.EventListener;

public interface BLISSListener extends EventListener
{
	/**
	 * Returns {@code true} iff this listener responds to the given event generator
	 * @param eg the event generator querying this listener for responsiveness
	 * @return {@code true} iff this listener responds to the given event generator
	 */
	public boolean listensFor(Object eg);
	
	public void postEvent(BLISSEvent evt);
}
