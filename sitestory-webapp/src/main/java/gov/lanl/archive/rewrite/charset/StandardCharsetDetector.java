/*
 *  This file is part of the Wayback archival access software
 *   (http://archive-access.sourceforge.net/projects/wayback/).
 *
 *  Licensed to the Internet Archive (IA) by one or more individual 
 *  contributors. 
 *
 *  The IA licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package gov.lanl.archive.rewrite.charset;

import java.io.IOException;
import java.io.InputStream;

public class StandardCharsetDetector extends CharsetDetector {

	@Override
	public String getCharset(InputStream resource, String ctype)
	throws IOException {
		String charSet = getCharsetFromHeaders(ctype);
		if(charSet == null) {
			charSet = getCharsetFromMeta(resource);
			if(charSet == null) {
				
				charSet = getCharsetFromBytes(resource);
				
				if(charSet == null) {
					System.out.println ("default charset");
					charSet = DEFAULT_CHARSET;
				}
			}
		}
		return charSet;
	}
}
