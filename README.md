# Cvičení z Programování II
## Zapouzdření
* atributy při zapouzdření nejsou přístupné přímo, ale přes metody `getX` a `setX`
  - toto je vlastnost Javy, jiné jazyky to umí i bez explicitních metod (např. Python)
* umožňuje přepsat vnitřek objektu bez toho, aby se změnilo vnější rozhraní
* umožňuje atributy pouze pro čtení či pouze pro zápis
  - opět vlastnost Javy, nikoli zapouzdření samotného


## Dědičnost
* od obecného objektu (např. auto) můžeme odvozovat konkrétnější objekty (např. nákladní auto)
* *potomek* *zdědí* všechmy atributy a metody od *předka*

### Přetěžování metod
* v *potomku* je možné předefinovat metodu z *předka*
* v obvyklém případě se pak volá nejpozději předefinovaná metoda
  - pozor, výběr, která metoda se zavolá, je složitý a v různých jazycích se liší
* přetížené metody je vhodné označit *anotací*  `@Override`, zvyšuje to přehlednost a snižuje potenciál pro budoucí chyby
  - NetBeans obvykle samy nabízí
