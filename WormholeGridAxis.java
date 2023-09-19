import java.awt.Color;

public class WormholeGridAxis extends WormholeGridCore {
    public WormholeGridAxis(Space space, BGDomain parent, Mo position, double radius, Demo2 world) {
    	super(space,parent,position,radius,world);
    }
    @Override
	public void generate() {
    	Space s = new Space(world, new Color(world.rand.nextInt(256),world.rand.nextInt(256),world.rand.nextInt(256)));
	    new WormholeGridAxis(space, null, this.position.comp(Mo.Translate(5,0)), 1, world).join(new WormholeGridCore(s, null, Mo.IDENTITY, 1, world));
	    s = new Space(world, new Color(world.rand.nextInt(256),world.rand.nextInt(256),world.rand.nextInt(256)));
	    new WormholeGrid(space, null, this.position.comp(Mo.Rotate(Math.PI/2)).comp(Mo.Translate(5,0)), 1, world).join(new WormholeGridCore(s, null, Mo.IDENTITY, 1, world));
	    generated = true;
    }
}
