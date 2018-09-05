package com.powermock;

import com.junit.ex.junittest.todoapp.Dependency;
import com.junit.ex.junittest.todoapp.SystemUnderTest;
import com.junit.ex.junittest.todoapp.UtilityClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
public class MockingStaticMethodTestPowerMock {

    //Specific runner class when we use mock and powermock
    //@RunWith(PowerMockRunner.class)
    //Initialize the class which class needs to mock UtilityClass

    //Mock

    @Mock
    private Dependency dependency;

    @InjectMocks
    private SystemUnderTest systemUnderTest;

    @Test
    public void testRetrieveTodosRelatedToSpring_usingPowermock() {
        when(dependency.retrieveAllStats()).thenReturn(Arrays.asList(1,2,3));
        PowerMockito.mockStatic(UtilityClass.class);


    }
}
