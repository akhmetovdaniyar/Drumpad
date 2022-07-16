package com.example.drumpad

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class SoundViewModelTest {
    private lateinit var drumPad: DrumPads
    private lateinit var sound: Sound
    private lateinit var subject: SoundViewModel
    @Before
    fun setUp() {
        drumPad = mock(DrumPads::class.java)
        sound = Sound("assetPath")
        subject = SoundViewModel(drumPad)
        subject.sound = sound
    }
    @Test
    fun exposesSoundNameAsTitle() {
        assertThat(subject.title, `is`(sound.name))
    }
    @Test
    fun callsDrumPadPlayOnButtonClicked() {
        subject.onButtonClicked()
        verify(drumPad).play(sound)
    }
}