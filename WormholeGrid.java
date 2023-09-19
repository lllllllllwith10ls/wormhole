import java.awt.Color;

public class WormholeGrid extends WormholeGridCore {
    public WormholeGrid(Space space, BGDomain parent, Mo position, double radius, Demo2 world) {
    	super(space,parent,position,radius,world);
    }
    @Override
	public void generate() {
    	Space s = new Space(world, new Color(world.rand.nextInt(256),world.rand.nextInt(256),world.rand.nextInt(256)));
	    new WormholeGrid(space, null, this.position.comp(Mo.Translate(5,0)), 1, world).join(new WormholeGridCore(s, null, Mo.IDENTITY, 1, world));
	    generated = true;
	    System.out.println("c" + this.space.wormholes.size() + " " + this.position.comp(Mo.Translate(5,0)).b.norm());
    }
}
