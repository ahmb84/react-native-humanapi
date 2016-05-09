package io.holis.humanapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.os.Bundle;

import io.holis.humanapi.bridge.ConnectOptions;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

public class HumanReactModule extends ReactContextBaseJavaModule {
  private final static String TAG = HumanReactModule.class.getName();

  private final static String REACT_MODULE_NAME = "HumanReactModule";
  private final static int HUMANAPI_AUTH = 1;
  private final static int RESULT_CANCELED = 0;
  private final static int RESULT_OK = 1;

  private Callback humanCallback;

  public HumanReactModule(ReactApplicationContext reactApplicationContext) {
    super(reactApplicationContext);
  }

  /**
   * @return the name of this module. This will be the name used to {@code require()} this module
   * from javascript.
   */
  @Override
  public String getName() {
      return REACT_MODULE_NAME;
  }
  /**
    * This method is exported to JS
    */
    @ReactMethod
    public void onConnect(@Nullable ReadableMap options, Callback callback) {
        humanCallback = callback;

        ConnectOptions connectOptions = new ConnectOptions(options);

        Activity activity = getCurrentActivity();

        if (activity == null) {
            // invokeAuthCallback(getReactApplicationContext().getString(R.string.com_auth0_android_react_native_lock_no_activity), null, null);
            return;
        }

        Intent intent = new Intent(activity, co.humanapi.connectsdk.ConnectActivity.class);

        intent.putExtras(connectOptions.getBundle());

        activity.startActivity(intent);
    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != HUMANAPI_AUTH) {
            return; // incorrect code
        }
        Log.d("hapi-home", "resultCode: " + resultCode);
        if (resultCode == RESULT_OK) {
            Log.d("hapi-home", "Authorization workflow completed");
            Bundle b = data.getExtras();
            Log.d("hapi-home", ".. public_token=" + b.getString("public_token"));


        } else if (resultCode == RESULT_CANCELED) {
            Log.d("hapi-home", "Authorization workflow cancelled");
        }
    }*/
}
