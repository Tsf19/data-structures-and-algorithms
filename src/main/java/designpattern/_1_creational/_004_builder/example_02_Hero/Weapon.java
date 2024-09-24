package designpattern._1_creational._004_builder.example_02_Hero;

/**
 * Weapon enumeration.
 */
public enum Weapon {

  DAGGER, SWORD, AXE, WARHAMMER, BOW;

  @Override
  public String toString() {
    return name().toLowerCase();
  }
}
