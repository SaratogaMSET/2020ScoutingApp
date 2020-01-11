package com.example.officialscoutingapp;

import android.content.Context;
<<<<<<< HEAD

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;
=======
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
>>>>>>> 1c0ebc41ae095fd8d358ce32f2ab7a41920640b4

import org.junit.Test;
import org.junit.runner.RunWith;

<<<<<<< HEAD
import static org.junit.Assert.assertEquals;
=======
import static org.junit.Assert.*;
>>>>>>> 1c0ebc41ae095fd8d358ce32f2ab7a41920640b4

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.officialscoutingapp", appContext.getPackageName());
    }
}
