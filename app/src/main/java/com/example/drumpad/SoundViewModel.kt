package com.example.drumpad

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class SoundViewModel(private val drumPads: DrumPads): BaseObservable() {
    fun onButtonClicked() {
        sound?.let {
            drumPads.play(it)
        }
    }

    var sound: Sound? = null
        set(sound) {
            field = sound
            notifyChange()
        }
    @get:Bindable
    val title: String?
        get() = sound?.name
}