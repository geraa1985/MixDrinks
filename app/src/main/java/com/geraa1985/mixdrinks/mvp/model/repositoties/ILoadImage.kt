package com.geraa1985.mixdrinks.mvp.model.repositoties

interface ILoadImage<T> {
    fun loadInto(url: String, container: T)
}