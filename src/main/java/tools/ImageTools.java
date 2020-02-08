package tools;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageTools {

    public BufferedImage getImageFromFile (String imagePath) throws IOException {
        return ImageIO.read(new File(imagePath));
    }

}
