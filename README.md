# Rezervation-System
# Özet

Veri yapıları konusundaki teorik bilgilerin yardımıyla
yazılımı yapılan projede, bir firmanın rezervasyon
bilgilerini içeren sıralı verilerini, işletmelerin hizmet
alanlarına göre sınıflandırmasını ve bu sayede
verilerle ilgili istenen sorgu ve analizlerin daha etkin
bir şekilde yapılabileceği bir model geliştirmesi
sağlanmıştır.
.

# 1. Giriş

Projede kişilerin rezervasyon kayıtları
“rezervasyon.txt” dosyası içinde tutulmuştur.
Tasarlanan sistemde “rezervasyon.txt” dosyasından
çekilen kayıt bilgileriyle meydana getirilecek ağaç
yapısı 3 aşamada oluşturuldu. İlk aşamada ağacın üst
kısmında, “rezervasyon” kök düğümünden başlayarak
aşağı doğru kategoriler ve alt kategoriler için
kayıtlardaki hiyerarşik sıraya göre alt düğümler
oluşturuldu. Her kategori düğüm yapısı; kategori ismi
,alt kategori sayısı, kullanıcı sayısı, rezervasyon
sayısı, kategori yolu ve derinlik bilgilerini tutar.
İkinci aşamada ağacın altında bulunan kategori
düğümlerinden sonra rezervasyon işlemini yapan
müşteri bilgilerinin yer aldığı kullanıcı düğümleri
Max-Heap Algoritmasına göre oluşturularak ayrı bir
ağaca eklenmesi sağlanmıştır. Kullanıcı düğümleri;
kullanıcı id, kategori ismi, rezervasyon sayısı
bilgilerini içerir. Modelin oluşturulmasındaki bu son
aşamada her bir kullanıcı düğümüne kullanıcıların o
kategorideki rezervasyonları, bağlı liste yapısı
kullanılarak eklenmiştir. Bağlı listelerdeki her bir
düğüm; yer id, rezervasyon zamanı, enlem , boylam
,şehir bilgilerini içerir.
Projede kategori bulma, silme, ekleme işlemlerinin
ağaç yapısı üzerinde gerçekleştirilmesi sağlanmıştır.
Ayrıca proje üzerinde kullanıcı ile ilgili
işlemler(ekleme-silme) ve sorgu listeleme

işlemleri(kullanıcıya, kategoriye, rezervasyon yerine
göre) yapılabilmektedir.

# 2. Temel Bilgiler

Program​ ​ JAVA ​ ​ programlama​ ​ dilinde​ ​ geliştirilmiş​ ​
olup,
tümleşik​ ​ geliştirme​ ​ ortamı​ ​ olarak​ ​ “Netbeans IDE” ve
“IntelliJ IDEA” kullanılmıştır.

# 3. Tasarım

## 3.1 Algoritma
İlk aşamada dosya baştan sona okunur ve ağacın üst
kısmında, “rezervasyon” kök düğümünden başlayarak
aşağı doğru kategoriler ve alt kategoriler için
kayıtlardaki hiyerarşik sıraya göre alt düğümler
oluşturulur. Sonrasında dosya tekrar okunur ve
kategorilerinde altında bulunan binary treelere max-
heap algoritması kullanılarak kullanıcılar eklenir.
En sonra olarak dosya tekrar okunur ve rezervasyon
bilgileri kullanıcıların altına bağlı liste şeklinde
eklenir.
Sonrasında isterler gerçekleştirilmek üzere kullanıcıya
bir arayüz sunulur
.
Bu arayüz ile kullanıcı:
- Kategori bulma: Kategorinin ismi ile ağaç üzerinde
arama yapılarak kategori bilgileri ekrana basma.
- Yeni kategori ekleme: Altına eklenmesi istenen
kategori bulunarak onun bir alt kategorisi olacak
şekilde yeni kategori ekleme.

- Kategori silme: Kategoriyi ve altındaki kullanıcıları
silme
- Kullanıcı ekleme: Belirlenen bir kategoriye yeni bir
kullanıcı eklenme.
- Kullanıcı silme: 3 durum mevcuttur 1. Durumda
belli bir kategorinin altında yer alan tüm kullanıcılar
silinir. 2. durumda belli bir kategori altındaki belli bir
kullanıcı bulunarak silinir. 3. durumda ise belli bir
kullanıcının tüm kategorilerdeki kullanıcı düğümleri
silinir. Bu üç seçenek kullanıcıya sunulur.
- Kullanıcıya göre kategori listeleme: Kullanıcının
yapmış olduğu tüm rezervasyonların ait olduğu
kategoriler tekrarsız olarak listelenir.
- Kategoriye göre kullanıcı listeleme: Belli bir
kategorideki tüm kullanıcıların bilgileri listelenir.
- Rezervasyon yerine göre kullanıcı listeleme: Aynı
yerde rezervasyon yaptırmış olan tüm kullanıcılar
listelenir.
- Kullanıcıya göre rezervasyon listeleme: Belli bir
kullanıcıya ait tüm kategorideki rezervasyon yerleri
tekrarsız olarak listelenir.
İşlemlerini gerçekleştirebilir.


