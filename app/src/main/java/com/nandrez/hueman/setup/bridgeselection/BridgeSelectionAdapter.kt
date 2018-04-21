/*
 * Copyright (c) 2017. nandrez labs, All Rights Reserved
 */
package com.nandrez.hueman.setup.bridgeselection

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nandrez.hueman.R
import com.nandrez.hueman.view.Bridge
import kotlinx.android.synthetic.main.item_bridge.view.*

internal class BridgeSelectionAdapter(
        private val onBridgeSelected: (Bridge) -> Unit

) : RecyclerView.Adapter<BridgeSelectionAdapter.BridgeViewHolder>() {

    val availableBridges = ArrayList<Bridge>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BridgeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_bridge, parent, false)
        return BridgeViewHolder(view)
    }

    override fun onBindViewHolder(holder: BridgeViewHolder, position: Int) {
        holder.bindBridge(availableBridges[position])
    }

    override fun getItemCount(): Int {
        return availableBridges.size
    }

    fun updateAvailableBridges(bridges: List<Bridge>) {
        availableBridges.clear()
        availableBridges.addAll(bridges)
    }

    internal inner class BridgeViewHolder(bridgeView: View) : RecyclerView.ViewHolder(bridgeView) {

        fun bindBridge(bridge: Bridge) {
            with(itemView) {
                bridgeIdTextView.text = bridge.id
                bridgeNameTextView.text = bridge.name
                bridgeIpAddressTextView.text = bridge.ipAddress
                bridgeMacAddressTextView.text = bridge.macAddress
                bridgeStatusTextView.text = bridge.status
                setOnClickListener { onBridgeSelected }
            }
        }

    }

}