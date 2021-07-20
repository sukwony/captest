package io.phloxcorp.eldo.qa2.plugins;

import android.content.Context;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;

@CapacitorPlugin(name = "NaverLogin")
public class NaverLogin extends Plugin {
    @PluginMethod()
    public void login(PluginCall call) {
        getActivity().runOnUiThread(() -> {
            OAuthLogin.getInstance().startOauthLoginActivity(getActivity(), new OAuthLoginHandler() {
                @Override
                public void run(boolean success) {
                    OAuthLogin oAuthLogin = OAuthLogin.getInstance();
                    Context context = getContext();

                    if (success) {
                        JSObject ret = new JSObject();
                        ret.put("accessToken", oAuthLogin.getAccessToken(context));
                        ret.put("refreshToken", oAuthLogin.getRefreshToken(context));
                        call.resolve(ret);
                    } else {
                        call.reject(oAuthLogin.getLastErrorCode(context).getCode() + ": " + oAuthLogin.getLastErrorDesc(context));
                    }
                }
            });
        });
    }
}
