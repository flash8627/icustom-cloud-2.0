package com.gwtjs.icustom.webservice.autoconfigure;

import org.springframework.stereotype.Service;

@Service
public class CXFServletConstants {

	private boolean hideServiceListPage = true;
	
	private boolean disableAddressUpdates = true;

	public boolean isHideServiceListPage() {
		return hideServiceListPage;
	}

	public void setHideServiceListPage(boolean hideServiceListPage) {
		this.hideServiceListPage = hideServiceListPage;
	}

	public boolean isDisableAddressUpdates() {
		return disableAddressUpdates;
	}

	public void setDisableAddressUpdates(boolean disableAddressUpdates) {
		this.disableAddressUpdates = disableAddressUpdates;
	}

}
