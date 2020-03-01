4. Use Rope
Entry: Rope: Use()
Megkapja a playert, elkéri tőle a fieldjét, attól a fieldtől elkéri a szomszédokat egy loopban, a megkapott szomszédoktól elkéri a játékosokat amik rajtuk vannak, és ezeken meghívja a Save()-et

5. Use food
Entry: Food: Use()
A kapott playeren meghívja a ChangeTemperature()-t

6. Use Item
Entry: UseItem()
A kapott Item-en meghivja a Use()-t és átadja magát a player.

7. Use Shovel
Entry: Shovel: Use()
A kapott playertől elkéri a fieldjét, majd ezen meghívja a RemoveSnow() függvényt

8.Take Item
Entry: Player: PickUpItem()
A player meghívja a fieldjének a TakeItem()-jét, utána ez meghívja a tárolt item Equip()-jét, ami hozzáadja magát a player által tárolt itemekhez az AddItem() függvénnyel

9.Use FlareGunPart
Entry: FlareGunPart: Use()
Meghívja a Game-en az IsEveryoneHere-t, ami vissza is tér. Ez után elkéri a playertől a fieldjét, amin meghívja a countGunParts()-t, visszatér és opcionálisan meghívja a Game-en az Overt().

10. Take Diving Gear
Entry: DivingGear: Equip()
Meghívja a SetWearsDigingsuit() függvényét a playernek

11. Player digs
Entry: Player: Dig()
A player field-jén meghívja a RemoveSnow()-t



10-es azóta feleslegessá vált, így az nincs.