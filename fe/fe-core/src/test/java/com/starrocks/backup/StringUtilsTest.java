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

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void testStripEnd() {
        // Test with null input
        Assert.assertNull(StringUtils.stripEnd(null, "/"));
        
        // Test with empty input
        Assert.assertEquals("", StringUtils.stripEnd("", "/"));
        
        // Test with no trailing characters to strip
        Assert.assertEquals("test", StringUtils.stripEnd("test", "/"));
        
        // Test with single trailing character to strip
        Assert.assertEquals("test", StringUtils.stripEnd("test/", "/"));
        
        // Test with multiple trailing characters to strip
        Assert.assertEquals("test", StringUtils.stripEnd("test///", "/"));
        
        // Test with mixed trailing characters where only some should be stripped
        Assert.assertEquals("test/path", StringUtils.stripEnd("test/path/", "/"));
        
        // Test with null stripChars (should strip whitespace)
        Assert.assertEquals("test", StringUtils.stripEnd("test  ", null));
        
        // Test with multiple characters in stripChars
        Assert.assertEquals("test", StringUtils.stripEnd("test/.", "/."));
    }
}