## 3.2 Kullanılan Metodlar

#### void listele4( ArrayList&lt;Rezervasyon&gt;,String, Kategori)
// Belli bir kullanıcıya ait tüm kategorideki rezervasyon
yerleri tekrarsız olarak listelenir.

#### void kullaniciyagoreyer(ArrayList&lt;Rezervasyon&gt;, String ,
Rezervasyon )
// Rezervasyonları tekrarsız olacak bir şekilde Arrayliste
eklenir
.
#### boolean rezervasyonzamankarsilastir(String
rezervasyon_zamani1, String rezervasyon_zamani2)
// Rezervasyonların zamanları karşılaştırılır.

#### void listele3(ArrayList&lt;String&gt; kullanicisimleri, String yer,
Kategori temp)
// Aynı yerde rezervasyon yaptırmış olan tüm kullanıcılar
listelenir.

#### void listele2(Kategori temp,ArrayList&lt;String&gt;
kullanicisimleri)
// Belli bir kategorideki tüm kullanıcıların bilgileri
listelenir.

#### void listele1(String secimstring,Kategori
temp,ArrayList&lt;String&gt; kategorisimleri)
// Kullanıcının yapmış olduğu tüm rezervasyonların ait
olduğu kategoriler tekrarsız olarak listelenir.

#### void KullaniciSil3(String secimstring,Kategori temp)
// Belli bir kullanıcının tüm kategorilerdeki kullanıcı
düğümleri silinir.

#### void Kullanicisil(Kategori temp)
// Kullanıcı silme işlemi sonrasında kategorilerin kullanıcı
ve rezervasyon sayılarını günceller.

#### void KullaniciSil1(Kategori tempkategori)
/ /Belli bir kategorinin altında yer alan tüm kullanıcılar
silinir.

#### void KullaniciSil2(Kullanici tempkullanici,Kategori
tempkategori)
// Belli bir kategori altındaki belli bir kullanıcı bulunarak
silinir

#### void Kullanicidugumunekle(Kullanici kok,Kullanici
dugum)
// Kullanıcı binary treesine yeni kullanıcı eklenir.

#### void KategoriSil(Kategori tempkategori)
// Kategoriyi siler.

#### void KategoriEkle(String kategorisim,Kategori kok)
// Kategori ekler.

#### void Kullaniciekle(String kullanicisim,Kategori kok)
// Kullanici ekler

#### void Kategoribilgileriyaz(Kategori kategori)
// Kategori bilgilerini yazdırır.

#### void rezervasyonlari_yazdir(Rezervasyon kok)
// Rezervasyonları yazdırır.

#### void rezsayiarttir(Kategori kok)
// Rezervasyon sayılarını arttırır.

#### void rezervasyon_al(String st)
// Satırdan rezervasyon bilgilerini okur.

#### void rezervasyon_bagla(String isim,Kategori
kategori,String yerid, String rezervasyonzamani, String
enlem, String boylam, String sehir)
// Rezervasyonu kullanıcı düğümünün altına ekler.

#### void rezervasyon_ekle(Rezervasyon rezervasyon_kok,
Rezervasyon yenirezervasyon)
// Rezervasyon oluşturur.

#### void kullanicilari_al(String satir)
// Satırdan kullanıcı bilgilerini okur.

#### void kategorileri_al(String satir)
// Satırdan kategori bilgilerini okur.

#### void kullanicisayisiarttir(Kategori kategori)
// Kullanıcı sayılarını arttırır.

#### void kullaniciguncelle(Kullanici kullanici)
// Ağacı max heap olacak şekilde günceller.

#### void kullaniciyerdegistir(Kullanici kullanici,Kullanici
karsilastirma)
// Kullanıcı ağacı üzerinde yer değiştirme işlemi yapar.

#### void yenikullanici_ekle(Kullanici yenikullanici, Kullanici
kok)
// Yeni kullanıcı ekler.

#### Kullanici kullanicivarmi(String kullanici,Kullanici kok)
// Verilen kategori düğümü altında kullanıcıyı arar ve eğer
bulur ise o kullanıcıyı döndürür. Bulamaz ise null bir
işaretçi döndürür.

#### boolean yerkontrol(Rezervasyon kok, String yerid)
// Yer id var olup olmadığını kontrol eder.

#### Kategori kategorivarmi(String kategori,Kategori temp)
// Verilen kategori düğümü altında kategoriyi arar ve
eğer bulur ise o kategoriyi döndürür. Bulamaz ise null
bir işaretçi döndürür.
