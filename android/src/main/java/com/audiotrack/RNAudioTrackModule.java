package com.audiotrack;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableArray;

import java.util.ArrayList;

import com.facebook.react.bridge.Callback;

import android.media.AudioTrack;
import android.media.AudioManager;
import android.media.AudioFormat;
import android.util.Base64;
import android.util.Log;

public class RNAudioTrackModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    private static AudioTrack audioTrack;

    int bufferSize = 8192;

    public RNAudioTrackModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        if (audioTrack != null) {
            audioTrack.stop();
            audioTrack.release();
            audioTrack = null;
        }
    }

    @Override
    public String getName() {
        return "RNAudioTrack";
    }

    @ReactMethod
    public void init(ReadableMap options) {
        int streamType = AudioManager.STREAM_MUSIC;
        int sampleRateInHz = 44100;
        int channelConfig = AudioFormat.CHANNEL_OUT_MONO;
        int audioFormat = AudioFormat.ENCODING_PCM_16BIT;
        int mode = AudioTrack.MODE_STREAM;
        if (options.hasKey("streamType")) {
            streamType = options.getInt("streamType");
        }
        ;
        if (options.hasKey("bitsPerChannel")) {
            int bitsPerChannel = options.getInt("bitsPerChannel");

            if (bitsPerChannel == 8) {
                audioFormat = AudioFormat.ENCODING_PCM_8BIT;
            }
        }
        if (options.hasKey("channelsPerFrame")) {
            int channelsPerFrame = options.getInt("channelsPerFrame");

            // every other case --> CHANNEL_IN_MONO
            if (channelsPerFrame == 2) {
                channelConfig = AudioFormat.CHANNEL_OUT_STEREO;
            }
        }
        if (options.hasKey("sampleRate")) {
            sampleRateInHz = options.getInt("sampleRate");
        }
        if (options.hasKey("bufferSize")) {
            bufferSize = options.getInt("bufferSize");
        }
        audioTrack = new AudioTrack(streamType, sampleRateInHz, channelConfig, audioFormat, bufferSize * 2, mode);
    }

    @ReactMethod
    public void Play() {
        if (audioTrack != null) {
            audioTrack.play();
        }
    }

    @ReactMethod
    public void Stop() {
        if (audioTrack != null) {
            audioTrack.stop();
            audioTrack.release();
            audioTrack = null;
        }
    }

    @ReactMethod
    public void Pause() {
        if (audioTrack != null) {
            audioTrack.pause();
        }
    }

    @ReactMethod
    public void SetVolume(float gain) {
        if (audioTrack != null) {
            audioTrack.setVolume(gain);
        }
    }

    @ReactMethod
    public void Write(String base64String) {
        byte[] bytesArray = Base64.decode(base64String, Base64.NO_WRAP);
        if (audioTrack != null && bytesArray != null) {
            short[] buffer = byte2short(bytesArray);
            audioTrack.write(buffer, 0, bufferSize);
        }
    }

    public static short[] byte2short(byte[] paramArrayOfbyte) {
        short[] arrayOfShort = new short[paramArrayOfbyte.length / 2];
        for (int i = 0; ; i += 2) {
            if (i >= paramArrayOfbyte.length)
                return arrayOfShort;
            byte b1 = paramArrayOfbyte[i];
            byte b2 = paramArrayOfbyte[i + 1];
            short s = (short) ((short) ((short) b1 & 0xFF) + (short) (b2 << 8));
            arrayOfShort[i / 2] = (short) s;
        }
    }
}