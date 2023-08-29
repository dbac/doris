// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.apache.doris.nereids.trees.expressions.functions.scalar;

import org.apache.doris.catalog.FunctionSignature;
import org.apache.doris.nereids.trees.expressions.Expression;
import org.apache.doris.nereids.trees.expressions.functions.ExplicitlyCastableSignature;
import org.apache.doris.nereids.trees.expressions.functions.PropagateNullable;
import org.apache.doris.nereids.trees.expressions.shape.UnaryExpression;
import org.apache.doris.nereids.trees.expressions.visitor.ExpressionVisitor;
import org.apache.doris.nereids.types.BigIntType;
import org.apache.doris.nereids.types.DateTimeType;
import org.apache.doris.nereids.types.DateTimeV2Type;
import org.apache.doris.nereids.types.DateType;
import org.apache.doris.nereids.types.DateV2Type;
import org.apache.doris.nereids.types.DecimalV2Type;
import org.apache.doris.nereids.types.DecimalV3Type;
import org.apache.doris.nereids.types.DoubleType;
import org.apache.doris.nereids.types.FloatType;
import org.apache.doris.nereids.types.IntegerType;
import org.apache.doris.nereids.types.LargeIntType;
import org.apache.doris.nereids.types.SmallIntType;
import org.apache.doris.nereids.types.TimeType;
import org.apache.doris.nereids.types.TimeV2Type;
import org.apache.doris.nereids.types.TinyIntType;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * ScalarFunction 'running_difference'. This class is generated by GenerateFunction.
 */
public class RunningDifference extends ScalarFunction
        implements UnaryExpression, ExplicitlyCastableSignature, PropagateNullable {

    public static final List<FunctionSignature> SIGNATURES = ImmutableList.of(
            FunctionSignature.ret(SmallIntType.INSTANCE).args(TinyIntType.INSTANCE),
            FunctionSignature.ret(IntegerType.INSTANCE).args(SmallIntType.INSTANCE),
            FunctionSignature.ret(BigIntType.INSTANCE).args(IntegerType.INSTANCE),
            FunctionSignature.ret(BigIntType.INSTANCE).args(BigIntType.INSTANCE),
            FunctionSignature.ret(LargeIntType.INSTANCE).args(LargeIntType.INSTANCE),
            FunctionSignature.ret(DoubleType.INSTANCE).args(FloatType.INSTANCE),
            FunctionSignature.ret(DoubleType.INSTANCE).args(DoubleType.INSTANCE),
            FunctionSignature.ret(DecimalV2Type.SYSTEM_DEFAULT).args(DecimalV2Type.SYSTEM_DEFAULT),
            FunctionSignature.ret(DecimalV3Type.WILDCARD).args(DecimalV3Type.WILDCARD),
            FunctionSignature.ret(IntegerType.INSTANCE).args(DateType.INSTANCE),
            FunctionSignature.ret(IntegerType.INSTANCE).args(DateV2Type.INSTANCE),
            FunctionSignature.ret(TimeType.INSTANCE).args(DateTimeType.INSTANCE),
            FunctionSignature.ret(TimeV2Type.INSTANCE).args(DateTimeV2Type.SYSTEM_DEFAULT)
    );

    /**
     * constructor with 1 argument.
     */
    public RunningDifference(Expression arg) {
        super("running_difference", arg);
    }

    /**
     * withChildren.
     */
    @Override
    public RunningDifference withChildren(List<Expression> children) {
        Preconditions.checkArgument(children.size() == 1);
        return new RunningDifference(children.get(0));
    }

    @Override
    public <R, C> R accept(ExpressionVisitor<R, C> visitor, C context) {
        return visitor.visitRunningDifference(this, context);
    }

    @Override
    public List<FunctionSignature> getSignatures() {
        return SIGNATURES;
    }
}