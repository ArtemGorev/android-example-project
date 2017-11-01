package com.ledgerleopard.mycustommodule.functionality.activityone;

import com.ledgerleopard.commons.BasePresenter;
import com.ledgerleopard.mycustommodule.CustomModuleConfig;

/**
 * Created by sergeybrazhnik on 01.11.17.
 */

public class ActivityOnePresenter
	extends BasePresenter<CustomModuleConfig, ActivityOneContract.IView, ActivityOneContract.IModel, ActivityOneViewModel>
	implements ActivityOneContract.IPresenter {

	public ActivityOnePresenter(ActivityOneContract.IView view, ActivityOneContract.IModel model, CustomModuleConfig configuration) {
		super(view, model, configuration);
	}

	@Override
	public void onStart() {
		view.enableButton(configuration.customParameter == 1);
	}

	@Override
	public void myButtonClicked() {
		String result = model.executeRequest();
		view.showResult(result);
	}
}
