package com.example.injector;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import android.app.Activity;

public final class Injector {
    private final Activity mActivity;

    private Injector(Activity activity) {
        mActivity = activity;
    }

    public static Injector get(Activity activity) {
        return new Injector(activity);
    }

    public void inject() {
        for (Field field : mActivity.getClass().getDeclaredFields()) {
            for (Annotation annotation : field.getAnnotations()) {
                if (annotation.annotationType().equals(InjectView.class)) {
                    try {
                        Class<?> fieldType = field.getType();
                        int idValue = InjectView.class.cast(annotation).value();
                        field.setAccessible(true);
                        Object injectedValue = fieldType.cast(mActivity.findViewById(idValue));
                        if (injectedValue == null) {
                            throw new IllegalStateException("findViewById(" + idValue
                                    + ") gave null for " +
                                    field + ", can't inject");
                        }
                        field.set(mActivity, injectedValue);
                        field.setAccessible(false);
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    }
                }
            }
        }
    }
}
