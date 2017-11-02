package com.ledgerleopard.mycustommodule.functionality.activityone;

import com.ledgerleopard.commons.BaseContract;

/**
 * This is a interfaces for MVP components.
 * Try to understand and follow this pattern to implement good architecture
 */
public interface ActivityOneContract {

	/**
	 * Describe all actions that view can do.
	 * Like draw list, show/hide elements and etc
	 */
	interface IView extends BaseContract.IBaseView {
		void enableButton( boolean visible );
		void showResult(String result);
	}

	/**
	 * This is a place where you should point out all actions that user can do on your form
	 * Like button clicks, selection of elements, swipes and etc
	 */
	interface IPresenter extends BaseContract.IBasePresenter<ActivityOneViewModel> {
		void myButtonClicked();
	}

	/**
	 * Describe all actions that needed to retrieve your data.
	 * It can be http requests, queries to DB, reading from internal storage and etc
	 */
	interface IModel extends BaseContract.IBaseModel {
		String executeRequest();
	}
}
