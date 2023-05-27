package io.github.zodh.adapters.observer;

import org.springframework.context.ApplicationListener;

public abstract class Observer <T extends Observable> implements ApplicationListener<T>, Finder<T> {

  public T findTarget(Object identifier) {
    if (identifier == null) {
      throw new IllegalArgumentException("It is not possible to get an object with null identifier");
    }
    return find(identifier);
  }

}
