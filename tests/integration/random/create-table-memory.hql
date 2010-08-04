use "/";
drop table if exists RandomTest;
create table COMPRESSOR="none" RandomTest (
  Field,
  T1,
  T2,
  T3,
  T4,
  T5,
  T6,
  T7,
  ACCESS GROUP default IN_MEMORY (Field),
  ACCESS GROUP AT1 IN_MEMORY (T1),
  ACCESS GROUP AT2 IN_MEMORY (T2),
  ACCESS GROUP AT3 IN_MEMORY (T3),
  ACCESS GROUP AT4 IN_MEMORY (T4),
  ACCESS GROUP AT5 IN_MEMORY (T5),
  ACCESS GROUP AT6 IN_MEMORY (T6),
  ACCESS GROUP AT7 IN_MEMORY (T7)
);
