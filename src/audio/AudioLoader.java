package audio;

import sun.audio.AudioData;
import sun.audio.AudioStream;

import java.io.IOException;

public class AudioLoader {


    public static AudioData getData(String path){
        AudioStream stream;
        AudioData data = null;

        try {
            stream = new AudioStream(AudioLoader.class.getResourceAsStream(path));
            data = stream.getData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
