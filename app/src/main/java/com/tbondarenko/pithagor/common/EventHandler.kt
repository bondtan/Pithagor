package com.tbondarenko.pithagor.common

interface EventHandler<E> {
    fun obtainEvent(event: E)
}