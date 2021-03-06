/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pig.penny.apps.ds;

import java.io.Serializable;
import java.util.Set;

import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.data.Tuple;
import org.apache.pig.penny.Location;
import org.apache.pig.penny.MonitorAgent;

public class DSMonitorAgent extends MonitorAgent {
    
    private final static int NUM_SAMPLES = 5;
    
    private int tupleCount = 0;

    public void finish() {
    }

    public Set<Integer> furnishFieldsToMonitor() {
        return null;
    }

    public void init(Serializable[] args) {
    }

    public Set<String> observeTuple(Tuple t, Set<String> tags) throws ExecException {
        if (tupleCount++ < NUM_SAMPLES) {
            communicator().sendToCoordinator(t);
        }
        return tags;
    }

    public void receiveMessage(Location source, Tuple message) {
    }

}
