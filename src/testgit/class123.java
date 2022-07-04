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
        for (ColumnDefinitions.Definition variable : variables) {
            names.add(variable.getName());
        }

        if (method.getParameterTypes().length < names.size())
            throw new IllegalArgumentException(String.format("Not enough arguments for method %s, "
                    + "found %d but it should be at least the number of unique bind parameter names in the @Query (%d)",
                method.getName(), method.getParameterTypes().length, names.size()));

        if (method.getParameterTypes().length > variables.size())
            throw new IllegalArgumentException(String.format("Too many arguments for method %s, "
                    + "found %d but it should be at most the number of bind parameters in the @Query (%d)",
                method.getName(), method.getParameterTypes().length, variables.size()));
		  	UserAccessor accessor = new MappingManager(session).createAccessor(UserAccessor.class);
			accessor.addUserStr(0, Enum.FEMALE);
			accessor.addUserStr(1, Enum.MALE);
			assertThat(accessor.getUserStr(Enum.MALE).one().getGender()).isEqualTo(Enum.MALE);
			assertThat(accessor.getUserStr(Enum.MALE).one().getKey()).isEqualTo(1);
			session.execute("delete from user where key = 0");
			accessor.updatePhones_positional("1111", "2222", 0);
			assertPhonesEqual(0, "1111", "2222");
			session.execute("delete from user where key = 0");
			accessor.updatePhones_named(0, "1111", "2222");
			assertPhonesEqual(0, "1111", "2222");
			session.execute("delete from user where key = 0");
			accessor.updatePhones_fallback("1111", "2222", 0);
			assertPhonesEqual(0, "1111", "2222");
			session.execute("delete from user where key = 0");
			accessor.updateBothPhones(0, "1111");
			assertPhonesEqual(0, "1111", "1111");
			session.execute("delete from user where key = 0");
			accessor.updatePhones_fallback2("1111", "2222", 0);
			assertPhonesEqual(0, "1111", "2222");

    }
