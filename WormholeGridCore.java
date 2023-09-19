import java.awt.Color;

public class WormholeGridCore extends Wormhole {
	Demo2 world;
	public boolean generated = false;
    public WormholeGridCore(Space space, BGDomain parent, Mo position, double radius, Demo2 world) {
    	super(space,parent,position,radius);
    	this.world = world;
    }
	public void onDraw() {
	    if(!generated)
    	{
	    	generate();
	    	generated = true;
    	}
    }
	public void generate() {
	    for(int i = 0; i < 4; i++)
    	{
	    	Space s = new Space(world, new Color(world.rand.nextInt(256),world.rand.nextInt(256),world.rand.nextInt(256)));
	    	new WormholeGridAxis(space, null, this.position.comp(Mo.Rotate(Math.PI/2*i)).comp(Mo.Translate(5,0)), 1, world).join(new WormholeGridCore(s, null, Mo.IDENTITY, 1, world));
    	}
	    generated = true;
	    System.out.println("a" + this.space.wormholes.size());
	}
}
