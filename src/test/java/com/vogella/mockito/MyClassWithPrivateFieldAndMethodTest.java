package com.vogella.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vogella.mockito.withprivate.MyClassWithPrivateFieldAndMethod;

@ExtendWith(MockitoExtension.class)
class MyClassWithPrivateFieldAndMethodTest {

    @Spy
    MyClassWithPrivateFieldAndMethod mock = new MyClassWithPrivateFieldAndMethod();

    @Test
    void ensureSpyAndReflectiveAccessCanChangeAPrivateField() throws NoSuchFieldException, IllegalAccessException,
            NoSuchMethodException, InvocationTargetException {
        assertEquals("initial", mock.getValue());

        mock.field1 = "Hello";

        doReturn("mocked by Mockito").when(mock).toBeMockedByMockito();

        Field declaredField = MyClassWithPrivateFieldAndMethod.class.getDeclaredField("hiddenField");
        declaredField.setAccessible(true);
        declaredField.set(mock, "changed");

        Method privateMethod = MyClassWithPrivateFieldAndMethod.class.getDeclaredMethod("meineMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(mock);

        assertEquals("Hello", mock.field1);
        assertEquals("changed", mock.getValue());
        assertEquals("mocked by Mockito", mock.toBeMockedByMockito());
        assertEquals("lalal", mock.getValueSetByPrivateMethod());
    }
}

