package pl.piotrdawidziuk.Controller;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;

@Controller
public class DataProducerController {

    @GetMapping("/get-text")
    public @ResponseBody String getText() {
        return "Hello world";
    }

    @GetMapping("/get-image")
    public @ResponseBody byte[] getImage() throws IOException {
        final InputStream in = getClass().getResourceAsStream("https://vignette.wikia.nocookie.net/uncyclopedia/images/b/be/Cat.JPG");
        return IOUtils.toByteArray(in);
    }

    @GetMapping(value = "/get-image-with-media-type", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImageWithMediaType() throws IOException {
        final InputStream in = getClass().getResourceAsStream("https://vignette.wikia.nocookie.net/uncyclopedia/images/b/be/Cat.JPG");
        return IOUtils.toByteArray(in);
    }

    @GetMapping(value = "/get-file", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody byte[] getFile() throws IOException {
        final InputStream in = getClass().getResourceAsStream("https://www.w3.org/TR/PNG/iso_8859-1.txt");
        return IOUtils.toByteArray(in);
    }

}