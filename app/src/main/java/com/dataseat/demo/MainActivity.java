package com.dataseat.demo;

import com.dataseat.joustingbirds.R;
import com.dataseat.sdk.AdvertListener;
import com.dataseat.sdk.DSErrorCode;
import com.dataseat.sdk.Dataseat;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.app.Activity;
import android.widget.Button;
import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity  {

    private static final int BARCODE_READER_ACTIVITY_REQUEST = 1;
    private static MainActivity instance;
    private static String gaid;
    private Dataseat dataseat;

    public static synchronized MainActivity getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.activity_main);

        final Activity self = this;
        dataseat = Dataseat.getInstance(this);
        dataseat.initializeSDK();
    }

    public void preloadInterstitialAd(final View view) {
        dataseat.preloadInterstitial("Test", 5.0f, new Dataseat.PreloadAdvertCallback() {
            @Override
            public void onSuccess() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        findViewById(R.id.showAdButton).setVisibility(View.VISIBLE);
                    }
                });
            }

            @Override
            public void onError() {

            }
        });
    }

    public void preloadRewardedAd(final View view) {
        //mInterstitial.setAdUnitId("d29ee5e499794c8dbef60e0c3942f84e");
    }

    public void showAd(View view) {

        dataseat.showInterstitialAd(new AdvertListener() {
            @Override
            public void onAdFailed(@NotNull DSErrorCode dsErrorCode) {

            }

            @Override
            public void onAdShown() {

            }

            @Override
            public void onAdClicked() {

            }

            @Override
            public void onAdImpression() {

            }

            @Override
            public void onAdDismissed() {

            }

            @Override
            public void onAdComplete() {

            }

            @Override
            public void onAdResumeAutoRefresh() {

            }

            @Override
            public void onAdPauseAutoRefresh() {

            }

            @Override
            public void onAdExpanded() {

            }

            @Override
            public void onAdCollapsed() {

            }
        });
    }

}
