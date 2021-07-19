package io.phloxcorp.eldo.qa2.plugins;

import android.app.Activity;
import android.content.Intent;

import androidx.activity.result.ActivityResult;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.ActivityCallback;
import com.getcapacitor.annotation.CapacitorPlugin;

import io.phloxcorp.eldo.qa2.NicepayActivity;

@CapacitorPlugin(name = "Nicepay")
public class Nicepay extends Plugin {
    @PluginMethod()
    public void bring(PluginCall call) {
        /*
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", value);
        call.resolve(ret);
         */
        Intent intent = new Intent(this.getContext(), NicepayActivity.class);
        if (intent != null) {
            startActivityForResult(call, intent, "callback");
        }
    }

    @ActivityCallback
    private void callback(PluginCall call, ActivityResult result) {
        if (result.getResultCode() == Activity.RESULT_CANCELED) {
            call.reject("Activity canceled");
        } else {
            Intent data = result.getData();
            // do something with the result data
            call.resolve();
        }
    }
}