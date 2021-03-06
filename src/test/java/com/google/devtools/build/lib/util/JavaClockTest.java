// Copyright 2014 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.google.devtools.build.lib.util;

import static com.google.common.truth.Truth.assertThat;

import com.google.devtools.build.lib.clock.Clock;
import com.google.devtools.build.lib.clock.JavaClock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for the Clock instance based on the Java System class.
 */
@RunWith(JUnit4.class)
public class JavaClockTest {

  @Test
  public void javaClockIsAdvancing() throws Exception {
    Clock clock = new JavaClock();
    long millis = clock.currentTimeMillis();
    long nanos = clock.nanoTime();

    Thread.sleep(10);

    assertThat(clock.currentTimeMillis()).isNotEqualTo(millis);
    assertThat(clock.nanoTime()).isNotEqualTo(nanos);
  }
}
