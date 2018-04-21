/*
 * Copyright (c) 2018. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.setup.bridgeselection

import com.nandrez.hueman.BasePresenter
import com.nandrez.hueman.BaseView
import com.nandrez.hueman.view.Bridge

interface BridgeSelectionContract {

    interface View : BaseView<Presenter> {

        fun showAvailableBridges()

    }

    interface Presenter : BasePresenter {

        fun findBridges(): List<Bridge>

        fun pairWithBridge(selectedBridge: Bridge)

    }

}