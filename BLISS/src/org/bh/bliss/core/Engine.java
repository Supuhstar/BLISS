package org.bh.bliss.core;

import org.bh.bliss.core.DataTable;
import bht.tools.util.ArrayPP;
import bht.tools.util.BHTimer;
import bht.tools.util.SortedArrayPP;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.InputStream;
import org.bh.bliss.evt.InputListener;
import org.bh.bliss.evt.TickEvent;

/**
 * Engine, made for BLISS, is copyright Blue Husky Programming ©2013 CC 3.0 BY-SA<HR/>
 *
 * @author Supuhstar of Blue Husky Programming
 * @version 1.0.0
 * @since 2013-07-30
 */
public class Engine
{
	private ArrayPP<InputListener> inputs;
	private ArrayPP<DataTable> dataTables;
	private BHTimer ticker;
	private ControlCenter controlCenter;
	private long tickCounter = 0;

	public Engine()
	{
		controlCenter = new ControlCenter();
		inputs = new ArrayPP<>();
		dataTables = new ArrayPP<>();
		ticker = new BHTimer(new Runnable()
		{
			@Override
			public void run()
			{
				TickEvent tickEvent = new TickEvent(ticker, tickCounter++, System.currentTimeMillis());
				controlCenter.postEvent(tickEvent);
			}
		}, 30D);
	}

	public Engine attachInputListener(InputListener input)
	{
		if (input == null)
			throw new NullPointerException("Input cannot be null");
		inputs.add(input);
		return this;
	}

	/**
	 * Alerts all attached input listeners of the given input event and returns a list of the alerted listeners
	 * @param event the event of which to alert all the input listeners
	 * @return all alerted listeners
	 */
	public InputListener[] fireInputEvent(InputEvent event)
	{
		ArrayPP<InputListener> ret = new ArrayPP<>();
		for (InputListener inputListener : inputs)
			if (inputListener != null && inputListener.listensFor(event))
			{
				ret.add(inputListener);
				inputListener.inputPerformed(event);
			}
		return ret.t;
	}

	public Engine attachDataTable(DataTable dataTable)
	{
		dataTables.add(dataTable);
		return this;
	}

	public Engine start()
	{
		ticker.start();
		return this;
	}

	public Engine pause()
	{
		ticker.stop();
		return this;
	}

	public ControlCenter getControlCenter()
	{
		return controlCenter;
	}

	public Engine setControlCenter(ControlCenter newControlCenter)
	{
		controlCenter = newControlCenter;
		return this;
	}
        
        public Engine setUpdateSpeed(int millisBetweenUpdates)
        {
            ticker.setDelay(millisBetweenUpdates);
            return this;
        }
        
        public Engine setUpdateSpeed(float framesPerSecond)
        {
            ticker.setDelay(framesPerSecond);
            return this;
        }
}
