## 3. Dosyadaki Hakikat:

Bir dosyadan hatalı sayı girişlerini saptayıp ayıklayan bir uygulama hazırlayınız. Bu program hatalı değerleri filtrelemeli ve hatasız sayıları (tamsayı veya ondalıklı) sıralı bir şekilde (sorted) çıktı olarak vermelidir.

`Uyulması gereken kurallar aşağıda belirtilmiştir:`

- Okunacak dosya komut satırı argümanı olarak alınmalıdır. Ancak, komut satırı argümanı girilmemişse, kullanıcıya okunacak dosyanın adı sorulmalıdır (geçerli bir dosya adı girene kadar).
- Dosyadaki her satırın sadece tek bir sayı içermesi beklenmektedir, ancak bazıları hatalıdır. Her satırı programdan okutunuz ve geçerli sayı değerlerini ortaya çıkartınız (yani hatasız olanları elekten geçiriniz).
- Hatalı girişlere örnekler:

```
A # char
SdgA # string
1R5 # string
56,1 # comma, wrong
9?4 # string
9-0 # string, sign after first decimal
*** # string
```

- Hatasız ve sayı olarak değerlendirilmesi gereken girişlere örnekler:

```
405
43.7
-78
-3.14
```

- Programınız hataların üstesinden gelebilmeli (exception handling ile) ve dosya sonuna gelene kadar geçerli sayıları okuyabilmelidir. Programınızın içerisinde Sayi abstract sınıfından türetilmiş TamSayi ve NoktaliSayi sınıfları mevcut olmalıdır. Sayilariniz bu sınıflar vasıtası ile tutulmalıdr.
- Dosyada kaç tane sayı olduğu önceden bilinmemektedir. Programınız dosya sonunu tespit etmelidir.
- IntSort isimli ayrı bir sınıf oluşturunuz. Bu sınıfın kurucu metodu dosyadan okunmuş olan sıralanmamış Sayi dizisini parametre olarak almalı, bu sayıları sıralayarak sıralanmış halini sınıf attribute'ü olarak kaydetmelidir. IntSort sınıfının ayrıca sıralanmış diziyi döndürdüğü bir metodu daha olmalıdır. Herhangi bir sıralama algoritmasını kullanabilirsiniz.
- Programınız geçerli sayıları sıraladığı gibi, dosyadaki toplam satır sayısını belirtmeli, kaçının geçerli sayı içerdiğine dair sayısal ve yüzdesel bilgi vermelidir. Örneğin:

```
Toplam 194 satır
121 geçerli sayı değeri bulundu (%62.37) o 73 geçersiz satır (%37.63).
```

- Programınız boyunca karşılaşılan tüm exceptionlar bir log dosyasında tutulmalıdır. Formatını öyle bir şekilde ayarlayınız ki aşağıdaki son maddedeki şartlar karşılansın.
- Programınız bu log dosyası adı (geçerli bir dosya yoluyla) ve ek bir opsiyon (örneğin “-L” şeklinde) içerecek şekilde iki komut satırı argümanıyla çağrıldığında, hangi tarihte (gün bazında) ve toplamda kaç adet hatanın kaydedilmiş olduğu ekranda listelenebilmelidir.