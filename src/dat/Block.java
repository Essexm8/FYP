package dat;

import org.newdawn.slick.opengl.Texture;
import static employees.Artiste.*;
public class Block
{ 
    private float x, y, width, height;
    private Texture texture;
    private BlockType type;
    
    // This class deals with the bounds of each Block object, and prepares any variables it may have
   
    public Block(float x, float y, float width, float height, BlockType type) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.type = type;
            this.texture = QuickLoad(type.textureName);
    }
   
    public void Draw() {
            DrawBlockTex(texture, x, y, width, height);
    }

    public float getX() {
            return x;
    }
   
    public int getXPos() {
            return (int) x / BlockGrid.BLOCK_SIZE;
    }
   
    public int getYPos() {
            return (int) y / BlockGrid.BLOCK_SIZE;
    }

    public void setX(float x) {
            this.x = x;
    }

    public float getY() {
            return y;
    }

    public void setY(float y) {
            this.y = y;
    }

    public float getWidth() {
            return width;
    }

    public void setWidth(float width) {
            this.width = width;
    }

    public float getHeight() {
            return height;
    }

    public void setHeight(float height) {
            this.height = height;
    }

    public Texture getTexture() {
            return texture;
    }

    public void setTexture(Texture texture) {
            this.texture = texture;
    }

    public BlockType getType() {
            return type;
    }

    public void setType(BlockType type) {
            this.type = type;
    }
   
   
   
}
