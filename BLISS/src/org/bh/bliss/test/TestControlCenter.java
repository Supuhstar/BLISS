package org.bh.bliss.test;

import bht.tools.util.math.Vector2D;
import java.awt.geom.Point2D;
import java.util.logging.Logger;
import org.bh.bliss.core.ControlCenter;
import org.bh.bliss.evt.BLISSEvent;
import org.bh.bliss.test.Collider.Hitbox;
import org.bh.bliss.test.evt.CollisionCalculationRequest;

/**
 * TestControlCenter, made for BLISS, is copyright Blue Husky Programming ©2013 CC 3.0 BY-SA<HR/>
 *
 * @author Supuhstar of Blue Husky Programming
 * @version 1.0.0
 * @since 2013-08-01
 */
public class TestControlCenter extends ControlCenter
{
	@Override
	public void postEvent(BLISSEvent evt)
	{
		super.postEvent(evt);
		if (evt instanceof CollisionCalculationRequest)
		{
			Hitbox ccrAh = ((CollisionCalculationRequest) evt).A.getHitbox(), ccrBh = ((CollisionCalculationRequest) evt).B.getHitbox();
			if (ccrAh.inverted && ccrBh.inverted)
			{
				Logger.getLogger(TestControlCenter.class.getCanonicalName()).warning("Can't comprehend the collision of 2 inverted hitboxes");
				return;
			}
			else
			{
				if (ccrBh.inverted)//so we can assume B is never inverted
				{
					postEvent(new CollisionCalculationRequest(evt, ((CollisionCalculationRequest) evt).B, ((CollisionCalculationRequest) evt).A));
					return;
				}
				Vector2D ccrAm = ((CollisionCalculationRequest) evt).A.getMovement(), ccrBm = ((CollisionCalculationRequest) evt).B.getMovement();
				Point2D ccrAmre = ccrAm.getRelativeEnd(), ccrBmre = ccrBm.getRelativeEnd();
				if (ccrAh.inverted)
				{
					if (!ccrAh.contains(ccrBh))//if the interior hitbox (B) is at all outside the exterior hitbox (A)
					{
						if (ccrBh.getX() < ccrAh.getX() && ccrBmre.getX() < 0//if the left edge of the interior hitbox is outside the left edge of the exterior hitbox and the interior hitbox isn't already heading back in
							|| ccrBh.getX() + ccrBh.getWidth() > ccrAh.getWidth() && ccrBmre.getX() > 0)//if the right edge of the interior hitbox is outside the right edge of the exterior hitbox and the interior hitbox isn't already heading back in
							((CollisionCalculationRequest) evt).B.getMovement().setRelativeEnd(new java.awt.geom.Point2D.Double(ccrAmre.getX() - ccrBmre.getX(), ccrBmre.getY()));
						if (ccrBh.getY() < ccrAh.getY() && ccrBmre.getY() < 0//if the top edge of the interior hitbox is outside the top edge of the exterior hitbox and the interior hitbox isn't already heading back in
							|| ccrBh.getY() + ccrBh.getHeight() > ccrAh.getHeight() && ccrBmre.getY() > 0)//if the bottom edge of the interior hitbox is outside the bottom edge of the exterior hitbox and the interior hitbox isn't already heading back in
							((CollisionCalculationRequest) evt).B.getMovement().setRelativeEnd(new java.awt.geom.Point2D.Double(ccrBmre.getX(), ccrAmre.getY() - ccrBmre.getY()));
					}
				}
				else if (ccrAh.intersects(ccrBh) //						&& (ccrAh.getX())
						)
				{
					((CollisionCalculationRequest) evt).A.getMovement().setRelativeEnd(new java.awt.geom.Point2D.Double(-ccrAmre.getX(), -ccrAmre.getY()));
					((CollisionCalculationRequest) evt).B.getMovement().setRelativeEnd(new java.awt.geom.Point2D.Double(-ccrBmre.getX(), -ccrBmre.getY()));
				}
			}
		}
		
		
	}
}
