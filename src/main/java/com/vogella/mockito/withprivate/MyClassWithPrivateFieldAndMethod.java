package com.vogella.mockito.withprivate;

public class MyClassWithPrivateFieldAndMethod {

    public String field1 = "";
    public String valueSetByPrivateMethod = "";
    private String hiddenField = "initial";

    public String getValue() {
        return hiddenField;
    }

    public String getValueSetByPrivateMethod() {
        return valueSetByPrivateMethod;
    }

    public String toBeMockedByMockito() {
        return "stuff";
    }

    @SuppressWarnings("unused") // called via reflection in tests
    private void meineMethod() {
        valueSetByPrivateMethod = "lalal";
    }
}
