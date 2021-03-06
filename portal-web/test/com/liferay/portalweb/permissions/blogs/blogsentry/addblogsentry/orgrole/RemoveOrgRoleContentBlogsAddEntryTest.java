/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.permissions.blogs.blogsentry.addblogsentry.orgrole;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class RemoveOrgRoleContentBlogsAddEntryTest extends BaseTestCase {
	public void testRemoveOrgRoleContentBlogsAddEntry()
		throws Exception {
		selenium.open("/web/guest/home/");
		assertEquals(RuntimeVariables.replace("Go to"),
			selenium.getText("//li[@id='_145_mySites']/a/span"));
		selenium.mouseOver("//li[@id='_145_mySites']/a/span");

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("link=Control Panel")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Roles", RuntimeVariables.replace("Roles"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@id='_128_keywords']",
			RuntimeVariables.replace("Orgrole"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Roles Orgrole Name"),
			selenium.getText(
				"//td[@id='_128_ocerSearchContainer_col-name_row-1']/a"));
		assertEquals(RuntimeVariables.replace("Organization"),
			selenium.getText(
				"//td[@id='_128_ocerSearchContainer_col-type_row-1']/a"));
		selenium.clickAt("//td[@id='_128_ocerSearchContainer_col-name_row-1']/a",
			RuntimeVariables.replace("Roles Orgrole Name"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Define Permissions",
			RuntimeVariables.replace("Define Permissions"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Roles Orgrole Name"),
			selenium.getText("//h1[@class='header-title']"));
		assertEquals(RuntimeVariables.replace("Summary"),
			selenium.getText("//section[@id='portlet_128']/div/div/div/h3"));
		assertEquals(RuntimeVariables.replace("Blogs"),
			selenium.getText(
				"//td[@id='_128_ocerSearchContainer_col-resource-set_row-1']/a"));
		assertEquals(RuntimeVariables.replace("Blogs"),
			selenium.getText(
				"//td[@id='_128_ocerSearchContainer_col-resource_row-1']"));
		assertEquals(RuntimeVariables.replace("Add Entry"),
			selenium.getText(
				"//td[@id='_128_ocerSearchContainer_col-action_row-1']"));
		assertEquals(RuntimeVariables.replace("Delete"),
			selenium.getText(
				"//a[@id='_128_ocerSearchContainer_1_menu_delete']/span"));
		selenium.clickAt("//a[@id='_128_ocerSearchContainer_1_menu_delete']/span",
			RuntimeVariables.replace("Delete"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("The permission was deleted."),
			selenium.getText("//div[@class='portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace(
				"This role does not have any permissions."),
			selenium.getText("//div[@class='portlet-msg-info']"));
	}
}