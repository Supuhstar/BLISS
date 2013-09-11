package org.bh.bliss.test;

import org.bh.bliss.core.Engine;

/**
 * Test, made for BLISS, is copyright Blue Husky Programming ©2013<HR/>
 * Tests <B>B</B>lue Husky's <B>Lis</B>tener-based <B>S</B>imulator (<B>BLISS</B>)
 *
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * @since 2013-07-30
 */
public class Test
{
	public static final CharSequence TITLE = "BLISS", VERSION = "0.0.0\u03BB";//U+03BB = lambda

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args)
	{
		Engine testEngine = new Engine().setControlCenter(new TestControlCenter());
		TestFrame frame = new TestFrame(testEngine);
		frame.setVisible(true);
		testEngine.getControlCenter().registerGameObject(frame);
	}
}
