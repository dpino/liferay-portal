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

package com.liferay.portalweb.portal.controlpanel.dynamicdatalists.record.editrecord;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditRecordTest extends BaseTestCase {
	public void testEditRecord() throws Exception {
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
		selenium.clickAt("link=Dynamic Data Lists",
			RuntimeVariables.replace("Dynamic Data Lists"));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@name='_167_keywords']",
			RuntimeVariables.replace("List Name"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace("Search"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("List Name"),
			selenium.getText("//tr[3]/td[2]/a"));
		selenium.clickAt("//tr[3]/td[2]/a",
			RuntimeVariables.replace("List Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText("//span[@title='Actions']/ul/li/strong/a"));
		selenium.clickAt("//span[@title='Actions']/ul/li/strong/a",
			RuntimeVariables.replace("Actions"));

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Edit')]/a")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Edit')]/a"));
		selenium.click(RuntimeVariables.replace(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[contains(.,'Edit')]/a"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Boolean"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[1]/span/span/label"));
		selenium.click(
			"//div[@class='aui-fieldset-content ']/div[1]/span/span/span/input[2]");
		assertEquals(RuntimeVariables.replace("Date"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[2]/span/span/label"));
		selenium.type("//div[@class='aui-fieldset-content ']/div[2]/span/span/span/input",
			RuntimeVariables.replace("08/09/10"));
		assertEquals(RuntimeVariables.replace("Decimal"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[3]/span/span/label"));
		selenium.type("//div[@class='aui-fieldset-content ']/div[3]/span/span/span/input",
			RuntimeVariables.replace("8.910"));
		assertEquals(RuntimeVariables.replace("Documents and Media"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[4]/div/span/span/label"));
		selenium.clickAt("//div[@class='aui-fieldset-content ']/div[4]/div/div/span/span/input",
			RuntimeVariables.replace("Select"));

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("//iframe")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.selectFrame("//iframe");

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("//input[@value='Choose']")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("//input[@value='Choose']",
			RuntimeVariables.replace("Choose"));
		selenium.selectFrame("relative=top");

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace("Document_1.txt")
										.equals(selenium.getValue(
								"//div[4]/div/span/span/span/input"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertEquals("Document_1.txt",
			selenium.getValue("//div[4]/div/span/span/span/input"));
		assertTrue(selenium.isPartialText(
				"//div[@class='aui-fieldset-content ']/div[5]/span/span/label",
				"File Upload"));
		selenium.uploadCommonFile("//div[@class='aui-fieldset-content ']/div[5]/span/span/span/input",
			RuntimeVariables.replace("Document_2.txt"));
		assertEquals(RuntimeVariables.replace("Integer"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[6]/span/span/label"));
		selenium.type("//div[@class='aui-fieldset-content ']/div[6]/span/span/span/input",
			RuntimeVariables.replace("8910"));
		assertEquals(RuntimeVariables.replace("Number"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[7]/span/span/label"));
		selenium.type("//div[@class='aui-fieldset-content ']/div[7]/span/span/span/input",
			RuntimeVariables.replace("111213"));
		assertEquals(RuntimeVariables.replace("Radio"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[8]/div/label"));
		assertEquals(RuntimeVariables.replace("option 1"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[8]/div/span[1]/span"));
		assertEquals(RuntimeVariables.replace("option 2"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[8]/div/span[2]/span"));
		assertEquals(RuntimeVariables.replace("option 3"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[8]/div/span[3]/span"));
		selenium.clickAt("//div[@class='aui-fieldset-content ']/div[8]/div/span[2]/span/span/input",
			RuntimeVariables.replace("option 3"));
		assertEquals(RuntimeVariables.replace("Select"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/span[1]/span/label"));
		assertEquals(RuntimeVariables.replace("option 1"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/span[1]/span/span/select/option[1]"));
		assertEquals(RuntimeVariables.replace("option 2"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/span[1]/span/span/select/option[2]"));
		assertEquals(RuntimeVariables.replace("option 3"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/span[1]/span/span/select/option[3]"));
		selenium.select("//div[@class='aui-fieldset-content ']/span[1]/span/span/select",
			RuntimeVariables.replace("label=option 1"));
		assertEquals(RuntimeVariables.replace("Text"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[9]/span/span/label"));
		selenium.type("//div[@class='aui-fieldset-content ']/div[9]/span/span/span/input",
			RuntimeVariables.replace("Text Field Edited"));
		assertEquals(RuntimeVariables.replace("Text Box"),
			selenium.getText(
				"//div[@class='aui-fieldset-content ']/div[10]/span/span/label"));
		selenium.type("//div[@class='aui-fieldset-content ']/div[10]/span/span/span/textarea",
			RuntimeVariables.replace("Text\nBox\nEdited"));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}