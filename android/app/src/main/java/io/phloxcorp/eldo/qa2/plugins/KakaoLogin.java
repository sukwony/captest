package io.phloxcorp.eldo.qa2.plugins;

import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.user.UserApiClient;

@CapacitorPlugin(name = "KakaoLogin")
public class KakaoLogin extends Plugin {
    private static final String TAG = "KakaoLogin";

    private void callback(PluginCall call, OAuthToken token, Throwable error) {
        if (error != null)  {
            Log.e(TAG, "로그인 실패", error);
        } else if (token != null) {
            String accessToken = token.getAccessToken();
            Log.i(TAG, "로그인 성공 " + accessToken);
            JSObject ret = new JSObject();
            ret.put("accessToken", accessToken);
            call.resolve(ret);
        }
    }

    @PluginMethod()
    public void login(PluginCall call) {
        if (UserApiClient.getInstance().isKakaoTalkLoginAvailable(this.getContext())) {
            UserApiClient.getInstance().loginWithKakaoTalk(this.getContext(), (token, error) -> {
                this.callback(call, token, error);
                return null;
            });
        } else {
            UserApiClient.getInstance().loginWithKakaoAccount(this.getContext(), (token, error) -> {
                this.callback(call, token, error);
                return null;
            });
        }
    }
}