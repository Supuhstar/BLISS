package org.bh.bliss.test;

import bht.tools.util.math.Vector2D;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import org.bh.bliss.test.evt.CollisionListener;

/**
 * Collider, made for BLISS, is copyright Blue Husky Programming ©2013 CC 3.0 BY-SA<HR/>
 *
 * @author Supuhstar of Blue Husky Programming
 * @version 1.0.0
 * @since 2013-08-01
 */
public interface Collider
{
//		public final Rectangle hitbox;
//		public final bht.tools.util.math.Vector2D movement;
//		public Collider(Rectangle hitbox, Vector2D movement)
//		{
//			this.hitbox = hitbox;
//			this.movement = movement;
//		}
	public Hitbox getHitbox();

	public Collider setHitbox(Rectangle newHitbox);

	public Vector2D getMovement();

	public Collider setMovement(Vector2D newMovement);

	public static class Hitbox extends Rectangle
	{
		public boolean inverted;
		public Hitbox(Rectangle r)
		{
			this(r, false);
		}
		public Hitbox(Rectangle r, boolean initInverted)
		{
			super(r);
			inverted = initInverted;
		}
	}
	
	public Collider addCollisionListener(CollisionListener cl);
	public Collider removeCollisionListener(CollisionListener cl);
}
