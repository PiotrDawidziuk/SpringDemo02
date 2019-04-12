package pl.piotrdawidziuk.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JoinImageController {
	
	@GetMapping(value = "/get-joined", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getJoinedImage() throws IOException {
    	InputStream in = new URL("https://vignette.wikia.nocookie.net/uncyclopedia/images/b/be/Cat.JPG").openStream();  
        return IOUtils.toByteArray(in);
    }
	

}
