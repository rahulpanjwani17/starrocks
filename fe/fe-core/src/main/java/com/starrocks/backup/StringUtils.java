// Copyright 2021-present StarRocks, Inc. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.starrocks.backup;

/**
 * Utility class for string operations in backup package.
 */
public class StringUtils {
    
    /**
     * Strips any of a set of characters from the end of a String.
     * 
     * @param str the String to remove characters from, may be null
     * @param stripChars the characters to remove, null treated as whitespace
     * @return the stripped String, {@code null} if null String input
     */
    public static String stripEnd(String str, String stripChars) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        
        int end = str.length();
        
        if (stripChars == null) {
            while (end != 0 && Character.isWhitespace(str.charAt(end - 1))) {
                end--;
            }
        } else {
            while (end != 0 && stripChars.indexOf(str.charAt(end - 1)) != -1) {
                end--;
            }
        }
        
        return str.substring(0, end);
    }
}
