package org.apache.cordova.echo;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.widget.Toast;
import com.pbn.tlib.*;

/**
* This class echoes a string called from JavaScript.
*/
public class EchoPlugin extends CordovaPlugin {

    //private static final String TAG = "Echo";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("echo")) {
            String message = args.getString(0);
            message = new MyLibService().sayHello(message);
            Toast.makeText(cordova.getActivity(), "tlib result=" + (message), Toast.LENGTH_SHORT).show();
            this.EchoPlugin(message, callbackContext);
            return true;
        }
        return false;
    }

    private void EchoPlugin(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}