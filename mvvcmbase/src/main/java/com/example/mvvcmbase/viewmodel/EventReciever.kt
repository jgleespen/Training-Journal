package com.example.mvvcmbase.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mvvcmbase.models.ViewEvent

interface EventReceiver<TypeOfViewEvent : ViewEvent> {
    /** Invoked by the View and received by the implementing [ViewModel] **/
    fun onEvent(event: TypeOfViewEvent)

    /** Not all [ViewEvent] should occur more than once when rapidly clicked,
     * this utility method will restrict frequency of sent [ViewEvent] according to
     * an implementation-determined debounce time. */
    fun onEventDebounced(event: TypeOfViewEvent)
}
