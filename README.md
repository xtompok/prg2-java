# Cvičení z Programování II

## Doporučené zdroje
* [Průvodce labyrintem algoritmů](http://pruvodce.ucw.cz/) - knížka popisující mnohé základní i pokročilé algoritmy, čtivé, ačkoli poměrně rozsáhlé
* [Programátorské kuchařky](https://ksp.mff.cuni.cz/kucharky/) - sepsané základy algoritmizace, od úplných základů až po složité algoritmy a datové struktury

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

## Rozhraní
* slouží k definování chování nějakého objektu při pohledu zvenku
* objekt implementující dané rozhraní můžeme snadno vyměnit za jiný, který implementuje totéž rozhraní
* rozhraní samotné neobsahuje výkonný kód, jen popisuje, které metody bude mít objekt toto rozhraní implementující

### GUI
* JFrame
  - reprezentuje okno
* JPanel
  - reprezentuje plátno, na které se přidávají komponenty
  - jeden `JFrame` může obsahovat více `JPanel`ů
* JLabel, JButton, JTextField
  - popisek, tlačítko, textové pole
  - `addActionListener` přidá posluchače událostí

* ActionListener
  - zpracovává události od komponent
  - jedna komponenta může mít více posluchačů
  - jeden posluchač může poslouchat více komponent
  - v jednoduchých případech se obvykle implementuje jako anonymní třída

* LayoutManager
  - zodpovídá za to, jak se umísťují prvky přidávané na panel / panely do okna
  - [Galerie layoutů](https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html)
