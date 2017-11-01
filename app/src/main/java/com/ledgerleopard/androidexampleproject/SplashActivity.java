package com.ledgerleopard.androidexampleproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.google.gson.Gson;
import com.ledgerleopard.balances.BalanceConfig;
import com.ledgerleopard.commons.activity.AbstractSplashActivity;
import com.ledgerleopard.commons.model.Modules.NavigationItem;

// 1. First of all extend your slpash from  AbstractSplashActivity
public class SplashActivity extends AbstractSplashActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
	}

	// return view for splash screen or use this tutorial LayoutInflater.from(SplashActivity.this).inflate(R.layout.activity_splash, null);
	// and create splash over drawable and manifest.xml
	@Override
	public View provideLayoutView() {
		return LayoutInflater.from(SplashActivity.this).inflate(R.layout.activity_splash, null);
	}


	@Override
	public void debugFunctionStop() {

	}

	// if you wanna stop executing of app and execute few requests to external servers - this is a best place
	// use launcherInterrupted=true to stop execution
	// after api calls done execute debugFunctionContinue()
	//
	// in this example we will read settings from sharedpreference and set new configuration to balance module
	@Override
	public void additionalInitialization() {
		SharedPreferences sharedPref = getSharedPreferences(
			"MY_SETTINGS", Context.MODE_PRIVATE);
		int allowTransfer = sharedPref.getInt("BALANCE_ALLOW_TRANSFER", 1);

		// 10 is a module id in configuration.json file
		NavigationItem balanceModule = configuration.findModuleById(10);

		// set new configuration parameter
		Gson gson = new Gson();
		BalanceConfig config = gson.fromJson(balanceModule.configuration, BalanceConfig.class);
		config.allow_transfer = allowTransfer;
		balanceModule.configuration = gson.toJsonTree(config);

		// continue executing app
		debugFunctionContinue();
	}
}
