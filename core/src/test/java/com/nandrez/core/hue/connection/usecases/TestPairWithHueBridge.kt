/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.core.hue.connection.usecases

import com.nandrez.core.hue.connection.HueBridge
import com.nandrez.core.hue.connection.HueService
import com.nandrez.core.lib.UseCase
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TestPairWithHueBridge {
    
    private lateinit var testee : PairWithHueBridge
    private lateinit var hueServiceMock : HueService
    
    @Before
    fun setUp() {
        hueServiceMock = mock<HueService>()
        testee = PairWithHueBridge(hueServiceMock)
    }
    
    @Test
    fun executeUseCase_success() {
        val request = createRequest()
        val expectedResponse = createResponse()
        var isCalled = false
        val callback = object : UseCase.Callback<PairWithHueBridge.Response> {
            override fun onSuccess(response: PairWithHueBridge.Response) {
                Assert.assertEquals(expectedResponse, response)
                isCalled = true
            }
            override fun onError() {
                throw AssertionError("Unexpected CallBack-call")
            }
        }
        
        whenever(hueServiceMock.pairWithHueBridge(any(), any())).thenAnswer {
            callback.onSuccess(expectedResponse)
        }
        
        testee.run(request, callback)
        Assert.assertTrue("onSuccess() was not called", isCalled)
    }
    
    @Test
    fun executeUseCase_failure() {
        val request = createRequest()
        var isCalled = false
        val callback = object : UseCase.Callback<PairWithHueBridge.Response> {
            override fun onSuccess(response: PairWithHueBridge.Response) {
                throw AssertionError("Unexpected CallBack-call")
            }
            override fun onError() {
                isCalled = true;
            }
        }
        
        whenever(hueServiceMock.pairWithHueBridge(any(), any())).thenAnswer {
            callback.onError()
        }
        
        testee.run(request, callback)
        Assert.assertTrue("onError() was not called", isCalled)
    }
    
    private fun createRequest() : PairWithHueBridge.Request {
        val accessPoint = HueBridge("1.3.3.7", "testBridge", "any", "testuser")
        return PairWithHueBridge.Request(accessPoint)
    }
    
    private fun createResponse() : PairWithHueBridge.Response {
        return PairWithHueBridge.Response("testUser")
    }
    
}