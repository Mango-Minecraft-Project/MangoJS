package com.mangojellypudding.mangojs.utils;

@SuppressWarnings("unused")
public class Pair<K, V> {
    final K left;
    final V right;

    public Pair(K left, V right) {
        this.left = left;
        this.right = right;
    }

    public K getLeft() {
        return left;
    }

    public V getRight() {
        return right;
    }
}