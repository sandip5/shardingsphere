/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.orchestration.internal.state.schema;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public final class OrchestrationSchemaGroupTest {
    
    @Test
    public void assertAddWithExistedSchemaName() {
        OrchestrationSchemaGroup actual = new OrchestrationSchemaGroup();
        actual.add(new OrchestrationSchema("test_0.ds_0"));
        actual.add(new OrchestrationSchema("test_0.ds_1"));
        assertThat(actual.getSchemaGroup().get("test_0").size(), is(2));
        assertTrue(actual.getSchemaGroup().get("test_0").contains("ds_0"));
        assertTrue(actual.getSchemaGroup().get("test_0").contains("ds_1"));
    }
    
    @Test
    public void assertAddWithoutExistedSchemaName() {
        OrchestrationSchemaGroup actual = new OrchestrationSchemaGroup();
        actual.add(new OrchestrationSchema("test_0.ds_0"));
        actual.add(new OrchestrationSchema("test_1.ds_1"));
        assertThat(actual.getSchemaGroup().get("test_0").size(), is(1));
        assertTrue(actual.getSchemaGroup().get("test_0").contains("ds_0"));
        assertThat(actual.getSchemaGroup().get("test_1").size(), is(1));
        assertTrue(actual.getSchemaGroup().get("test_1").contains("ds_1"));
    }
}
