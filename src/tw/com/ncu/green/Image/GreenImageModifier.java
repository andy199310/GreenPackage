package tw.com.ncu.green.Image;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Arrays;

/**
 * Some useful method to modify image
 * @author Green
 *
 */
public class GreenImageModifier {
	
	/**
	 * Resize image to custom size
	 * @param originalImage	- Image which want to resize
	 * @param width - New size
	 * @param height - New size
	 * @return resized image
	 */
	public static Image resize(Image originalImage, int width, int height){
		BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = resizedImage.createGraphics();
		
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();
		
		return resizedImage;
	}
	
	/**
	 * Resize image to custom size, by percent
	 * @param originalImage	- Image which want to resize
	 * @param percent - New size by percent
	 * @return resized image
	 */
	public static Image resize(Image originalImage, double percent){
		int width = (int) (originalImage.getWidth(null) * percent/100);
		int height = (int) (originalImage.getHeight(null) * percent/100);
		
		BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = resizedImage.createGraphics();
		
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();
		
		return resizedImage;
	}
	
	/**
	 * Rotate image by degree<p>
	 * **Now can only rotate (0, 90, 180, 270)degree.
	 * @param originalImage	- Image which want to rotate
	 * @param degree - which degree want to rotate
	 * @return Rotated image
	 * @throws IllegalArgumentException - You can only rotate (0, 90, 180, 270)degree.
	 */
	public static Image rotateImage(Image originalImage, double degree){
		int width = originalImage.getWidth(null);
		int height = originalImage.getHeight(null);
		double radian = Math.toRadians(degree);
		
		int[] trans = {0, 0};
		int[] newSize = {0, 0};
		
		switch((int)degree%360){
		case 0:
			newSize[0] = width;
			newSize[1] = height;
			trans[0] = 0;
			trans[1] = 0;
			break;
		case 90:
			newSize[0] = height;
			newSize[1] = width;
			trans[0] = height;
			trans[1] = 0;
			break;
		case 180:
			newSize[0] = width;
			newSize[1] = height;
			trans[0] = width;
			trans[1] = height;
			break;
		case 270:
			newSize[0] = height;
			newSize[1] = width;
			trans[0] = 0;
			trans[1] = width;
			break;
		default:
			throw new IllegalArgumentException("Can't rotate degree besides 0, 90, 180, 270");
		}
		
		BufferedImage rotatedImage = new BufferedImage(newSize[0], newSize[1], BufferedImage.TYPE_INT_RGB);
		Graphics2D g = rotatedImage.createGraphics();
		
		g.translate(trans[0], trans[1]);
		
		g.rotate(radian);
		g.drawImage(originalImage, 0, 0, null);
		
		g.dispose();
		
		return rotatedImage;
		
	}
}
