package com.example.myPlugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

public class ThePlugin extends CordovaPlugin{
	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
	    super.initialize(cordova, webView);
	    // your init code here
	}
	
	 @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("echo".equals(action)) {
            this.echo(args.getString(0),callbackContext);
            return true;
        }
        return false;  // Returning false results in a "MethodNotFound" error.
    }
	 
	 private void echo(String message, CallbackContext callbackContext) {
         if (message != null && message.length() > 0) {
             callbackContext.success("Message received: "+message);
         } else {
             callbackContext.error("Error occurred");
         }
     }
}
