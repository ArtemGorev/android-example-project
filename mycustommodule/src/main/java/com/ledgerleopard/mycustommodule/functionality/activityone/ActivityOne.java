package com.ledgerleopard.mycustommodule.functionality.activityone;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.ledgerleopard.commons.activity.AbstractModuleActivity;
import com.ledgerleopard.mycustommodule.CustomModuleConfig;
import com.ledgerleopard.mycustommodule.R;

/**
 * This is test implementation of module's view.
 * View should extend AbstractModuleActivity and be parametrised with presenter interface and configuration class
 * Also it should implement View interface
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
		if ( customModuleConfig.buttonVisibilityParameter != 0  || customModuleConfig.buttonVisibilityParameter != 1)
			new IllegalArgumentException("This parametr should be 0 or 1");
	}

	/**
	 * Presenter initialization
	 */
	@Override
	protected void initMVP() {
		presenter = new ActivityOnePresenter(this, new ActivityOneModelImpl(this), configuration);
	}

	/**
	 * implement all UI stuff
	 */
	@Override
	protected void initUI() {
		setContentView(R.layout.activity_one);
		btn = (Button) findViewById(R.id.button);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				presenter.myButtonClicked();
			}
		});
		tvResult = (TextView) findViewById(R.id.tvResult);
	}
}
