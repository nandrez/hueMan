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

class TestDiscoverHueBridge {
    
    private lateinit var testee : DiscoverHueBridge
    private lateinit var hueServiceMock : HueService
    
    @Before
    fun setup() {
        hueServiceMock = mock<HueService>()
        testee = DiscoverHueBridge(hueServiceMock)
    }
    
    @Test
    fun executeUseCase_success() {
        val request = DiscoverHueBridge.Request("test")
        val expectedResponse = createResponse()
        var isCalled = false
        val callback = object : UseCase.Callback<DiscoverHueBridge.Response> {
            override fun onSuccess(response: DiscoverHueBridge.Response) {
                Assert.assertEquals(expectedResponse, response)
                isCalled = true
            }
            override fun onError() {
                throw AssertionError("Unexpected CallBack-call")
            }
        }
        
        whenever(hueServiceMock.discoverBridge(any(), any())).thenAnswer {
            callback.onSuccess(expectedResponse)
        }
        
        testee.run(request, callback)
        Assert.assertTrue("onSuccess() was not called", isCalled)
    }
    
    @Test
    fun executeUseCase_failure() {
        val request = DiscoverHueBridge.Request("test")
        var isCalled = false
        val callback = object : UseCase.Callback<DiscoverHueBridge.Response> {
            override fun onSuccess(response: DiscoverHueBridge.Response) {
                throw AssertionError("Unexpected CallBack-call")
            }
            override fun onError() {
                isCalled = true;
            }
        }
        
        whenever(hueServiceMock.discoverBridge(any(), any())).thenAnswer {
            callback.onError()
        }
        
        testee.run(request, callback)
        Assert.assertTrue("onError() was not called", isCalled)
    }
    
    private fun createResponse() : DiscoverHueBridge.Response {
        val accessPoint = listOf(HueBridge("1.3.3.7", "testBridge", "any", "testuser"))
        return DiscoverHueBridge.Response(accessPoint)
    }
    
}