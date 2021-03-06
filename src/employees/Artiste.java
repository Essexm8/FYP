package employees;

import org.lwjgl.LWJGLException; 
import org.lwjgl.opengl.Display; 
import org.lwjgl.opengl.DisplayMode; 
import org.newdawn.slick.opengl.Texture; 
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader; 
import static org.lwjgl.opengl.GL11.*; 
import java.io.IOException; 
import java.io.InputStream; 
//This for the most part allows the data and graphis to be separate objects, the system itself is 
public class Artiste 
{
	public static final int WIDTH = 900, HEIGHT = 900;
	
	
	public static void BeginSim() { Display.setTitle("Traffic Simulation"); 
	try { Display.setDisplayMode(new DisplayMode(HEIGHT, WIDTH)); 
	Display.create();
	} catch (LWJGLException e) { e.printStackTrace(); } 
	
	//This is used with helping to deal with the screen setup
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
	glMatrixMode(GL_MODELVIEW);
	glEnable(GL_TEXTURE_2D);
	
	//These 2 allow us to view the car texture with the block behind it also shown, which removes any whitespace
	glEnable(GL_BLEND);
	glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}
	
	public static boolean CollisionDetection(float x1, float y1, float w1, float h1,  float x2, float y2, float w2, float h2) {
		if(x1 + w1 > x2 && x1 < x2 + w2 && y1 + h1 > y2 && y1 < y2 + h2) {
			return true;
		}
		return false;
	}
	public static void DrawBlock(float x, float y, float width, float height) 
	{ 
		glBegin(GL_QUADS); glVertex2f(x, y); //top-left 
		glVertex2f(x + width, y); //top-right 
		glVertex2f(x + width, y + height); //bottom-right 
		glVertex2f(x, y + height); //bottom-left 
		glEnd(); }
	
	//Allows for the drawing of rectangular objects with textures
	public static void DrawBlockTex(Texture tex, float x, float y, float width, float height)
	{ 
		tex.bind();
		glTranslatef(x, y, 0); 
		glBegin(GL_QUADS); 
		glTexCoord2f(0, 0); 
		glVertex2f(0, 0); 
		glTexCoord2f(1, 0); 
		glVertex2f(width, 0); 
		glTexCoord2f(1, 1); 
		glVertex2f(width, height); 
		glTexCoord2f(0, 1); 
		glVertex2f(0, height); glEnd(); glLoadIdentity(); 
		} 
	//Allows textures to be rotated
	public static void DrawRotateCar(Texture tex, float x, float y, float width, float height, float angle) {
		tex.bind();
		glTranslatef(x + width / 2, y + height / 2, 0);
		glRotatef(angle, 0, 0, 1);
		glTranslatef(- width / 2, - height / 2, 0);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		glTexCoord2f(1, 0);
		glVertex2f(width, 0);
		glTexCoord2f(1, 1);
		glVertex2f(width, height);
		glTexCoord2f(0, 1);
		glVertex2f(0, height);
		glEnd();
		glLoadIdentity();
	}
	
	//sets up for loading textures
	public static Texture LoadTexture(String path, String fileType) 
	{ 
		Texture tex = null; 
		InputStream in = ResourceLoader.getResourceAsStream(path); 
		try { tex = TextureLoader.getTexture(fileType, in); 
		} catch (IOException e) 
		{ e.printStackTrace(); } 
		return tex; } 
	
	//Allows for images of type PNG to be easily loaded into the simulation
	public static Texture QuickLoad(String name) 
	{ 
		Texture tex = null; tex = LoadTexture("res/" + name + ".png", "PNG"); return tex; 
		} 
	
	
	}
