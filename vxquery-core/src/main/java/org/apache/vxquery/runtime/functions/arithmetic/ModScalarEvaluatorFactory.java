package org.apache.vxquery.runtime.functions.arithmetic;

import edu.uci.ics.hyracks.algebricks.runtime.base.IScalarEvaluatorFactory;

public class ModScalarEvaluatorFactory extends AbstractArithmeticScalarEvaluatorFactory {
    private static final long serialVersionUID = 1L;

    public ModScalarEvaluatorFactory(IScalarEvaluatorFactory[] args) {
        super(args);
    }

    @Override
    protected AbstractArithmeticOperation createArithmeticOperation() {
        return new ModOperation();
    }
}