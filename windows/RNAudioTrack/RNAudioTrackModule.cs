using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Audio.Track.RNAudioTrack
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNAudioTrackModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNAudioTrackModule"/>.
        /// </summary>
        internal RNAudioTrackModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNAudioTrack";
            }
        }
    }
}
