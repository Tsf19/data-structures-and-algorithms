package designpattern._1_creational._004_builder.example_02_Hero;

import lombok.AllArgsConstructor;

/**
 * Armor enumeration.
 */
@AllArgsConstructor
public enum Armor {

  CLOTHES("clothes"),
  LEATHER("leather"),
  CHAIN_MAIL("chain mail"),
  PLATE_MAIL("plate mail");

  private final String title;

  @Override
  public String toString() {
    return title;
  }
}
