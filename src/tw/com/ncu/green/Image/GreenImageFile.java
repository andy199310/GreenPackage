package tw.com.ncu.green.Image;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * This package is useful for user to load image into
 * ImageIcon and get it.
 * @author	Green
 * @since	JDK1.7
 */

public class GreenImageFile {
	
	/** This BufferImage is used for image storage. */
	private BufferedImage[] image;
	
	/** How many image is loaded. */
	private int imageCount;	//Default to 0
	
	/** Save the path*/
	private String[] imagePath;
	
	/**
	 * Constructor of imageicon<p>
	 * @param path[] : Path of image
	 */
	public GreenImageFile(String[] path){
		imageCount = path.length;
		imagePath = path;
		
		//Load the image
		image = new BufferedImage[imageCount];
		
		for(int i=0; i<imageCount; i++){
			try{
				image[i] = ImageIO.read(new File(imagePath[i]));
			} 
			catch (IOException e){
				throw new IllegalArgumentException("Path:" + imagePath[i] + "can't loaded");
			} 
		}
	}
	
	/**
	 * Get Image
	 * @param imageId
	 * @return Image
	 */
	public Image getImage(int imageId){
		if(imageId < 0 || imageId > imageCount){
			throw new IllegalArgumentException("Index out of range.");
		}
		else{
			return image[imageId];
		}
	}

}
