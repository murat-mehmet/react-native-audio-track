
# react-native-audio-track

This Module is in accordance with ```react-native-recording```

## Getting started

`$ npm i git://github.com/murat-mehmet/react-native-audio-track.git --save`

### Mostly automatic installation

`$ react-native link react-native-audio-track`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-audio-track` and add `RNAudioTrack.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNAudioTrack.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNAudioTrackPackage;` to the imports at the top of the file
  - Add `new RNAudioTrackPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-audio-track'
  	project(':react-native-audio-track').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-audio-track/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-audio-track')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNAudioTrack.sln` in `node_modules/react-native-audio-track/windows/RNAudioTrack.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Audio.Track.RNAudioTrack;` to the usings at the top of the file
  - Add `new RNAudioTrackPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import AudioTrack from 'react-native-audio-track';
AudioTrack.init({
  bufferSize: 4096,
  sampleRate: 44100,
  bitsPerChannel: 16,
  channelsPerFrame: 1,
})
AudioTrack.write(bytesArray,offset,size);
AudioTrack.play();
AudioTrack.pause();
AudioTrack.stop();
AudioTrack.setVolume(gain);
```
  
