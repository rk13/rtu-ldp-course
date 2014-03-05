package test.aspect;

public aspect ArgValidationAspect
{
	/** Pointcut to all setter methods in test.pojo package */
	pointcut asserted():
		execution(* test.pojo..set*(*));

	
	/** Advice to validate passed input arguments for null values */
	before() : asserted()
	{
		for(Object o : thisJoinPoint.getArgs()) {
			if (o == null) {
				throw new IllegalArgumentException(
						"Argument of '" + thisJoinPoint.getSignature() + "' could not be null!");
		    }
		}
	}
}
