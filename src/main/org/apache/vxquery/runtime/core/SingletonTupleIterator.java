/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.apache.vxquery.runtime.core;

import org.apache.vxquery.exceptions.SystemException;
import org.apache.vxquery.runtime.CallStackFrame;
import org.apache.vxquery.runtime.LocalRegisterAccessor;
import org.apache.vxquery.runtime.RegisterAllocator;
import org.apache.vxquery.runtime.base.TupleIterator;

public final class SingletonTupleIterator implements TupleIterator {
    private final LocalRegisterAccessor<Boolean> done;

    public SingletonTupleIterator(RegisterAllocator rAllocator) {
        done = new LocalRegisterAccessor<Boolean>(rAllocator.allocate(1));
    }

    @Override
    public void close(CallStackFrame frame) {
    }

    @Override
    public boolean next(CallStackFrame frame) throws SystemException {
        if (done.get(frame)) {
            return false;
        }
        done.set(frame, true);
        return true;
    }

    @Override
    public void open(CallStackFrame frame) {
        done.set(frame, false);
    }
}