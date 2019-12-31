
import { NativeModules } from 'react-native';

const { RNAudioTrack } = NativeModules;



export default {
    // TODO: params check
    init: (options: {
      bufferSize: number,
      sampleRate: number,
      bitsPerChannel: 8 | 16,
      channelsPerFrame: 1 | 2,
    }) => RNAudioTrack.init(options),
    play: () => RNAudioTrack.Play(),
    stop: () => RNAudioTrack.Stop(),
    pause:()=> RNAudioTrack.Pause(),
    write:(base64:String)=> RNAudioTrack.Write(base64),
    setVolume:(gain:Number)=>RNAudioTrack.SetVolume(gain),
  }
