package io.github.zodh.adapters.observer;

public interface Finder<T extends Observable> {

  T find(Object identifier);

}
