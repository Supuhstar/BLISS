package org.bh.bliss.test;

import bht.tools.util.ArrayPP;
import bht.tools.util.math.Vector2D;
import java.awt.Dialog.ModalityType;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.bh.bliss.core.Engine;
import org.bh.bliss.core.GameObject;
import org.bh.bliss.evt.BLISSEvent;
import org.bh.bliss.evt.TickEvent;
import org.bh.bliss.test.sim.MotionEvent;
import org.bh.bliss.test.sim.MotionListener;
import static org.bh.bliss.test.Test.TITLE;
import static org.bh.bliss.test.Test.VERSION;
import org.bh.bliss.test.evt.CollisionCalculationRequest;
import org.bh.bliss.test.evt.CollisionEvent;
import org.bh.bliss.test.evt.CollisionListener;

/**
 * TestFrame, made for BLISS, is copyright Blue Husky Programming ©2013 CC 3.0 BY-SA<HR/>
 *
 * @author Supuhstar of Blue Husky Programming
 * @version 1.0.0
 * @since 2013-08-01
 */
public class TestFrame extends JFrame implements GameObject
{
	private Engine engine;
	private ArrayPP<ColliderWindow> colliderWindows = new ArrayPP<>();
	private static final Rectangle SCREEN_BOUNDS = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();

	public TestFrame(Engine initEngine)
	{
		super(TITLE + " " + VERSION + " test");
		engine = initEngine;
		initGUI();
	}
	JButton startButton;

	private void initGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new GridBagLayout());

		colliderWindows.add(new ColliderWindow(), new ColliderWindow());
		for (final ColliderWindow w : colliderWindows)
		{
			w.setModal(true);
			w.setModalityType(ModalityType.MODELESS);
			w.addCollisionListener(new CollisionListener() {

				@Override
				public boolean listensFor(Object eg)
				{
					return eg instanceof CollisionEvent;
				}

				@Override
				public void postEvent(BLISSEvent evt)
				{
					if (evt instanceof CollisionEvent)
					{
						engine.getControlCenter().postEvent(new CollisionCalculationRequest(evt, ((CollisionEvent)evt).COLLIDER_A, ((CollisionEvent)evt).COLLIDER_B));
					}
				}
			});
			
//			engine.getControlCenter().
			/*w.addMotionListener(new MotionListener()
			 {
			 @Override
			 public boolean listensFor(Object eg)
			 {
			 return eg instanceof MotionEvent;
			 }

			 @Override
			 public void postEvent(BLISSEvent evt)
			 {
			 if (evt instanceof MotionEvent)
			 {
			 for (ColliderWindow cw : colliderWindows)
			 {
			 if (cw != w)
			 {
			 if (cw.getMovement().)
			 }
			 }
			 }
			 }
			 });*/
		}

		startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				startButton.setText("Restart");
				engine.start();
				Random rand = new Random();
				for (ColliderWindow w : colliderWindows)
				{
					w.setSize(100, 100);
					w.setLocation(rand.nextInt(SCREEN_BOUNDS.width - w.getWidth()), rand.nextInt(SCREEN_BOUNDS.height - w.getHeight()));
					w.getMovement().setRelativeEnd(new java.awt.geom.Point2D.Double(1 - rand.nextInt(2), 1 - rand.nextInt(2)));
					w.setVisible(true);
				}
			}
		});

		add(startButton);

		pack();
	}

	@Override
	public GameObject[] getChildren()
	{
		return colliderWindows.t;
	}

	@Override
	public boolean listensFor(Object eg)
	{
		return eg instanceof TickEvent;
	}

	@Override
	public void postEvent(BLISSEvent evt)
	{
		if (evt instanceof TickEvent)
		{
			Collider sbc = new Collider()
			{
				@Override
				public Hitbox getHitbox()
				{
					return new Hitbox(SCREEN_BOUNDS, true);
				}

				@Override
				public Collider setHitbox(Rectangle newHitbox)
				{
					return this;
				}

				@Override
				public Vector2D getMovement()
				{
					return new Vector2D();
				}

				@Override
				public Collider setMovement(Vector2D newMovement)
				{
					return this;
				}

				@Override
				public Collider addCollisionListener(CollisionListener cl)
				{
					return this;
				}

				@Override
				public Collider removeCollisionListener(CollisionListener cl)
				{
					return this;
				}
			};
			for (ColliderWindow cw : colliderWindows) // Ask control center to handle collisions with the edges of the screen
				engine.getControlCenter().postEvent(new CollisionCalculationRequest(evt, cw, sbc));

			for (int i1 = 0, l = colliderWindows.length() - 1; i1 < l; i1++) // Ask control center to handle collisions with other windows
			{
				Collider cw1 = colliderWindows.get(i1);
				for (int i2 = i1 + 1; i2 <= l; i2++)
					engine.getControlCenter().postEvent(new CollisionCalculationRequest(evt, cw1, colliderWindows.get(i2)));
			}

			for (GameObject go : getChildren())
				go.postEvent(evt);

			/*
			 for (ColliderWindow cw : colliderWindows)
			 {
			 Point2D cwme = cw.getMovement().getRelativeEnd();
			 cw.setLocation((int) (cw.getX() + cwme.getX() + 0.5), (int) (cw.getY() + cwme.getY() + 0.5));
			 }
			 for (int i1=0, l=colliderWindows.length() - 1; i1 < l; i1++)
			 {
			 Collider cw1 = colliderWindows.get(i1);
			 for (int i2 = i1 + 1; i2 < l; i2++)
			 {
			 Collider cw2 = colliderWindows.get(i2);
			 if (cw1.getHitbox().intersects(cw2.getHitbox()))
			 {
			 Vector2D cw1om = cw1.getMovement(), cw2om = cw2.getMovement();
			 cw1.setMovement(Vector2D.add(cw1om, cw2om));
			 cw2.setMovement(Vector2D.add(cw2om, cw1om));
			 }
			 }

			 if (!screenBounds.contains(cw1.getHitbox()))
			 {
			 Point2D cw1mre = cw1.getMovement().getRelativeEnd();
			 Rectangle cw1h = cw1.getHitbox();
			 double cw1hx = cw1h.getX(), cw1hy = cw1h.getY();
			 if(cw1hx < 0 || cw1hx > screenBounds.getWidth())
			 cw1mre.setLocation(-cw1mre.getX(), cw1mre.getY());
			 if(cw1hy < 0 || cw1hy > screenBounds.getHeight())
			 cw1mre.setLocation(cw1mre.getX(), -cw1mre.getY());
			 }
			 }*/
		}
	}
}
