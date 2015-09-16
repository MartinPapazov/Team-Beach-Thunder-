package audio;

import sun.audio.AudioData;
import sun.audio.AudioDataStream;
import sun.audio.ContinuousAudioDataStream;

import java.io.InputStream;

public class AudioAssets {
    private static AudioData spaceshipLasserOneAudio;
    private static AudioData spaceshipLasserTwoAudio;
    private static AudioData spaceshipLasserThreeAudio;
    private static AudioData spaceshipLasserFourAudio;
    private static AudioData spaceshipLasserFiveAudio;
    private static AudioData spaceshipBigLasserOneAudio;
    private static AudioData menuAudio;
    private static AudioData explosionAudio;
    private static AudioData menuChoiceSound;

    public static InputStream getSpaceshipLasserOneAudiInputStream() {
        return loadSingleSound(spaceshipLasserOneAudio);
    }

    public static InputStream getSpaceshipLasserTwoAudiInputStream() {
        return loadSingleSound(spaceshipLasserTwoAudio);
    }

    public static InputStream getSpaceshipLasserThreeAudiInputStream() {
        return loadSingleSound(spaceshipLasserThreeAudio);
    }

    public static InputStream getSpaceshipLasserFourAudiInputStream() {
        return loadSingleSound(spaceshipLasserFourAudio);
    }

    public static InputStream getSpaceshipLasserFiveAudiInputStream() {
        return loadSingleSound(spaceshipLasserFiveAudio);
    }

    public static InputStream getSpaceshipBigLasserOneAudiInputStream() {
        return loadSingleSound(spaceshipBigLasserOneAudio);
    }

    public static InputStream getMenuMusic() {
        return loadContinuousAudio(menuAudio);
    }

    public static InputStream getExplosionAudio() {
        return loadSingleSound(explosionAudio);
    }

    public static InputStream getMenuChoiceSound() {
        return loadSingleSound(menuChoiceSound);
    }

    public static void initialization() {
        //Audio
        spaceshipLasserOneAudio = AudioLoader.getData("/audio/Laser1.wav");
        spaceshipLasserTwoAudio = AudioLoader.getData("/audio/Laser2.wav");
        spaceshipLasserThreeAudio = AudioLoader.getData("/audio/Laser3.wav");
        spaceshipLasserFourAudio = AudioLoader.getData("/audio/Laser4.wav");
        spaceshipLasserFiveAudio = AudioLoader.getData("/audio/Laser5.wav");
        spaceshipBigLasserOneAudio = AudioLoader.getData("/audio/BigLaser1.wav");
        menuAudio = AudioLoader.getData("/audio/menuSound1.wav");
        explosionAudio = AudioLoader.getData("/audio/explosion.wav");
        menuChoiceSound = AudioLoader.getData("/audio/menuChoiceSound.wav");
    }

    private static InputStream loadSingleSound(AudioData data) {
        InputStream inputStream = new AudioDataStream(data);
        return inputStream;
    }

    private static InputStream loadContinuousAudio(AudioData data) {
        InputStream inputStream = new ContinuousAudioDataStream(data);
        return inputStream;
    }
}
