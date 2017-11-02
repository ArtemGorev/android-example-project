package com.ledgerleopard.mycustommodule.functionality.activityone;

import com.ledgerleopard.commons.BasePresenter;
import com.ledgerleopard.mycustommodule.CustomModuleConfig;

/**
 * This is implementation of module presenter
 * Presenter is a middle man between view and model
 * Exactly presenter contains all business login of form
 */
public class ActivityOnePresenter
	extends BasePresenter<CustomModuleConfig, ActivityOneContract.IView, ActivityOneContract.IModel, ActivityOneViewModel>
	implements ActivityOneContract.IPresenter {

	public ActivityOnePresenter(ActivityOneContract.IView view, ActivityOneContract.IModel model, CustomModuleConfig configuration) {
		super(view, model, configuration);
	}

	@Override
	public void onStart() {
		view.enableButton(configuration.buttonVisibilityParameter == 1);
	}

	@Override
	public void myButtonClicked() {
		vm.titleText = model.executeRequest();
		view.showResult(vm.titleText);
	}
}
