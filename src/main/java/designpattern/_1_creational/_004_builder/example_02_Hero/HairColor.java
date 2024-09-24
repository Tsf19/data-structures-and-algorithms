package designpattern._1_creational._004_builder.example_02_Hero;

/**
 * HairColor enumeration.
 */
public enum HairColor {

  WHITE,
  BLOND,
  RED,
  BROWN,
  BLACK;

  @Override
  public String toString() {
    return name().toLowerCase();
  }

}
