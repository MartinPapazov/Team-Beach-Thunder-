package contracts;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public interface IInformational {
    BufferedImage getObjectImage();
    HashMap<String, String> getInformationAboutObject();
}
