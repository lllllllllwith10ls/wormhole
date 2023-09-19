import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Demo2 extends World {

    public Cursor cursor;
    public Random rand;

    public Demo2() {
	super();

	// a blue plane
	Space s1 = new Space(this, Color.blue.darker());

	// the player's cursor, at the origin
	cursor = new Cursor(s1, Mo.Translate(1.5,1.5), null);

	rand = new Random();
	
//	Space s2 = new Space(this, new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
//	new WormholeGridCore(s1, null, Mo.Translate(0,0), 1, this).join(new WormholeGridCore(s2, null, Mo.IDENTITY, 1, this));
//	
	for(int i = -15; i <= 15; i++)
	{
		for(int j = -15; j <= 15; j++)
		{
			Space s2 = new Space(this, new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
			new Wormhole(s1, null, Mo.Translate(i*5,j*5), 1).join(new Wormhole(s2, null, Mo.IDENTITY, 1));
		}
	}
	
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    Demo2 world = new Demo2();

		    Viewport viewport = new Viewport(800, 640, world);
		    world.cursor.attach(viewport);
                    viewport.camera = new Camera(world.cursor, Mo.Scale(50).comp(Mo.Translate(-1.5,0)));

                    JFrame f = new JFrame("Wormhole");
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f.add(viewport);
                    f.pack();
                    f.setResizable(false);
                    f.setVisible(true);

                    viewport.start();
                }
            });
    }

}