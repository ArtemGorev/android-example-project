package com.ledgerleopard.mycustommodule.functionality.activityone;

import com.ledgerleopard.commons.BaseContract;

/**
 * Created by sergeybrazhnik on 01.11.17.
 */

public interface ActivityOneContract {

	interface IView extends BaseContract.IBaseView {
		void enableButton( boolean visible );
		void showResult(String result);
	}

	interface IPresenter extends BaseContract.IBasePresenter<ActivityOneViewModel> {
		void myButtonClicked();
	}

	interface IModel extends BaseContract.IBaseModel {
		String executeRequest();
	}
}
