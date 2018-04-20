package dat;

public enum BlockType {
		
	Ground("GroundBlock", true), Road("RoadBlock", false), Intersection("Intersection1", false), NULL("RoadBlock", false), Building("Building", false), Building2("Building2", false);
	
	String textureName;
	boolean buildable;
	BlockType(String textureName, boolean buildable) {
		this.textureName = textureName;
		this.buildable = buildable;}
	}