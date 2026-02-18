
# Cesta za skřetem

Textové RPG o chudém žebrákovi, který se vydá do začarovaného lesa pro skřetův poklad. Cestou mu pomáhá tajemný kouzelník. Hra používá Command pattern.

## Autor
Ondřej Micka
## Průběh hry
* Hráč se vydá do lesa.
* Potkává stvůry které musí prazit, od kouzelníka dostává otázky, otevírá truhly.
* Na závěr se utká se Skřetem.

## Herní příkazy
Do konzole pište následující příkazy:
* pomoc ->            vypíše všechny příkazy s vysvětlením
* hledat okolo ->        vypíše se vše co se nachází kolem.
* konec hry ->                               ukončí se hra
* inventar ->                           vypíše se inventář
* bojovat ->                   spustí se souboj s příšerou
* otazka ->                        kouzelník položí otázku
* truhla ->                               otevře se truhla
* jit dal ->           půjdeš dál (bez možnosti se vrátit)

## Herní mechaniky
* Ve hře se nachází několik itemů. Itemy pro útočení(např. meč, sekera) a itemy pro uzdavení(např. lektvar, zlaté jablko).
* Když hráč najde truhlu, může s z ní vzít jeden ze tří itemů.
* Pokud se hráč zeptá na otázku od kouzelníka a odpoví zpravně, dostane náhodný item.
* Souboj:
    * V souboji používá svoje itemy jak hráč, tak stvůra.
    * Průběh hry: střídá se vždy hráč a stvůra v použití itemů, dokud někdo neumře.


##  Instalace a spuštění hry
Vyžadována Java Runtime Environment (JRE) ve verzi 24 nebo novější.
* Vytvořte .jar soubor. 
* Otevřete terminál v dané složce, kde je hra.
* zadejte příkaz pro přepnutí kódování na UTF-8: chcp 65001
* zadejte příkaz: java -jar CestaZaSkretem.jar
