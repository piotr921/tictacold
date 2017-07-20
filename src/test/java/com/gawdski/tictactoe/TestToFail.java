package com.gawdski.tictactoe;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestToFail {

    @Test
    public void failTest(){
        Assert.assertTrue(true);
    }
}
