package l1j.server.server.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReflectionUtil {
	private static Logger _log = Logger.getLogger(ReflectionUtil.class
			.getName());

	private static void logException(Exception e) {
		_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
	}

	public static Class<?> classForName(String className) {
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException e) {
			logException(e);
		}
		return null;
	}

	public static Constructor<?> getConstructor(Class<?> cls, Class<?>... args) {
		try {
			return cls.getDeclaredConstructor(args);
		} catch (SecurityException e) {
			logException(e);
		} catch (NoSuchMethodException e) {
			logException(e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <T> T newInstance(Constructor<?> con, Object... args) {
		try {
			con.setAccessible(true);
			return (T) con.newInstance(args);
		} catch (IllegalArgumentException e) {
			logException(e);
		} catch (InstantiationException e) {
			logException(e);
		} catch (IllegalAccessException e) {
			logException(e);
		} catch (InvocationTargetException e) {
			logException(e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <T> T newInstance(Class<?> cls) {
		Constructor<?> con = getConstructor(cls, new Class<?>[0]);
		return (T) newInstance(con, new Object[0]);
	}

	public static <T, T2> T newInstance(String className, Class<T2> arg,
			T2 argValue) {
		Class<?> cls = ReflectionUtil.classForName(className);
		Constructor<?> con = ReflectionUtil.getConstructor(cls, arg);
		return ReflectionUtil.<T> newInstance(con, argValue);
	}

	public static <T> T newInstance(String className) {
		Class<?> cls = ReflectionUtil.classForName(className);
		return ReflectionUtil.<T> newInstance(cls);
	}
}
