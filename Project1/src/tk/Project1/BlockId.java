package src.tk.Project1;

public enum BlockId
{
	AIR (0),
	DIRT (1),
	STONE(2),
	COBBLESTONE(3),
	SAND(4),
	SANDSTONE(5),
	WOOD(6),
	PLANK(7),
	COALORE(8),
	IRONORE(9),
	GOLDORE(10),
	TINORE(11),
	COPPERORE(12),
	DIAMONDORE(13),
	GRASS(14),
	TITANIUMORE(15),
	IRON(16),
	GOLD(17),
	TIN(18),
	COPPER(19),
	DIAMOND(20),
	
	;private final int id;
	
	public BlockId(int id){
		this.id=id;
	}
}
