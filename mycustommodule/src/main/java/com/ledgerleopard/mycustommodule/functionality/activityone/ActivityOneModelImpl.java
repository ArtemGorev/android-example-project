package com.ledgerleopard.mycustommodule.functionality.activityone;

import android.content.Context;
import com.ledgerleopard.commons.BaseModel;

/**
 * Implementation of module'd model
 */
public class ActivityOneModelImpl extends BaseModel implements ActivityOneContract.IModel {

	public ActivityOneModelImpl(Context context) {
		super(context);
	}

	@Override
	public String executeRequest() {
		return "Result of your response";
	}
}
