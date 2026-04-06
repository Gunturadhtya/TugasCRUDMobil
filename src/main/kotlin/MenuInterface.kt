package org.mobil

interface MenuInterface<T, K> {
    fun add(data: T)
    fun list(): List<T>
    fun edit(key: K, newData: T)
    fun delete(key: K)
    fun showData(key: K): Pair<K, T>?
    fun showMenu()
}