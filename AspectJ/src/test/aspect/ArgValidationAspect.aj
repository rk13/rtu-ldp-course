package test.aspect;

/**
 * Validates passed input arguments for null values. Allows to avoid
 * boiler-plate code stuff
 */
public aspect ArgValidationAspect {

/*******************************************************************************
 * Pointcut declaration
 ******************************************************************************/
	pointcut asserted(final Object target):
	  // all setter methods in test.pojo package
	  execution(* test.pojo..set*(*)) && this(target);


/*******************************************************************************
 * Advice declaration
 ******************************************************************************/
	before(final Object target) : asserted(target){

		// use internal AspectJ API to get passed arguments of joinpoint;
		final Object[] args = thisJoinPoint.getArgs();
		final String signature = String.valueOf(thisJoinPoint.getSignature());
		// start validation for all passed args
		int idx = 0;
		for(Object o : args) {
			idx++;
			if (o==null) {
				throw new IllegalArgumentException(idx+" argument of '"+signature+"' could not be null. See "+thisJoinPoint.getSourceLocation());
		    }
		}
	}

}
