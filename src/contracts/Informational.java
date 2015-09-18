package contracts;

import java.awt.image.BufferedImage;
import java.util.Map;

public interface Informational {

    BufferedImage getObjectImage();
    Map<String, String> getInformationAboutObject();
}
