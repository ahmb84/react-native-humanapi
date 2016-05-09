/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 */

import React, { Component } from 'react';
import HumanAPI from 'react-native-humanapi'
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  TouchableOpacity
} from 'react-native';

class Example extends Component {
  connectHumanAPI = () => {
    const humanAPI = new HumanAPI()
    humanAPI.onConnect({
      client_id: '6346b1a5dbd7399e0cc15a708620133a38574630',
      client_user_id: 'wayne@holis.io',
    }, () => console.log('Done'))
  }
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome to React Native!
        </Text>
        <Text style={styles.instructions}>
          To get started, edit index.android.js
        </Text>
        <Text style={styles.instructions}>
          Shake or press menu button for dev menu
        </Text>
        <TouchableOpacity style={styles.button} onPress={this.connectHumanAPI}>
          <Text style={styles.instructions}>
            Connect HumanAPI
          </Text>
        </TouchableOpacity>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
  button: {
    padding: 5,
    borderRadius: 5,
    backgroundColor: '#337ab7',
  },
});

AppRegistry.registerComponent('Example', () => Example);
