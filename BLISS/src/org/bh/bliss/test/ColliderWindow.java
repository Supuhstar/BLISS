package org.bh.bliss.test;

import org.bh.bliss.test.evt.CollisionEvent;
import bht.tools.util.ArrayPP;
import bht.tools.util.math.Vector2D;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Point2D;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JLabel;
import org.bh.bliss.core.GameObject;
import org.bh.bliss.evt.BLISSEvent;
import org.bh.bliss.evt.TickEvent;
import org.bh.bliss.test.sim.MotionEvent;
import org.bh.bliss.test.sim.MotionListener;
import org.bh.bliss.test.sim.MovingObject;
import org.bh.bliss.test.evt.CollisionListener;

/**
 * ColliderWindow, made for BLISS, is copyright Blue Husky Programming ©2013 CC 3.0 BY-SA<HR/>
 *
 * @author Supuhstar of Blue Husky Programming
 * @version 1.0.0
 * @since 2013-08-01
 */
public class ColliderWindow extends JDialog implements GameObject, Collider, MovingObject
{
	private static int staticCounter = 0;
	
	private Vector2D movement = new Vector2D();
	private ArrayPP<MotionListener> motionListeners = new ArrayPP<>();
	private ArrayPP<CollisionListener> collisionListeners = new ArrayPP<>();

	public ColliderWindow()
	{
		staticCounter++;
		setTitle("Collider Window");
		addComponentListener(new ComponentAdapter()
		{
			@Override
			public void componentMoved(ComponentEvent e)
			{
				Vector2D oldMovement = movement.clone();
				movement = new Vector2D().setAnchor(getLocation());
				Point2D oma = oldMovement.getAnchor();
				movement.setRelativeEnd(new java.awt.Point.Double(getX() - oma.getX(), getY() - oma.getY()));
				MotionEvent me = new MotionEvent(e.getSource(), oldMovement, movement);
				for (MotionListener motionListener : motionListeners)
					if (motionListener != null)
						motionListener.postEvent(me);
			}
		});
		add(new JLabel("Collider number " + staticCounter));
		pack();
	}

	@Override
	public boolean listensFor(Object eg)
	{
		return eg instanceof CollisionEvent;
	}

	@Override
	public void postEvent(BLISSEvent evt)
	{
		if (evt != null)
			if (evt instanceof CollisionEvent)
			{
				Logger.getLogger(ColliderWindow.class.getCanonicalName()).info("Collision detected!");
				for (CollisionListener cl : collisionListeners)
				{
					
				}
//				setMovement(((CollisionEvent) evt).getDirectionToGo());
			}
			else if (evt instanceof TickEvent)
				updatePosition();
	}

	public void updatePosition()
	{
		System.out.println("Updating window " + staticCounter + "... " + System.currentTimeMillis());
		Point2D mre = movement.getRelativeEnd();
		setLocation((int) (getX() + mre.getX() + 0.5), (int) (getY() + mre.getY() + 0.5));
		movement.setAnchor(getLocation());

	}

	@Override
	public GameObject[] getChildren()
	{
		return null;
	}

	@Override
	public Hitbox getHitbox()
	{
		return new Hitbox(getBounds());
	}

	@Override
	public Collider setHitbox(Rectangle newHitbox)
	{
		setBounds(newHitbox);
		return this;
	}

	@Override
	public Vector2D getMovement()
	{
		return movement;
	}

	@Override
	public Collider setMovement(Vector2D newMovement)
	{
		movement = newMovement;
		return this;
	}

	@Override
	public MovingObject addMotionListener(MotionListener ml)
	{
		motionListeners.add(ml);
		return this;
	}

	@Override
	public MovingObject removeMotionListener(MotionListener ml)
	{
		motionListeners.remove(ml, false);
		return this;
	}

	@Override
	public Collider addCollisionListener(CollisionListener cl)
	{
		collisionListeners.add(cl);
		return this;
	}

	@Override
	public Collider removeCollisionListener(CollisionListener cl)
	{
		collisionListeners.remove(cl, false);
		return this;
	}
}
