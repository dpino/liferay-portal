/**
 * Copyright (c) 2000-2007 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portal.deploy;

import com.liferay.portal.kernel.util.SystemProperties;
import com.liferay.util.FileUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * <a href="DeployUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class DeployUtil {

	public static String getResourcePath(String resource)
		throws Exception {

		return _instance._getResourcePath(resource);
	}

	private DeployUtil() {
	}

	private String _getResourcePath(String resource) throws IOException {
		String tmpDir = SystemProperties.get(SystemProperties.TMP_DIR);

		File file = new File(
			tmpDir + "/liferay/com/liferay/portal/deploy/dependencies/" +
				resource);

		File parentFile = file.getParentFile();

		if (parentFile != null) {
			parentFile.mkdirs();
		}

		byte[] byteArray = FileUtil.getBytes(
			getClass().getResourceAsStream("dependencies/" + resource));

		OutputStream os = new FileOutputStream(file);

		os.write(byteArray);

		return FileUtil.getAbsolutePath(file);
	}

	private static DeployUtil _instance = new DeployUtil();

}