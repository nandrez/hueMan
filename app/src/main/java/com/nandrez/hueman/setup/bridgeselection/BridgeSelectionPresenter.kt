/*
 * Copyright (c) 2018. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.setup.bridgeselection

import com.nandrez.hueman.view.Bridge

class BridgeSelectionPresenter(
        private val view: BridgeSelectionContract.View

) : BridgeSelectionContract.Presenter {

    init {
        view.presenter = this
    }

    override fun start() {
        TODO("not implemented")
    }

    override fun findBridges(): List<Bridge> {
        TODO("not implemented")
    }

    override fun pairWithBridge(selectedBridge: Bridge) {
        TODO("not implemented")
    }
}