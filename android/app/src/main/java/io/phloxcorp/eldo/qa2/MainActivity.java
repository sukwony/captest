package io.phloxcorp.eldo.qa2;

import android.os.Bundle;

import com.codetrixstudio.capacitor.GoogleAuth.GoogleAuth;
import com.getcapacitor.BridgeActivity;
import com.kakao.sdk.common.KakaoSdk;

import io.phloxcorp.eldo.qa2.plugins.Echo;
import io.phloxcorp.eldo.qa2.plugins.KakaoLogin;

public class MainActivity extends BridgeActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        KakaoSdk.init(this, "079f1a62b15fd69602be4e55de2cfd49");

        registerPlugin(GoogleAuth.class);
        registerPlugin(Echo.class);
        registerPlugin(KakaoLogin.class);
    }
}
