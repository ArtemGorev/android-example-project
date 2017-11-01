package com.ledgerleopard.mycustommodule.functionality.activityone;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.ledgerleopard.commons.activity.AbstractModuleActivity;
import com.ledgerleopard.mycustommodule.CustomModuleConfig;
import com.ledgerleopard.mycustommodule.R;

/**
 * This is test implementation of view.
 * View should extend AbstractModuleActivity and be parametrised with presenter interface and configuration class
 *
 */
public class ActivityOne
	extends AbstractModuleActivity<CustomModuleConfig, ActivityOneContract.IPresenter>
	implements ActivityOneContract.IView {

	private Button btn;
	private TextView tvResult;

	@Override
	public void enableButton( boolean visible ){
		btn.setVisibility(visible? View.VISIBLE : View.GONE);
	}

	@Override
	public void showResult(String result) {
		tvResult.setText(result);
	}

	@Override
	protected void checkConfiguration(CustomModuleConfig customModuleConfig) {
		if ( customModuleConfig.customParameter != 0  || customModuleConfig.customParameter != 1)
			new IllegalArgumentException("This parametr should be 0 or 1");
	}

	@Override
	protected void initMVP() {
		presenter = new ActivityOnePresenter(this, new ActivityOneModelImpl(this), configuration);
	}

	@Override
	protected void initUI() {
		setContentView(R.layout.activity_one);
		btn = (Button) findViewById(R.id.button);
		tvResult = (TextView) findViewById(R.id.tvResult);
	}
}
