/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.handlers;

import org.wahlzeit.model.AccessRights;
import org.wahlzeit.model.Client;
import org.wahlzeit.model.Guest;
import org.wahlzeit.model.ModelConfig;
import org.wahlzeit.model.UserSession;
import org.wahlzeit.utils.DesignPattern;
import org.wahlzeit.utils.HtmlUtil;
import org.wahlzeit.webparts.WebPart;

import java.util.Map;


/**
 * A handler class for a specific web page.
 */
@DesignPattern(name = "Template Method", participants = {"Concrete Class"})
public class LogoutPageHandler extends AbstractWebPageHandler {

	/**
	 *
	 */
	public LogoutPageHandler() {
		initialize(PartUtil.SHOW_NOTE_PAGE_FILE, AccessRights.USER);
	}

	/**
	 *
	 */
	protected String doHandleGet(UserSession us, String link, Map args) {
		Client previousClient = us.getClient();
		us.setClient(new Guest(previousClient));
		us.clearSavedArgs();
		return link;
	}

	/**
	 * @methodtype command
	 */
	protected void makeWebPageBody(UserSession us, WebPart page) {
		ModelConfig config = us.getClient().getLanguageConfiguration();
		page.addString("noteHeading", config.getThankYou());
		String msg1 = config.getLogoutSucceeded();
		String msg2 = config.getContinueWithTellFriends();
		page.addString("note", HtmlUtil.asP(msg1) + HtmlUtil.asP(msg2));
	}

}
