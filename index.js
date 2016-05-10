var { NativeModules, Platform } = require('react-native')
var HumanModule = NativeModules.HumanReactModule

class HumanAPI {
  onConnect(options) {
    const onCallback = (data) => {
      const status = data.status
      switch(status) {
        case 'auth':
          if (options.auth)
            options.auth(data)
          break
        case 'success':
          if (options.success)
            options.success(data)
          break
        default:
          if (options.cancel)
            options.cancel()
          break
      }
    }
    HumanModule.onConnect(options, onCallback)
  }
}

export default HumanAPI
