package com.ledgerleopard.androidexampleproject.customformview;

import android.os.Bundle;
import android.view.View;
import com.ledgerleopard.androidexampleproject.R;
import com.ledgerleopard.balances.BalanceConfig;
import com.ledgerleopard.balances.api.Balance;
import com.ledgerleopard.balances.functionality.balance.BalanceContract;
import com.ledgerleopard.balances.functionality.balance.BalanceModel;
import com.ledgerleopard.balances.functionality.balance.BalancePresenter;
import com.ledgerleopard.balances.functionality.balance.adapter.BalanceElementAdapter;
import com.ledgerleopard.balances.system.Constants;
import com.ledgerleopard.commons.activity.AbstractModuleActivity;
import com.ledgerleopard.commons.view.button.CustomButton;
import com.ledgerleopard.commons.view.elemetsadapter.BaseElementAdapter;
import com.ledgerleopard.commons.view.textview.CustomTextView;

import java.io.Serializable;
import java.util.List;

/**
 * This is an example of full custom view for balance module.
 * To use this custom view implementation don't forget to point full name of this class in configuration.json
 * "start_module_activity": "com.ledgerleopard.androidexampleproject.customformview.BalanceListImpl"
 *
 * I assume that you want to show only one first balance in this implementation
 */
public class BalanceListImpl
	extends AbstractModuleActivity<BalanceConfig, BalanceContract.Presenter>
	implements BalanceContract.View {

	private CustomTextView tvBalanceAmount;
	private CustomButton btnSend;
	private CustomButton btnHistory;
	private CustomTextView tvBalanceName;

	@Override
	public void showBalanceList(List<BaseElementAdapter> data) {
		if (data.size() != 0 ) {
			tvBalanceAmount.setText(((BalanceElementAdapter)data.get(0)).amount+"");
			tvBalanceName.setText("My custom points");
		}
	}

	@Override
	public void goToTransferActivity(List<Balance> balances) {
		Bundle bundle = new Bundle();
		bundle.putSerializable(Constants.SEND_VIRTUAL_POINTS_EXTRA_BALANCES, (Serializable) balances);
		startActivityForResultRight(configuration.sendVirtualPointsActivity,
			bundle,
			Constants.SEND_VIRTUAL_POINTS_REQUEST_CODE);
	}

	@Override
	public void goToHistoryActivity() {
		startActivityRight(configuration.transactionHistoryActivity, null);
	}

	@Override
	public void showTransferAndHistoryBtn( boolean visible) {
		btnSend.setVisibility(visible ? View.VISIBLE : View.GONE);
		btnHistory.setVisibility(visible ? View.VISIBLE : View.GONE);
	}

	@Override
	public void showNoMoneyDialog() {
		createDialog(getString(R.string.commons_info), getString(R.string.balance_no_money), null);
	}

	@Override
	public void stopRefreshing() {
		// this method should not be implemented for this custom view
	}

	@Override
	protected void checkConfiguration(BalanceConfig balanceConfig) {
		// no required parameters to check
	}

	@Override
	protected void initMVP() {
		presenter = new BalancePresenter(this,
			new BalanceModel(this, startActivityEntity.token, startActivityEntity.baseUrl),
			configuration);
	}

	@Override
	protected void initUI() {
		setTitle("My custom title");
		setContentView(R.layout.activity_balance_list);
		tvBalanceAmount = (CustomTextView) findViewById(R.id.tvBalanceAmount);
		tvBalanceName = (CustomTextView) findViewById(R.id.tvVirtualBalanceName);
		btnSend = (CustomButton) findViewById(R.id.btnSend);
		btnSend.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				presenter.clickAddBalance();
			}
		});


		btnHistory = (CustomButton) findViewById(R.id.btnHistory);
		btnHistory.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				presenter.clickHistory();
			}
		});
	}
}
