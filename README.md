# Generics

Pripremni zadatak koji pokriva gradivo Java generics.

U zadacima je dozvoljeno korištenje dodatnih, pomoćnih varijabli i metoda.

## Zadatak 1: Klasa Student i enumeracija Subject

Napišite klasu 'Student' koja ima sljedeće članske varijable:

- `id` - Identifikacijski broj studenta.
- `grades` - Studentove ocjene. Student ima 6 kolegija. Svaki element polja predstavlja ocjenu iz jednog kolegija.

Klasa 'Student' treba imati sljedeće metode:

- `getId()` - Vraća identifikacijski broj studenta.
- `setGrade(Subject subject, int grade)` - Postavlja ocjenu iz zadanog predmeta.
- `average()` - Vraća prosjek ocjena studenta.

Enumeracija `Subject` predstavlja neki kolegij koji se može ocijeniti kod studenta.
Zadani kolegiji su:

- Fundamentals of electrical engineering,
- Management in engineering,
- Mathematical analysis 2,
- Object oriented programming,
- Physical education and welfare 2,
- Physics

Primjer korištenja:

```Java
Student s = new Student("0036111111");
s.setGrade(Subject.PHYSICS, 5);
s.setGrade(Subject.MATHEMATICAL_ANALYSIS_2, 4);
s.setGrade(Subject.OBJECT_ORIENTED_PROGRAMMING, 3);
System.out.println(s.average()); // ispisuje 4.0
```

## Zadatak 2: Sučelja MyComparator i Tester

Definirajte sučelje `MyComparator<T> koje služi za uspoređivanje dva objekta tipa 'T'.
Sučelje treba imati jednu metodu:

- `compare(T o1, T o2)` - Uspoređuje objekte `o1` i `o2` te vraća negativni cijeli broj ako
                          je `o1` manji od `o2`, nula ako su jednaki, ili pozitivni cijeli 
                          broj ako je `o1` veći od `o2`.

Potrebno je napraviti i dvije implementacije tog sučelja.
Jedna implementacija je klasa `IntegerComparator` koja služi za uspoređivanje cijelih brojeva.
Druga implementacija je klasa `StudentGradeComparator` koja uspoređuje studente prema njihovoj prosječnoj ocjeni.
U klasu student dodati javno dostupan prosjek generacije.

Definirajte sučelje `Tester<T>` koje služi za testiranje objekata tipa `T`. 
Sučelje treba imati jednu metodu:
- `test(T object)` - Prima objekt tipa `T` te vraća `true` ako objekt prolazi test, odnosno `false` ako ne prolazi.

Potrebno je napraviti i dvije implementacije tog sučelja.
Jedna implementacija je klasa EvenIntegerTester koja služi za provjeru je li neki cijeli broj paran.
Druga implementacija je klasa AboveAverageStudentTester koja služi za provjeru ima li student iznad prosječni prosjek ocjena.

Primjer korištenja:
```Java
MyComparator<Integer> comparator = new IntegerComparator();
System.out.println(comparator.compare(1, 2)); // ispisuje cijeli broj < 0
System.out.println(comparator.compare(2, 2)); // ispisuje 0
System.out.println(comparator.compare(3, 2)); // ispisuje cijeli broj > 0

Tester<Student> tester = new AboveAverageStudentTester();
Student s1 = ... // stvaranje studenta s prosjekom 2.0
Student s2 = ... // stvaranje studenta s prosjekom 4.4
        
System.out.println(tester.test(s1)); // ispisuje false
System.out.println(tester.test(s2)); // ispisuje true
```

## Zadatak 3: Klasa BinaryTreeSearch

Binarno stablo je struktura podataka koja se sastoji od čvorova koji sadrže vrijednosti i poveznice na druge čvorove.
Svaki čvor u binarnom stablu može imati najviše dva djeteta - lijevo i desno dijete.
Ova struktura koristi se za pohranu i organizaciju podataka u hijerarhiju.
Binarna stabla često se koriste u implementaciji algoritama pretraživanja, sortiranja i kompresije podataka.

Binarno stablo pretraživanja je posebna vrsta binarnog stabla u kojoj su vrijednosti organizirane tako da svaki čvor
pohranjuje vrijednost koja je veća od vrijednosti pohranjene u njegovom lijevom djetetu, a manja od vrijednosti pohranjene
u njegovom desnom djetetu.

Napišite klasu `Node<T>` koja predstavlja čvor binarnog stabla i ima sljedeće članske varijable.

- `T value` - Vrijednost pohranjena u čvoru.
- `Node<T> left` - Lijevo dijete čvora.
- `Node<T> right` - Desno dijete čvora.

Klasa `Node<T>` treba imati sljedeće metode:

- `Node(T value)` - Konstruktor koji postavlja vrijednost. Čvor nema djece.
- `Node(T value, Node<T> left, Node<T> right)` - Konstruktor koji postavlja vrijednost i djecu.
- `getValue()` - Vraća vrijednost.
- `setValue()` - Postavlja vrijednost.
- `getLeft()` - Vraća lijevo dijete.
- `setLeft()` - Postavlja lijevo dijete.
- `getRight()` - Vraća desno dijete.
- `setRight()` - Postavlja desno dijete.

Napišite klasu `BinarySearchTree<T>` koja predstavlja binarno stablo pretraživanja.
BinarySearchTree<T> ima sljedeće članske varijable:

- `Node<T> root` - Korijen stabla.
- `MyComparator<T> comparator` - Za uspoređivanje objekata.

BinarySearchTree<T> ima sljedeće metode:

- `BinarySearchTree(MyComparator<T> comparator)` - Stvara stablo sa zadanim komparatorom.
- `insert(T value)` - Dodaje vrijednost u stablo.
- `contains(T value)` - Provjerava postoji li vrijednost u stablu.
- `countIf(Tester<T> tester)` - Broji koliko vrijednosti u stablu zadovoljava zadani test.
- `printInOrder()` - Ispisuje stablo _inorder_ poretkom.
- `printPreOrder()` - Ispisuje stablo _preorder_ poretkom.
- `printPostOrder()` - Ispisuje stablo _postorder_ poretkom.

Primjer Korištenja:
```Java
BinarySearchTree<T> bst = new BinarySearchTree<T>(new IntegerComparator());
bst.insert(10);
bst.insert(25);
bst.insert(14);
bst.insert(6);
bst.insert(8);
bst.insert(1);
bst.insert(22);
bst.insert(19);

bst.printInOrder(); //  1 6 8 10 14 19 22 25
bst.printPreOrder(); // 10 6 1 8 25 14 22 19
bst.printPostOrder(); // 1 8 6 19 22 14 25 10

System.out.println(bst.countIf(new EvenIntegerTester())); // 5
System.out.println(bst.contains(14)); // true
System.out.println(bst.contains(13)); // false
```

Načini ispisivanja za svaki čvor:
Inorder - ispiši vrijednost lijevog djeteta, zatim svoju, zatim vrijednost desnog dijeteta.
Preorder - ispiši svoju vrijednost, zatim vrijednost lijevog djeteta, zatim vrijednost desnog djeteta
Postorder - ispiši vrijednost lijevog djeteta, zatim desnog, zatim svoju

Hint:
Koristi rekurziju za prolazak po stablu
Koristi metodu comparator.compare za uspoređivanje vrijednosti u stablu


