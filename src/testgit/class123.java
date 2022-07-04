package testgit;

public class class123 {
	public void prepare(MappingManager manager, PreparedStatement ps) {
        this.session = manager.getSession();
        this.statement = ps;

      validateParameters();

        Class<?> returnType = method.getReturnType();
        if (Void.TYPE.isAssignableFrom(returnType) || ResultSet.class.isAssignableFrom(returnType))
            return;
        if (Statement.class.isAssignableFrom(returnType)) {
            returnStatement = true;
            return;
        }
        if (ResultSetFuture.class.isAssignableFrom(returnType)) {
            this.async = true;
            return;
        }
        if (ListenableFuture.class.isAssignableFrom(returnType)) {
            this.async = true;
            Type k = ((ParameterizedType)method.getGenericReturnType()).getActualTypeArguments()[0];
            if (k instanceof Class && ResultSet.class.isAssignableFrom((Class<?>)k))
                return;
            mapType(manager, returnType, k);
        } else {
            mapType(manager, returnType, method.getGenericReturnType());
        }
    }
private void validateParameters() {
        if (method.isVarArgs())
            throw new IllegalArgumentException(String.format("Invalid varargs method %s in @Accessor interface", method.getName()));

        ColumnDefinitions variables = statement.getVariables();
        Set<String> names = Sets.newHashSet();


      
    }
}
