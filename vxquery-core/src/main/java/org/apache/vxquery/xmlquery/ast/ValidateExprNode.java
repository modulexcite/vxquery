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
package org.apache.vxquery.xmlquery.ast;

import org.apache.vxquery.util.SourceLocation;
import org.apache.vxquery.xmlquery.query.XQueryConstants;

public class ValidateExprNode extends ASTNode {
    private XQueryConstants.ValidationMode mode;
    private ASTNode expr;

    public ValidateExprNode(SourceLocation loc) {
        super(loc);
    }

    @Override
    public ASTTag getTag() {
        return ASTTag.VALIDATE_EXPRESSION;
    }

    public ASTNode getExpr() {
        return expr;
    }

    public void setExpr(ASTNode expr) {
        this.expr = expr;
    }

    public void setMode(XQueryConstants.ValidationMode mode) {
        this.mode = mode;
    }

    public XQueryConstants.ValidationMode getMode() {
        return mode;
    }
}