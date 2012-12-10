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
	 * Constructor of GreenImageFile<p>
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
	 * Get Image via image id
	 * @param	id
	 * @throws	IllegalArgumentException
	 * 			No id fit the input
	 * @return	Image
	 */
	public Image getImage(int id){
		if(id < 0 || id > imageCount){
			throw new IllegalArgumentException("Index out of range.");
		}
		else{
			return image[id];
		}
	}
	
	/**
	 * Get image via image path
	 * @param	path
	 * @throws	IllegalArgumentException
	 * 			No path fit the input
	 * @return	Image
	 */
	public Image getImage(String path){
		int i = 0;
		
		//Search if any path fit the input
		for(i=0; i<imageCount; i++){
			if(imagePath[i] == path){
				break;
			}
		}
		
		// Check if out of range
		if(i >= imageCount){
			//Don't have any path fit the input
			throw new IllegalArgumentException("Can't search path");
		}else{
			return image[i];
		}
	}
	
	/**
	 * Get image list
	 * @return String[][] id:path
	 */
	public String[][] getImageList(){
		String[][] list = new String[imageCount][2];
		
		for(int i=0; i<imageCount; i++){
			list[i][0] = String.valueOf(i);
			list[i][1] = imagePath[i];
		}
		
		return list;
	}

}
