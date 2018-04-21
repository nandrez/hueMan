/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.setup.bridgeselection

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nandrez.hueman.R

/**
 * A fragment representing a [List] of available bridges.
 */
class BridgeSelectionFragment : Fragment(), BridgeSelectionContract.View {

    override lateinit var presenter: BridgeSelectionContract.Presenter
    private val bridgeSelectionAdapter = BridgeSelectionAdapter(presenter::pairWithBridge)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_bridgeselection, container, false)
        if (view is RecyclerView) {
            val context = view.getContext()
            view.layoutManager = LinearLayoutManager(context)

            view.adapter = bridgeSelectionAdapter
            showAvailableBridges()
        }
        return view
    }

    override fun showAvailableBridges() {
        val availableBridges = presenter.findBridges()
        bridgeSelectionAdapter.updateAvailableBridges(availableBridges)
    }

    companion object {
        fun newInstance(): BridgeSelectionFragment = BridgeSelectionFragment()
    }

}