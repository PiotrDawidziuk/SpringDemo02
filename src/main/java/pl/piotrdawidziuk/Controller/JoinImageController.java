package pl.piotrdawidziuk.Controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JoinImageController {
	
	  public static void setColorToGraphics(Graphics2D graph, int width, int height) {
	    	Color oldColor = graph.getColor();
	 	    graph.setPaint(Color.BLACK);
	 	    graph.fillRect(0, 0, width, height);
	 	    graph.setColor(oldColor);
	    }
	
	@GetMapping(value = "/get-joined", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getJoinedImage() throws IOException {
		
		String url1 = "https://upload.wikimedia.org/wikipedia/commons/a/a7/Toddy_Dog.jpg";
		String url2 = "https://vignette.wikia.nocookie.net/uncyclopedia/images/b/be/Cat.JPG";
		String url3 = "https://vignette.wikia.nocookie.net/uncyclopedia/images/b/be/Cat.JPG";
		
		BufferedImage img1 = ImageIO.read(new URL(url1));
		BufferedImage img2 = ImageIO.read(new URL(url2));
		BufferedImage img3 = ImageIO.read(new URL(url3));
		ArrayList<BufferedImage> imgList = new ArrayList<BufferedImage>();
		imgList.add(img1);
		imgList.add(img2);
		//imgList.add(img3);
		imgList.add(img3);
		imgList.add(img1);

		
		BufferedImage joinedImg = joinBufferedImage(imgList);
		
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ImageIO.write(joinedImg, "jpg", os);
		InputStream in = new ByteArrayInputStream(os.toByteArray());
		
    	return IOUtils.toByteArray(in);
    }
	
    public static BufferedImage joinBufferedImage(ArrayList<BufferedImage> img) {
    	
    		BufferedImage newImage = null;
    	
    		if (img.size()==1) {
    			newImage = img.get(0);
    		} 
    		else if (img.size()==2) {
    		BufferedImage img1= img.get(0);
    		BufferedImage img2= img.get(1);
    		
	    	int offset = 2;
       	    int width = img1.getWidth() + img2.getWidth() + offset;
    	    int height = Math.max(img1.getHeight(), img2.getHeight()) + offset;
    	    newImage = new BufferedImage(width, height,
    	        BufferedImage.TYPE_INT_BGR);
    	    Graphics2D g2 = newImage.createGraphics();
    	    
    	    setColorToGraphics(g2,width,height);
    	    
//    	    Color oldColor = g2.getColor();
//    	    g2.setPaint(Color.BLACK);
//    	    g2.fillRect(0, 0, width, height);
//    	    g2.setColor(oldColor);
//    	    
    	    g2.drawImage(img1, null, 0, 0);
    	    g2.drawImage(img2, null, img1.getWidth() + offset, 0);
    	    g2.dispose();
    	    } else if (img.size()==3) {
    	    	BufferedImage img1= img.get(0);
        		BufferedImage img2= img.get(1);
        		BufferedImage img3= img.get(2);
        		
    	    	int offset = 2;
           	    int width = img1.getWidth() + img2.getWidth() + img3.getWidth() + offset;
        	    int height = Collections.max(Arrays.asList(img1.getHeight(),img2.getHeight(),img3.getHeight())) + offset;
        	    newImage = new BufferedImage(width, height,
        	        BufferedImage.TYPE_INT_BGR);
        	    Graphics2D g2 = newImage.createGraphics();
        	    
        	    setColorToGraphics(g2,width,height);
//        	    Color oldColor = g2.getColor();
//        	    g2.setPaint(Color.BLACK);
//        	    g2.fillRect(0, 0, width, height);
//        	    g2.setColor(oldColor);
        	    
        	    g2.drawImage(img1, null, 0, 0);
        	    g2.drawImage(img2, null, img1.getWidth() + offset, 0);
        	    g2.drawImage(img3, null, img1.getWidth()+img2.getWidth() + offset, 0);
        	    g2.dispose();
    	    } else if(img.size() == 4) {
    	    	
    	    	BufferedImage img1= img.get(0);
        		BufferedImage img2= img.get(1);
        		BufferedImage img3= img.get(2);
        		BufferedImage img4 = img.get(3);
        		
    	    	int offset = 2;
           	    
    	    	int width = (Collections.max(Arrays.asList(img1.getWidth(),img3.getWidth())) + (Collections.max(Arrays.asList(img2.getWidth(),img4.getWidth())) + offset*2));
           	    
           	    
        	    int height = (Collections.max(Arrays.asList(img1.getHeight(),img2.getHeight())) + (Collections.max(Arrays.asList(img3.getHeight(),img4.getHeight())) + offset*2));
        	    newImage = new BufferedImage(width, height,
        	        BufferedImage.TYPE_INT_BGR);
        	    Graphics2D g2 = newImage.createGraphics();
        	    
        	    setColorToGraphics(g2,width,height);
        	    g2.drawImage(img1, null, 0, 0);
        	    g2.drawImage(img2, null, img1.getWidth() + offset, 0);
        	    g2.drawImage(img3, null, 0, Collections.max(Arrays.asList(img1.getHeight(),img2.getHeight())) + offset);
        	    g2.drawImage(img4, null, img1.getWidth() + offset, Collections.max(Arrays.asList(img1.getHeight(),img2.getHeight())) + offset);
        	    g2.dispose();
    	    	
    	    } else if (img.size()==5) {
    	    	
    	    	BufferedImage img1= img.get(0);
        		BufferedImage img2= img.get(1);
        		BufferedImage img3= img.get(2);
        		BufferedImage img4 = img.get(3);
        		BufferedImage img5 = img.get(4);
        		
    	    	int offset = 2;
           	    
    	    	int width = Collections.max(Arrays.asList ((img1.getWidth() + img2.getWidth() + img3.getWidth()), (img4.getWidth() + img5.getWidth())) ) + offset;
           	    
           	    
        	    int height = Collections.max(Arrays.asList ((img1.getHeight() + img4.getHeight()), (img2.getHeight() + img5.getHeight()), img3.getHeight()) ) + offset;
        	    
        	    newImage = new BufferedImage(width, height,
        	        BufferedImage.TYPE_INT_BGR);
        	    Graphics2D g2 = newImage.createGraphics();
        	    
        	    setColorToGraphics(g2,width,height);
        	    g2.drawImage(img1, null, 0, 0);
        	    g2.drawImage(img2, null, img1.getWidth() + offset, 0);
        	    g2.drawImage(img3, null, img1.getWidth()+img2.getWidth() + offset, 0);

        	    g2.drawImage(img4, null, 0, Collections.max(Arrays.asList(img1.getHeight(),img2.getHeight())) + offset);
        	    g2.drawImage(img5, null, img1.getWidth() + offset, Collections.max(Arrays.asList(img1.getHeight(),img2.getHeight())) + offset);
        	    
        	    
        	    g2.dispose();
    	    	
    	    }
   
    	    
    	    return newImage;
    	  }
    
  

}
