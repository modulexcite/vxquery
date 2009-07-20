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
package org.apache.vxquery.types.processors;

import org.apache.vxquery.context.StaticContext;
import org.apache.vxquery.datamodel.DMOKind;
import org.apache.vxquery.datamodel.XDMAtomicValue;
import org.apache.vxquery.datamodel.XDMItem;
import org.apache.vxquery.datamodel.XDMValue;
import org.apache.vxquery.datamodel.atomic.AtomicValueFactory;
import org.apache.vxquery.datamodel.atomic.HexBinaryValue;
import org.apache.vxquery.exceptions.ErrorCode;
import org.apache.vxquery.exceptions.SystemException;
import org.apache.vxquery.exceptions.SystemExceptionFactory;
import org.apache.vxquery.types.AtomicType;
import org.apache.vxquery.types.BuiltinTypeRegistry;
import org.apache.vxquery.types.TypeUtils;
import org.apache.vxquery.types.XQType;

public class Base64BinaryCastProcessor implements CastProcessor {
    public static final CastProcessor INSTANCE = new Base64BinaryCastProcessor();

    private Base64BinaryCastProcessor() {
    }

    @Override
    public XDMValue cast(AtomicValueFactory avf, XDMValue value, SystemExceptionFactory ieFactory,
            StaticContext ctx) throws SystemException {
        if (value.getDMOKind() == DMOKind.ATOMIC_VALUE) {
            XDMAtomicValue aVal = (XDMAtomicValue) value;
            AtomicType type = aVal.getAtomicType();
            if (TypeUtils.isSubtypeTypeOf(type, BuiltinTypeRegistry.XS_BASE64_BINARY)) {
                return value;
            } else if (TypeUtils.isSubtypeTypeOf(type, BuiltinTypeRegistry.XS_HEX_BINARY)) {
                byte[] bytes = ((HexBinaryValue) aVal).getBytes();
                return avf.createBase64Binary(bytes);
            }
        }
        CharSequence str = ((XDMItem) value).getStringValue();
        return avf.createBase64Binary(str);
    }

    @Override
    public boolean castable(XDMValue value, StaticContext ctx) {
        return false;
    }

    @Override
    public Boolean castable(XQType type) {
        return null;
    }

    @Override
    public ErrorCode getCastFailureErrorCode(XQType type) {
        return null;
    }
}