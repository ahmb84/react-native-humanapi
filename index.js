var { NativeModules, Platform } = require('react-native')
var HumanModule = NativeModules.HumanReactModule

class HumanAPI {
  onConnect(options, callback) {
    HumanModule.onConnect(options, callback);
  }
}

export default HumanAPI
